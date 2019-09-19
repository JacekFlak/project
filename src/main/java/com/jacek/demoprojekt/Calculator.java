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

    private CalculatorLogic calculatorLogic;
    private final Logger logger = LoggerFactory.getLogger(Connection.class);

    public Calculator(CalculatorLogic calculatorLogic) {
        this.calculatorLogic = calculatorLogic;
    }

    @GetMapping("/calc")
    protected double doGet(@RequestParam double a, @RequestParam double b) {
        logger.info("Request got -> sum_result");
        return calculatorLogic.sum(a, b);
    }
}
