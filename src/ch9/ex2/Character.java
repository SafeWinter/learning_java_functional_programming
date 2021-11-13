package ch9.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Character {

    private final List<String> items = new ArrayList<>();
    private Location location;
    
    public Character(Location currentLocation) {
        this.location = currentLocation;
    }
    
    public boolean pickup(Command command) {
        try {
            List<String> itemNames = command.getArguments();
            itemNames.stream()
                .filter(itemName -> {
                    if(this.location.getItems().contains(itemName)) {
                        return true;
                    } else {
                        System.out.println("Cannot pick up " + itemName);
                        return false;
                    }
                })
                .forEach(itemName -> {
                    this.items.add(itemName);
                    this.location.getItems().remove(itemName);
                    System.out.println("Picking up " + itemName);
                });
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean drop(Command command) {
        List<String> itemNames = command.getArguments();
        if(itemNames.isEmpty()) {
            System.out.println("Drop what?");
            return false;
        }
        
//        boolean droppedItem = false;
//        for (String itemName : itemNames) {
//            droppedItem = this.items.remove(itemName);
//            if(droppedItem) {
//                this.location.getItems().add(itemName);
//                System.out.println("Dropping " + itemName);
//            } else {
//                System.out.println("Cannot drop " + itemName);
//            }
//        }
//        return droppedItem;
        
        List<Boolean> results = new ArrayList<>();
        itemNames.stream()
            .map(itemName -> {
                boolean droppable = this.items.contains(itemName);
                results.clear();
                results.add(droppable);
                if(droppable) {
                    this.location.getItems().add(itemName);
                    return "Dropping " + itemName;
                } else {
                    return "Cannot drop " + itemName;
                }
            })
            .forEach(System.out::println);
        return results.get(0);
    }
    
    public boolean walk(Command command) {
        List<String> directions = command.getArguments();
        if(directions.isEmpty()) {
            System.out.println("Go where?");
            return false;
        }
        directions.forEach(direction -> {
            Optional<String> locationName = this.location.getLocationByDirection(direction);
            System.out.print(locationName
                    .map(name -> {
                        Location newLocation = GameElements.locations.get(name);
                        this.location = newLocation;
                        GameElements.currentLocation = newLocation;
                        GameElements.displayView(newLocation);
                        return "";
                    })
                    .orElse("However you can't go " + direction + "\n"));
            
        });
        return true;
    }
    
    public boolean inventory(Command command) {
        // List<String> arguments = command.getArguments();
        if(this.items.isEmpty()) {
            System.out.println("You are holding nothing.");
            return false;
        }
        String items = this.items.stream().collect(Collectors.joining(" "));
        System.out.println("You are holding: " + items);
        return true;
    }
}
