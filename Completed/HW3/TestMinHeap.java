import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;

public class TestMinHeap{
    
    @Test
    public void testIsEmpty(){
        MinHeap newHeap = new MinHeap(4);
        assertTrue(newHeap.isEmpty());
        newHeap.Insert(2);
        assertFalse(newHeap.isEmpty());
    }

    @Test
    public void testSize(){
        MinHeap newHeap = new MinHeap(3);
        newHeap.Insert(4);
        newHeap.Insert(9);
        newHeap.Insert(2);
        assertEquals(3, newHeap.size());
    }

    @Test
    public void testInsertToMinHeap(){
        MinHeap newHeap = new MinHeap(3);
        newHeap.Insert(new String("4"));
        newHeap.Insert(new String("9"));
        newHeap.Insert(new String("2"));
        System.out.println(newHeap.getMin());
        assertEquals("2", newHeap.getMin());
    }

    @Test
    public void testIsFull(){
        MinHeap newHeap = new MinHeap(4);
        newHeap.Insert(4);
        newHeap.Insert(9);
        newHeap.Insert(2);
        newHeap.Insert(5);
        System.out.print(newHeap.size());
        assertTrue(newHeap.isFull());
    }

    @Test
    public void testRemove(){
        MinHeap newHeap = new MinHeap(4);
        newHeap.Insert(4);
        newHeap.Insert(9);
        newHeap.Insert(2);
        newHeap.Insert(5);
        System.out.print(newHeap.size());
        newHeap.remove();
        newHeap.remove();
        assertEquals(2, newHeap.size());
        assertEquals(5, newHeap.remove());
    }

    @Test
    public void testToString(){
        MinHeap newHeap = new MinHeap(4);
        newHeap.Insert(4);
        newHeap.Insert(9);
        newHeap.Insert(2);
        newHeap.Insert(5);
        String str = "The list of elements in the minheap is: [2, 5, 4, 9]";
        System.out.print(newHeap);
        assertEquals(str,newHeap.toString());
    }
}