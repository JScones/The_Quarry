package mvc;

public class PetTiger extends Pet {
	
	private static String tigerToy = "Ball";
	private static int maxHunger = 10;
	private static int maxEnergy = 11;
	private static int weight = 85;
	private static int[] stats = {maxHunger, maxEnergy, weight};

	public PetTiger(String name){
		
		super("Tiger", tigerToy, stats);
		super.setName(name);
	}
	

}
