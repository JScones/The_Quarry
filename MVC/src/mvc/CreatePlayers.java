package mvc;
import java.util.*;



/**
 * Class for creating players, mainly to separate code.
 *
 */
public class CreatePlayers {
	
	private String curPlayerName;
	
	public CreatePlayers()
	{
		
	}
	
	/**
	 * Returns a player object to be added to the main game's list of players.
	 * The player must have a unique name and between 1-3 pets, which also have unique names.
	 * 
	 * This method has no console input or output itself, that is all handled by other private methods
	 * for security and to keep the methods specific.
	 * 
	 * @param aName the name of the player to be created
	 * @param petSpecies an <code>ArrayList</code> of the players chosen pet species
	 * @param petNames an <code>ArrayList</code> of the players chosen pet names
	 * @return 		The complete player object that has just been created
	 * 
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
		    }
		    
	    }
	    
	    return pets;
	}
	
}

