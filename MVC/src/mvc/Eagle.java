package mvc;

public class Eagle extends Pet {
	
	private static Toy eagleToy = new Toy("Freedom", 14.0, 15);
	private static int maxHunger = 8;
	private static int maxEnergy = 15;
	private static int weight = 100;

	public Eagle(String name){
		
		super("Eagle", eagleToy);
		super.setName(name);
	}
	


}
