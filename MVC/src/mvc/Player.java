package mvc;

import java.util.ArrayList;

/**
 * 
 * @author screw
 *
 */
public class Player {

	public String name;
	private ArrayList<Pet> pets = new ArrayList<Pet>();
	private ArrayList<Toy> toys = new ArrayList<>();
	private ArrayList<Food> foods = new ArrayList<>();
	private Double money = 50.0; //dollars
	private int score = 0;
	
	public Player(String aName, ArrayList<Pet> newPets)
	{
		name = aName;
		pets = newPets;
	}
	
	public Player(){
		
	}
	
	public Double getMoney()
	{
		return money;
	}
	
	public void setMoney(double amountNew) 
	{
		money = amountNew;
	}
	
	/**
	 * Returns a boolean of whether a player can purchase a toy
	 * @param toy Toy attempting to be purchased.
	 * @return whether the player can purchase the toy.
	 */
	public boolean canBuy(Toy toy)
	{
		if(toy.getPrice() <= money)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * returns a boolean of whether a player can purchase a food item.
	 * @param food Food attempting to be purchased
	 * @return whether the player can afford the Food.
	 */
	public boolean canBuy(Food food)
	{
		if(food.getPrice() <= money)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void Buy(Toy toy)
	{
		money -= toy.getPrice();
		toys.add(toy);
	}
	
	public void Buy(Food food)
	{
		money -= food.getPrice();
		foods.add(food);
	}
	
	
	public ArrayList<Pet> getPets()
	{
		return pets;
	}
	
	public ArrayList<Toy> getToys()
	{
		return toys;
	}
	
	public ArrayList<Food> getFood()
	{
		return foods;
	}
	
	public void addFood(Food food)
	{
		foods.add(food);
	}
	
	public void addToy(Toy toy)
	{
		toys.add(toy);
	}
	
	public void addPet(Pet pet) //for testing
	{
		pets.add(pet);
	}
	
	
	@Override
	public String toString()
	{
		String out = "player: %s has pet(s) %s";
		String printPets = "";
		for(int i = 0; i < pets.size(); i++)
		{
			printPets += pets.get(i);
			if(i < pets.size() - 2)
					printPets += ", ";
			if(i == pets.size() - 2)
					printPets += " and ";
		}
		return String.format(out, name, printPets);
	}
	
	public void printPets()
	{
		for(int i = 0; i < pets.size(); i++){
			pets.get(i).displayPetStats();
		}
	}
	
	/**
	 * Increases the players money by $50 and adds the days score
	 */
	public void dayOver()
	{
		money += 50;
		
		for(Pet pet : pets)
		{
			pet.dayEnd();
			score += pet.getScore();
		}
	}
	
	public int getScore()
	{
		return score;
	}

}
