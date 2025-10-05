package com.Kevin.calculator;
import org.springframework.stereotype.Service;
@Service
public class CalculatorService {
    /**
     * Method that processess the calculations for the calculator
     *
     * @param operation description
     * @param b the first value to be considered in the operation
     * @param a the second value to be considered in the operation
     * @return the value after the operation is completed
     */
    public double calculate(Operation operation, double a, double b) {
        switch (operation) {
            case ADDITION -> {
                return add(a, b);
            }
            case SUBTRACTION -> {
                return subtract(a, b);
            }
            case MULTIPLICATION -> {
                return multiply(a, b);
            }
            case DIVISION -> {
                return divide(a, b);
            }
            default -> throw new IllegalArgumentException("Unsupported operation");
        }
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public double subtract(double a, double b) {
        return a - b;
    }
    
    public double multiply(double a, double b) {
        return a * b;
    }
    
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }



}
