public class Pokemon1Runner{
	public static void main(String[] args) {

        // build some Pokemon objects
        Pokemon1 charmander = new Pokemon1("Charmander",40,20);
        Pokemon1 pikachu = new Pokemon1("Pikachu",50,25);
        Pokemon1 onix = new Pokemon1("Onix",70,15);
        Pokemon1 geodude = new Pokemon1("Geodude",40,25);
        Pokemon1 meowth = new Pokemon1("Meowth",60,5);
		

        // build some PokemonTrainer objects
        PokemonObserver brock = new PokemonObserver("Brock");
        PokemonObserver ash = new PokemonObserver("Ash");
        PokemonObserver jesse = new PokemonObserver("Jessie");
        PokemonObserver james = new PokemonObserver("James");

        // ok, so now that we've got some Pokemon and Trainers, let's register them
        // so we know who is responsible for who (i.e. which trainers are observers of which Pokemon)

        // both jesse and james are responsible for meowth's well being
        meowth.addMyObserver(james);
        meowth.addMyObserver(jesse);

        // brock is responsible for geodude and onix
        geodude.addMyObserver(brock);
        onix.addMyObserver(brock);

        // ash is responsible for charmander and pikachu
        charmander.addMyObserver(ash);
        pikachu.addMyObserver(ash);

        // let's set the Pokemon loose - let them get into trouble, and see what happens
        geodude.attack(pikachu); // pikachu is the first in trouble
        pikachu.attack(geodude); // pikachu, or course, retaliates
        charmander.attack(meowth); // now charmander enters the fray
        meowth.attack(onix);  // but meowth is convinced that onix did it
		System.out.println(meowth.countMyObservers());
    }
}