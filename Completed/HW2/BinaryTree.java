/* BinaryTree.java - Class that creates a Binary Tree based on a sequence of generic values.
*  Joshua Martin and Viet Nguyen
*  March 15, 2020
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree<T>{
	BinaryNode<T> root = null;	
	
	private T nullSymbol = null;

	/**
	 * Default constructor
	 */
	public BinaryTree(){

	}

	/**
	 *	This constructor is useful for test purposes,
	 *  not meant for use in general.
	 *
	 *  Constructs a binary tree from a given valid breadth-first traversal sequence.
	 *  @param seq is an array containing breadth-first traversal sequence of the nodes of a tree.
	 */
	public BinaryTree(T[] seq){
		initFromBfsSequence(seq);
	}

	/**
	 *	This constructor is useful for test purposes,
	 *  not meant for use in general.
	 *
	 *  Constructs a binary tree from a given valid breadth-first traversal sequence. 
	 *	A given special symbol (nullSymbol) in the sequence is interpreted as absence of node. 
	 *	During construction of the tree, when such a special symbol is encountered, 
	 *	that is considered to be an absent node, and thus no corresponding node is added to the tree.
	 * 	
	 * 	@param seq is an array containing breadth-first traversal sequence of the nodes of a tree.
	 * 	@param nullSymbol is a special symbol in the given sequence that denotes absence of a node.
	 */
	public BinaryTree(T[] seq, T nullSymbol){
		this.nullSymbol = nullSymbol;
		initFromBfsSequence(seq);
	}

	private void initFromBfsSequence(T[] seq){
		if(seq.length == 0)
			throw new IllegalArgumentException("Cannot build tree from empty sequence");
		
		if(seq[0].equals(nullSymbol))
			throw new IllegalArgumentException("Symbol for root cannot be nullSymbol");
				
		List<BinaryNode<T>> nodes = new ArrayList<BinaryNode<T>>(seq.length);
		this.root = new BinaryNode<T>(seq[0]);
		nodes.add(root);

		for(int i = 0; i < seq.length; i++){			
			if(nodes.get(i) == null){ 				
				handelNullParentNode(nodes, i, seq.length);				
			}else{				
				handleNonNullParentNode(nodes, i, seq);				
			}
		}		
	}

	// This method will handle the null nodes in the iteration of nodes.get(i) in initFromBfsSequence method.
	private void handelNullParentNode(List<BinaryNode<T>> nodes, 
						int nullNodeIndex, int seqLength){
		int leftIndex = (nullNodeIndex * 2) + 1; // finding the left child index from formula 
				
		if(leftIndex < seqLength){
			nodes.add(null);

			int rightIndex = (nullNodeIndex * 2) + 2; // finding the right child index from formula
			if(rightIndex < seqLength){
				nodes.add(null);
			}
		}
	}

	// This method will handle the non-null nodes in the iteration of nodes.get(i) in initFromBfsSequence method.
	private void handleNonNullParentNode(List<BinaryNode<T>> nodes, 
								int parentIndex, T[] seq){
		//Determines what the left connecting node from placement in the sequence.							
		int leftIndex = (parentIndex * 2) + 1;			
		//need to check if the index falls outside of the list index
		if(leftIndex < seq.length){
			BinaryNode<T> leftNode = null;
			//check if the sequence is not null.
			if(!seq[leftIndex].equals(nullSymbol)){
				leftNode = new BinaryNode<T>(seq[leftIndex]);
			}
			nodes.get(parentIndex).leftNode = leftNode;
			nodes.add(leftNode);
			
			//Determines what the right connecting node from placement in the sequence.
			int rightIndex = (parentIndex * 2) + 2;				
			if(rightIndex < seq.length){
				BinaryNode<T> rightNode = null;
				if(!seq[rightIndex].equals(nullSymbol)){
					rightNode = new BinaryNode<T>(seq[rightIndex]);
				}
				nodes.get(parentIndex).rightNode = rightNode;
				nodes.add(rightNode);			
			}
		}
	}

	//Method determining the height of the tree.
	public int height(){
		//if the root is null the tree is empty and height is 0.
		if (root == null) return 0;	
		return root.height();
	}

	public int width(){
		// TODO: Modify this method-body to compute and return the width 
		// of the tree.
		
			// return if tree is empty
		if (root == null) {
			return 0;
		}

		// create an empty queue and enqueue root node
		Queue<BinaryNode<T>> queue = new LinkedList<>();
		queue.add(root);

		// pointer to store current node
		BinaryNode<T> curr = null;

		// stores maximum width
		int max = 0;

		// run till queue is not empty
		while (!queue.isEmpty())
		{
			// calculate number of nodes in current level
			// This is equal to width of current level
			int width = queue.size();

			// update maximum width if number of nodes in current level
			// is more than maximum width found so far
			if (max < width) {
				max = width;
			}

			// process every node of current level and enqueue their
			// non-empty left and right child to queue
			while (width-- > 0)
			{
				curr = queue.poll();
				if (curr.getLeftNode() != null) {
					queue.add(curr.getLeftNode());
				}
				
				if (curr.getRightNode() != null) {
					queue.add(curr.getRightNode());
				}
			}
		}

		return max;
	}

	public String breadthFirstTraverse(){
		// TODO: Modify this method-body to return a string corresponding
		// to the breadth-first-traversal of the tree.
		
		//Make a queue (LinkedList) that holds our BinaryNodes.
		Queue<BinaryNode<T>> queue = new LinkedList<>();
		//Add the root node to the queue.
		queue.add(root);
		
		String st ="";
		//While there is something in the queue loop.
		while (queue.isEmpty() == false) {
			//Add a node from the queue to the string.
			BinaryNode<T> n = queue.remove();
			st = st + " " + n.getData();
			//Add the left node if not null.
			if (n.getLeftNode() != null)
				queue.add(n.getLeftNode());
			//Add the right node if not null.	
			if (n.getRightNode() != null)
				queue.add(n.getRightNode());
			
		}
		st = st.substring(1,st.length());
		return st;
		
	}

	public String preOrderTraverse(){
		//Trims the final result of the preorder traversal of our tree.
		return root.preOrderTraverse().trim();				
	}

	public String postOrderTraverse(){
		//Trims the final result of the postorder traversal of our tree.
		return root.postOrderTraverse().trim();
	}

	public String inOrderTraverse(){
		//Trims the final result of the inorder traversal of our tree.
		return root.inOrderTraverse().trim();
	}
	
	static class BinaryNode<T>{
		private T data = null;
		private BinaryNode<T> leftNode = null;
		private BinaryNode<T> rightNode = null;

		//Sets the data for a newly constructed binary node.
		public BinaryNode(T data){
			this.data = data;			
		}

		//String containing data from Binary Nodes.
		public String toString(){
			return "" + data;
		}

		//Gets the left node from the current node.
		public BinaryNode<T> getLeftNode(){
			return this.leftNode;
		}
		//Gets the right node from the current node.
		public BinaryNode<T> getRightNode(){
			return this.rightNode;
		}
		//Sets the left node from the current node.
		public void setLeftNode(BinaryNode<T> node){
			this.leftNode = node;
		}
		//Sets the right node from the current node.
		public void setRightNode(BinaryNode<T> node){
			this.rightNode = node;
		}
		//Gets the data of the current node.
		public T getData(){
			return this.data;
		}
		//Sets the data of the current node.
		public void setData(T data){
			this.data = data;
		}
		//Determines the height of a node.
		public int height(){
			if(isLeaf()) return 0;
			
			int leftHeight = 0;
			int rightHeight = 0;
			
			if(leftNode != null){ 
				leftHeight = leftNode.height();
			}

			if(rightNode != null){
				rightHeight = rightNode.height();
			}
			//Conditional that determines whether the right or left height is higher.
			int maxHeight = leftHeight > rightHeight? leftHeight: rightHeight;

			return maxHeight + 1 ;
		}
		//Determines whether the node is a leaf node.
		public boolean isLeaf(){
			return (leftNode == null && rightNode == null);
		}

		//Preorder traversal of the tree.
		public String preOrderTraverse(){
			
			StringBuilder stringBuffer = new StringBuilder();			
			//Adds the root(ME) data to the string.
			stringBuffer.append(" " + data);
			//Adds the left data to the string.
			if(leftNode != null){
				stringBuffer.append(leftNode.preOrderTraverse());				
			}
			//Adds the right data to the string.
			if(rightNode != null){
				stringBuffer.append(rightNode.preOrderTraverse());
			}

			return stringBuffer.toString();				
		}

		public String postOrderTraverse(){			
			StringBuilder stringBuffer = new StringBuilder();
			//Adds the left node data to the string.
			if(leftNode != null){
				stringBuffer.append(leftNode.postOrderTraverse());				
			}
			//Adds the right nodes data to the string.
			if(rightNode != null){
				stringBuffer.append(rightNode.postOrderTraverse());
			}
			//Adds the root(ME) node data to the string.
			stringBuffer.append(" " + data);
			return stringBuffer.toString();	
		}

		public String inOrderTraverse(){	
			StringBuilder stringBuffer = new StringBuilder();
			//Adds the left node data to the string.
			if(leftNode != null){
				stringBuffer.append(leftNode.inOrderTraverse());				
			}
			//Add the root(ME) node data to the string.
			stringBuffer.append(" " + data);
			//Adds the right node data to the string.
			if(rightNode != null){
				stringBuffer.append(rightNode.inOrderTraverse());
			}

			return stringBuffer.toString();		
		}
	}
}