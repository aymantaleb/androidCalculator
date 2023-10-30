//Calculator by Ayman Taleb 11/04/2021

package com.example.calculator2;

import android.widget.TextView;
import java.math.*;
import java.text.DecimalFormat;
import java.util.ArrayList;


//two contstructors, one for operations that take two inputs and one for operations that take one (ie %, LN, Square root, x^2)
//each operation coresponds to a different int value
public class Calculator {
    //two numbers used in operation
    double firstNum;
    double lastNum;
    double result;
    //operation variable
    int operation; //no operation = -1
    //tool to help round numbers to 7 decimals
    //constructor
    public Calculator(double firstNum, double lastNum, int operation){
        switch (operation){
            case 1: {
                result = addOperation(firstNum, lastNum);
                result = round(result,7);
                break;
            }
            case 2: {
                result = subOperation(firstNum, lastNum);
                result = round(result,7);
                break;
            }
            case 3:
                result = multOperation(firstNum,lastNum);
                result = round(result,7);
                break;
            case 4:
                result = divOperation(firstNum,lastNum);
                result = round(result,7);
                break;
            case 9:
                result = xToYOperation(firstNum,lastNum);
                result = round(result,7);
                break;
        }

    }
    public Calculator(double firstNum, int operation){
        switch (operation){
            case 5:
                result = percentOperation(firstNum);
                result = round(result,7);
                break;
            case 6:
                result = sqrtOperation(firstNum);
                result = round(result,7);
                break;
            case 7:
                result = squareOperation(firstNum);
                result = round(result,7);
                break;
            case 8:
                result = naturalLogOperation(firstNum);
                result = round(result,7);
                break;
        }

    }

    public Calculator(ArrayList<Integer> operations, ArrayList<Double> digits){

        double firstDigit = digits.get(0);
        Calculator calculator = null;
        for(int i = 0; i < digits.size() - 1; i++) {
            int operation = operations.get(i);
            double secondDigit = digits.get(i+1);
            System.out.println(firstDigit + " " + secondDigit + " " + operation);
            calculator = new Calculator(firstDigit,secondDigit,operation);
            firstDigit = calculator.result;
            result = round(calculator.result,7);
        }


    }

    //takes in a value and rounds it to the 7th decimal
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.UP);
        return bd.doubleValue();
    }



    private double xToYOperation(double firstNum, double lastNum) {
        double pow = Math.pow(firstNum, lastNum);
        return pow;
    }

    private double divOperation(double firstNum, double lastNum) {
        double v = firstNum / lastNum;
        return v;
    }

    private double multOperation(double firstNum, double lastNum) {
        double v = firstNum * lastNum;
        return v;
    }

    private double subOperation(double firstNum, double lastNum) {
        double i = firstNum - lastNum;
        return i;
    }

    private double addOperation(double firstNum, double lastNum) {

        double i = firstNum + lastNum;
        return i;
    }



    private double naturalLogOperation(double firstNum) {
        double log = Math.log(firstNum);
        return log;
    }

    private double squareOperation(double firstNum) {

        double pow = Math.pow(firstNum, 2);
        return pow;
    }

    private double sqrtOperation(double firstNum) {
        double sqrt = Math.sqrt(firstNum);
        return sqrt;
    }

    private double percentOperation(double firstNum) {
        double v = firstNum / 100;
        return (double) v;
    }
}
