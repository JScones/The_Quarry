package mvc;

public class Gorilla extends Pet {
	
	private static Toy gorillaToy = new Toy("Club", 13.0, 14);
	private static int maxHunger = 5;
	private static int maxEnergy = 4;
	private static int weight = 250;

	public Gorilla(String name){
		
		super("Gorilla", gorillaToy);
		super.setName(name);
	}
	

}
