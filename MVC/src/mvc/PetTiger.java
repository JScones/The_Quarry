package mvc;

import javax.swing.ImageIcon;

public class PetTiger extends Pet {
	
	private static String tigerToy = "Book";
	private static int maxHunger = 50;
	private static int maxEnergy = 100;
	private static int weight = 85;
	private static int[] stats = {maxHunger, maxEnergy, weight};
	private static ImageIcon icon = new ImageIcon(PetTiger.class.getResource("/resources/tiger_small.png"));

	public PetTiger(String name){
		
		super("Tiger", tigerToy, stats, icon);
		super.setName(name);
	}
	
	public PetTiger(){
		
		super("Tiger", tigerToy, stats, icon);
	}
	

}
