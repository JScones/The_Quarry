package mvc;

public class PetEagle extends Pet {
	
	private static String favToy = "Freedom";
	private static int maxHunger = 8;
	private static int maxEnergy = 15;
	private static int weight = 100;
	private static int[] stats = {maxHunger, maxEnergy, weight};

	public PetEagle(String name){
		
		super("Eagle", favToy, stats);
		super.setName(name);
	}
}
