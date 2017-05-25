package mvc;

public class Help {
	
	public String helpText()
	{
		String helpText = "<html><p>1. Upon starting the game you will have an option of choosing how many "
				+ "players are playing the game and how many days the game will last for.In each 'day' you "
				+ "will be able to do up to two actions to each and every pet.<br />"
				+ "2. You will be asked for the name of each player and the name(s) and species of their pet(s). "
				+ "Names must contain only characters and be unique from all other names.<br />"
				+ "3. Each player is now able to view the stats of their pet as well as perform actions.<br />"
				+ "4. The store may be visited to check a players inventory as well as buy food and toys for their pets.<br />"
				+ "5. At the end of each day the stats of each players pets will be stored to calculate their end score.<br />"
				+ "6. If any of the pets stats reach zero the pet will die. Each pet may be revived once before staying "
				+ "dead for the remainder of the game.<br /><br />"
				+"ACTIONS<br />"
				+"Play: Let a pet play with toys you have bought from the store. This decreases its energy and increases the "
				+ "pets mood, more so if its the pets favorite"
				+ "	toy. If the toy is not the pets favorite it will be rougher with the toy, causing it to break sooner.<br />"
				+ "Feed: select food items you have bought from the store to give to your pet. This action helps restore the "
				+ "'Hunger' bar of the pet.<br />"
				+ "Toilet: Relieves the pet and restores the 'Toilet' bar.<br />"
				+ "Sleep: Restores the pets 'Energy' bar. This does not advance a day forward in the game.<br /><br />"
				+ "RANDOM EVENTS - After each day there is a chance any pet will get a random event.<br />"
				+ "Misbehaving: If your pet begins to misbehave you have the option of correcting the behaviour"
				+ " with a punishment, the pet will feel unhappy after this.<br />"
				+ "Sick: If the pet becomes sick, you have the option to cure the pet for $10 and it will feel happier"
				+ " after this, if not the pet will stay sick.<br />"
				+ "</p></html>";
		return helpText;
	}

}
