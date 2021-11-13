package ch9.ex2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Location {

	private String name;
	private String description;
	
	private final List<String>           items      = new ArrayList<>();
	private final List<String>           npcs       = new ArrayList<>();
	private final Map<String, Direction> directions = new HashMap<>();
	
	// on name
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Location name(String name) {
		this.name = name;
		return this;
	}
	
	// on description
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Location description(String description) {
		this.description = description;
		return this;
	}
	
	// on items
	public void addItem(String itemName) {
		this.items.add(itemName);
	}
	public List<String> getItems() {
		return this.items;
	}
	
	// on npcs
	public void addNPC(String npcName) {
		this.npcs.add(npcName);
	}
	public List<String> getNPCs() {
		return this.npcs;
	}
	
	// on directions
	public void addDirection(Direction direction) {
		this.directions.put(direction.getDirection(), direction);
	}
	public Optional<String> getLocationByDirection(String direction) {
		if(this.directions.containsKey(direction)) {
			return Optional.of(this.directions.get(direction).getLocation());
		} else {
			return Optional.empty();
		}
	}
	
	// Display methods
	public void displayItems() {
		if(this.items.isEmpty()) {
			return;
		}
		
		System.out.print("On the ground you see:");
		this.items.forEach(item -> System.out.print(" " + item));
		System.out.println();
	}
	
	public void displayNPCs() {
		if(this.npcs.isEmpty()) {
			return;
		}
		
		System.out.print("The NPCs you'll see here:");
		this.npcs.forEach(npc -> System.out.print(" " + npc));
		System.out.println();
	}
	
	public void displayPaths() {
		if(this.directions.isEmpty()) {
			System.out.println("You can go nowhere from here.");
			return;
		}
		
		this.directions.forEach((way, direction) -> {
			System.out.printf("If you go %s, you can get to %s\n", way, direction.getLocation());
		});
	}
}
