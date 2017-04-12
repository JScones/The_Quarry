import java.util.*;
import java.util.Scanner;

public class CreatePlayers {
	
	private Scanner in = new Scanner(System.in);
	private ArrayList<String> playerNames = new ArrayList<>();
	private ArrayList<String> petNames = new ArrayList<>();
	private int numPlayers;
	private int maxPets = 5;
	
	public CreatePlayers()
	{
		numPlayers += 1;
	}
	
	public Player makePlayer()
	{
		System.out.println(String.format("Player %d, what is your name?", numPlayers++));
	    String name = in.next();
		while(playerNames.contains(name))
		{
			System.out.println("Sorry, that name is taken. Please enter another:");
			name = in.next();
		}
	    playerNames.add(name);
	    System.out.println(String.format("Ok %s, how many pets do you want?", name));
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
			    if(numPets > maxPets)
			    {
			    	isValid = false;
			    	System.out.println("Sorry, thats too many pets! be realistic (less than 5)");
			    }
		    }
		    catch(InputMismatchException ime)
		    {
		    	System.out.println("Invalid input. Please enter a valid number.");
		    	in.nextLine();
		    }
		    

		    
	    }
	    
	    ArrayList<Pet> pets = new ArrayList<>();
	    String[] species = {"Lion"};
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
		    
		    Lion p = new Lion(thisPetName);
		    pets.add(p);
	    }
	    Player p = new Player(name, pets);
	    return p;
	}
	
}

