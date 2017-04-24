import java.util.*;
import java.util.Scanner;


/**
 * Not actually sure this should be and object but definitely needed to
 * be separated into a seperate class, can you make a static class, idk...
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
public class CreatePlayers {
	
	private Scanner in = new Scanner(System.in);
	private ArrayList<String> playerNames = new ArrayList<>();
	private ArrayList<String> petNames = new ArrayList<>();
	private int numPlayers = 1;
	private int maxPets = 3;
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
	 * @return 		The complete player object that has just been created
	 */
	public Player makePlayer()
	{
		curPlayerName = getName();
	    int numPets = getNumPets();
	    ArrayList<Pet> pets = createPets(numPets);
	    
	    Player p = new Player(curPlayerName, pets);
	    return p;
	}
	
	/**
	 * Returns the name of the player, given it is not already taken.
	 * If a name is already taken, asks for a different one.
	 * 
	 * @return		The players name.
	 */
	private String getName()
	{
		System.out.println(String.format("Player %d, what is your name?", numPlayers++));
		String tempName = in.next();
		while(playerNames.contains(tempName))
		{
			System.out.println("Sorry, that name is taken. Please enter another:");
			tempName = in.next();
		}
	    playerNames.add(tempName);
	    
	    return tempName;
	}
	
	/**
	 * Returns the number of pets a player wants, handling invalid input such as
	 * strings or numbers outside 1, 2 or 3.
	 * 
	 * 
	 * @return		The number of pets the player wants (1, 2 or 3).
	 */
	private int getNumPets()
	{
		System.out.println(String.format("Ok %s, how many pets do you want?", curPlayerName));
	    boolean isValid = false;
	    int numPets = 0;
	    while(!(isValid))
	    {
		    try
		    {
		    	numPets = in.nextInt();
		    	isValid = true;
			    if(numPets <= 0)
			    {
			    	isValid = false;
			    	System.out.println("You need atleast one pet, please enter a positive number.");
			    }
			    if(numPets >= maxPets)
			    {
			    	isValid = false;
			    	System.out.println("Sorry, thats too many pets! be realistic (3 or less)");
			    }
		    }
		    catch(InputMismatchException ime)
		    {
		    	System.out.println("Invalid input. Please enter a valid number.");
		    	in.nextLine();
		    } 
	    }
	    return numPets;
	}
	
	/**
	 * Returns a collection of Pet child objects with player chosen names.
	 * 
	 * Creates default instances of each type of pet (potentially with unique random generated
	 * favourite toys??), then allows the player to view the stats of each species before choosing
	 * their pets.
	 * 
	 * The player is asked to choose a species and a name for each pet they desire.
	 * The names of the pets are checked to make sure they are unique, and if not the player is asked
	 * to choose a different name.
	 * 
	 * 
	 * @param		numPets The number of pets to be created.
	 * @return		An array list of the created pet objects.
	 */
	private ArrayList<Pet> createPets(int numPets)
	{
		
	    ArrayList<Pet> pets = new ArrayList<>();
	    String[] species = {"Lion", "Gorilla"};
	    
	    //Creating default pets, could add a random gen for favToys, other traits here
    	Lion l = new Lion("");
    	Gorilla g = new Gorilla("");
	    
	    System.out.println("Do you want to view the stats of each pet before choosing? (y/n)");
	    char viewStats = in.next().charAt(0);
	    if(viewStats == 'y')
	    {
	    	l.displayPetStats();
	    	g.displayPetStats();
	    }
	    	
	    // This loop gets each pet's species and name (checking for duplicates) and adds them to an Array list
	    for(int j = 1; j <= numPets; j++)
	    {
	    	System.out.println("Which species for pet " + j + ":");
		    for(int k = 1; k <= species.length; k++)
		    {
		    	System.out.println(k + " " + species[k-1]);
		    }
		    System.out.println("Please enter a number (1-6)");
		    int thisPet = in.nextInt() - 1;
		    	
		    System.out.println("What do you want to name your " + species[thisPet]);
		    String thisPetName = in.next();
			while(petNames.contains(thisPetName))
			{
				System.out.println("Sorry, that name is taken. Please enter another:");
				thisPetName = in.next();
			}
		    petNames.add(thisPetName);
		    
		    // This adds the correct species of pet to the array list.
		    switch(thisPet) {
		    
		    case 0: // Lion
		    	l.setName(thisPetName);
		    	pets.add(l);
			    break;
			    
		    case 1: // Gorilla
		    	g.setName(thisPetName);
		    	pets.add(g);
		    	break;
		    	
		    // MORE NEEDED HERE
		    }
		    
	    }
	    
	    return pets;
	}
	
}

