import org.junit.Test;
import static org.junit.Assert.*;

public class TestUnboundedPriorityQueue{

	@Test
	public void testEnqueue1(){
		UnboundedPriorityQueue queue = new UnboundedPriorityQueue(1);
		queue.enqueue(1);
		assertEquals(queue.dequeue(), 1);
	}
	
	@Test
	public void testEnqueue2(){
		UnboundedPriorityQueue queue = new UnboundedPriorityQueue(1);
		queue.enqueue(1);
		queue.enqueue(2);
		assertEquals(queue.dequeue(),1);
		assertEquals(queue.dequeue(),2);
	}
	
	@Test
	public void testEnqueueFullArray(){
		UnboundedPriorityQueue queue = new UnboundedPriorityQueue(1);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		//Ensuring that the size of the array is greater than the initialized value of 1.
		assertTrue(queue.getSize() > 1);
	}
	
	@Test
	public void testDequeue1(){
		UnboundedPriorityQueue queue = new UnboundedPriorityQueue(1);
		queue.enqueue(1);
		assertEquals(queue.dequeue(), 1);
	}
	
	@Test
	public void testDequeue2(){
		UnboundedPriorityQueue queue = new UnboundedPriorityQueue(1);
		queue.enqueue(1);
		queue.enqueue(2);
		assertEquals(queue.dequeue(), 1);
		assertEquals(queue.dequeue(), 2);
	}
	
	@Test
	public void testDequeueEmptyQueue(){
		UnboundedPriorityQueue queue = new UnboundedPriorityQueue(1);
		try{
			queue.dequeue();
			fail();
		}catch(IndexOutOfBoundsException e){
			assertEquals(e.getMessage(), "Priority queue is empty!");
		}
	}
	
	@Test
	public void testfindMin(){
		UnboundedPriorityQueue queue = new UnboundedPriorityQueue(1);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		assertEquals(queue.findMin(),1);
	}
	
	@Test
	public void testFindMinException(){
		UnboundedPriorityQueue queue = new UnboundedPriorityQueue(1);
		try{
			queue.findMin();
		}catch(IndexOutOfBoundsException e){
			assertEquals(e.getMessage(), "Priority queue is empty!");
		}
	}
	
	@Test
	public void testIsEmpty(){
		UnboundedPriorityQueue queue = new UnboundedPriorityQueue(1);
		queue.enqueue(1);
		assertTrue(queue.isEmpty() == false);
		queue.dequeue();
		assertTrue(queue.isEmpty() == true);
	}
	
	@Test
	public void testGetSize(){
		UnboundedPriorityQueue queue = new UnboundedPriorityQueue(1);
		queue.enqueue(1);
		queue.enqueue(2);
		assertEquals(queue.getSize(), 2);
		queue.dequeue();
		assertEquals(queue.getSize(), 1);
	}

}