package com.example.calculatorapplication.CalculatorInterface;

import com.example.calculatorapplication.Enum.OperationEnum;

/**
 * @author swati.khobragade
 */
public interface ScientificOperationInterface {
    /**
     * @param number
     * @param operation
     * @return
     */
    double calculateScientificOperation(double number, OperationEnum operation);
}
