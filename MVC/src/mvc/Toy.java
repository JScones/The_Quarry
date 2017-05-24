package mvc;

public class Toy {
	
	private String name;
	private Double price;
	protected int durability;
	
	public void setVars(String aName, Double aPrice, int aDurability)
	{
		name = aName;
		price = aPrice;
		durability = aDurability;
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public Double getPrice()
	{
		return price;
	}
	
	public int getDurability()
	{
		return durability;
	}
	
	@Override
	public String toString(){
		return name;
	}

	public boolean playAndBreak(int damage)
	{
		durability -= damage;
		if( durability < 1)
		{
			return true;
		}
		else
			return false;
	}
}
