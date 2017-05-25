package mvc;

import javax.swing.ImageIcon;

public class PetGorilla extends Pet {
	
	private static String gorillaToy = "Club";
	private static int maxHunger = 80;
	private static int maxEnergy = 60;
	private static int weight = 250;
	private static int[] stats = {maxHunger, maxEnergy, weight};
	private static ImageIcon icon = new ImageIcon(PetGorilla.class.getResource("/resources/Harambe_small.png"));

	public PetGorilla(String name){
		
		super("Gorilla", gorillaToy, stats, icon);
		super.setName(name);
	}
	
	public PetGorilla(){
		
		super("Gorilla", gorillaToy, stats, icon);
	}
	

}
