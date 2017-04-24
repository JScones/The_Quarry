
public class Gorilla extends Pet{
	
	public Gorilla(String name)
	{
		super("Gorilla", 250); // super needs species, name, weight
		maxHunger = 5;
		maxEnergy = 4;
		setStats(name, "Swing");
		
		
	}
}
