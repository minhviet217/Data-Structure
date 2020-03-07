import java.util.ArrayList;
import java.security.SecureRandom;
import java.util.Arrays;

public class SortersRunner {

    public static void main(String[] args) {

        String[] dogNames = { "Butch", "Fifi", "Spot", "Fido", "Bella", "Pepper", "Rocky", "Mac", "Happy", "Buffy" };
        ArrayList<Dog> myDogs = new ArrayList<Dog>();
        for (int i=0; i < 10; i++) {
            myDogs.add(new Dog(dogNames[i], 80.0 - i*7));
        }
		
		
	   System.out.println("initial state");
        for (Dog d : myDogs)
            System.out.println(d);
		
		ArrayList<String> a = new ArrayList<>();
		a.add("hello");
		a.add("halo");
		a.add("bibo");

       Sorters2120.mergeSort(myDogs);

        System.out.println("after sort");
        for (Dog d : myDogs)
            System.out.println(d);
        

    }
	
	
	


}
