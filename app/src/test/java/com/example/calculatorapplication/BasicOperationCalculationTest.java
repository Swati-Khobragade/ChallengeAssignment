package com.example.calculatorapplication;

import com.example.calculatorapplication.Controller.BasicOperationCalculation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BasicOperationCalculationTest {
    private BasicOperationCalculation basicOperationCalculation;

    /**
     * Sets up the test fixture.
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {
        basicOperationCalculation = new BasicOperationCalculation();
    }

    /**
     * Tears down the test fixture.
     * (Called after every test case method.)
     */
    @After
    public void tearDown() {
        basicOperationCalculation = null;
    }
    @Test
    public void addition_isCorrect() {
        assertEquals(basicOperationCalculation.calculateBasicOperation(6, 4, "add"),10.0,0.0);
    }
    @Test
    public void subtraction_isCorrect() {
        assertEquals(basicOperationCalculation.calculateBasicOperation(6, 4, "sub"),2.0,0.0);
    }
    @Test
    public void multiplication_isCorrect() {
        assertEquals(basicOperationCalculation.calculateBasicOperation(6, 4, "mult"),24.0,0.0);
    }
    @Test
    public void division_isCorrect() {
        assertEquals(basicOperationCalculation.calculateBasicOperation(6, 4, "div"),1.5,0.0);
    }
}
