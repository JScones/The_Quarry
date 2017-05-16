package mvc;

public class Tiger extends Pet {
	
	private static Toy tigerToy = new Toy("Ball", 18.0, 19);
	private static int maxHunger = 10;
	private static int maxEnergy = 11;
	private static int weight = 85;

	public Tiger(String name){
		
		super("Tiger", tigerToy);
		super.setName(name);
	}
	

}
