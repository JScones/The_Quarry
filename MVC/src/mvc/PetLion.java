package mvc;

public class PetLion extends Pet {
	
	private static String lionToy = "Ball of yarn";
	private static int maxHunger = 8;
	private static int maxEnergy = 15;
	private static int weight = 100;
	private static int[] stats = {maxHunger, maxEnergy, weight};

	public PetLion(String name){
		
		super("Lion", lionToy, stats);
		super.setName(name);
	}
	
}