package mvc;

public class Lion extends Pet {
	
	private static Toy lionToy = new Toy("Ball of yarn", 10.0, 10);
	private static int maxHunger = 8;
	private static int maxEnergy = 15;
	private static int weight = 100;

	public Lion(String name){
		
		super("Lion", lionToy);
		super.setName(name);
	}
	
}