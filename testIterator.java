import java.util.*;

public class testIterator{
    public static void main(String[] args){
        LinkedList<String> colors = new LinkedList<String>();
        //add elements to colors - red, green, blue, yellow, black, white
        colors.add("red");
        colors.add("green");
        colors.add("blue");
        colors.add("yellow");
        colors.add("black");
        colors.add("white");

        //create an iterator for the list colors
        Iterator<String> iterator = colors.iterator();

        //iterate through the list using the iterator and print the list
        while (iterator.hasNext()){
            System.out.println(iterator.next());
			if (colors.contains("green")){
				iterator.remove();
			}
        }
		
        //iterate through the list using for each and print the list
        for(String c: colors){
            System.out.println(c);
        }
    }
}