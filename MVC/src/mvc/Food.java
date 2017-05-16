package mvc;

public class Food {

	private String name;
	private Double price;
	private int value;
	
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
