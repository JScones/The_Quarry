package mvc;

public class Snake extends Pet {
	
	private static Toy snakeToy = new Toy("Plane", 16.0, 17);
	private static int maxHunger = 16;
	private static int maxEnergy = 17;
	private static int weight = 4;

	public Snake(String name){
		
		super("Snake", snakeToy);
		super.setName(name);
	}
	

}
