/**
* A class CompareString that demonstrates recursion include three methods.
* One method is main
* One method compares two strings using alphabetical order. 
* One method finds the minimum String(by alphabetical order) in an array of Strings.
* 
* @author	Viet Nguyen
* @version	4/10/2019
*/
import java.util.ArrayList;

public class CompareString{
	
	public static void main(String[] args){
		
		ArrayList<String> stringArray = new ArrayList<>();
		stringArray.add("Heal!");
		stringArray.add("Hel");
		stringArray.add("Heal");
		stringArray.add("Hoah");
		
		System.out.println(compareTo(stringArray.get(0),stringArray.get(1)));
		System.out.println(findMinimum(stringArray));
		
	}
	/*This method compares two strings based on alphabetical order
	*@param String s1
	*@param String s2
	*
	*@return: 0 if (s1=s2), positive integer if (s1>s2), negative integer if (s1<s2)
	*/
	public static int compareTo(String s1, String s2){
		
		int length1 = s1.length();
		int length2 = s2.length();
		
		if (length1 == 0){
			return -length2;
		}
		
		if (length2 == 0){
			return length1;
		}
		
		int asc1 = s1.charAt(0);
        int asc2 = s2.charAt(0);

        if (asc1 == asc2){
			return compareTo(s1.substring(1),
				   s2.substring(1));
					}
            else{
				return asc1-asc2;
			}
	}
	/*This method find minimum string in an ArrayList of strings based on alphabetical order
	*@param ArrayList<String> stringArray
	*@return String
	*/
	public static String findMinimum(ArrayList<String> stringArray){
		if (stringArray.size() == 1){
			return stringArray.get(0);
			}
		else if (stringArray.size() == 2){
			int diff = compareTo(stringArray.get(0),stringArray.get(1));
			if (diff == 0){
				return stringArray.get(0);
				}
			if (diff > 0){
				return stringArray.get(1);					
				}
			if (diff < 0){
				return stringArray.get(0);
				}
			}	
			else {
				stringArray.remove(0);
				return findMinimum(stringArray);
			}
		return "";
	}			
}