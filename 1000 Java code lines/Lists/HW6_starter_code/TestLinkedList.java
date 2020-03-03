/**
* @author	Viet Nguyyen, HW5 2120
* @version	10/28/2019
*/
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestLinkedList{
	private LinkedList<Dog> myDogList;
	Dog fifi;
    Dog butch;
    Dog leonard;
    Dog spot;
	LinkedList<Dog>.Node<Dog> n1;
	LinkedList<Dog>.Node<Dog> n2;
	LinkedList<Dog>.Node<Dog> current; 
	
	@Before
	public void setup(){
		myDogList = new LinkedList<Dog>();
		fifi = new Dog("Fifi", 12, 8);
        butch = new Dog("Butch", 10, 10);
        leonard = new Dog("Leonard", 22, 13);
        spot = new Dog("Spot", 17, 9);
		myDogList.add(fifi);
		myDogList.add(butch);
		myDogList.add(leonard);
		myDogList.add(spot);
		n1 = myDogList.itsFirstNode;
		n2 = myDogList.itsLastNode;
	}
	
	@Test
	public void testSize(){
		assertEquals(myDogList.size(),4);
	}
	
	@Test
	public void testAdd(){
		
		assertEquals(n1.getData(),fifi);
		assertEquals(n2.getData(),spot);
	}
	
	@Test
	public void testAddAtIndex(){
		myDogList.add(spot,1);
		LinkedList.Node current = n1.getNextNode();
		assertEquals(current.getData(),spot);
	}
	
	@Test
	public void testGet(){
		LinkedList.Node current = n2.getPriorNode();
		assertEquals(current.getData(),leonard);
	}
	
	@Test
	public void testContains(){
		assertTrue(myDogList.contains(leonard));
	}
	
	@Test
	public void testIndexOf(){
		assertEquals(myDogList.indexOf(spot),3);
	}
	
	@Test
	public void testHasNext(){
		Iterator<Dog> iter1 = myDogList.getIterator();
		assertTrue(iter1.hasNext());
	}
	
	@Test
	public void testHasPrior(){
		Iterator<Dog> iter1 = myDogList.getIterator();
		iter1.setToEnd();
		assertTrue(iter1.hasPrior());
	}
	
	@Test
	public void testNext(){
		Iterator<Dog> iter1 = myDogList.getIterator();
		assertEquals(iter1.next(),fifi);
	}
	
	@Test
	public void testPrior(){
		Iterator<Dog> iter1 = myDogList.getIterator();
		iter1.setToEnd();
		assertEquals(iter1.prior(),spot);
	}
	
	@Test
	public void testSetToEnd(){
		Iterator<Dog> iter1 = myDogList.getIterator();
		iter1.setToEnd();
		assertEquals(iter1.next(),spot);
	}
}
	
	