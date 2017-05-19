package mvc;
import java.util.*;
import java.util.Scanner;


/**
 * Not actually sure this should be and object but definitely needed to
 * be separated into a separate class, can you make a static class, idk...
 * 
 * Handles the creation of players by:
 * 		asking for the players name and checking for duplicates.
 * 		asking for the number of pets wanted.
 * 		creating the array list of the pets with correct attributes (no duplicate names etc).
 * 		can also display the stats of the potential pets before the player chooses.
 * 
 * @author Josh & Jack
 *
 */
public class CreatePlayersNew {
	
	private Scanner in = new Scanner(System.in);
	private ArrayList<String> playerNames = new ArrayList<>();
	private ArrayList<String> petNames = new ArrayList<>();
	private int numPlayers = 1;
	private int maxPets = 3;
	private String curPlayerName;
	
	public CreatePlayersNew()
	{
		
	}
	
	/**
	 * Returns a player object to be added to the main game's list of players.
	 * The player must have a unique name and between 1-3 pets, which also have unique names.
	 * 
	 * This method has no console input or output itself, that is all handled by other private methods
	 * for security and to keep the methods specific.
	 * 
	 * @return 		The complete player object that has just been created
	 */
	public Player makePlayer(String aName, ArrayList<String> petSpecies, ArrayList<String> petNames)
	{
		curPlayerName = aName;
	    ArrayList<Pet> pets = createPets(petSpecies, petNames);
	    
	    Player p = new Player(curPlayerName, pets);
	    return p;
	}
	
	
	
	/**
	 * Redo JavaDoc here
	 */
	private ArrayList<Pet> createPets(ArrayList<String> petSpecies, ArrayList<String> petNames)
	{
		int numPets = petSpecies.size();
	    ArrayList<Pet> pets = new ArrayList<>();
	    	
	    // This loop gets each pet's species and name (checking for duplicates) and adds them to an Array list
	    for(int j = 0; j < numPets; j++)
	    {
	    	String thisPet = petSpecies.get(j);
	    	String thisPetName = petNames.get(j);
		    petNames.add(thisPetName);
		    
		    // This adds the correct species of pet to the array list.
		    switch(thisPet) {
		    
		    case "Lion": // Lion
		    	PetLion lion = new PetLion(thisPetName);
		    	pets.add(lion);
			    break;
			    
		    case "Gorilla": // Gorilla
		    	PetGorilla gorilla = new PetGorilla(thisPetName);
		    	pets.add(gorilla);
		    	break;
		    	
		    case "Eagle": //Eagle
		    	PetEagle eagle = new PetEagle(thisPetName);
		    	pets.add(eagle);
		    	break;
		    	
		    case "Tiger": // Tiger
		    	PetTiger tiger = new PetTiger(thisPetName);
		    	pets.add(tiger);
		    	break;
		    	
		    case "Elephant": // Elephant
		    	PetElephant elephant = new PetElephant(thisPetName);
		    	pets.add(elephant);
		    	break;
		    	
		    case "Snake": // Snake
		    	PetSnake snake = new PetSnake(thisPetName);
		    	pets.add(snake);
		    	break;
		    	
		    // MORE NEEDED HERE
		    }
		    
	    }
	    
	    return pets;
	}
	
}

