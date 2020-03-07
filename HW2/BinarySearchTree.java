
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>{
	BinaryNode<T> root = null;
	
	public BinarySearchTree(){
	}
	
	public BinarySearchTree(T[] seq){
		super();
	}
	
	public BinarySearchTree(T[] seq, T nullSymbol){
		super();
	}
		
	
	public void insert(T value){
		BinaryNode<T> currentNode = root;

		while(currentNode.getData() != null){
			int compareResult = value.compareTo(currentNode.getData());
			if(compareResult > 0){
				currentNode = currentNode.getRightNode();
			}
			else if(compareResult < 0){
				currentNode = currentNode.getLeftNode();
			}else{
				return;
			}
		}
		currentNode.setData(value);		
	}
	
	public void remove(T value){
		BinaryNode<T> currentNode = root;

		while(currentNode.getData() != null){
			int compareResult = value.compareTo(currentNode.getData());
			if(compareResult > 0){
				currentNode = currentNode.getRightNode();
			}
			else if(compareResult < 0){
				currentNode = currentNode.getLeftNode();
			}else{
				return;
			}
		}
		currentNode.setData(null);	
	}
	
	public boolean contains(T value){
		BinaryNode<T> currentNode = root;
		
		while(currentNode.getData() != null){
			int compareResult = value.compareTo(currentNode.getData());
			if(compareResult > 0){
				currentNode = currentNode.getRightNode();
			}
			else if(compareResult < 0){
				currentNode = currentNode.getLeftNode();
			}else{
				return true;
			}
		}
		return false;
		
	}

}