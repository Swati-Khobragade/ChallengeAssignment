package com.example.calculatorapplication.Controller;
/**
 * @author Swati.Khobragade
 */

import android.util.Log;

import com.example.calculatorapplication.CalculatorInterface.ArithmeticOperationInterface;

public class BasicOperationCalculation implements ArithmeticOperationInterface {
    @Override
    public double calculateBasicOperation(double firstNum, double secondNum, String operation) {
        Log.d("firstNum", String.valueOf(firstNum));
        Log.d("secondNum", String.valueOf(secondNum));
        double calculatedValue = 0;
        switch (operation) {
            case "add":
                try {
                    calculatedValue = firstNum + secondNum;
                } catch (ArithmeticException ex) {
                    Log.e("Exception::", ex.getMessage());
                }
                break;
            case "sub":
                try {
                    calculatedValue = firstNum - secondNum;
                } catch (ArithmeticException ex) {
                    Log.e("Exception::", ex.getMessage());
                }
                break;
            case "mult":
                try {
                    calculatedValue = firstNum * secondNum;
                } catch (ArithmeticException ex) {
                    Log.e("Exception::", ex.getMessage());
                }
                break;
            case "div":
                try {
                    calculatedValue = firstNum / secondNum;
                } catch (ArithmeticException ex) {
                    Log.e("Exception::", ex.getMessage());
                }
                break;
        }
        Log.d("calculated Value", String.valueOf(calculatedValue));
        return calculatedValue;
    }

    @Override
    public double calculateScientificOperation(double number, String operation) {
        return 0;
    }
}
