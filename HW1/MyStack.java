/**
* A class that models a Stack using a singly linkedlist.
*
* @name		Viet Nguyen, Joshua Martin
* @version	02/06/2020
*/
import java.util.LinkedList;

public class MyStack<T> {

	private SinglyLinkedList<T> theList;
	private T temp;
	
	//Stack constructor that creates a new list to use as a "stack"
	public MyStack() {
		//Instantiates a new list theList.
		this.theList = new SinglyLinkedList<T>();
	}
	
	/**
	* Pops off the item on the top of the stack.
	*
	* @return	T 	 the item popped off the top of the stack.
	*/
	public T pop() {
		//Creates a new iterator for theList.
		SinglyLinkedList<T>.SinglyLinkedListIterator it = theList.iterator();
		//Use while loop to iterate to the last node in theList.
		while(it.hasNext()){
			//Store the element from the last node.
			this.temp = it.next();
		}
		//Remove the last node
		theList.remove(this.temp);
		//Return the popped value from the stack.
		return this.temp;
	}
	
	/**
	* Peek the item on the top of the stack.
	*
	* @return	T 	 the item popped off the top of the stack.
	*/
	public T peek() {
		//Creates a new iterator for theList.
		SinglyLinkedList<T>.SinglyLinkedListIterator it = theList.iterator();
		//Use while loop to iterate to last node in theList.
		while(it.hasNext()){
			this.temp = it.next();
		}
		//Return the element from the last node in theList.
		return this.temp;
	}
	
	
	/**
	* Pushes an item to the top of the stack.
	*
	* @param	T 	item  	
	*/
	public void push(T value) {
		//Add a node to the end of theList, this is functionally the top of the "stack"
		this.theList.add(value);
	}
	
	/**
	* Check whether the stack is empty.
	*
	* @return	true or false	 If the stack is empty this method will return true.
	*/
	public boolean isEmpty(){
		//Check the size of theList
		if (this.theList.size() == 0){
			//If size == 0 it is true that theList is empty.
			return true;
		}
		//If size!=0 It is false that theList is empty.
		return false;
	}
}