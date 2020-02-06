/**
* A class that implements a singly LinkedList
*
* @name		Viet Nguyen, Joshua Martin
* @version	02/06/2020
*/
import java.util.*;
import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable{
	//Instance variable for amount of nodes in Singly Linked List.
	private int size;
	//Instance variable for the first node(head node) in the Singly Linked List.
	private Node head;
	//Instance variable for the last node(tail node) in the Singly Linked List.
	private Node tail;

	public SinglyLinkedList(){
		//Initialize the size, head, and tail in the constructor.
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	//The SinglyLinkedListIterator is a private inner class, it implements the Iterator interface and it's methods. 
	private class SinglyLinkedListIterator implements Iterator<T>{
		//Declare Node instance variable.
		private Node node;
		//SinglyLinkedList Constructor assigns head node to node instance variable.
		public SinglyLinkedListIterator(){
			node = head;
		}
        //hasNext method tests whether the next node is null or not.
		public boolean hasNext(){
			if (node != null){
				return true;
			}
			return false;
		}
		//next method returns the next node element referenced from the currently focused node.
		public T next() {
			//If the next node referenced is not null return the element of that node.
			if (hasNext() == true)
			{
				T tempNode = node.getElement();
			
				node = node.getNextNode();

				return tempNode;
			}
			//If the next node's element is null throw an exception.
			else {
				throw new NoSuchElementException("There is no next element!");
			}
		}
		
		//The remove method is not supported in our current Singly Linked List Iterator so we throw an exception.
		public void remove(){
			throw new UnsupportedOperationException("remove operation is not supported by this iterator");
		}

	}

	//A private nested class.
	private static class Node {
		//Instance variable to store the element within a node.
		private T element;
		//Instance variable to store a reference to the next node from the current node focused upon.
		private Node nextNode;

		//Node constructor that builds a new Node with a given element within it.
		public Node(T element){
			this.element = element;
			//The next node from the newly created node should be null since we want to be able to set it later.
			this.nextNode = null;
		}

		//The getNextNode method gets the next node in the SinglyLinkedList from the current node.
		public Node getNextNode(){
			return this.nextNode;
		}
		//The setNextNode method allows us to change the value of the next node a node references.
		public void setNextNode(Node nextNode){
			this.nextNode = nextNode;
		}

		//the getElement method returns the element contained within a Node.
		public T getElement(){
			return this.element;
		}

		//The setElement method changes value of the element within a Node.
		public void setElement(T element){
			this.element = element;
		}
	}
	
	//The add method allows for the addition of a new Node in the SinglyLinkedList and increments the size accordingly.
	public void add(T element){
		Node newNode = new Node(element);
		if (this.size == 0){
			this.head = newNode;
			this.tail = newNode;
		}else {
			this.tail.setNextNode(newNode);
			this.tail = newNode;
		}
		this.size++;
	}
	
	//Inserts a Node a given index in the SinglyLinkedList.
	public void insertAt(T element, int index){
		//Creates a temporary Node.
		Node tempNode = this.head;
		//If the index given is greater than the size of the list, than it will print a statement explaining why that is wrong.
		if (index > size){
			System.out.println("index given greater than list's size!");
		}
		//If the index given is equal to size we can use the add method to add a new Node.
		if (index == size){
			add(element);
		}
		//If the index is less than the size of the list you have to iterate through the list to the proper index and insert the new Node.
		else {
			//iterate through node in the list until the node before target node
			for (int i = 0; i < index; i++){
				tempNode = tempNode.getNextNode();
			}
			//Create target Node
			Node targetNode = new Node(element);
			//store next node of tempNode into beyond 
			Node beyond = tempNode.getNextNode();
			//set the next reference of target node to beyond
			targetNode.setNextNode(beyond);
			//set the next reference of previous to the target node
			tempNode.setNextNode(targetNode);
			size++;
		}
	}
	
	public void remove(T element){
		Node tempNode = this.head;
		Node currentNode = tempNode.getNextNode();
		//Checking if the head is the node containing element to be removed.
		if(tempNode.getElement().equals(element)){
			//Changing the head node to the next node from the previous head.
			this.head = tempNode.getNextNode();
			size--;
			
		}else{
			//Iterating through until the currentNode is the node containing the desired element.
			while(currentNode.getElement().equals(element) == false){
				//Changing tempNode and currentNode to their next nodes.
				tempNode = currentNode;
				currentNode = currentNode.getNextNode();
			}
			//Since we wish to remove currentNode we set the next reference from tempNode to currentNode.getNextNode.
			tempNode.setNextNode(currentNode.getNextNode());
			size--;
		}
	}
	//Clears the nodes from the LinkedList.
	public void clear(){
		this.head = null;
		size = 0;
	}
	
	//Tells whether the list is empty or not.	
	public boolean isEmpty(){
		if (this.size == 0){
			return true;
		}
		return false;
	}
	
	//Returns the size value of the SinglyLinkedList.
	public int size(){
		return size;
	}
	
	//Gets the element within the Node that is a certain number from the first.
	public T getNthFromFirst(int n){
		//Store the value of the head Node to help us with iterating the list.
		Node tempNode = this.head;
		if (n > size-1){
			//if n  >= size, there is no element to get so it throws an exception.
			throw new NoSuchElementException("The element does not exist.");
		}
		//If the value given is 0 then we just need to return the element from the first Node.
		if (n == 0){
			return tempNode.getElement();
		}
		//Iterate through each Node by setting tempNode to it's next Node until we reach the proper Node.
		for (int i = 0; i < n; i++){
			tempNode = tempNode.getNextNode();
		}
		//Return the Node we wish to get which should be stored in tempNode.
		return tempNode.getElement();
	}
	
	//Gets the Node that is a given number of nodes from the end.
	public T getNthFromLast(int n){
		//Create a temporary Node to store the head Node for use iterating.
		Node tempNode = this.head;
		//If the number is equal to the size-1 then it is the head Node we need to return.
		if (n == size-1){
			return tempNode.getElement();
		}
		//Iterate through the Nodes by reassigning tempNode to it's next referenced Node until we reach the Node we desire based on size - n - 1 from the head Node.
		for (int i = 0; i < size - n; i++){
			tempNode = tempNode.getNextNode();
		}
		//Return the value of tempNode which will contain the Node we want to get the element from.
		return tempNode.getElement();
	}
	
	//Returns a newly instantiated SinglyLinkedListIterator.
	public SinglyLinkedListIterator iterator(){
		return new SinglyLinkedListIterator();
	}
	
	//Returns a string that shows the size of the SinglyLinkedList.
	public String toString(){
		return String.format("The singlylinkedlist has size of %d", size);
	}
}
