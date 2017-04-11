import java.util.Scanner;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Name:");
	    String name = in.next();
	    
	    Lion bob = new Lion("Bob");
	    Lion jim = new Lion("Jim");
	    ArrayList<Pet> pets = new ArrayList<>();
	    pets.add(bob);
	    pets.add(jim);
	    
	    Player p1 = new Player(name, pets);
	    
	    System.out.println(p1);

	}

}
