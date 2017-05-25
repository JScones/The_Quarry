package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import mvc.*;


public class ToyTest {
	
	
	
	Player player = new Player();
	
	@Before
	public void SetUp()
	{
		player.addPet(new PetLion());
		player.addToy(new ToyBook()); //not favorite
		player.addToy(new ToyYarn()); //Favorite
		
	}
	
	
	@Test
	public void testFavBreak() {
		Toy yarn = player.getToys().get(1);
		int duro = yarn.getDurability();
		Pet lion = player.getPets().get(0);
		lion.playAndBreak(yarn);
		assertTrue((duro - 1) == (yarn.getDurability()));
	}

	@Test
	public void testDamage()
	{
		Toy book = player.getToys().get(0);
		int duro = book.getDurability();
		Pet lion = player.getPets().get(0);
		lion.playAndBreak(book);
		assertTrue(book.getDurability() == duro - 2);
	}
}
