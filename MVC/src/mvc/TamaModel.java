package mvc;

import java.util.*;

public class TamaModel{
	
	private int clickCount;
	private String[] species = {"Lion", "Gorilla", "Eagle", "Tiger", "Elephant", "Snake"};
	private static ArrayList<Player> players = new ArrayList<>();
	private static int numDays;
	private static int numExpectedPlayers;
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
		numExpectedPlayers = newNumPlayers;
		numDays = newNumDays;
		//System.out.println(numPlayers + numDays);
	}
	
	public Boolean enoughPlayers()
	{
		return numExpectedPlayers == players.size();
	}
	
	public int curNumPlayers()
	{
		return players.size();
	}
	
	public String[] getSpecies()
	{
		return species;
	}
	
	public void addPlayer(Player newPlayer)
	{
		players.add(newPlayer);
		System.out.println(players.get(0));
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
