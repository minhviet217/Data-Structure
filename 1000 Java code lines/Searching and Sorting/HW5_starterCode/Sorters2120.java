/**
* @author	Viet Nguyyen, HW5 2120
* @version	10/28/2019
*/
import java.util.List;
import java.util.ArrayList;
import java.lang.Comparable;
import java.util.Collections;
public class Sorters2120 {

	/*Implement a method of Bubble Sort with generic type. 
	*This method extends Comparable interface and *overwrites method compareTo()
	*@param theList this the list needed to be sort
	*Use the swap() method belown in the implementation
	*Check theList empty or not by comepare its size to 1
	*/
    public static <T extends Comparable<T> > void bubbleSort(List<T> theList) {
        int lastToConsider = theList.size();
        while (lastToConsider > 1) {
            for (int j=0; j<lastToConsider-1; j++) {
                if (theList.get(j).compareTo(theList.get(j+1))  >  0 ) {
                    swap(theList,j,j+1);
                }
            }
            lastToConsider--;
        }
    }

	/*swap two objects in the list with generic type. 
	*This method extends Comparable interface overwrites *method compareTo()
	*@param List<T> thelist int i1 int i2
	*/
    private static <T extends Comparable<T> > void swap(List<T> theList, int i1, int i2) {

        T temp = theList.get(i1);
        theList.set(i1,theList.get(i2));
        theList.set(i2,temp);
    }
	
	/*Implement a method of selectionSort with generic type
	*It extends interface Comparable and overwrite *compareTo()
	*@param List<T> theList this is the list needed to be sorted
	*/
    public static <T extends Comparable<T> > void selectionSort(List<T> theList) {

        // stubbed
		int lastToConsider = theList.size();
        while (lastToConsider > 1) {
			for (int i = 0; i < theList.size()-1; i++){
				int smallest = i;
				for(int index = i + 1; index < theList.size(); index++){
					if(theList.get(index).compareTo(theList.get(smallest)) < 0){
						smallest = index;
					}
				}
				swap(theList,i,smallest);
			}
			 lastToConsider--;
		}
    }

	/*mergeSort method to call recursiveMergeSortHelper method for sorting theList
	*@param List<T> theList
	*/
    public static <T extends Comparable<T> > void mergeSort(List<T> theList) {
		
		recursiveMergeSortHelper(theList,0,theList.size());
		
    }

	/*Implement a method of Merge Sort recursively with *generic type
	*@param List<T> theList int first int last
	*sorting process will start from first to last
	*/
	public static <T extends Comparable<T> > void recursiveMergeSortHelper(List<T> theList, int first, int last) {
    
		List<T> left = new ArrayList<>();
		List<T> right = new ArrayList<>();
		int center;
 
		if(theList.size() > 1) {
			center = theList.size()/2;
			for (int i=0; i<center; i++) {
                left.add(theList.get(i));
			}
 
			for (int i=center; i<theList.size(); i++) {
                right.add(theList.get(i));
			}
 
			recursiveMergeSortHelper(left,0,left.size());
			recursiveMergeSortHelper(right,0,right.size());

			merge(left, right, theList);
		}
	
	}
   
	/*Method merge is used to merge two smaller sorted 
	*list after splitting them from the original list
	*@param List<T> left list, List<T> right list, List *<T> combined list 
	*/
	public static <T extends Comparable<T> > void merge(List<T> left, List<T> right, List<T> combined) {
		
		int leftIndex = 0;
		int rightIndex = 0;
		int combinedIndex = 0;
		
		while (leftIndex < left.size() && rightIndex < right.size()) {
			if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
				combined.set(combinedIndex, left.get(leftIndex));
				leftIndex++;
			} 
			else {
            combined.set(combinedIndex, right.get(rightIndex));
            rightIndex++;
			}
			combinedIndex++;
		}
 
		List<T> data = new ArrayList<>();
		int dataIndex;
		if (leftIndex >= left.size()) {
			data = right;
			dataIndex = rightIndex;
		} 
		else {
        data = left;
        dataIndex = leftIndex;
		}
		
		for (int i=dataIndex; i<data.size(); i++) {
			combined.set(combinedIndex, data.get(i));
			combinedIndex++;
		}
	}
	
	/*IndexOF method with generic type to find the index *of a particular element in the list
	*@param T searchItem, List<T> theList
	*/
    public static <T extends Comparable<T> > int indexOf(T searchItem, List<T> theList) {

        return recursiveBinarySearcher(searchItem, theList, 0, theList.size()-1);

    }
	
	/*Implement a method of binary search with generic type
	*it extends interface comparable and overwrites *compareTo()
	*@param T searchItem, List<T> theList, int first, int *last
	*/
    private static <T extends Comparable<T> > int recursiveBinarySearcher(T searchItem, List<T> theList, int first, int last) {

        // stubbed
		int middle;
		boolean notInList = false;
		while (notInList == false){
			middle = (first + last)/2;
			if (searchItem.compareTo(theList.get(middle)) == 0){
				return middle;
			}
			else if (searchItem.compareTo(theList.get(middle)) < 0){
				last = middle - 1;
			}
			else {
				first = middle + 1;
			}
			if (first > last){
				notInList = true;
			}
		}
        return -1;

    }
}
