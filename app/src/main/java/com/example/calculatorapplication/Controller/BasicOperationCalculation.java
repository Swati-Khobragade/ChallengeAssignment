package com.example.calculatorapplication.Controller;
/**
 * @author Swati.Khobragade
 */

import android.util.Log;

import com.example.calculatorapplication.CalculatorInterface.BasicOperationInterface;
import com.example.calculatorapplication.Enum.OperationEnum;

public class BasicOperationCalculation implements BasicOperationInterface {
    double mFirstNum;
    double mSecondNum;
    double mCalculatedValue;

    @Override
    public double calculateBasicOperation(double firstNum, double secondNum, OperationEnum operation) {
        Log.d("mFirstNum", String.valueOf(firstNum));
        Log.d("mSecondNum", String.valueOf(secondNum));
        mFirstNum = firstNum;
        mSecondNum = secondNum;
        mCalculatedValue = 0;
        switch (operation) {
            case ADD:
                addOperation();
                break;
            case SUB:
                subOperation();
                break;
            case MULTIPLY:
                multiplyOperation();
                break;
            case DIVIDE:
                divideOperation();
                break;
        }
        Log.d("calculated Value", String.valueOf(mCalculatedValue));
        return mCalculatedValue;
    }

    /**
     * Method to Add Numbers
     */
    private void addOperation() {
        try {
            mCalculatedValue = mFirstNum + mSecondNum;
        } catch (ArithmeticException ex) {
            Log.e("Exception::", ex.getMessage());
        }
    }

    /**
     * Method to Subtract Numbers
     */
    private void subOperation() {
        try {
            mCalculatedValue = mFirstNum - mSecondNum;
        } catch (ArithmeticException ex) {
            Log.e("Exception::", ex.getMessage());
        }
    }

    /**
     * Method to Multiply Numbers
     */
    private void multiplyOperation() {
        try {
            mCalculatedValue = mFirstNum * mSecondNum;
        } catch (ArithmeticException ex) {
            Log.e("Exception::", ex.getMessage());
        }
    }

    /**
     * Method to Divide Numbers
     */
    private void divideOperation() {
        try {
            mCalculatedValue = mFirstNum / mSecondNum;
        } catch (ArithmeticException ex) {
            Log.e("Exception::", ex.getMessage());
        }
    }
}
