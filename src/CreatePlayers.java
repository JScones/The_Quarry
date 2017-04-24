import java.util.*;
import java.util.Scanner;

public class CreatePlayers {
	
	private Scanner in = new Scanner(System.in);
	private ArrayList<String> playerNames = new ArrayList<>();
	private ArrayList<String> petNames = new ArrayList<>();
	private int numPlayers;
	private int maxPets = 3;
	private String curPlayerName;
	
	public CreatePlayers()
	{
		numPlayers += 1;
	}
	
	public Player makePlayer()
	{
		curPlayerName = getName();
	    
	    ArrayList<Pet> pets = createPets();
	    
	    Player p = new Player(curPlayerName, pets);
	    return p;
	}
	
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
	
	private ArrayList<Pet> createPets()
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
		    
		    switch(thisPet) {
		    
		    case 0:
		    	l.setName(thisPetName);
		    	pets.add(l);
			    break;
			    
		    case 1:
		    	g.setName(thisPetName);
		    	pets.add(g);
		    	break;
		    }
		    
		    
		    
	    }
	    
	    return pets;
	}
	
}

