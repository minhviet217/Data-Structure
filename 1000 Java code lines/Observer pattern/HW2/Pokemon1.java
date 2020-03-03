/**
	* This Pokemon1 class is modibfied by the Pokemon class 
	* so that it becomes a myObservable subtype
	* @version 9/11/2019
	* @author Viet Nguyen, HW2 2120
	*/
public class Pokemon1 extends MyObservable{
	private int myHealth;  /** @invariant myHealth >=0 */
    private int myAttackPower; /** @invariant myAttackPower >= 0 */
    private String myName; /** @invariant myName != "" */
	
	/**
        @param name The name of the Pokemon
        @param initialHealth The initial health of the Pokemon
        @param initialAttackPower The initial attack power of the Pokemon
        @since Sunday, Sep 9, 2018

        @custom.require name != ""
        @custom.require initialHealth > 0
        @custom.require initialAttackPower > 0
        @custom.ensure  getName() != "" && getName() == name
        @custom.ensure  getHealth() > 0 && getHealth() == initialHealth
        @custom.ensure  getAttackPower() > 0 && getAttackPower() == initialAttackPower
    */
    public Pokemon1(String name, int initialHealth, int initialAttackPower) {
        myName = name;
        myAttackPower = initialAttackPower;
        myHealth = initialHealth;
    }

    /**
        @return An int corresponding to the Pokemon's current health
        @custom.ensure  getHealth() >= 0
    */
    public int getHealth() {
        return myHealth;
    }

    /**
        @return An int corresponding to the Pokemon's current attack
        @custom.ensure  getAttackPower() >= 0
    */
    public int getAttackPower() {
        return myAttackPower;
    }

    /**
        @return A string corresponding to the Pokemon's name
        @custom.ensure  getName() != ""
    */
    public String getName() {
        return myName;
    }

    /**
        @return Returns true of the Pokemon's health is zero, otherwise false
    */
    public boolean isDead() {
        if (myHealth == 0)
            return true;
        return false;
    }

    /**
        @param other The other pokemon to attack
        @custom.require other != null
        @custom.ensure  other.getHealth() == 0 || (other.getHealth() == other.old.getHealth() - getAttackPower()) 
    */
    public void attack(Pokemon1 other) {
        other.takeDamage(this.myAttackPower, this);
    }

    /**
        @param amountOfDamage The amount of damage that this pokemon takes in an attack
        @param attacker The pokemon that dealth the damage to this pokemon
        @custom.require amountOfDamage >= 0
        @custom.ensure  getHealth() == 0 || (getHealth() == old.getHealth() - amtOfDamage) 
    */
    public void takeDamage(int amountOfDamage, Pokemon1 attacker) {
        int amtOfDamageActuallyDealt;
        if (amountOfDamage > myHealth) {
            amtOfDamageActuallyDealt = myHealth;
            myHealth = 0;
        }
        else {
            myHealth -= amountOfDamage;
            amtOfDamageActuallyDealt = amountOfDamage;
        }
        setChanged();
        notifyMyObservers(new WhatHappened(attacker, this, "Body Slam", amtOfDamageActuallyDealt));
    }

    /**
        @return Returns a string corresponding the the state of the Pokemon
    */
    public String toString() {
        String returnval = "";
        returnval += "Pokemon " + myName + ":\n\thealth: " + myHealth + "\n\tattack: " + myAttackPower;
        return returnval;
    }

}