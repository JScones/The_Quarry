package mvc;

public class PetGorilla extends Pet {
	
	private static String gorillaToy = "Club";
	private static int maxHunger = 5;
	private static int maxEnergy = 4;
	private static int weight = 250;
	private static int[] stats = {maxHunger, maxEnergy, weight};

	public PetGorilla(String name){
		
		super("Gorilla", gorillaToy, stats);
		super.setName(name);
	}
	

}
