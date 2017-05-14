import java.util.*;

/**
 * Main class that runs the Tamagotchi style game.
 * 
 * First sets up the game environment, asking for the number of players and days.
 * Then gathers each players information (player name, pets, pet's names).
 * Then begins the main game loop.
 * 
 * @author Josh & Jack
 *
 */
public class Main {
	
	private static ArrayList<Player> players = new ArrayList<>();
	private static int numDays;
	private static int numPlayers;


	
	/**
	 * Initial set up stage.
	 * 
	 * Asks for the number of players (NEEDS ERROR HANDLING)
	 * Asks for the number of days (NEEDS ERROR HANDLING)
	 * Creates the players
	 */
	private static void setUp()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many people would like to play?");
		numPlayers = in.nextInt();
		System.out.println("How many days do you want to play?");
		numDays = in.nextInt();
		
		CreatePlayers playerCreator = new CreatePlayers();
		
		for(int i = 0; i < numPlayers; i++)
		{
			Player p = playerCreator.makePlayer();
			players.add(p);
		}
		in.close();
	}

	/**
	 * Main method, calls set up (That's all it does so far :(  ).
	 * 
	 * @param args Catches command line arguments.
	 */
	public static void main(String[] args) {

		Pet lion = new Pet("Lion", new Toy());
		System.out.println(lion);
		setUp();
		
		System.out.println();
		for(int j = 0; j < players.size(); j++)
		{
			System.out.println();
			System.out.println(players.get(j));
			players.get(j).printPets();
		}
	
		
		

	}

}
