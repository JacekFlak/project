package com.jacek.demoprojekt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcRestFuncServiceTest {

    CalcService calcService = new CalcService();

    @Test
    public void sum() {
        //given
        double firstValue = 4.15;
        double secondValue = 5.68;
        //when
        double product = calcService.sum(firstValue, secondValue);
        //then
        assertEquals(9.83, product, 0);
    }
}