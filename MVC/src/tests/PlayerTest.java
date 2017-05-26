package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import mvc.*;

public class PlayerTest {

	Player daxx = new Player();
	Toy ball = new ToyBall();
	Toy club = new ToyClub();
	Food milk = new FoodMilk();
	Food Piggy = new FoodBacon();
	
	@Test
	public void testAddFood() 
	{
		ArrayList<Food> foods = daxx.getFood();
		foods.add(Piggy);
		daxx.addFood(Piggy);
		assertTrue(daxx.getFood().equals(foods));
		
	}
	
	@Test
	public void testAddToy()
	{
		ArrayList<Toy> toys = daxx.getToys();
		toys.add(ball);
		daxx.addToy(ball);
		
		assertTrue(daxx.getToys().equals(toys));
	}

	@Test
	public void testBuy()
	{
		double bal = daxx.getMoney();

		daxx.Buy(milk);
		assertTrue(bal - milk.getPrice() == daxx.getMoney());
		

	}
	
}
	
