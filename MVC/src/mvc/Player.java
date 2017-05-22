package mvc;

import java.util.ArrayList;


public class Player {

	public String name;
	private ArrayList<Pet> pets = new ArrayList<Pet>();
	private ArrayList<Toy> toys = new ArrayList<>();
	private ArrayList<Food> foods = new ArrayList<>();
	private Double money = 50.0; //dollars
	
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
	
//	public void useMoney(Double cost)
//	{
//		money -= cost;
//	}
	
	public boolean canBuy(Toy toy)
	{
		if(toy.getPrice() <= money)
		{
			money -= toy.getPrice();
			toys.add(toy);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void Buy(Food food)
	{
		if(food.getPrice() <= money)
		{
			money -= food.getPrice();
			foods.add(food);
		}
		else
		{
			double amountOver = food.getPrice();
			System.out.println("costs $" + amountOver + " more than you have.");
		}
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

}
