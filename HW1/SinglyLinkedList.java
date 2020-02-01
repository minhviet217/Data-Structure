import java.util.*;
import java.util.Iterator;
public class SinglyLinkedList<T> implements Iterable{
	
	private int size;
	
	private Node head;
	
	private Node tail;

	public SinglyLinkedList(){
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	class SinglyLinkedListIterator implements Iterator<T>{
		
		private Node node;
		
		public SinglyLinkedListIterator(){
			node = head;
		}

		public boolean hasNext(){
			if (node != null){
				return true;
			}
			return false;
		}

		public T next() {
			
			if (hasNext() == true)
			{
				T tempNode = node.getElement();
			
				node = node.getNextNode();

				return tempNode;
			}

			else {
				throw new NoSuchElementException("There is no next element!");
			}
		}
		
		public void remove(){
			throw new UnsupportedOperationException("remove operation is not supported by this iterator");
		}

	}

	class Node {
		
		private T element;

		private Node nextNode;

		public Node(T element){
			this.element = element;
			this.nextNode = null;
		}

		public Node getNextNode(){
			return this.nextNode;
		}

		public void setNextNode(Node nextNode){
			this.nextNode = nextNode;
		}

		public T getElement(){
			return this.element;
		}

		public void setElement(T element){
			this.element = element;
		}
	}

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

	public void insertAt(T element, int index){
		Node tempNode = this.head;
		if (index > size){
			System.out.println("index given greater than list's size!");
		}
		if (index == size){
			add(element);
		}
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
	
	public void clear(){
		this.head = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		if (this.size == 0){
			return true;
		}
		return false;
	}
	
	public int size(){
		return size;
	}
	
	public T getNthFromFirst(int n){
		Node tempNode = this.head;
		if (n > size-1){
			//if n  >= size, there is no element to get
			throw new NoSuchElementException("You are idiot!");
		}
		if (n == 0){
			return tempNode.getElement();
		}
		for (int i = 0; i < n; i++){
			tempNode = tempNode.getNextNode();
		}
		return tempNode.getElement();
	}
	
	public T getNthFromLast(int n){
		Node tempNode = this.head;
		if (n == size-1){
			return tempNode.getElement();
		}
		for (int i = 0; i < size - n; i++){
			tempNode = tempNode.getNextNode();
		}
		return tempNode.getElement();
	}
	
	public SinglyLinkedListIterator iterator(){
		return new SinglyLinkedListIterator();
	}
	
	public String toString(){
		return String.format("The singlylinkedlist has size of %d", size);
	}
}
