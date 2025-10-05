package com.Kevin.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    
    @Autowired
    private CalculatorService calculatorService;
    
    // Calculate using operation enum
    @PostMapping("/calculate")
    public CalculationResponse calculate(@RequestBody CalculationRequest request) {
        double result = calculatorService.calculate(
            request.getOperation(), 
            request.getA(), 
            request.getB()
        );
        return new CalculationResponse(result);
    }
    
    // Individual operation endpoints (alternative approach)
    @PostMapping("/add")
    public CalculationResponse add(@RequestBody CalculationRequest request) {
        double result = calculatorService.add(request.getA(), request.getB());
        return new CalculationResponse(result);
    }
    
    @PostMapping("/subtract")
    public CalculationResponse subtract(@RequestBody CalculationRequest request) {
        double result = calculatorService.subtract(request.getA(), request.getB());
        return new CalculationResponse(result);
    }
    
    @PostMapping("/multiply")
    public CalculationResponse multiply(@RequestBody CalculationRequest request) {
        double result = calculatorService.multiply(request.getA(), request.getB());
        return new CalculationResponse(result);
    }
    
    @PostMapping("/divide")
    public CalculationResponse divide(@RequestBody CalculationRequest request) {
        double result = calculatorService.divide(request.getA(), request.getB());
        return new CalculationResponse(result);
    }
    
}