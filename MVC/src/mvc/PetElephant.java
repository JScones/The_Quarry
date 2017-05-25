package mvc;

import javax.swing.ImageIcon;

public class PetElephant extends Pet {
	
	private static String elephantToy = "Piano";
	private static int maxHunger = 95;
	private static int maxEnergy = 40;
	private static int weight = 1206;
	private static int[] stats = {maxHunger, maxEnergy, weight};
	private static ImageIcon icon = new ImageIcon(PetElephant.class.getResource("/resources/elephant_small.png"));

	public PetElephant(String name){
		
		super("Elephant", elephantToy, stats, icon);
		super.setName(name);
	}
	
	public PetElephant(){
		
		super("Elephant", elephantToy, stats, icon);
	}
}
	
