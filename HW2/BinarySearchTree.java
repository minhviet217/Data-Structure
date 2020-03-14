public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>{
	
	BinaryNode<T> tempNode;
	
	public BinarySearchTree(){
	}
	
	public BinarySearchTree(T[] seq){
		super(seq);
	}
	
	public BinarySearchTree(T[] seq, T nullSymbol){
		super(seq, nullSymbol);
	}
	
	public void insert(T value){
		
		if(root == null){
			root  = new BinaryNode<T>(value);
		}else{
			tempNode = root;
			boolean truth = true;
			while(truth){
				int compareResult = value.compareTo(tempNode.getData());
				if(compareResult < 0){
					if(tempNode.getLeftNode() != null){
						tempNode = tempNode.getLeftNode();
					}else{
						tempNode.setLeftNode(new BinaryNode<T>(value));
						truth = false;
					}
				}
				else if(compareResult > 0){
					if(tempNode.getRightNode() != null){
						tempNode = tempNode.getRightNode();
					}else{
						tempNode.setRightNode(new BinaryNode<T>(value));
						truth = false;
					}
				}
				else{
				}
			}
		}
	}
	
		public void remove(T value){
		this.remove(value, this.root, null);
	}

	private void remove(T value, BinaryNode<T> node1, BinaryNode<T> node2){
		if(node1 == null){
			return;
		}else{
			int compareResult = value.compareTo(node1.getData());
			if(compareResult < 0){
				this.remove(value, node1.getLeftNode(), node1);
			}
			else if(compareResult > 0){
				this.remove(value, node1.getRightNode(), node1); 
			}
			else {
				remove(node1, node2);
			}
		}
	}

	private void remove(BinaryNode<T> node1, BinaryNode<T> node2){
		if (node1 == this.root){
			removeRoot();
		}
		else if((node1.getLeftNode() != null) && (node1.getRightNode() != null)){
			removeChild(node1);
		}
		else{
			removeChildren(node1, node2);
		}
	}

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

	private void removeChild(BinaryNode<T> node1){
		BinaryNode<T> leftChild = findMax(node1.getLeftNode());
		BinaryNode<T> parentofLeft = getParent(leftChild);
		node1.setData(leftChild.getData());
		remove(leftChild.getData(), leftChild, parentofLeft);
	}

	private void removeChildren(BinaryNode<T> removedNode, BinaryNode<T> parent){
		if (removedNode == parent.getLeftNode()){
			if (removedNode.getLeftNode() != null){
				parent.setLeftNode(removedNode.getLeftNode());}
			else{
				parent.setLeftNode(removedNode.getRightNode());
			}
		}
		else if (removedNode == parent.getRightNode()){
			if (removedNode.getLeftNode() != null){
				parent.setRightNode(removedNode.getLeftNode());}
			else{
				parent.setRightNode(removedNode.getRightNode());
			}
		}
		else{
			if (removedNode == parent.getLeftNode()){
				parent.setLeftNode(null);
			}
			else {
				parent.setRightNode(null);
			}
		}
	}

	private BinaryNode<T> getParent(BinaryNode<T> node){
		BinaryNode<T> curr = root;
		BinaryNode<T> parent = root;
		boolean found = true;
		
		if(node != root){
			while(found){
				int compareResult = node.getData().compareTo(curr.getData());
				if(compareResult < 0){
					parent = curr;
					curr = curr.getLeftNode();
				}
				else if(compareResult > 0){
					parent = curr;
					curr = curr.getRightNode();
				}
				else {
					found = false;
				}
			}
		}
		return parent;
	}

	public T findMin(){
		return findMin(root).getData();
	}

	private BinaryNode<T> findMin(BinaryNode<T> node){
		if(node == null){
			return null;
		}
		else if(node.getLeftNode() == null){
			return node;
		}
		return findMin(node.getLeftNode());
	}

	public T findMax(){
		return findMax(root).getData();
	}

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
		if(node == null){
			return false;
		}
		
		int valueCompare = value.compareTo(node.getData());
		if(valueCompare > 0){
			return contains(value, node.getRightNode());
		}
		else if(valueCompare < 0){
			return contains(value, node.getLeftNode());
		}
		else{
			return true;
		}
	}
	
	public boolean contains(T value){
		tempNode = root;
		return contains(value, tempNode);
	}
	
}