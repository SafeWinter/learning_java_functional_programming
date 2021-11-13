package ch9.ex2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GameElements {

    public static Map<String, Item>         items = new HashMap<>();
    public static Map<String, NPC>           npcs = new HashMap<>();
    public static Map<String, Location> locations = new HashMap<>();
    
    public static Location currentLocation;
    
    public static final Map<String, Supplier<Boolean>> commands = new HashMap<>();
    
    
    public static void displayLocation(Location location) {
        System.out.println("Location ------");
        System.out.println("Name: " + location.getName());
        System.out.println("Description: " + location.getDescription());
        
        System.out.println("Items ---------");
        location.getItems().forEach(item -> System.out.println(GameElements.items.get(item)));
        
        System.out.println("NPCs ----------");
        location.getNPCs().forEach(npc -> System.out.println(GameElements.npcs.get(npc)));
    }
    
    public static void displayView(Location location) {
        System.out.println(location.getDescription());
        location.displayItems();
        location.displayNPCs();
    }
    
    public static void displayPaths(Location location) {
        location.displayPaths();
    }
}
