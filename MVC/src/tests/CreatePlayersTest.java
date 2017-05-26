package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import mvc.*;

public class CreatePlayersTest {

	CreatePlayers create = new CreatePlayers();
	String name = "Ash";
	ArrayList<String> petNames = new ArrayList<String>();
	Pet harambe = new PetGorilla();
	Pet cecil = new PetLion();
	ArrayList<String> species = new ArrayList<String>();
	ArrayList<Pet> pets = new ArrayList<Pet>();
	
	@Before
	public void SetUp()
	{
		petNames.add("Harambe");
		petNames.add("Cecil");
		species.add("Gorilla");
		species.add("Lion");
		harambe.setName("Harambe");
		cecil.setName("Cecil");
		pets.add(harambe);
		pets.add(cecil);
		
	}
	
	@Test
	public void testmakePlayerPets()
	{

		Player ash = create.makePlayer(name, species, petNames);
		
		assertTrue(ash.getPets().toString().equals(pets.toString()));
		
	}
	
	@Test
	public void testMakePlayer()
	{
		Player ash = create.makePlayer(name, species, petNames);
		assertTrue(ash.getMoney() == 50.0);
	}

}
