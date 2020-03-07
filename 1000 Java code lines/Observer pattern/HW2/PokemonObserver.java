/**
	* This PokemonObserver class is modibfied by the PokemonTrainer class 
	* so that it becomes a myObserver subtype
	* @version 9/11/2019
	* @author Viet Nguyen,HW2 2120
	*/

public class PokemonObserver implements MyObserver{
	 private String myName; /** @invariant myName != "" */
    
    /**
        @param name The name of the PokemonTrainer
        @since Sunday, Sep 9, 2018

        @custom.require name != ""
    */
    public PokemonObserver(String name) {
        myName = name;
    }

    /**
        @return A string corresponding to the PokemonTrainer's name
        @custom.ensure  getName() != ""
    */
    public String getName() {
        return myName;
    
    } 

    @Override
    /**
        {@inheritdoc}
    */
    public void update(PokemonObserver obs, Object o) {
        String whatHappened = "";
        whatHappened += this + " is notified that " + o;
        System.out.println(whatHappened);
    }

    /**
        @return Returns a string corresponding the the state of the PokemonTrainer
    */
    public String toString() {
        String returnval = "";
        returnval += "PokemonTrainer " + myName;
        return returnval;
    }
}