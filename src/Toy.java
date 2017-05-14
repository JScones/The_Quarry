
public class Toy {
	
	private String name;
	private Double price;
	private int durability;
	
	public Toy(String aName, Double aPrice, int aDurability)
	{
		name = aName;
		price = aPrice;
		durability = aDurability;
		
	}
	
	public Toy()
	{
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public Double getPrice()
	{
		return price;
	}

	protected void play(int damage)
	{
		durability -= damage;
		if( durability > 1)
		{
			System.out.println("Oops, it broke :( ");
			//remove from player's inventory here
		}
	}
}
