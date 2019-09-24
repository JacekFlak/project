package com.jacek.demoprojekt;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorFunctionsTest {

    CalculatorFunctions calculatorFunctions = new CalculatorFunctions();

    @Test
    public void sum() {
        //given
        double firstValue = 4.15;
        double secondValue = 5.68;
        //when
        double product = calculatorFunctions.sum(firstValue, secondValue);
        //then
        assertEquals(9.83, product,0) ;
    }
}