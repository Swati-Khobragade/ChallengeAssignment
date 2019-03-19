package com.example.calculatorapplication.Controller;
/**
 * @author Swati.Khobragade
 */

import android.util.Log;

import com.example.calculatorapplication.CalculatorInterface.ScientificOperationInterface;
import com.example.calculatorapplication.Enum.OperationEnum;

public class ScientificOperationCalculation implements ScientificOperationInterface {
    double mNumber;
    double mCalculatedValue;

    @Override
    public double calculateScientificOperation(double number, OperationEnum operation) {
        Log.d("Number", String.valueOf(number));
        mNumber = number;
        mCalculatedValue = 0;
        switch (operation) {
            case LOG:
                logOperation();
                break;
            case LOGN:
                logNOperation();
                break;
        }
        Log.d("calculated Value", String.valueOf(mCalculatedValue));
        return mCalculatedValue;
    }

    /**
     * Method to calculate log
     */
    private void logOperation() {
        try {
            mCalculatedValue = Math.log(mNumber);
        } catch (ArithmeticException ex) {
            Log.e("Exception::", ex.getMessage());
        }
    }

    /**
     * Method to calculate logN
     */
    private void logNOperation() {
        try {
            mCalculatedValue = Math.log10(mNumber);
        } catch (ArithmeticException ex) {
            Log.e("Exception::", ex.getMessage());
        }
    }
}
