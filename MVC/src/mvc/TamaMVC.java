package mvc;

public class TamaMVC {
	
	public static void main(String[] args)
	{
		TamaModel 			 model = new TamaModel();
		TamaView 			 view  = new TamaView(model);
		TamaController	controller = new TamaController(model, view);
		
		view.frame.setVisible(true);
	}
}
