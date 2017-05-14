import java.util.*;

public class Pet {

	private String species;
	private String name;
	private int hunger;
	protected int maxHunger;
	private int energy;
	protected int maxEnergy;

	private int weight;
	private int toilet = 10;
	private int health = 10;
	private int mood = 10;
	private int dayActions = 2;
	
	private Toy favToy;
	
	//{"Lion", "Gorilla", "Eagle", "Tiger", "Elephant", "Snake"}
	private static final Map<String, int[]> speciesMap = createSpeciesMap();
	
	private static Map<String, int[]> createSpeciesMap()
	{
		Map<String, int[]> speciesMap = new Hashtable()
		speciesMap.put("Lion", new int[]{8, 15, 100});
		speciesMap.put("Gorilla", new int[]{5, 4, 250});
		speciesMap.put("Eagle", new int[]{7, 8, 15});
		speciesMap.put("Tiger", new int[]{10, 11, 85});
		speciesMap.put("Elephant", new int[]{13, 14, 1206});
		speciesMap.put("Snake", new int[]{16, 17, 4});
		
		return speciesMap;
	}
	
	public Pet(String aSpecies, Toy aFavToy)
	{
		species = aSpecies;
		int[] petStats = speciesMap.get(species);
		maxHunger = petStats[0];
		maxEnergy = petStats[1];
		weight = petStats[2];
		hunger = maxHunger;
		energy = maxEnergy;
		favToy = aFavToy;
	}
	
	public String toString()
	{
		return name + " (" + species + ")";
	}
	
	
	public void setName(String aName)
	{
		name = aName;
	}
	
	public int[] getStats()
	{
		return new int[]{hunger, energy, weight, toilet, health, mood};
	}
	
	public Toy getFavToy()
	{
		return favToy;
	}
	
	public void displayPetStats()
	{
		System.out.println();
		System.out.println(species + ":");
		System.out.println("Appetite: " + maxHunger + "/10");
		System.out.println("Energy: " + maxEnergy + "/10");
		System.out.println("Weight: " + weight + "Kg");
		System.out.println("Favourite toy: " + favToy);
		System.out.println();
	}
	
	public void dayEnd()
	{
		hunger -= 4;
		energy -= 3;
		toilet -= 3;
		mood -= 2;
		
		health = (hunger + energy + toilet + mood) / 4;
		dayActions = 2;
		
	}
	
	public void play(Toy toy)
	{
		if( toy.getName() == favToy)
		{
			toy.play(1);
			mood += 5;
		}
		else
		{
			toy.play(2);
			mood += 2;
		}
	}
	
	public void feed(Food food)
	{
		hunger += food.getValue();
		// when calling this in main, food must be removed from inventory
	}
	
	public void sleep()
	{
		energy += 5;
	}
	
}
