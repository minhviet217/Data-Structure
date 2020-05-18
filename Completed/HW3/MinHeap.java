import java.util.List;
import java.lang.Exception;
public class MinHeap<T extends Comparable>{

    private static final int DEFAULT_CAPACITY = 10;
    private int size;//Numbers of elements in the min heap
    private T[] array;//The min heap array
    //Create default constructor for the min heap
    public MinHeap(){
        this(DEFAULT_CAPACITY);
    }

    //Create constructor for the min heap with optional capacity
    public MinHeap(int capacity){
        size = 0;
        array = (T[]) new Comparable[capacity+1];
    }

    // this method is to check if the min heap is empty or not
    // @return true if the size of the min heap is equal to 0 
    public boolean isEmpty(){
        return size == 0;
    }

    // @return number of elements in the min heap 
    public int size(){
        return size;
    }

    // @return true if the min heap's size is equal to (array.length - 1)
    public boolean isFull(){
        if (size == array.length-1)
            return true;
        return false;
    }

    //If the size of the array is not big enough for inserting new item
    //and then, create new array with bigger size
    private void newArray(int newSize){
        if (size > newSize){
            throw new IllegalArgumentException("new size is smaller than current size!");
        }

        T[] newArray = (T[]) new Comparable[array.length*2+1];
        for (int i = 0; i <= array.length; i++){
            newArray[i] = array[i];
        }
    }
    /** Insert item into the min heap */
    public void Insert(T item)
    {
      // increase array size if the min heap is full
      if (size >= (array.length - 1)){
		  newArray(array.length*2+1);
      }
   
      // find position for item
      // currentNode starts at new leaf and go up to the root of the minheap
      int currentNode = ++size;
      while (currentNode != 1 && array[currentNode/2].compareTo(item) > 0)
      {
         // if array[currentNode] can not hold the item
         array[currentNode] = array[currentNode/2]; // move item down
         currentNode /= 2;                          // move to parent
      }
   
      array[currentNode] = item;
   }

    //This method to get minimum value of the minheap, always at array[1]
    public T getMin(){
		if (size == 0){
			return null;
		}
		return array[1];
	}
   
    /** remove min element and return it */
   public T remove()
   {
      // if array is empty return null
      if (size == 0) return null;      
   
      // The minimum element of the min heap is at index 1 of the array
      T removedElement = array[1];  
   
      // Save the last element in the array
      T lastElement = array[size--];
   
      // begin with root,find a position for lastElement
      int currentNode = 1;  // assgin current node(root) to 1
      int child = 2;        // the child of currentNode is 1 + 1 = 2
      while (child <= size)
      {
         // if child is not the last element and the value of array[child + 1] is smaller than 
         //the value of array[child], assign the bigger value to array[child]
         if ((child < size) && (array[child].compareTo(array[child + 1]) > 0)){
             child = child + 1;
            }
   
         // insert last Element in array[currentNode] if last element is smaller than array[child]
         if (lastElement.compareTo(array[child]) <= 0){
             // Done with insert
			 break;   
            }
   
        // if last element is bigger than array[child]
		// move child up
		array[currentNode] = array[child]; 
		// move down a level
        currentNode = child;             
         child *= 2;
      }
      array[currentNode] = lastElement;
   
      return removedElement;
   }
   
   //Print out the min heap
   public String toString()
   {
      StringBuffer s = new StringBuffer(); 
      s.append("The list of elements in the minheap is: [");
      s.append(array[1]);
      for (int i = 2; i <= size; i++){
        s.append(", " + array[i]);
      }
      s.append("]");
      return new String(s);
   }
}