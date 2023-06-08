

public class ExampleTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testAddition() {
        assertEquals(3, calculator.add(1, 2));
    }

    @Test
    public void testSubtraction() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    private void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new RuntimeException("Expected " + expected + " but got " + actual);
        }
    }
}
