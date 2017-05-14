package mvc;

public class TamaModel {
	
	private int clickCount;
	String[] species = {"Lion", "Gorilla", "Eagle", "Tiger", "Elephant", "Snake"};

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
		
		
}
