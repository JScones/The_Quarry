package mvc;

import java.util.ArrayList;

public class TamaModel{
	
	private int clickCount;
	private String[] species = {"Lion", "Gorilla", "Eagle", "Tiger", "Elephant", "Snake"};
	private static ArrayList<Player> players = new ArrayList<>();
	private static int numDays;
	private static int numPlayers;


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
		
		
}
