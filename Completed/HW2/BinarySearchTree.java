/* BinarySearchTree.java - Class that creates a Binary Search Tree based on the previously implemented Binary Tree class.
*  Joshua Martin and Viet Nguyen
*  March 15, 2020
*/


public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>{
	
	BinaryNode<T> tempNode;
	//Default constructor.
	public BinarySearchTree(){
	}
	//BinarySearchTree constructor based on the BinaryTree constructor using the array of values.
	public BinarySearchTree(T[] seq){
		super(seq);
	}
	//BinarySearchTree constructor based on the BinaryTree constructor using the sequence of values and the nullSymbol.
	public BinarySearchTree(T[] seq, T nullSymbol){
		super(seq, nullSymbol);
	}
	//Inserts a value in the tree.
	public void insert(T value){
		//If the root is null the tree is empty and the inserted node is the new root node.
		if(root == null){
			root  = new BinaryNode<T>(value);
		}else{
			//The tempNode is set to the root so we can iterate without changing our root variable.
			tempNode = root;
			//A boolean value to loop based off of.
			boolean truth = true;
			while(truth){
				//Compare the value to add the the tempNode data value.
				int compareResult = value.compareTo(tempNode.getData());
				//If the value < tempNode.getData() tempNode can be set to it's left node.
				if(compareResult < 0){
					if(tempNode.getLeftNode() != null){
						tempNode = tempNode.getLeftNode();
					}else{
						//When we reach null we have reached the node to insert value into.
						tempNode.setLeftNode(new BinaryNode<T>(value));
						//Change the value of truth to break out of the loop.
						truth = false;
					}
				}
				//If the value > tempNode.getData() tempNode can be set to it's right node.
				else if(compareResult > 0){
					if(tempNode.getRightNode() != null){
						tempNode = tempNode.getRightNode();
					}else{
						//When we reach a null we have reached the node to insert value into.
						tempNode.setRightNode(new BinaryNode<T>(value));
						//Change the value of truth to break out of the loop.
						truth = false;
					}
				}
				//Do nothing if the value is already in the tree.
				else{
				}
			}
		}
	}
	
	//this method calls another method to remove value of target node
	//it will start from root node for its checking process
	public void remove(T value){
		this.remove(value, this.root, null);
	}

	//This method is a supporter method for remove method 
	private void remove(T value, BinaryNode<T> node1, BinaryNode<T> node2){
		//if node1 is null, so nothing to remove
		if(node1 == null){
			return;
		}
		//if node1 is not null
		else{
			int compareResult = value.compareTo(node1.getData());
			//traverse to the left subtree to target node
			if(compareResult < 0){
				this.remove(value, node1.getLeftNode(), node1);
			}
			//traverse to right subtree to remove target node
			else if(compareResult > 0){
				this.remove(value, node1.getRightNode(), node1); 
			}
			//if value == node1.getData(), call another helper remove method
			else {
				remove(node1, node2);
			}
		}
	}
	
	//This helper method is dealing with the case that node1 is not null and its data is equal value
	private void remove(BinaryNode<T> node1, BinaryNode<T> node2){
		//If node1 is root node, just remove it
		if (node1 == this.root){
			removeRoot();
		}
		//if target node has two children, call removeChild method to remove it
		else if((node1.getLeftNode() != null) && (node1.getRightNode() != null)){
			removeChild(node1);
		}
		//else call another remove method to remove target node
		else{
			removeChildren(node1, node2);
		}
	}
	
	//This method is to remove the node with two children and it is not a root node
	//Find max of left subtree 
	//copy the value in target node
	//Delete duplicate
	private void removeChild(BinaryNode<T> node1){
		
		BinaryNode<T> leftChild = findMax(node1.getLeftNode());
		BinaryNode<T> parentofLeft = getParent(leftChild);
		node1.setData(leftChild.getData());
		remove(leftChild.getData(), leftChild, parentofLeft);
	}


	//This method is to remove node if it is a root node
	private void removeRoot(){
		if((root.getLeftNode() != null) && (root.getRightNode() != null)){
			removeChild(root);
		}
		else if(root.getLeftNode() != null){
			root = root.getLeftNode();
		}
		else if(root.getRightNode() != null){
			root = root.getRightNode();
		}
		else {root = null;}
	}
	

	//This remove method deals with the case when the node need to be removed has parent node that is not null
	private void removeChildren(BinaryNode<T> removedNode, BinaryNode<T> parent){
		//if removed node is the left child node of parent node
		//and the left child node of the removed node is not null
		//Delete the removed node and connect with the parent of the removed node
		if (removedNode == parent.getLeftNode()){
			if (removedNode.getLeftNode() != null){
				parent.setLeftNode(removedNode.getLeftNode());}
			else{
				parent.setLeftNode(removedNode.getRightNode());;
			}
		}
		
		//if removed node is the right child node of parent node
		//and the right child node of the removed node is not null
		//Delete the removed node and connect with the parent of the removed node
		else if (removedNode == parent.getRightNode()){
			if (removedNode.getLeftNode() != null){
				parent.setRightNode(removedNode.getLeftNode());}
			else{
				parent.setRightNode(removedNode.getRightNode());
			}
		}
		
		//The removed node is the leaf, just delete it and set that node to null
		else{
			if (removedNode == parent.getLeftNode()){
				parent.setLeftNode(null);
			}
			else {
				parent.setRightNode(null);
			}
		}
	}

	//This method is to find the parent node of the current node
	//This method is necessary when we need to remove or delete a node that is not a root node
	private BinaryNode<T> getParent(BinaryNode<T> node){
		
		//Current node is root node
		BinaryNode<T> curr = root;
		BinaryNode<T> parent = root;
		boolean truth = true;
		
		//If a node is not a root node, we compare the value of that node and current node
		if(node != root){
			while(truth){
				int compareResult = node.getData().compareTo(curr.getData());
				//If the compareResult < 0, it means the node is in the left substree, parent node now is current node
				//and the node is the left child node of parent node
				if(compareResult < 0){
					parent = curr;
					curr = curr.getLeftNode();
				}
				//If the compareResult > 0, it means the node is in the right substree, parent node now is current node
				//and the node is the right child node of parent node
				else if(compareResult > 0){
					parent = curr;
					curr = curr.getRightNode();
				}
				//if compareResult = 0, continue to run the while loop
				else {
					truth = false;;
				}
			}
		}
		return parent;
	}

	//This method is to find node with maximum value of a binary search tree
	//Only process the right substrees, start from root until it reachs to node without children
	//that node will contain maximum value.
	private BinaryNode<T> findMax(BinaryNode<T> node){
		if(node != null){
			while(node.getRightNode() != null){
				node = node.getRightNode();
			}
		}
		return node;
	}

	//Helper method for contains to help iterate and check if each individual node value is null or contains the desired value.
	public boolean contains(T value, BinaryNode<T> node){
		//If we reach a null node then the value is not in the tree.
		if(node == null){
			return false;
		}
		
		int valueCompare = value.compareTo(node.getData());
		//If the value we are searching for is greater than the current node's data value recursively run contains again with the node's right node.
		if(valueCompare > 0){
			return contains(value, node.getRightNode());
		}
		//If the value we are searching for is less than the current node's data value recursively run contains again with the node's left node.
		else if(valueCompare < 0){
			return contains(value, node.getLeftNode());
		}
		else{
			//If the node's data value is the same as the searched for value then return true;
			return true;
		}
	}
	//Method that calls to the other contains method to recursively determine if the tree contains a value.
	public boolean contains(T value){
		tempNode = root;
		return contains(value, tempNode);
	}
	
}