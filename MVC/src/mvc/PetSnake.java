package mvc;

import javax.swing.ImageIcon;

public class PetSnake extends Pet {
	
	private static String snakeToy = "Plane";
	private static int maxHunger = 30;
	private static int maxEnergy = 40;
	private static int weight = 4;
	private static int[] stats = {maxHunger, maxEnergy, weight};
	private static ImageIcon icon = new ImageIcon("resources/snake_small.png");
	
	
	public PetSnake(String name){
		
		super("Snake", snakeToy, stats, icon);
		super.setName(name);
	}
	
	public PetSnake(){
		
		super("Snake", snakeToy, stats, icon);
	}
	

}
