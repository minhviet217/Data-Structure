/**
* A class that models a Stack using a singly linkedlist.
*
* @name		Viet Nguyen, Joshua Martin
* @version	02/06/2020
*/
import java.util.LinkedList;

public class MyStack<T> {

	private SinglyLinkedList<T> theList;
	
	public MyStack() {
		this.theList = new SinglyLinkedList<T>();
	}
	
	/**
	* Pops off the item on the top of the stack.
	*
	* @return	T 	
	*/
	public T pop() {
		SinglyLinkedList<T>.SinglyLinkedListIterator it = theList.iterator();
		T popValue = it.next();
		theList.remove(popValue);
		return popValue;
	}
	
	/**
	* Pushes an item to the top of the stack.
	*
	* @param	T 	item
	*/
	public void push(T value) {
	
		this.theList.add(value);
	}
	
	/**
	* Check whether the stack is empty.
	*
	* @return	true or false	
	*/
	public boolean isEmpty(){
		if (this.theList.size() == 0){
			return true;
		}
		return false;
	}
}