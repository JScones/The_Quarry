
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
	
	protected String favToy;
	
	public Pet(String aSpecies, int aWeight)
	{
		species = aSpecies;
		weight = aWeight;
		favToy = "Ball";
	}
	
	public String toString()
	{
		return name + " (" + species + ")";
	}
	
	protected void setStats(String aName, String aFavToy)
	{
		hunger = maxHunger;
		energy = maxEnergy;
		
		name = aName;
		favToy = aFavToy;
	}
	
	protected void setName(String aName)
	{
		name = aName;
	}
	
	
	protected void displayPetStats()
	{
		System.out.println();
		System.out.println(species + ":");
		System.out.println("Appetite: " + maxHunger + "/10");
		System.out.println("Energy: " + maxEnergy + "/10");
		System.out.println("Weight: " + weight + "Kg");
		System.out.println("Favourite toy: " + favToy);
		System.out.println();
	}
	
	protected void dayEnd()
	{
		hunger -= 4;
		energy -= 3;
		toilet -= 3;
		mood -= 2;
		
		health = (hunger + energy + toilet + mood) / 4;
		dayActions = 2;
		
	}
	
	protected void play(Toy toy)
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
	
	protected void feed(Food food)
	{
		hunger += food.getValue();
		// when calling this in main, food must be removed from inventory
	}
	
	protected void sleep()
	{
		energy += 5;
	}
}
