package mvc;

import javax.swing.ImageIcon;

public class PetGorilla extends Pet {
	
	private static String gorillaToy = "Club";
	private static int maxHunger = 5;
	private static int maxEnergy = 4;
	private static int weight = 250;
	private static int[] stats = {maxHunger, maxEnergy, weight};
	private static ImageIcon icon = new ImageIcon("resources/Harambe_small.png");

	public PetGorilla(String name){
		
		super("Gorilla", gorillaToy, stats, icon);
		super.setName(name);
	}
	
	public PetGorilla(){
		
		super("Gorilla", gorillaToy, stats, icon);
	}
	

}
