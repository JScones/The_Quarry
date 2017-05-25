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

	/**
	 * Constructs the pet object
	 * @param aSpecies chosen species of the pet.
	 * @param aFavToy Favourite toy of the pet.
	 * @param petStats Int array of pets starting stats
	 * @param aIcon Image for the GUI representation of the pet.
	 */
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
		return new int[]{hunger, maxHunger, energy, maxEnergy, toilet, getHealth(), maxHealth};
	}
	
	public int getScore()
	{
		int score = ((hunger * 100) /maxHunger) + ((energy* 100)/maxEnergy) + (toilet/10) + (mood/10);
		return score;
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
	
	/**
	 * decreases pets stats accordingly for a day end
	 */
	public void dayEnd()
	{
		if(isAlive == true)
		{
			hunger -= 10;
			energy -= 8;
			toilet -= 3;
			mood -= 4;
			
			health = getHealth();
			dayActions = 2;
			checkAlive();
		}
		else
		{
			hunger = 0;;
			energy = 0;
			toilet = 0;
			mood = 0;
			
			health = 0;
			dayActions = 2;
		}
		
	}
	
	/**
	 * 
	 * @return average of stats to get an overall health value.
	 */
	public int getHealth()
	{
		return (hunger + energy + toilet + mood) / 4;
	}
	
	/**
	 * Pet plays with a toy, decreasing energy and increasing mood, more so if its the pets favourite toy.
	 * @param toy Toy to be played with
	 * @return whether the toy will be broken or not
	 */
	public boolean playAndBreak(Toy toy)
	{
		dayActions -= 1;
		if( toy.getName() == favToy)
		{
			mood += 5;
			energy -= 5;
			
			checkOverMax();
			
			return toy.playAndBreak(1);
		}
		else
		{
			mood += 2;
			energy -= 5;
			
			checkOverMax();
			
			return toy.playAndBreak(2);
		}
		
	}
	
	public void increaseMood(int num)
	{
		mood += num;
	}
	
	/**
	 * consumes food which increases hunger and energy stat
	 * @param food Food to be eaten by pet.
	 */
	public void feed(Food food)
	{
		dayActions -= 1;
		hunger += food.getValue();
		energy += food.getValue() / 2;
		weight += 1;

		checkOverMax();
	}
	
	/**
	 * Sleep action restores the pets energy
	 */
	public void sleep()
	{
		dayActions -= 1;
		energy = maxEnergy;
		
		checkOverMax();
	}
	
	/**
	 * One of the days actions, adjusts the toilet and weight stats accordingly
	 */
	public void goToilet()
	{
		dayActions -= 1;
		toilet += 10;
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
	
	/**
	 * 
	 * @return String representations of mood int, "Sad", "Average" "Happy".
	 */
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
	
	/**
	 * Checks all stats are above one, if not the pet is dead and all stats equal zero
	 * @return whether the pet is alive or not
	 */
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
	
	public boolean checkMisbehave()
	{
		return isMisbehaving;
	}
	
	/**
	 * Revives a dead pet and sets its stats back to original values
	 */
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
