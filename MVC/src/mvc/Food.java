package mvc;

public class Food {

	private String name;
	private Double price;
	private int value;
	
	public Food(String foodName, Double foodPrice, int foodValue)
	{
		name = foodName;
		price = foodPrice;
		value = foodValue;
	}
	
	public int getValue()
	{
		return value;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
