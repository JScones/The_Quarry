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
		System.out.println("aaaaaa\nddddddd");
	}

	@Test
	public void testBuy()
	{
		double bal = daxx.getMoney();

		daxx.Buy(milk);
		assertTrue(bal - milk.getPrice() == daxx.getMoney());
		

	}
	
	@Test
	public void testBuyExceed()
	{
		double bal = daxx.getMoney();
		ArrayList<Food> foods = daxx.getFood();
		daxx.setMoney(1.0);

		daxx.Buy(milk);

		assertTrue(1.0 == daxx.getMoney());
		daxx.setMoney(bal);
		assertTrue(foods == daxx.getFood());
		
	}

}
	
