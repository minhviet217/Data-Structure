README.TXT - Homework 2 Binary Tree Assignment

Joshua Martin and Viet Nguyen

For this assignment we were tasked with finishing the files BinaryTree.java and BinarySearchTree.java.

For the BinaryTree file we finished implementing several methods dictating the width, postorder traversal, inOrder traversal, and breadth-First-Traversal of a Binary Tree.

Width was computed based on the maximum elements inputted to a queue. This allowed us to keep track of the maximum number of elements across(width) the tree.

For postOrder and inOrder traversal we realized changing the order of the saved values to the string will give you the proper answer.
For postOrder the order was Left,Right,Root(ME)
For inOrder the order was Left, Root(Me), Right

Breadth-First-Traversal tracks the nodes left to right across each level of the tree starting from the root.
For this we used a queue to store the nodes on each level. It would then pop them to a string and store the child nodes to the queue. 
This ensured that in the way we stored values the upper levels get put the string before the lower levels and the left gets popped to the string before the right if available.


In BinarySearchTree we used super() to use the parent constructors from BinaryTree to make a BinarySearchTree.

For insertion we compared each node from the root to our desired value. 
If the value was the same we did nothing (duplicate values).
If the insertion value is less than the current node's data then we can continue to iterate down the tree to the left.
If the insertion value is greater than the current node's data then we can continue to iterate down the tree to the right.
Once we reach a null node we know we are in the proper place to insert the value and set the data value for that node to the insertion value.

For removal we not only had to remove a value from the tree, we had to remove it based on the number of children.
We used several helper methods in order to help us locate whether the node to remove had 0,1, or 2 children.
Then the node values are shifted to make sure the tree is properly formed.

For contains we only had to return true if the tree contained a node with the searched for data value.
We chose to iterate through the tree like normal using a tempNode, but if we reached a null node or if the tree was empty we can safely say the value is not in the tree.
For that instance we return false, and only if our comparison of value and the current data value of the tempNode are the same do we return true.
 