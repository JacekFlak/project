package com.jacek.demoprojekt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Calculator {

    private CalculatorFunctions calculatorFunctions;
    private final Logger logger = LoggerFactory.getLogger(Connection.class);

    public Calculator(CalculatorFunctions calculatorFunctions) {
        this.calculatorFunctions = calculatorFunctions;
    }

    private String a;// = request.getParameter("firstValue");
    private String b;// = request.getParameter("secondValue");
    private double aValue = Double.parseDouble(a);
    private double bValue = Double.parseDouble(b);
    private double sumValue = CalculatorFunctions.sum(aValue, bValue);

    String wynik = String.valueOf(sumValue);

    @GetMapping("/calc")
    protected double doGet(@RequestParam(required = false, value = "a", defaultValue = " ") double a, @RequestParam(required = false, value = "b", defaultValue = " ") double b) {
        logger.info("Request got -> sum_result");
        return calculatorFunctions.sum(a, b);
    }
}
