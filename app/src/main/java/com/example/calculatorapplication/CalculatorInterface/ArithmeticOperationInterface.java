package com.example.calculatorapplication.CalculatorInterface;

/**
 * @author swati.khobragade
 */
public interface ArithmeticOperationInterface {
    /**
     * @param firstNum
     * @param secondNum
     * @param operation
     * @return
     */
    double calculateBasicOperation(double firstNum, double secondNum, String operation);

    /**
     * @param number
     * @param operation
     * @return
     */
    double calculateScientificOperation(double number, String operation);
}
