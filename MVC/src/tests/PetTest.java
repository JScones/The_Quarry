package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import mvc.Pet;
import mvc.PetTiger;
import mvc.Food;
import mvc.FoodBacon;
import mvc.Toy;
import mvc.ToyBall;
import mvc.ToyClub;


public class PetTest {

	//Change variable names?
	Pet Tigger = new PetTiger("PuddyCat");
	Food Piggy = new FoodBacon();
	Toy Ballo = new ToyBall();
	Toy Clubbo = new ToyClub();
	
	@Test
	public void testFeed() {
		int hunger = Tigger.getStats()[0];
		int value = Piggy.getValue();
		Tigger.feed(Piggy);
		
		assertEquals(Tigger.getStats()[0], hunger + value);
	}

	
	@Test
	public void testPlay() {
		Toy testToy = Ballo;
		//Toy testToy = Clubbo;
		int tiggerMood = Tigger.getStats()[5];
		Tigger.playAndBreak(testToy);
		if(testToy.getName() == Tigger.getFavToy()){
			assertEquals(tiggerMood + 5, Tigger.getStats()[5]);
		}
		else{
			assertEquals(tiggerMood + 2, Tigger.getStats()[5]);
		}
		
	}

}
