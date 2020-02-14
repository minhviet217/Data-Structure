For Homework 1 we were tasked to do 3 major things:
1)Create and make methods for a Singly Linked List class with two additional inner classes Node and SinglyLinkedListIterator.
2)Implement a stack using the SinglyLinkedList class.
3)Convert an infix equation to postfix using the MyStack class.

The setup we followed for SinglyLinkedList was taken from the pseudocode from the homework assignment sheet.
As far as the other two files MyStack.java and Startup.java we had to be more creative in our solution.

MyStack is the creation of a stack using a singly linked list.
The methods we chose to include were:

push - We needed a way to add things onto the top of our stack.
 We chose to make the last node in the SinglyLinkedList our top.
 From this point we used our add method within the SinglyLinkedList class in order to add a new node to the LinkedList that is the stack.

pop - The pop method not only takes the top value off the stack it also returns it.
We instantiated an iterator called "it" to be able to navigate any preexisting nodes.
Knowing that the "top" of our stack is the end of the list we used a while loop with it.hasNext as the condition.
Inside the loop we constantly reassigned a temp value to the value of the iterator.
When the while loop stopped this meant that the temp value is actually the element of the last node.
We then used the remove method to remove the node containing the same element as the last node.
Lastly we jsut needed to return the value saved in temp and the pop was functionally done.


peek - The peek method functions in much of the same way as the pop except that it does not remove any nodes.
The iterator was instantiated and used in order to find the element in the last node.
This is then returned so that we can use this in our precedence checking in the Startup class.
 
isEmpty - The isEmpty method is based on the fact that our "stack" is a Linked List. 
Linked List has a size method that we used to determine whether or not the stack is empty (size==0) or not(size!=0).


For the Startup class we chose to only include two methods:
main - the method that acts as the sandbox for us to test our previous classes and their methods.
precedence - Based on mathematical precedence we set a smaller integer value for characters + or - then * or /.
A return value of -1 was made for any opertor that was not +,-,*,/.
This allowed us to numerically compare operators in a few different tiers of precedence.
When we compared the character on the stack and the last read character we could apply that to the infix postfix algorithm in order to determine what to push or pop and when.

Infix to postfix algorithm:

We read the string inputted by the user a single character at a time.
If we read an operator push immediately to the stack if the stack is empty.
In the case that the stack is not empty  we compare the precedence level of the character on the top of the stack to the character last read.
If the stack value is of higher precedence then you pop the stack value.
You must continuously compare the last read character to the top of the stack until the stack does not have any more values or has less than or equal precedence.
This indicates that you must push the last read value on the stack.

Operands(letters or numbers) can be pushed as soon as they are read.
If an open paranthesis is read then we push it to the stack.
In between the pushed open parenthesis and the closed parenthesis the inner equation will be translated like normal.
The only difference is that when the closed parenthesis is read it pops all values off the stack until the open parenthesis.
Lastly, to make sure we don't have any remaining operators on the stack we pop all stack values until the stack is empty.


