package mavenMicroservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAddition() {
        assertEquals(4, Calculator.calculate(2, 2, '+'));
    }

    @Test
    void testSubtraction() {
        assertEquals(2, Calculator.calculate(5, 3, '-'));
    }

    @Test
    void testMultiplication() {
        assertEquals(15, Calculator.calculate(3, 5, '*'));
    }

    @Test
    void testDivision() {
        assertEquals(2, Calculator.calculate(6, 3, '/'));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            Calculator.calculate(5, 0, '/');
        });
    }

    @Test
    void testInvalidOperator() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.calculate(5, 5, '%');
        });
    }
}