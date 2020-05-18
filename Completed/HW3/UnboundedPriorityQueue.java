import java.util.*;

public class UnboundedPriorityQueue<T extends Comparable<? super T>>{
	//Setting the array as an instance variable.
	T[] queue;
	//Setting a default size for the array creation.
	private static final int DEFAULT_SIZE = 10;
	//Initializing size to zero.
	private int size = 0;
	
	//Default constructor using the default array size.
	public UnboundedPriorityQueue(){
		queue = (T[]) new Comparable[DEFAULT_SIZE];
	}
	
	//Constructor based on a given size.
	public UnboundedPriorityQueue(int queueSize){
		queue = (T[]) new Comparable [queueSize + 1];
	}
	
	//Insert into the priority queue, maintaining heap.
	public void enqueue(T element){
		if(size == queue.length - 1){
			//Resizing array to make it bigger using a temp array.
			T[] temp = queue;
			queue = (T[]) new Comparable[queue.length * 2 + 1];
			//Placing array elements back in there index in bigger T[].
			for(int i = 0; i < temp.length;i++){
				queue[i] = temp[i];
			}
		}
		//Percolate upward to maintain heap.
		int num = ++size;
		//Compares new element to existing element at queue[num/2] until the element is greater than or equal.
		for(queue[0] = element; element.compareTo(queue[num/2]) < 0; num /= 2)
			queue[num] = queue[num/2];
		//Assign the element to it's index in the array.
		queue[num] = element;
	}
	
	
	
	//Remove item from priority queue, maintaining heap.
	public T dequeue(){
		//If isEmpty is equal to true then the array is empty and we can't dequeue.
		if(isEmpty()){
			throw new IndexOutOfBoundsException("Priority queue is empty!");
		}
		
		//Find minimum item since it is the item we need to remove.
		T deleteItem = findMin();
		queue[1] = queue[size--];
		//Use percolateDown method to maintain heap structure as you remove an element from the queue.
		percolateDown(1);
		
		return deleteItem;
	}
	
	public T findMin( )
    {
		//If the queue is empty then the index will be out of bounds if we try to dequeue.
        if(isEmpty( )){
            throw new IndexOutOfBoundsException("Priority queue is empty!");
		}
		//Return the first element in the queue as it is the min.
        return queue[1];
    }
	
	//Adjusting the queue in the case of a dequeue. 
	public void percolateDown(int num){
		int child;
		T temp = queue[num];
		//Given that the queue has more than one element 
		while(num * 2 <= size){
			child = num * 2;
			//Checking to see we are not at the last index and that our element contained at the child index is greater than the next indexes element.
			if(child != size && queue[child + 1].compareTo(queue[child]) < 0)
				//Increment child in order check the next index.
				child++;
			if(queue[child].compareTo(temp) < 0)
				//If the child element is less than temp element than the child element should be the value left in the num index.
				queue[num] = queue[child];
			else
				//If child element is greater than temp break the loop.
				break;
		}
		
		queue[num] = temp;
	}
	
	//A method to tell whether the Array queue is empty or not.
	public boolean isEmpty(){
		//If the size of the queue is zero then it is empty(true).
		if(size == 0){
			return true;
		}else{
			return false;
		}
	}
	
	//A getter method to check the size of the queue.
	public int getSize(){
		return this.size;
	}
}