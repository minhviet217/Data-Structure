Homework 3 - Priority Queue

For this assignment we were tasked with implementing two classes:
UnboundedPriorityQueue.java and MinHeap.java

For UnboundedPriorityQueue we were advised to give it constructors for a given size and constructors with a default size.

In order to accomplish this we set a default int to make sure that there was a base size given if the user did not specify one in the construction of the T array.
If the size was specified the T array was just made for that specific size.

In order to enqueue we had to ensure the array size was large enough and that we maintained the heap.
For dequeue we had to ensure that the array was not empty and that the heap order was maintained.
In order to check the size of the "queue" I made a size instance variable that can be accessed to test through the method getSize.
Lastly, for this file I had to check whether or not the "queue" was empty or not. For this I just checked if the size variable was equalt to zero.


For the MinHeap file we were tasked with creating a minheap for our priority queue.

The first constructor used a default size variable to ensure a default size for T array creation.
The next constructor created a T array based on a given size.

We added the isEmpty method for this class to check whether the array was empty or not.
A size method returns the value of the size instance variable.
The isFull method checks to see whether the array is at it's instantiated capacity or not.

The newArray method allowed us to be able to change the size of the array to make it bigger.

The Insert method in MinHeap allows for the insertion of an object into the array given there is space, but if there is not space then the array is enlarged.

The getMin method returns the minimum element which will be in index 1, but if the array is empty it provides an error to explain there cannot be a min value.

The remove method ensures that the array is not empty before removing and element.
Also it makes sure to maintain the minHeap ordering for the array.

Lastly, the toString method lists the elements in the array in String format.



 