package com.example.calculatorapplication;

import com.example.calculatorapplication.Controller.ScientificOperationCalculation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ScientificOperationCalculationTest {
    private ScientificOperationCalculation scientificOperationCalculation;

    /**
     * Sets up the test fixture.
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {
        scientificOperationCalculation = new ScientificOperationCalculation();
    }

    /**
     * Tears down the test fixture.
     * (Called after every test case method.)
     */
    @After
    public void tearDown() {
        scientificOperationCalculation = null;
    }

    /**
     * Method to test log operation
     */
    @Test
    public void testLogOperation() {
        assertTrue(scientificOperationCalculation.calculateScientificOperation(45, "log") == 3.8066624897703196);
        assertFalse(scientificOperationCalculation.calculateScientificOperation(45, "log") == 4.8066624897703196);
    }

    /**
     * Method to test logN operation
     */
    @Test
    public void testLogNOperation() {
        assertTrue(scientificOperationCalculation.calculateScientificOperation(45, "logN") == 1.6532125137753437);
        assertFalse(scientificOperationCalculation.calculateScientificOperation(45, "logN") == 2.6532125137753437);

    }
}

