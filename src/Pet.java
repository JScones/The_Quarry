
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
	
	private String favToy = "Ball";
	
	public Pet(String aSpecies, String aName, int aWeight)
	{
		species = aSpecies;
		name = aName;
		weight = aWeight;
	}
	
	public String toString()
	{
		return name + " (" + species + ")";
	}
	
	protected void setStats()
	{
		hunger = maxHunger;
		energy = maxEnergy;
	}
}
