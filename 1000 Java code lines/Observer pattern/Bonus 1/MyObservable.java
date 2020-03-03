public class MyObservable{
	
	private int count;
	private boolean changed;
	private PokemonObserver[] myObservers;
	
	public MyObservable(){
		myObservers = new PokemonObserver[10];
	}
	
	public void addMyObserver(PokemonObserver myObserver){
		if (myObserver!=null){
			myObservers[count] = myObserver;
			countMyObservers();
		}
	}
	
	public void clearChanged(){
		changed = false;
	}
	
	public int countMyObservers(){
		return count++;
	}
	
	public void deleleMyObserver(PokemonObserver victim){
		if (myObservers.length != 0){
		 for(int i = 0; i < count; i++){
            if(myObservers[i]==victim){
                for(int j = i; j < count - 1; j++){
                    myObservers[j] = myObservers[j+1];
                }
                break;
            }
        }
		count--;}
		else {
			System.out.println("There is no Pokemon Trainers to delete!");
		}
	}
	
	public void deleleMyObserver(){
			myObservers = new PokemonObserver[0];
			count = 0;
		}
	
	public boolean hasChanged(){
		return changed=false;
	}
	
	public void notifyMyObservers(){
		notifyMyObservers(null);
	}
	
	public void notifyMyObservers(Object obj){
		if(!hasChanged()){
			for (int i = 0; i < count; i++){
			myObservers[i].update(myObservers[i],obj);}
			clearChanged();
		}
	}
	
	public void setChanged(){
		changed = true;
	}
}





