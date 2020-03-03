public class LinkedList<T>  {


    Node<T> itsFirstNode;
    Node<T> itsLastNode;
    private int size;


    public LinkedList() {
        itsFirstNode = null;
        itsLastNode = null;
        size = 0;
    }

    public int size() {
        return this.size;
    }
    
    public Iterator<T> getIterator() {
        return new Iterator<T>(this);
    }

    // THIS WILL NEED TO BE MODIFIED FOR DOUBLY LINKED LIST
    public void add(T element) {

        Node<T> node = new Node<T>(element);
		 if (itsFirstNode == null) {
            itsFirstNode = node;
            itsLastNode = itsFirstNode;
        }
        else {
            node.setPriorNode(itsLastNode);
			itsLastNode.setNextNode(node);
            itsLastNode = node;
        }
        size++;
    }

    // THIS WILL NEED TO BE MODIFIED FOR DOUBLY LINKED LIST
    public void add(T element, int index) {
        int counter = 0;
        Node<T> newNode = new Node<T>(element);
        Node<T> current = itsFirstNode;
        while (current != null ) {
            if (counter == index - 1 )
                break;
            current = current.getNextNode();
            counter++;
        }
		Node temp = current.getNextNode();
		current.setNextNode(newNode);
		newNode.setPriorNode(current);
		newNode.setNextNode(temp);
		temp.setPriorNode(newNode);
        size++;
    }

    public T get(int index) {
        int counter = 0;
        Node<T> current = itsFirstNode;
        while (current != null ) {
            if (counter == index)
                break;
            current = current.getNextNode();
            counter++;
        }
        return current.getData();
    }

    // TO BE IMPLEMENTED
    
    // returns true if element is in the list, false if not
    public boolean contains(T element) {
		Node<T> current = itsFirstNode;
		while(current != null){
			if (current.getData()== element){
				return true;
			}
			current = current.getNextNode();
		}
		return false;
    }

    // returns the index of the element if it is in the list, -1 if not found
    public int indexOf(T element) {
		Node<T> current = itsFirstNode;
		for (int index = 0; index < size; index++){
			if (current.getData() == element){
				return index;
			}
			current = current.getNextNode();
		}
		return -1;
    }

    // returns an Iterator at the location of the element if it is in the list
    // returns the null reference if the element is not found
    public Iterator<T> iteratorAt(T element) {
		Node<T> current = itsFirstNode;
		while(current != null){
			if (current.getData() == element){
				return this.getIterator();
			}
			current = current.getNextNode();
		}
		return null;
    }
    

    public String toString() {
        String returnVal = "";
        Node<T> current = itsFirstNode;
        if (size != 0 ) {
            while (current != null ) {
                returnVal += current.toString();
                returnVal += "\n";
                current = current.getNextNode();
            }
        }
        return returnVal;
    }  // end toString

    class Node<T> {
    
        private T data;
        private Node<T> itsNext;
        private Node<T> itsPrior;
    
        public Node(T data) {
            itsNext = null;
            itsPrior = null;
            this.data = data;
        }
    
    
        public T getData() {
            return this.data;
        }
    
        public Node<T> getNextNode() {
            return itsNext;
        }

        // TO BE IMPLEMENTED
        
        public Node<T> getPriorNode() {
			return itsPrior;
        }
        
    
        public void setNextNode(Node<T> next) {
            itsNext = next;
        }

        // TO BE IMPLEMENTED
        
        public void setPriorNode(Node<T> prior) {
			itsPrior = prior;
        }
    
        public String toString() {
            return data.toString();
        }
    
    }  // end of Node<T>
}
