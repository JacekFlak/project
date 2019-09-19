package com.jacek.demoprojekt;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorLogicTest {

    CalculatorLogic calculatorLogic = new CalculatorLogic();

    @Test
    public void sum() {
        //given
        double firstValue = 4.15;
        double secondValue = 5.68;
        //when
        double product = calculatorLogic.sum(firstValue, secondValue);
        //then
        assertEquals(9.83, product);
    }
}