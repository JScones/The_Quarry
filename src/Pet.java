
public class Pet {

	private String species;
	private String name;
	private int hunger;
	private int energy;
	private int mood;
	private int toilet;
	private int health;
	private int weight;
	
	public Pet(String aSpecies, String aName)
	{
		species = aSpecies;
		name = aName;
	}
	
	public String toString()
	{
		return name + " (" + species + ")";
	}
}
