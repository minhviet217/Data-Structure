import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.Observable;
import java.util.Observer;

public class RedirectTester{
	
	private ByteArrayOutputStream output = new ByteArrayOutputStream();
	private ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
	private String lineSeparator = System.getProperty("line.separator");
	private Pokemon charmander;
	private Pokemon pikachu;
	private Pokemon onix;
	private Pokemon geodude;
	private PokemonTrainer brock;
	private PokemonTrainer jesse;
	private PokemonTrainer james;
	private PokemonTrainer Ash;
	
	@Before
	public void setup() {
		System.setOut(new PrintStream(output));
		System.setErr(new PrintStream(errorOutput));
	} // end @Before method
	
	@After
	public void resetStreams() {
	System.setOut(System.out);
	System.setErr(System.err);
} // end @After method
	
	/**
	* Test for method getHealth in Pokemon Class
	*/
	@Test
	public void getHealthPokemonTest(){
		pikachu = new Pokemon("Pikachu",50,25);
		assertEquals(50,pikachu.getHealth());
	}
	
	/**
	* Test for method getAttackPower in Pokemon Class
	*/
	@Test
	public void getAttackPowerPokemonTest(){
		charmander = new Pokemon("Charmander",40,20);
		assertEquals(20,charmander.getAttackPower());
	}
	
	/**
	* Test for method getName in Pokemon Class
	*/
	@Test
	public void getNamePokemonTest(){
		onix = new Pokemon("Onix",70,15);
		assertEquals("Onix",onix.getName());
	}
	
	/**
	* Test for method isDead in Pokemon Class with the first condition
	* the Pokemon is not dead
	*/
	@Test
	public void isDeadPokemonTestConditionOne(){
		geodude = new Pokemon("Geodude",60,20);
		boolean isDead = false;
		assertEquals(isDead,geodude.isDead());
	}
	
	/**
	* Test for method getHealth in Pokemon Class with second condition
	* the Pokemon is dead
	*/
	@Test
	public void isDeadPokemonTestConditionTwo(){
		geodude = new Pokemon("Geodude",0,20);
		boolean isDead = false;
		assertEquals(!isDead,geodude.isDead());
	}
	
	/**
	* Test for method takeDamage in Pokemon Class with the first condition
	* the value of amountDamage is greater than the value of Pokemon's health
	* the pokemon here is pikachu
	*/
	@Test
	public void takeDamagePokemonTestConditionOne(){
		int amountDamage = 10;
		pikachu = new Pokemon("Pikachu",5,20);
		Pokemon attacker = new Pokemon("Geodude",40,10);
		pikachu.takeDamage(10,attacker);
		assertEquals(0,pikachu.getHealth());
	}
	
	/**
	* Test for method takeDamage in Pokemon Class with the second condition
	* the value of amountDamage is less than or equal to the value of Pokemon's health
	* the pokemon here is pikachu
	*/
	@Test
	public void takeDamagePokemonTestConditionTwo(){
		int amountDamage = 10;
		pikachu = new Pokemon("Pikachu",50,20);
		Pokemon attacker = new Pokemon("Geodude",40,10);
		pikachu.takeDamage(10,attacker);
		assertEquals(40,pikachu.getHealth());
	}
	
	/**
	* Test for method attackPokemon in Pokemon Class
	*/
	@Test
	public void attackPokemonTest(){
		pikachu = new Pokemon("Pikachu",50,20);
		Pokemon other = new Pokemon("Geodude",40,10);
		other.attack(pikachu);
		assertEquals(40,pikachu.getHealth());
	}
	
	/**
	* Test for method toString in Pokemon Class
	*/
	@Test
	public void toStringPokemonTest(){
		pikachu = new Pokemon("Pikachu",50,20);
		String p = "Pokemon " + pikachu.getName() + ":\n\thealth: " + pikachu.getHealth() + "\n\tattack: " + pikachu.getAttackPower();
		assertEquals(p,pikachu.toString());
	}
	
	/**
	* Test for method getName in PokemonTrainer Class
	*/
	@Test
	public void getNamePokemonTrainerTest(){
		brock = new PokemonTrainer("Brock");
		assertEquals("Brock",brock.getName());
	}
	
	/**
	* Test for method update in PokemonTrainer Class
	*/
	@Test
	public void updatePokemonTrainerTest(){
		Object o = new Object();
		String whatsGoingOn = "";
        whatsGoingOn += this + " is notified that " + o;
        System.out.println(whatsGoingOn);
		assertEquals(whatsGoingOn + lineSeparator, output.toString());
	}
	
	/**
	* Test for output in Pokemon Class and PokemonTrainer Class
	*/
	@Test
	public void testStdErr() {
		brock = new PokemonTrainer("Brock");
		jesse = new PokemonTrainer("Jesse");
		Pokemon attacker = new Pokemon("Pikachu",50,20);
		Pokemon victim = new Pokemon("Geodude",40,10);
		victim.addObserver(brock);
        victim.addObserver(jesse);
		attacker.addObserver(brock);
		String typeOfAttack = "sword";
		WhatHappened attack = new WhatHappened(attacker, victim, typeOfAttack,5);
		String whatsGoingOn = "";
        whatsGoingOn += this + " is notified that " + attack;
        System.err.println(whatsGoingOn);
		assertEquals(whatsGoingOn + lineSeparator, errorOutput.toString());
	}
	
	/**
	* Test for method toString in PokemonTrainer Class
	*/
	@Test
	public void toStringPokemonTrainerTest(){
		brock = new PokemonTrainer("Brock");
		String returnval = "";
        returnval += "PokemonTrainer " + brock.getName();
        assertEquals(returnval,brock.toString());
	}
}