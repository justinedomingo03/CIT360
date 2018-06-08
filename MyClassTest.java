import org.junit.*;


import junit.framework.TestCase;

public class MyClassTest extends TestCase {
	private int value1;
	private int value2;
	private int value3;

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
		int sum = MyClass.add(value1, value2);
		assertEquals(sum, total);
	}
	@Test
	public void testFailedAdd() {
		int total = 9;
		int sum = MyClass.add(value1, value2);
		assertNotSame(sum, total);
	}
	@Test
	public void testSub() {
		int total = 0;
		int sub = MyClass.sub(4, 4);
		assertEquals(sub, total);
	}
	@Test
	public void testMul() {
		int total = 15;
		int mul = MyClass.mul(value1, value2);
		assertEquals(mul, total);
	}
	@Test
	public void testDiv() {
		int total = 3;
		int div = MyClass.div(value3, value2);
		assertEquals(div, total);
	}
	@Test
	public void testExp() {
		int total = 243;
		int exp = MyClass.exp(value1, value2);
		assertEquals(exp, total);
	}
}