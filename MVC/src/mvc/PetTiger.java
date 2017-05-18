package mvc;

import javax.swing.ImageIcon;

public class PetTiger extends Pet {
	
	private static String tigerToy = "Ball";
	private static int maxHunger = 10;
	private static int maxEnergy = 11;
	private static int weight = 85;
	private static int[] stats = {maxHunger, maxEnergy, weight};
	private static ImageIcon icon = new ImageIcon("resources/tiger_small.png");

	public PetTiger(String name){
		
		super("Tiger", tigerToy, stats, icon);
		super.setName(name);
	}
	
	public PetTiger(){
		
		super("Tiger", tigerToy, stats, icon);
	}
	

}
