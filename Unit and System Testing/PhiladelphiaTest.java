import static org.junit.Assert.*;
import org.junit.Test;

public class PhiladelphiaTest {
	@Test
	public void testIsItSunny() {
		assertTrue(Philadelphia.isItSunny());
	}
	@Test	//java.lang.AssertionError
	public void testFailIsItSunny() {
		assertFalse(Philadelphia.isItSunny());
	}
	
	@Test
	public void testIsPassword() {
		long p = 123456;
		assertEquals(p, Philadelphia.isPassword());
	}
	@Test	//java.lang.AssertionError: expected:<654321> but was:<123456>
	public void testFailIsPassword() {
		long p = 654321;
		assertEquals(p, Philadelphia.isPassword());
	}
	
}