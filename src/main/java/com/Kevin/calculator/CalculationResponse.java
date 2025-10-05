package com.Kevin.calculator;

public class CalculationResponse {
    private double result;
    
    // Default constructor (required for Jackson JSON serialization)
    public CalculationResponse() {}
    
    // Constructor with result
    public CalculationResponse(double result) {
        this.result = result;
    }
    
    // Getter
    public double getResult() {
        return result;
    }
    
    // Setter
    public void setResult(double result) {
        this.result = result;
    }
}