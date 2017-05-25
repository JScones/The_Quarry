package mvc;

import javax.swing.ImageIcon;

public class PetEagle extends Pet {
	
	private static String favToy = "Ball";
	private static int maxHunger = 70;
	private static int maxEnergy = 80;
	private static int weight = 100;
	private static int[] stats = {maxHunger, maxEnergy, weight};
	private static ImageIcon icon = new ImageIcon(PetEagle.class.getResource("/resources/eagle_small.png"));

	public PetEagle(String name){
		
		super("Eagle", favToy, stats, icon);
		super.setName(name);
	}
	
	public PetEagle()
	{
		super("Eagle", favToy, stats, icon);
	}
}
