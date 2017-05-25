package mvc;

import javax.swing.ImageIcon;

public class PetLion extends Pet {
	
	private static String lionToy = "Ball of yarn";
	private static int maxHunger = 60;
	private static int maxEnergy = 60;
	private static int weight = 100;
	private static int[] stats = {maxHunger, maxEnergy, weight};
	private static ImageIcon icon = new ImageIcon(PetLion.class.getResource("/resources/lion_small.png"));

	public PetLion(String name){
		
		super("Lion", lionToy, stats, icon);
		super.setName(name);
	}
	
	public PetLion(){
		
		super("Lion", lionToy, stats, icon);
	}
	
}