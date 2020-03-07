/**
* @author	Viet Nguyyen, HW5 2120
* @version	10/28/2019
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SortersTester {
  private ArrayList<Dog> pack;
  private ArrayList<Dog> emptyList;

	/*This is a setup method to initialize the list for sorting and testing
	*/
  @Before
  public void setup() {
    emptyList = new ArrayList<Dog>();
    pack = new ArrayList<Dog>();
    pack.add(new Dog("Josie", 74));
    pack.add(new Dog("Beatrice", 118));
    pack.add(new Dog("Watson", 39));
    pack.add(new Dog("Brutus", 102));
    pack.add(new Dog("Phineas", 57));
    pack.add(new Dog("Hamlet", 76));
    pack.add(new Dog("Amadeus", 125));
    pack.add(new Dog("Sansa", 48));
    pack.add(new Dog("Nutmeg", 68));
    pack.add(new Dog("Copernicus", 87));
  }
	/*Method isInOrder is used to check object in the *original list is in order or not
	*@param List<Dog> pack
	*/
  private boolean isInOrder(List<Dog> pack) {
    boolean inOrder = true;
    String[] names = {"Watson", "Sansa",      "Phineas", "Nutmeg",   "Josie",
                      "Hamlet", "Copernicus", "Brutus",  "Beatrice", "Amadeus"};
    for(int i = 0; i < pack.size(); i++) {
      inOrder = inOrder && (pack.get(i).getName()).equals(names[i]);
    }
    return inOrder;
  }
	
	/*This is test method for bubble Sort
	*Test sort can handle emptyList 
	*Test normal case sorting
	*Test sorting on a sortedList
	*/
  @Test
  public void testBubbleSort() {
    // Test sort can handle emptyList
    Sorters2120.bubbleSort(emptyList);
    assertTrue(emptyList.size() == 0);

    // Test normal case sorting
    assertFalse(isInOrder(pack));
    Sorters2120.bubbleSort(pack);
    assertTrue(isInOrder(pack));

    // Test Sorting on a sortedList
    Sorters2120.bubbleSort(pack);
    assertTrue(isInOrder(pack));
  }

	/*This is test method for selection Sort
	*Test sort can handle emptyList 
	*Test normal case sorting
	*Test sorting on a sortedList
	*/
  @Test
  public void testSelectionSort() {
    // Test sort can handle emptyList
    Sorters2120.selectionSort(emptyList);
    assertTrue(emptyList.size() == 0);

    // Test normal case sorting
    assertFalse(isInOrder(pack));
    Sorters2120.selectionSort(pack);
    assertTrue(isInOrder(pack));

    // Test Sorting on a sortedList
    Sorters2120.selectionSort(pack);
    assertTrue(isInOrder(pack));
  }
  
	/*This is test method for Merge sort
	*Test sort can handle emptyList 
	*Test normal case sorting
	*Test sorting on a sortedList
	*/
 @Test
  public void testMergeSort() {
    // Test sort can handle emptyList
    Sorters2120.mergeSort(emptyList);
    assertTrue(emptyList.size() == 0);

    // Test normal case sorting
    assertFalse(isInOrder(pack));
    Sorters2120.mergeSort(pack);
    assertTrue(isInOrder(pack));

    // Test Sorting on a sortedList
    Sorters2120.mergeSort(pack);
    assertTrue(isInOrder(pack));
  }

	/*This is test method for method to find index of a particular element in the list
	*/
 @Test
  public void testIndexOf() {
    // Sort the pack using an independent sorter so that binary search can work
    Collections.sort(pack);
    Dog amadeus = new Dog("Amadeus", 125);
    Dog brutus = new Dog("Brutus", 102);
    Dog watson = new Dog("Watson", 39);

    Dog albert = new Dog("Albert", 130);
    Dog zeke = new Dog("Zeke", 12);

    assertEquals(9, Sorters2120.indexOf(amadeus, pack));
    assertEquals(7, Sorters2120.indexOf(brutus, pack));
    assertEquals(0, Sorters2120.indexOf(watson, pack));

    assertEquals(-1, Sorters2120.indexOf(albert, pack));
    assertEquals(-1, Sorters2120.indexOf(zeke, pack));
  }
}
