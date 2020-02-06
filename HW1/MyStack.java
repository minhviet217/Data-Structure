/**
* A class that models a Stack using a singly linkedlist.
*
* @name		Viet Nguyen, Joshua Martin
* @version	02/06/2020
*/
import java.util.LinkedList;

public class MyStack<T> {

	private LinkedList<T> SinglyLinkedList;
	
	public MyStack() {
		this.SinglyLinkedList = new LinkedList<T>();
	}
	
	/**
	* Pops off the item on the top of the stack.
	*
	* @return	T 	
	*/
	public T pop() {
		T popValue = this.SinglyLinkedList.remove(this.SinglyLinkedList.size()-1);
		return popValue;
	}
	
	/**
	* Pushes an item to the top of the stack.
	*
	* @param	T 	item
	*/
	public void push(T value) {
		
		//Provide implementation.
		this.SinglyLinkedList.add(value);
	}
	
	/**
	* Check whether the stack is empty.
	*
	* @return	true or false	
	*/
	public boolean isEmpty(){
		if (this.SinglyLinkedList.size() == 0){
			return true;
		}
		return false;
	}
}