package com.Kevin.calculator;

public class CalculationRequest {
    private Operation operation;
    private double a;
    private double b;
    
    public CalculationRequest() {}
    
    // Getters and Setters
    public Operation getOperation() { return operation; }
    public void setOperation(Operation operation) { this.operation = operation; }
    
    public double getA() { return a; }
    public void setA(double a) { this.a = a; }
    
    public double getB() { return b; }
    public void setB(double b) { this.b = b; }
}