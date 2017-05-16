package mvc;

public class TamaModel{
	
	private int clickCount;
	private String[] species = {"Lion", "Gorilla", "Eagle", "Tiger", "Elephant", "Snake"};


	public TamaModel()
	{
			
	}
	
	public void clicked()
	{
		clickCount++;
	}
	
	public int getClickCount()
	{
		return clickCount;
	}
	
	public String getMainMenuText()
	{
		String main = "Welcome to our tamagotchi game";
		return main;
	}
	
	public String getHelpText()
	{
		String help = "<html>This is where the help text goes<BR></html>";
		return help;
	}
		
		
}
