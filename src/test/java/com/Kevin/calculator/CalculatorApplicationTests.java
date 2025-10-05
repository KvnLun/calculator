package com.Kevin.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorApplicationTests {

	private CalculatorService calculatorService;
    
    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }
    
    // Addition tests
    @Test
    void testAddPositiveNumbers() {
        double result = calculatorService.add(5, 3);
        assertEquals(8.0, result);
    }
    
    @Test
    void testAddNegativeNumbers() {
        double result = calculatorService.add(-5, -3);
        assertEquals(-8.0, result);
    }
    
    @Test
    void testAddZero() {
        double result = calculatorService.add(5, 0);
        assertEquals(5.0, result);
    }
    
    // Subtraction tests
    @Test
    void testSubtract() {
        double result = calculatorService.subtract(10, 3);
        assertEquals(7.0, result);
    }
    
    @Test
    void testSubtractNegativeResult() {
        double result = calculatorService.subtract(3, 10);
        assertEquals(-7.0, result);
    }
    
    // Multiplication tests
    @Test
    void testMultiply() {
        double result = calculatorService.multiply(5, 3);
        assertEquals(15.0, result);
    }
    
    @Test
    void testMultiplyByZero() {
        double result = calculatorService.multiply(5, 0);
        assertEquals(0.0, result);
    }
    
    @Test
    void testMultiplyNegativeNumbers() {
        double result = calculatorService.multiply(-5, -3);
        assertEquals(15.0, result);
    }
    
    // Division tests
    @Test
    void testDivide() {
        double result = calculatorService.divide(10, 2);
        assertEquals(5.0, result);
    }
    
    @Test
    void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> {
            calculatorService.divide(10, 0);
        });
    }
    
    @Test
    void testDivideNegativeNumbers() {
        double result = calculatorService.divide(-10, 2);
        assertEquals(-5.0, result);
    }
    
    
    // Calculate with Operation enum tests
    @Test
    void testCalculateAddition() {
        double result = calculatorService.calculate(Operation.ADDITION, 5, 3);
        assertEquals(8.0, result);
    }
    
    @Test
    void testCalculateSubtraction() {
        double result = calculatorService.calculate(Operation.SUBTRACTION, 10, 3);
        assertEquals(7.0, result);
    }
    
    @Test
    void testCalculateMultiplication() {
        double result = calculatorService.calculate(Operation.MULTIPLICATION, 5, 3);
        assertEquals(15.0, result);
    }
    
    @Test
    void testCalculateDivision() {
        double result = calculatorService.calculate(Operation.DIVISION, 10, 2);
        assertEquals(5.0, result);
    }

}
