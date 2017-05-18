package mvc;

public abstract class Toy {
	
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

	public abstract void play(int damage);
}
