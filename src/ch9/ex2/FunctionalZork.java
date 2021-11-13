package ch9.ex2;

import static ch9.ex2.GameElements.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;;

public class FunctionalZork {

    private final Scanner      scanner;
    private Character          character;
    private FunctionalCommands fc;
    private Command            command = new Command();
    
    private Supplier<Boolean> pickupCommand    = () -> character.pickup(command);
    private Supplier<Boolean> dropCommand      = () -> character.drop(command);
    private Supplier<Boolean> walkCommand      = () -> character.walk(command);
    private Supplier<Boolean> inventoryCommand = () -> character.inventory(command);
    
    private Supplier<Boolean> lookCommand = () -> {
        GameElements.displayView(GameElements.currentLocation);
        return true;
    };
    private Supplier<Boolean> directionCommand = () -> {
        GameElements.currentLocation.displayPaths();
        return true;
    };
    private Supplier<Boolean> quitCommand = () -> {
        System.out.println("Thank you for playing!");
        return true;
    };
    
    private void initializeCommands() {
        commands.put("pickup", pickupCommand);
        commands.put("Pickup", pickupCommand);
        commands.put("drop", dropCommand);
        commands.put("Drop", dropCommand);
        commands.put("walk", walkCommand);
        commands.put("Walk", walkCommand);
        commands.put("go",   walkCommand);
        commands.put("inventory", inventoryCommand);
        commands.put("inv",       inventoryCommand);
        commands.put("look", lookCommand);
        commands.put("direction", directionCommand);
        commands.put("dir",       directionCommand);
        commands.put("quit", quitCommand);
    }
    
    public FunctionalZork() {
        scanner = new Scanner(System.in);
        fc = new FunctionalCommands();
        initializeGame();
        character = new Character(GameElements.currentLocation);
    }
    
    private void initializeGame() {
        initializeData();
        initializeCommands();
    }

    private void initializeData() {
        System.out.println("Welcome to Functional Zork!\n");
//        File file = new File("src/ch9/ex2/data.txt");
        Path path = Paths.get("src/ch9/ex2", "data.txt");
        File file = path.toFile();
        try(FileInputStream fis = new FileInputStream(file);
                BufferedReader br = new BufferedReader(new InputStreamReader(fis))
        ){
            String line = br.readLine();
            while("Location".equals(line)) {
                Location location = new Location()
                        .name(br.readLine())
                        .description(br.readLine());
                line = br.readLine();
                // direction
                while("Direction".equals(line)) {
                    location.addDirection(new Direction()
                            .direction(br.readLine())
                            .location(br.readLine()));
                    line = br.readLine();
                }
                // item
                while("Item".equals(line)) {
                    Item item = new Item()
                        .name(br.readLine())
                        .description(br.readLine());
                    String itemName = item.getName();
                    location.addItem(itemName);
                    GameElements.items.put(itemName, item);
                    line = br.readLine();
                }
                // NPC
                while("NPC".equals(line)) {
                    NPC npc = new NPC()
                            .name(br.readLine())
                            .description(br.readLine());
                    location.getNPCs().add(npc.getName());
                    GameElements.npcs.put(npc.getName(), npc);
                    line = br.readLine();
                }
                GameElements.locations.put(location.getName(), location);
            }
            if("StartingLocation".equalsIgnoreCase(line)) {
                GameElements.currentLocation = GameElements.locations.get(br.readLine());
                GameElements.displayView(GameElements.currentLocation);
            } else {
                System.out.println("Missing Starting Location");
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String command = "";
        FunctionalZork game = new FunctionalZork();
        Stream<String> commandStream;
        while (!"Quit".equalsIgnoreCase(command)) {
            System.out.print(">> ");
            commandStream = game.getCommandStream();
            game.parseCommandStream(commandStream);
            command = game.executeCommand();
        }
    }

    private String executeCommand() {
        Supplier<Boolean> nextCommand = commands.get(command.getCommand());
        if(nextCommand == null) {
            System.out.println("Bad command.");
            return "";            
        }
        fc.addCommand(nextCommand);
        fc.executeCommand();
        return command.getCommand();
    }

    private void parseCommandStream(Stream<String> tokens) {
        this.command.clear();
        tokens.forEach(token -> {
            if(commands.containsKey(token)) {
                this.command.setCommand(token);
            } else {
                this.command.addArgument(token);
            }
        });
    }

    private Stream<String> getCommandStream() {
        List<String> toRemove = Arrays.asList("a", "an", "the", "and");
        String commandLine = scanner.nextLine();
        return Pattern.compile("\\s+")
                .splitAsStream(commandLine)
                .map(this::additionalProccessing)
                //.map(String::toLowerCase)
                .filter(token -> !toRemove.contains(token));
    }
    
    private String additionalProccessing(String token) {
        if (token.equalsIgnoreCase("drop")) {
            // Additional processing
            System.out.println("Do some additional processing before dropping ...");
        }
        return token;
    }
}
