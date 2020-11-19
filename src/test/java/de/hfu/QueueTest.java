package de.hfu;

import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

public class QueueTest {
	
	private static Queue q;
	
	@BeforeClass
	public static void createClass() {
		q = new Queue(3);
	}
	
	@Test
	public void testenqueue0() {
		q = new Queue(3);
		q.enqueue(0);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		assertEquals(0,q.dequeue());
	}
	@Test
	public void testdequeue1() {
		q = new Queue(3);
		q.enqueue(0);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.dequeue();
		assertEquals(3,q.dequeue());
	}

	@Test
	public void testdequeue3() {
		q = new Queue(3);
		q.enqueue(0);
		q.enqueue(1);
		q.enqueue(2);
		q.dequeue();
		q.enqueue(0);
		assertEquals(3,q.tail);
	}
	
	@Test(expected=IllegalStateException.class, timeout=1000)
	public void testdequeueException() {
		q = new Queue(3);
		q.dequeue();
	}
	
}
