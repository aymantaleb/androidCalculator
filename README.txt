Calculator by Ayman Taleb 11/04/2021

All files needed are in the directories provided. 
All the online resources I used are listed in the statement.txt file

UI:
I spent a couple of hours playing around with the built in designer in Android Studio to get used to it and figure out how it works.
It has a landscape mode.
That egg character button does nothing, I just was trying to add an image to a button for fun because he looks funny. 

Calculator:
The calculator takes in up to 10 digits and 9 operations(+,-,*,/), 1 digit and 1 operation(x^2,LN(x),√), or 2 digits and 1 operation(x^y).
Each operation is assigned to a int code.
	operation type codes:
    -1: none
    1: addition
    2: subtraction
    3: multiplication
    4: division
    5: percent
    6: square root
    7: square
    8: natural log
    9: exponent (x^y)
	
	
I did not correct for the use of (x^2,LN(x),√,x^y) operations in a string of terms
If (+,-,*,/) are in the list, a boolean flag, mainOperatorFlag, is set to true. When true these operators, (x^2,LN(x),√,x^y), can't be used and the buttons do nothing.

The (x^2,LN(x),√,x^y) operators do NOT work in the double order way described in the instructions.
	
The digits and operations are stored in arrayslists, the arraylists are parsed through the calculator constructor that takes lists, which runs each element in the main calculator constructor.
The digits are parsed by reading whatever is in the TextView numberDisplay, and as you press numbers the string is just appened to.
The decimal can be added, there is a boolean flag that is set to true if the current number in the display has one already, so there aren't multiple.
The calculator constructor uses a switch statment based on the operation code.
There are three calculator constructors, the first one takes in two digits and an operation for the codes(1,2,3,4,9), the second one takes one digit and operation for the codes(5,6,7,8).
The third one takes the arraylists for the digits and operators and passes them through the first constructor.
The final result is rounded using a round function written using the BigDecimal type from the java.math library. It takes a double and the decimal places amout you want to round to and returns a rounded double to that many decimal places.
