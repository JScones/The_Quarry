package mvc;

public class Elephant extends Pet {
	
	private static Toy elephantToy = new Toy("Piano", 101.0, 12);
	private static int maxHunger = 13;
	private static int maxEnergy = 14;
	private static int weight = 1206;

	public Elephant(String name){
		
		super("Elephant", elephantToy);
		super.setName(name);
	}
}
	
