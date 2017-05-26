package mvc;

/**
 * Creates the model, view and controller objects and displays the view.
 * 
 *
 */
public class Main {
	
	public static void main(String[] args)
	{
		TamaModel 			 model = new TamaModel();
		TamaView 			 view  = new TamaView(model);
		@SuppressWarnings("unused")
		TamaController	controller = new TamaController(model, view);
		
		view.frame.setVisible(true);
	}
}
