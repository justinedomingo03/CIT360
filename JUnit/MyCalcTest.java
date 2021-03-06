import org.junit.*;


import junit.framework.TestCase;

public class MyCalcTest extends TestCase {
	int value1;
	int value2;
	int value3;

	// setUp() sets up variables required to do the testing
	public void setUp() throws Exception {
		value1 = 3;
		value2 = 5;
		value3 = 15;		
	}
	// tearDown() cleans up after test
	public void tearDown() {
		value1 = 0;
		value2 = 0;
	}
	
	@Test
	public void testAdd() {
		int total = 8;
		int sum = MyCalc.add(value1, value2);
		assertEquals(sum, total);
	}
	@Test
	public void testFailedAdd() {
		int total = 9;
		int sum = MyCalc.add(value1, value2);
		assertNotSame(sum, total);
	}
	@Test
	public void testSub() {
		int total = 0;
		int sub = MyCalc.sub(4, 4);
		assertSame(sub, total);
	}
	@Test
	public void testMul() {
		int total = 10;
		int mul = MyCalc.mul(value1, value2);
		assertTrue(mul > total);
	}
	@Test
	public void testDiv() {
		int total = 4;
		int div = MyCalc.div(value3, value2);
		assertFalse(total < div);
	}
	@Test
	public void testExp() {
		int total = 243;
		int exp = MyCalc.exp(value1, value2);
		assertEquals(exp, total);
	}
}