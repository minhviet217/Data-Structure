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