import java.util.ArrayList;

public class Player {

	private String name;
	private ArrayList<Pet> pets = new ArrayList<Pet>();
	//private ArrayList<Toy> toys = new ArrayList<>();
	//private ArrayList<Food> foods = new ArrayList<>();
	private Double money;
	
	public Player(String aName, ArrayList<Pet> newPets)
	{
		name = aName;
		pets = newPets;
	}
	
	public String toString()
	{
		String out = "player: %s has pets %s";
		String printPets = "";
		for(int i = 0; i < pets.size(); i++)
		{
			printPets += pets.get(i);
			if(i < pets.size() - 2)
					printPets += ", ";
			if(i == pets.size() - 2)
					printPets += " and ";
		}
		return String.format(out, name, printPets);
	}
	
	public void printPets()
	{
		for(int i = 0; i < pets.size(); i++){
			pets.get(i).displayPetStats();
		}
	}

}
