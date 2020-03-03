
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class MyList{
	public static <T extends Comparable<T> > void mergeSort(List<T> theList) {
		
			
		recursiveMergeSortHelper(theList,0,theList.size());
		
    }
	public static <T extends Comparable<T> > void recursiveMergeSortHelper(List<T> theList, int first, int last) {
    List<T> left = new ArrayList<>();
    List<T> right = new ArrayList<>();
    int center;
 
    if(theList.size() > 1) {
        center = theList.size()/2;
        // copy the left half of whole into the left.
        for (int i=0; i<center; i++) {
                left.add(theList.get(i));
        }
 
        //copy the right half of whole into the new arraylist.
        for (int i=center; i<theList.size(); i++) {
                right.add(theList.get(i));
        }
 
        // Sort the left and right halves of the arraylist.
		recursiveMergeSortHelper(left,0,left.size());
		recursiveMergeSortHelper(right,0,right.size());

        // Merge the results back together.
        merge(left, right, theList);
	}
    }
   

public static <T extends Comparable<T> > void merge(List<T> left, List<T> right, List<T> whole) {
    int leftIndex = 0;
    int rightIndex = 0;
    int wholeIndex = 0;
 
    // As long as neither the left nor the right ArrayList has
    // been used up, keep taking the smaller of left.get(leftIndex)
    // or right.get(rightIndex) and adding it at both.get(bothIndex).
    while (leftIndex < left.size() && rightIndex < right.size()) {
        if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
            whole.set(wholeIndex, left.get(leftIndex));
            leftIndex++;
        } else {
            whole.set(wholeIndex, right.get(rightIndex));
            rightIndex++;
        }
        wholeIndex++;
    }
 
    List<T> rest;
    int restIndex;
    if (leftIndex >= left.size()) {
        // The left ArrayList has been use up...
        rest = right;
        restIndex = rightIndex;
    } else {
        // The right ArrayList has been used up...
        rest = left;
        restIndex = leftIndex;
    }
 
    // Copy the rest of whichever ArrayList (left or right) was not used up.
    for (int i=restIndex; i<rest.size(); i++) {
        whole.set(wholeIndex, rest.get(i));
        wholeIndex++;
    }
}
}