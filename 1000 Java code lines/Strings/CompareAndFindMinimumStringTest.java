/**
* This this junit test of CompareAndFindMinimumString class
* @version 10/4/2019
* @author Viet Nguyen
*/
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
public class CompareAndFindMinimumStringTest{
	private static ArrayList<String> stringArray;
	
	@Before
	public void setUp(){
		stringArray = new ArrayList<>();
		stringArray.add("Heal!");
		stringArray.add("Hel");
		stringArray.add("Heal");
		stringArray.add("Hoah");
	}
	
	/*
	*Test for method compareTo(String s1, String s2) in CompareAndFindMinimumString class
	*/
	@Test
	public void testCompareString(){
		assertEquals(-11,CompareAndFindMinimumString.compareTo(stringArray.get(0),stringArray.get(1)));
	}
	
	/*
	*Test for method findMinimumString(ArrayList<String> stringArray) in CompareAndFindMinimumString class
	*/
	@Test
	public void testFindMinimumString(){
		assertEquals("Heal",CompareAndFindMinimumString.findMinimum(stringArray));
	}
}