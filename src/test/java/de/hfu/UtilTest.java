package de.hfu;

import org.junit.Test;
import static org.junit.Assert.*;


public class UtilTest {
	@Test
	public void testistErstesHalbjahrTrue() {
		assertTrue(Util.istErstesHalbjahr(6));
	}
	
	@Test
	public void testistErstesHalbjahrFalse() {
		assertFalse(Util.istErstesHalbjahr(7));
	}
	
	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void testistErstesHalbjahrExeption() {
		Util.istErstesHalbjahr(13);
	}
}
