public class PokemonRunnerExample {

/* an example class to show you examples of how to set up Observers and Observables.
   imagine a Pokemon Day Care, where Pokemon Trainers are responsible for the well-being
   of different Pokemon, and need to be notified with the Pokemon in his/her care or being
   attacked by their classmates
*/

    public static void main(String[] args) {

        // build some Pokemon objects
        Pokemon charmander = new Pokemon("Charmander",40,20);
        Pokemon pikachu = new Pokemon("Pikachu",50,25);
        Pokemon onix = new Pokemon("Onix",70,15);
        Pokemon geodude = new Pokemon("Geodude",40,25);
        Pokemon meowth = new Pokemon("Meowth",60,5);

        // build some PokemonTrainer objects
        PokemonTrainer brock = new PokemonTrainer("Brock");
        PokemonTrainer ash = new PokemonTrainer("Ash");
        PokemonTrainer jesse = new PokemonTrainer("Jessie");
        PokemonTrainer james = new PokemonTrainer("James");
		PokemonTrainer tammi = new PokemonTrainer("Tammi");

        // ok, so now that we've got some Pokemon and Trainers, let's register them
        // so we know who is responsible for who (i.e. which trainers are observers of which Pokemon)

        // both jesse and james are responsible for meowth's well being
        meowth.addObserver(jesse);
        meowth.addObserver(james);
		meowth.addObserver(tammi);

        // brock is responsible for geodude and onix
        geodude.addObserver(brock);
        onix.addObserver(brock);

        // ash is responsible for charmander and pikachu
        charmander.addObserver(ash);
        pikachu.addObserver(ash);

        // let's set the Pokemon loose - let them get into trouble, and see what happens
       geodude.attack(pikachu); // pikachu is the first in trouble
       pikachu.attack(geodude); // pikachu, or course, retaliates
       charmander.attack(meowth);     // now charmander enters the fray
       meowth.attack(onix);  // but meowth is convinced that onix did it
		System.out.println(pikachu);
    }

}
