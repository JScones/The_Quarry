import java.util.Scanner;
import java.util.ArrayList;


public class Main {
	
	private static ArrayList<Player> players = new ArrayList<>();
	
	private static void setUp()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many people would like to play?");
		int numPlayers = in.nextInt();
		
		CreatePlayers playerCreator = new CreatePlayers();
		
		for(int i = 0; i < numPlayers; i++)
		{
			Player p = playerCreator.makePlayer();
			players.add(p);
		}
		in.close();
	}

	public static void main(String[] args) {
	
		setUp();
		
		System.out.println();
		for(int j = 0; j < players.size(); j++)
		{
			System.out.println();
			System.out.println(players.get(j));
		}

	}

}
