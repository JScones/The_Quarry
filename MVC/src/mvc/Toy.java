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

	/**
	 * Does damage to a toy when its played with.
	 * @param damage damage value done by pet
	 * @return whether or not the toy will break
	 */
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
