package mvc;

public class PetSnake extends Pet {
	
	private static String snakeToy = "Plane";
	private static int maxHunger = 16;
	private static int maxEnergy = 17;
	private static int weight = 4;
	private static int[] stats = {maxHunger, maxEnergy, weight};

	public PetSnake(String name){
		
		super("Snake", snakeToy, stats);
		super.setName(name);
	}
	

}
