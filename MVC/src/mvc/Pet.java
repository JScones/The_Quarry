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
	private int maxHealth;

	private int weight;
	private int toilet = 7;
	private int health;
	private int mood = 10;
	private int dayActions = 2;
	private String favToy;
	private int livesLeft = 1;
	private Boolean hasDied = false;
	private Boolean isAlive = true;
	private Boolean isSick = false;
	private Boolean isMisbehaving = false;

	
	public Pet(String aSpecies, String aFavToy, int[] petStats, ImageIcon aIcon)
	{
		species = aSpecies;
		maxHunger = petStats[0];
		maxEnergy = petStats[1];
		weight = petStats[2];
		hunger = maxHunger / 2;
		energy = maxEnergy / 2;
		favToy = aFavToy;
		icon = aIcon;
		maxHealth = (maxHunger + maxEnergy + toilet + mood) / 4;
		health = getHealth();
	}
	
	public Pet()
	{
		
	}
	
	
	public String toString()
	{
		return "Name: " + name + "       Species: " + species;
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
	
	public int[] getBarStats()
	{
		return new int[]{hunger, maxHunger, energy, maxEnergy, toilet, health, maxHealth};
	}
	
	public String getStatsString()
	{
		String out;
		String[] statDescriptions = getStatDescriptions();
		if(name == null)
		{
			out = ("<html><p>Species: " + species + "<br />"
					+ "Appetite: " + statDescriptions[0] + "<br />"
					+ "Energy: " + statDescriptions[1] + "<br />"
					+ "Weight: " + weight + "Kg<br />"
					+ "Favourite toy: " + favToy + "</p></html>");
		}
		else
		{
			out = ("<html><p>Name :" + name + "<br /><br />"
					+ "Species: " + species + "<br /><br />"
					+ "Appetite: " + statDescriptions[0] + "<br /><br />"
					+ "Energy: " + statDescriptions[1] + "<br /><br />"
					+ "Mood: " + mood + "<br /><br />"
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
		if(isAlive == true)
		{
			hunger -= 4;
			energy -= 3;
			toilet -= 3;
			mood -= 4;
			
			health = getHealth();
			dayActions = 2;
			checkAlive();
		}
		
	}
	
	public int getHealth()
	{
		return (hunger + energy + toilet + mood) / 4;
	}
	
	public boolean playAndBreak(Toy toy)
	{
		dayActions -= 1;
		if( toy.getName() == favToy)
		{
			mood += 5;
			energy -= 2;
			
			checkOverMax();
			
			return toy.playAndBreak(1);
		}
		else
		{
			mood += 2;
			energy -= 2;
			
			checkOverMax();
			
			return toy.playAndBreak(2);
		}
		
	}
	
	public void increaseMood(int num)
	{
		mood += num;
	}
	
	public void feed(Food food)
	{
		dayActions -= 1;
		hunger += food.getValue();
		energy += food.getValue() / 2;
		weight += 1;

		checkOverMax();
	}
	
	public void sleep()
	{
		dayActions -= 1;
		energy += 5;
		
		checkOverMax();
	}
	
	public void goToilet()
	{
		dayActions -= 1;
		toilet += 3;
		weight -= 1;
		
		checkOverMax();
	}
	
	public int getLivesLeft()
	{
		return livesLeft;
	}
	
	public int getActionsLeft()
	{
		return dayActions;
	}
	
	public String getMood()
	{
		if(mood < 3)
		{
			return "Sad";
		}
		else if(mood < 6)
		{
			return "Average";
		}
		else
		{
			return "Happy";
		}
	}
	
	private String[] getStatDescriptions()
	{
		String[] stats = {"appetite", "energy"};
		
		if(maxHunger < 33)
		{
			stats[0] = "High";
		}
		else if(maxHunger < 66)
		{
			stats[0] = "Medium";
		}
		else if(maxHunger >= 66)
		{
			stats[0] = "Low";
		}
		
		if(maxEnergy < 33)
		{
			stats[1] = "Low";
		}
		else if(maxEnergy < 66)
		{
			stats[1] = "Medium";
		}
		else if(maxEnergy >= 66)
		{
			stats[1] = "High";
		}
		
		return stats;
	}
	
	private void checkOverMax()
	{
		if(toilet > 10)
			toilet = 10;
		
		if(hunger > maxHunger)
			hunger = maxHunger;
		
		if(energy > maxEnergy)
			energy = maxEnergy;
	}
	
	public boolean checkAlive()
	{
		if(toilet < 1 || hunger < 1 || energy < 1)
		{
			isAlive = false;
			livesLeft -= 1;
			toilet = 0;
			hunger = 0;
			energy = 0;
			health = 0;
		}
		
		return isAlive;
	}
	
	public boolean checkSick()
	{
		return isSick;
	}
	
	public void becomesSick()
	{
		isSick = true;
	}
	
	public void becomesNotSick()
	{
		isSick = false;
	}
	
	public void misbehave()
	{
		isMisbehaving = true;
	}
	
	public void notMisbehave()
	{
		isMisbehaving = false;
	}
	
	public void revive()
	{
		isAlive = true;
		hasDied = true;
		livesLeft = 0;
		
		hunger = maxHunger / 2;
		energy = maxEnergy / 2;
		toilet = 7;
		health = getHealth();
	}
	
	public Boolean checkHasDied()
	{
		return hasDied;
	}
}
