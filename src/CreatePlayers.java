import java.util.ArrayList;
import java.util.Scanner;

public class CreatePlayers {
	
	private Scanner in = new Scanner(System.in);
	
	public Player makePlayer()
	{
	    String name = in.next();
	    System.out.println(String.format("Ok %s, how many pets do you want?", name));
	    int numPets = in.nextInt();
	    
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
		    
		    Lion p = new Lion(thisPetName);
		    pets.add(p);
	    }
	    Player p = new Player(name, pets);
	    return p;
	}
	
}

