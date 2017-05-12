package mvc;

public class TamaModel {
	
	private int clickCount;

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
