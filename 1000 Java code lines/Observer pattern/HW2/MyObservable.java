public class MyObservable{
	
	private int count;
	private boolean changed;
	private PokemonObserver[] myObservers;
	
	public MyObservable(){
		myObservers = new PokemonObserver[10];
	}
	
	/**
	* Adds a PokemonObserver object to the array. 
	*
	* @param 	myObserver		A PokemonObserver object that will be added to myObservers.
	*/
	public void addMyObserver(PokemonObserver myObserver){
		if (myObserver!=null){
			myObservers[count] = myObserver;
			countMyObservers();
		}
	}
	
	/**
	* Changes the value of hasChanged back to false.
	*/
	public void clearChanged(){
		changed = false;
	}
	
	/**
	* Returns the number of Observers, which is value of count.
	*/
	public int countMyObservers(){
		return count++;
	}
	
	/**
	* Essentially, accesses value of hasChanged.
	*/
	public boolean hasChanged(){
		return changed = false;
	}
	
	/**
	* Notifies Observers of a change 
	*/
	public void notifyMyObservers(){
		notifyMyObservers(null);
	}
	
	/**
	* Notifies Observers of a change by calling update when 
	* hasChanged is true and sends in an argument as well.
	*/
	public void notifyMyObservers(Object obj){
		if(!hasChanged()){
			for (int i = 0; i < count; i++){
			myObservers[i].update(myObservers[i],obj);}
			clearChanged();
		}
	}
	
	/**
	* Changes the value of hasChanged to true.
	*/
	public void setChanged(){
		changed = true;
	}
}





