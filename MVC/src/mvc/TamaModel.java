package mvc;

import java.util.*;

public class TamaModel{
	
	private int clickCount;
	private String[] species = {"Lion", "Gorilla", "Eagle", "Tiger", "Elephant", "Snake"};
	private static ArrayList<Player> players = new ArrayList<>();
	private static int numDays;
	private static int numPlayers;
	public Map<String, Pet> defaultPets = makeDefaultPetsMap();

	public TamaModel()
	{
			
	}
	
	public void clicked()
	{
		clickCount++;
	}
	
	public int getClickCount()
	{
		return clickCount;
	}
	
	public String getMainMenuText()
	{
		String main = "Welcome to our tamagotchi game";
		return main;
	}
	
	public String getHelpText()
	{
		String help = "<html>This is where the help text goes<BR></html>";
		return help;
	}
	
	public void setUp(int newNumPlayers, int newNumDays)
	{
		numPlayers = newNumPlayers;
		numDays = newNumDays;
		//System.out.println(numPlayers + numDays);
	}
	
	public int getNumPlayers()
	{
		return numPlayers;
	}
	
	public String[] getSpecies()
	{
		return species;
	}
	
	private static Map<String, Pet> makeDefaultPetsMap()
	{
		Map<String, Pet> speciesMap = new Hashtable<String, Pet>();
		speciesMap.put("Lion", new PetLion());
		speciesMap.put("Gorilla", new PetGorilla());
		speciesMap.put("Eagle", new PetEagle());
		speciesMap.put("Tiger", new PetTiger());
		speciesMap.put("Elephant", new PetElephant());
		speciesMap.put("Snake", new PetSnake());
		return speciesMap;
	}
		
	private static ArrayList<Pet> makeDefaultPets()
	{
		ArrayList<Pet> defaultPets = new ArrayList<Pet>();
		PetEagle eagle = new PetEagle();
		defaultPets.add(eagle);
		
		return defaultPets;
	}
	
}
