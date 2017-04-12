import java.util.Scanner;
import java.util.ArrayList;


public class Main {
	
	//hi there

	public static void main(String[] args) {
		
		ArrayList<Player> players = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many people would like to play?");
		int numPlayers = in.nextInt();
		
		CreatePlayers playerCreator = new CreatePlayers();
		
		for(int i = 0; i < numPlayers; i++)
		{
			System.out.println(String.format("Player %d, what is your name?", i+1));
			Player p = playerCreator.makePlayer();
			players.add(p);
		}
		in.close();
		
		for(int j = 0; j < players.size(); j++)
		{
			System.out.println();
			System.out.println(players.get(j));
		}

	}

}
