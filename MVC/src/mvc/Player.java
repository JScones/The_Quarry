package mvc;

import java.util.ArrayList;


public class Player {

	private String name;
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
	
	public void Buy(Toy toy) throws InsufficientFundsException
	{
		if(toy.getPrice() <= money)
		{
			money -= toy.getPrice();
			toys.add(toy);
		}
		else
		{
			double amountOver = toy.getPrice();
			throw new InsufficientFundsException(amountOver);
		}
	}
	
	public void Buy(Food food) throws InsufficientFundsException
	{
		if(food.getPrice() <= money)
		{
			money -= food.getPrice();
			foods.add(food);
		}
		else
		{
			double amountOver = food.getPrice();
			throw new InsufficientFundsException(amountOver);
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
