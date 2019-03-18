package com.example.calculatorapplication.Controller;
/**
 * @author Swati.Khobragade
 */

import android.util.Log;

import com.example.calculatorapplication.CalculatorInterface.ArithmeticOperationInterface;

public class ScientificOperationCalculation implements ArithmeticOperationInterface {


    @Override
    public double calculateBasicOperation(double firstNum, double secondNum, String operation) {
        return 0;
    }

    @Override
    public double calculateScientificOperation(double number, String operation) {
        Log.d("Number", String.valueOf(number));
        double calculatedValue = 0;
        switch (operation) {
            case "log":
                try {
                    calculatedValue = Math.log(number);
                } catch (ArithmeticException ex) {
                    Log.e("Exception::", ex.getMessage());
                }
                break;
            case "logN":
                try {
                    calculatedValue = Math.log10(number);
                } catch (ArithmeticException ex) {
                    Log.e("Exception::", ex.getMessage());
                }
                break;
        }
        Log.d("calculated Value", String.valueOf(calculatedValue));
        return calculatedValue;
    }
}
