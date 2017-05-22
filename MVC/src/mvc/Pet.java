package mvc;

import javax.swing.ImageIcon;

public class Pet {
	
	public ImageIcon icon;

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
	private Boolean dayActionsUsed = false;
	private String favToy;
	private int livesLeft = 1;
	private Boolean isAlive = true;

	
	public Pet(String aSpecies, String aFavToy, int[] petStats, ImageIcon aIcon)
	{
		species = aSpecies;
		maxHunger = petStats[0];
		maxEnergy = petStats[1];
		weight = petStats[2];
		hunger = maxHunger;
		energy = maxEnergy;
		favToy = aFavToy;
		icon = aIcon;
	}
	
	public Pet()
	{
		
	}
	
	
	public String toString()
	{
		return name + " (" + species + ")";
	}
	
	
	public void setName(String aName)
	{
		name = aName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int[] getStats()
	{
		return new int[]{hunger, energy, weight, toilet, health, mood};
	}
	
	public String getStatsString()
	{
		String out;
		if(name == null)
		{
			out = ("<html><p>Species: " + species + "<br />"
					+ "Appetite: " + maxHunger + "<br />"
					+ "Energy: " + maxEnergy + "<br />"
					+ "Weight: " + weight + "Kg<br />"
					+ "Favourite toy: " + favToy + "</p></html>");
		}
		else
		{
			out = ("<html><p>Name :" + name + "<br /><br />"
					+ "Species: " + species + "<br /><br />"
					+ "Appetite: " + maxHunger + "<br /><br />"
					+ "Energy: " + maxEnergy + "<br /><br />"
					+ "Weight: " + weight + "Kg<br /><br />"
					+ "Favourite toy: " + favToy + "</p></html>");
		}
		return out;
	}
	
	public String getFavToy()
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
		dayActions -= 1;
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
		dayActions -= 1;
		hunger += food.getValue();
		// when calling this in main, food must be removed from inventory
	}
	
	public void sleep()
	{
		dayActions -= 1;
		energy += 5;
	}
	
	public int getLivesLeft()
	{
		return livesLeft;
	}
	
	public boolean getAliveStatus()
	{
		return isAlive;
	}
	
	public void died()
	{
		isAlive = false;
		livesLeft = 0;
	}
	
	public int getActionsLeft()
	{
		return dayActions;
	}
	
}
