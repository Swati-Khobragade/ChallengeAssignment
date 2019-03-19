package com.example.calculatorapplication;

import com.example.calculatorapplication.Controller.BasicOperationCalculation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
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

    /**
     * Method to test addition operation
     */
    @Test
    public void testAdditionOperation() {
        assertEquals(basicOperationCalculation.calculateBasicOperation(6, 4, "add"), 10.0, 0.0);
        assertNotSame(basicOperationCalculation.calculateBasicOperation(6, 4, "add"), 15);
    }

    /**
     * Method to test subtraction operation
     */
    @Test
    public void testSubtractionOperation() {
        assertEquals(basicOperationCalculation.calculateBasicOperation(6, 4, "sub"), 2.0, 0.0);
        assertNotSame(basicOperationCalculation.calculateBasicOperation(6, 4, "sub"), 6.0);
    }

    /**
     * Method to test multiplication operation
     */
    @Test
    public void testMultiplicationOperation() {
        assertEquals(basicOperationCalculation.calculateBasicOperation(6, 4, "mult"), 24.0, 0.0);
        assertNotSame(basicOperationCalculation.calculateBasicOperation(6, 4, "mult"), 22.0);
    }

    /**
     * Method to test division operation
     */
    @Test
    public void testDivisionOperation() {
        assertEquals(basicOperationCalculation.calculateBasicOperation(6, 4, "div"), 1.5, 0.0);
        assertNotSame(basicOperationCalculation.calculateBasicOperation(6, 4, "div"), 6.5);
    }
}
