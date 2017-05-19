package mvc;

public class ToyBall extends Toy{

	public ToyBall()
	{
		super.setVars("Ball", 18.0, 19);
	}
	
	@Override
	public void play(int damage)
	{
		durability -= damage;
		if( durability < 1)
		{
			System.out.println("Oh no, the ball popped! ");
			//remove from player's inventory here
		}
	}
}
