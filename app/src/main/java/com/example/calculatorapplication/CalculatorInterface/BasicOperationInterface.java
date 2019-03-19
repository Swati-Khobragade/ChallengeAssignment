package com.example.calculatorapplication.CalculatorInterface;

import com.example.calculatorapplication.Enum.OperationEnum;

/**
 * @author Swati.Khobragade
 */

public interface BasicOperationInterface {
    /**
     * @param firstNum
     * @param secondNum
     * @param operation
     * @return
     */
    double calculateBasicOperation(double firstNum, double secondNum, OperationEnum operation);
}
