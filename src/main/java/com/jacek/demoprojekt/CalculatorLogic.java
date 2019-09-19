package com.jacek.demoprojekt;

import org.springframework.stereotype.Service;

@Service
public class CalculatorLogic {

    private double a = 4.5;
    private double b = 3.5;

    double sum(double x, double y) {
        return x + y;
    }
}