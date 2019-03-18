package com.example.calculatorapplication;

import com.example.calculatorapplication.Controller.ScientificOperationCalculation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void log_isCorrect() {
        assertTrue(scientificOperationCalculation.calculateScientificOperation(45, "log")== 3.8066624897703196);
    }

    @Test
    public void logn_isCorrect() {
        assertTrue(scientificOperationCalculation.calculateScientificOperation(45, "logN")== 1.6532125137753437);
    }

}

