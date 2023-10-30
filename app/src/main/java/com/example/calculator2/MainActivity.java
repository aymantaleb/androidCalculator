//Calculator by Ayman Taleb 11/04/2021

package com.example.calculator2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.*;
import android.widget.*;

import com.example.calculator2.Calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //button declaration
    Button buttonEqual;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonMultiply;
    Button buttonDivide;
    Button buttonPercent;
    Button buttonSquart;
    Button buttonXSquare;
    Button buttonXtoY;
    Button buttonAC;
    Button buttonSign;
    Button buttonLN;
    Button buttonEggMan;
    Button buttonDecimal;



    /* operation type codes:
    *-1: none
    * 1: addition
    * 2: subtraction
    * 3: multiplication
    * 4: division
    * 5: percent
    * 6: square root
    * 7: square
    * 8: natural log
    * 9: exponent*/

    int operation = -1;
    boolean decFlag = false, mainOperatorFlag = false;//flag for decimal so it can't be put in more than once
    TextView numberDisplay;
    ArrayList <Double> digits = new ArrayList<>();//digits entered up to 10
    ArrayList <Integer> operations = new ArrayList<>();//operations (+,-,*,/) can be done in a long sequence of a max of 10 digits and 9 operations

    double number1 = 0;
    double number2 = 0;
    double sign = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing UI elements
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPlus = (Button) findViewById(R.id.buttonplus);
        buttonMinus = (Button) findViewById(R.id.buttonminus);
        buttonMultiply = (Button) findViewById(R.id.buttonmultiply);
        buttonDivide = (Button) findViewById(R.id.buttondivide);
        buttonEqual = (Button) findViewById(R.id.buttonequal);
        buttonDecimal = (Button) findViewById(R.id.buttondec);
        buttonSquart = (Button) findViewById(R.id.buttonsqrt);
        buttonSign = (Button) findViewById(R.id.buttonsign);
        buttonXSquare = (Button) findViewById(R.id.buttonxsquared);
        buttonXtoY = (Button) findViewById(R.id.buttonxtoy);
        buttonLN = (Button) findViewById(R.id.buttonln);
        buttonPercent = (Button) findViewById(R.id.buttonpercent);
        buttonAC = (Button) findViewById(R.id.buttonac);
//        buttonEggMan = (Button) findViewById(R.id.buttonfunnylittleguy);
        numberDisplay = (TextView) findViewById(R.id.numberDisplay);
        numberDisplay.setText("0");


        //number buttons, each checks if there are the max amount of digits in the arraylist
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int decimalIndex = 0;


                    if (digits.size() < 10) {
                        if (numberDisplay.getText().toString().equals("0")) {
                            numberDisplay.setText("0");
                        } else {
                            numberDisplay.setText(numberDisplay.getText() + "0");
                        }
                    }


            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int decimalIndex = 0;
                if(numberDisplay.getText().toString().contains(".") && numberDisplay.getText().toString().indexOf(".") != numberDisplay.getText().toString().length()-1){
                    decimalIndex = numberDisplay.getText().toString().indexOf(".");
                    char nextChar = numberDisplay.getText().toString().charAt(decimalIndex + 1);
                    String displayText = numberDisplay.getText().toString();
                    displayText.lastIndexOf(0);
                    if(nextChar == '0' && displayText.indexOf(nextChar) == displayText.length() - 1){
                        numberDisplay.setText(displayText.substring(0,decimalIndex+1));
                    }
                }

                    if (digits.size() < 10) {
                        if (numberDisplay.getText().toString().equals("0")) {
                            numberDisplay.setText("1");
                        } else {
                            numberDisplay.setText(numberDisplay.getText() + "1");
                        }
                    }

            }
        });
//
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int decimalIndex = 0;
                if(numberDisplay.getText().toString().contains(".") && numberDisplay.getText().toString().indexOf(".") != numberDisplay.getText().toString().length()-1){
                    decimalIndex = numberDisplay.getText().toString().indexOf(".");
                    char nextChar = numberDisplay.getText().toString().charAt(decimalIndex + 1);
                    String displayText = numberDisplay.getText().toString();
                    if(nextChar == '0' && displayText.indexOf(nextChar) == displayText.length() - 1){
                        numberDisplay.setText(displayText.substring(0,decimalIndex+1));
                    }
                }
                if(digits.size() < 10) {
                    if (numberDisplay.getText().toString().equals("0")) {
                        numberDisplay.setText("2");
                    } else {
                        numberDisplay.setText(numberDisplay.getText() + "2");
                    }
                }

            }
        });
//
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(digits.size() < 10) {
                    int decimalIndex = 0;
                    if(numberDisplay.getText().toString().contains(".") && numberDisplay.getText().toString().indexOf(".") != numberDisplay.getText().toString().length()-1){
                        decimalIndex = numberDisplay.getText().toString().indexOf(".");
                        char nextChar = numberDisplay.getText().toString().charAt(decimalIndex + 1);
                        String displayText = numberDisplay.getText().toString();
                        if(nextChar == '0' && displayText.indexOf(nextChar) == displayText.length() - 1){
                            numberDisplay.setText(displayText.substring(0,decimalIndex+1));
                        }
                    }
                    if (numberDisplay.getText().toString().equals("0")) {
                        numberDisplay.setText("3");
                    } else {
                        numberDisplay.setText(numberDisplay.getText() + "3");
                    }
                }
            }
        });
//
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int decimalIndex = 0;
                if(numberDisplay.getText().toString().contains(".") && numberDisplay.getText().toString().indexOf(".") != numberDisplay.getText().toString().length()-1){
                    decimalIndex = numberDisplay.getText().toString().indexOf(".");
                    char nextChar = numberDisplay.getText().toString().charAt(decimalIndex + 1);
                    String displayText = numberDisplay.getText().toString();
                    if(nextChar == '0' && displayText.indexOf(nextChar) == displayText.length() - 1){
                        numberDisplay.setText(displayText.substring(0,decimalIndex+1));
                    }
                }
                if(digits.size() < 10) {
                    if (numberDisplay.getText().toString().equals("0")) {
                        numberDisplay.setText("4");
                    } else {
                        numberDisplay.setText(numberDisplay.getText() + "4");
                    }
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int decimalIndex = 0;
                if(numberDisplay.getText().toString().contains(".") && numberDisplay.getText().toString().indexOf(".") != numberDisplay.getText().toString().length()-1){
                    decimalIndex = numberDisplay.getText().toString().indexOf(".");
                    char nextChar = numberDisplay.getText().toString().charAt(decimalIndex + 1);
                    String displayText = numberDisplay.getText().toString();
                    if(nextChar == '0' && displayText.indexOf(nextChar) == displayText.length() - 1){
                        numberDisplay.setText(displayText.substring(0,decimalIndex+1));
                    }
                }
                if(digits.size() < 10) {
                    if (numberDisplay.getText().toString().equals("0")) {
                        numberDisplay.setText("5");
                    } else {
                        numberDisplay.setText(numberDisplay.getText() + "5");
                    }
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int decimalIndex = 0;
                if(numberDisplay.getText().toString().contains(".") && numberDisplay.getText().toString().indexOf(".") != numberDisplay.getText().toString().length()-1){
                    decimalIndex = numberDisplay.getText().toString().indexOf(".");
                    char nextChar = numberDisplay.getText().toString().charAt(decimalIndex + 1);
                    String displayText = numberDisplay.getText().toString();
                    if(nextChar == '0' && displayText.indexOf(nextChar) == displayText.length() - 1){
                        numberDisplay.setText(displayText.substring(0,decimalIndex+1));
                    }
                }
                if(digits.size() < 10) {
                    if (numberDisplay.getText().toString().equals("0")) {
                        numberDisplay.setText("6");
                    } else {
                        numberDisplay.setText(numberDisplay.getText() + "6");
                    }
                }
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int decimalIndex = 0;
                if(numberDisplay.getText().toString().contains(".") && numberDisplay.getText().toString().indexOf(".") != numberDisplay.getText().toString().length()-1){
                    decimalIndex = numberDisplay.getText().toString().indexOf(".");
                    char nextChar = numberDisplay.getText().toString().charAt(decimalIndex + 1);
                    String displayText = numberDisplay.getText().toString();
                    if(nextChar == '0' && displayText.indexOf(nextChar) == displayText.length() - 1){
                        numberDisplay.setText(displayText.substring(0,decimalIndex+1));
                    }
                }
                if(digits.size() < 10) {
                    if (numberDisplay.getText().toString().equals("0")) {
                        numberDisplay.setText("7");
                    } else {
                        numberDisplay.setText(numberDisplay.getText() + "7");
                    }
                }

            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int decimalIndex = 0;
                if(numberDisplay.getText().toString().contains(".") && numberDisplay.getText().toString().indexOf(".") != numberDisplay.getText().toString().length()-1){
                    decimalIndex = numberDisplay.getText().toString().indexOf(".");
                    char nextChar = numberDisplay.getText().toString().charAt(decimalIndex + 1);
                    String displayText = numberDisplay.getText().toString();
                    if(nextChar == '0' && displayText.indexOf(nextChar) == displayText.length() - 1){
                        numberDisplay.setText(displayText.substring(0,decimalIndex+1));
                    }
                }
                if(digits.size() < 10) {
                    if (numberDisplay.getText().toString().equals("0")) {
                        numberDisplay.setText("8");
                    } else {
                        numberDisplay.setText(numberDisplay.getText() + "8");
                    }
                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int decimalIndex = 0;
                if(numberDisplay.getText().toString().contains(".") && numberDisplay.getText().toString().indexOf(".") != numberDisplay.getText().toString().length()-1){
                    decimalIndex = numberDisplay.getText().toString().indexOf(".");
                    char nextChar = numberDisplay.getText().toString().charAt(decimalIndex + 1);
                    String displayText = numberDisplay.getText().toString();
                    if(nextChar == '0' && displayText.indexOf(nextChar) == displayText.length() - 1){
                        numberDisplay.setText(displayText.substring(0,decimalIndex+1));
                    }
                }
                if(digits.size() < 10) {
                    if (numberDisplay.getText().toString().equals("0")) {
                        numberDisplay.setText("9");
                    } else {
                        numberDisplay.setText(numberDisplay.getText() + "9");
                    }
                }

            }
        });

        //decimal button
        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (numberDisplay.getText().toString().contains(".")) {
                        decFlag = true;
                    }
                    else{
                        decFlag = false;
                    }

                    if (decFlag == false) {
                        numberDisplay.setText(numberDisplay.getText() + ".");
                        decFlag = true;
                    }


            }
        });

        //operation buttons
        buttonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sign == 1) {
                    double temp = Double.parseDouble(numberDisplay.getText() + "");
                    temp = -1 * temp;
                    sign = -1;
                    numberDisplay.setText(Double.toString(temp));
                }
                else if(sign == -1){
                    double temp = Double.parseDouble(numberDisplay.getText() + "");
                    temp = -1 * temp;
                    sign = 1;
                    numberDisplay.setText(Double.toString(temp));
                }
            }
        });
//        checks if there are the max amount of operations in the arraylist
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!numberDisplay.getText().equals("")) {
                    if(operations.size() < 9){
                        number1 = Double.parseDouble(numberDisplay.getText() + "");
                        operation = 1;
                        digits.add(number1);
                        operations.add(operation);
                        numberDisplay.setText("");
                        mainOperatorFlag = true;
                    }

                }
            }
        });
//        checks if there are the max amount of operations in the arraylist
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!numberDisplay.getText().equals("")) {
                    if(operations.size() < 9){
                        number1 = Double.parseDouble(numberDisplay.getText() + "");
                        operation = 2;
                        digits.add(number1);
                        operations.add(operation);
                        numberDisplay.setText("");
                        mainOperatorFlag = true;
                    }
                }
            }
        });
        // checks if there are the max amount of operations in the arraylist
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!numberDisplay.getText().equals("")) {
                    if(operations.size() < 9){
                        number1 = Double.parseDouble(numberDisplay.getText() + "");
                        operation = 3;
                        digits.add(number1);
                        operations.add(operation);
                        numberDisplay.setText("");
                        mainOperatorFlag = true;
                    }
                }
            }
        });
//        checks if there are the max amount of operations in the arraylist
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!numberDisplay.getText().equals("")) {
                    if(operations.size() < 9){
                        number1 = Double.parseDouble(numberDisplay.getText() + "");
                        operation = 4;
                        digits.add(number1);
                        operations.add(operation);
                        numberDisplay.setText("");
                        mainOperatorFlag = true;
                    }
                }
            }
        });

        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mainOperatorFlag) {
                    if (!numberDisplay.getText().equals("")) {
                        number1 = Double.parseDouble(numberDisplay.getText() + "");
                        operation = 5;
                        numberDisplay.setText("");
                        Calculator calculator = new Calculator(number1, operation);
                        numberDisplay.setText(Double.toString(calculator.result));
                    }
                }
            }
        });

        buttonSquart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mainOperatorFlag) {
                    if (!numberDisplay.getText().equals("")) {
                        number1 = Double.parseDouble(numberDisplay.getText() + "");
                        operation = 6;
                        numberDisplay.setText("");
                        Calculator calculator = new Calculator(number1, operation);
                        numberDisplay.setText(Double.toString(calculator.result));
                    }
                }
            }
        });

        buttonXSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mainOperatorFlag) {
                    if (!numberDisplay.getText().equals("")) {
                        number1 = Double.parseDouble(numberDisplay.getText() + "");
                        operation = 7;
                        numberDisplay.setText("");
                        Calculator calculator = new Calculator(number1, operation);
                        numberDisplay.setText(Double.toString(calculator.result));
                    }
                }
            }
        });

        buttonLN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mainOperatorFlag) {
                    if (!numberDisplay.getText().equals("")) {
                        number1 = Double.parseDouble(numberDisplay.getText() + "");
                        operation = 8;
                        numberDisplay.setText("");
                        Calculator calculator = new Calculator(number1, operation);
                        numberDisplay.setText(Double.toString(calculator.result));
                    }
                }
            }
        });

        buttonXtoY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mainOperatorFlag) {
                    if (!numberDisplay.getText().equals("")) {
                        number1 = Double.parseDouble(numberDisplay.getText() + "");
                        operation = 9;
                        numberDisplay.setText("");
                    }
                }
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number2 = Double.parseDouble(numberDisplay.getText()+"");
                digits.add(number2);

               if(operation == 4 && number2 == 0){
                    numberDisplay.setText("ERROR");
                }
                else if (operation == -1){

                    numberDisplay.setText(numberDisplay.getText());
                }
                else if(operation == 9){
                    Calculator calculator = new Calculator(number1,number2,operation);
                    numberDisplay.setText(Double.toString(calculator.result));
                }

                else {
                    Calculator calculator = new Calculator(operations,digits);
                    numberDisplay.setText(Double.toString(calculator.result));
                }

            }
        });



        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1 = 0;
                number2 = 0;
                operations.clear();
                digits.clear();
                operation = -1;
                decFlag = false;
                mainOperatorFlag = false;
                numberDisplay.setText("0");
            }
        });


    }
}
