package mvc;

public class PetElephant extends Pet {
	
	private static String elephantToy = "Piano";
	private static int maxHunger = 13;
	private static int maxEnergy = 14;
	private static int weight = 1206;
	private static int[] stats = {maxHunger, maxEnergy, weight};

	public PetElephant(String name){
		
		super("Elephant", elephantToy, stats);
		super.setName(name);
	}
}
	
