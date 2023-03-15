package main;
import java.util.Scanner;

// import java.lang.math;
// import java.util;

public class Calculator {
	
	  public Calculator() {
	    }
	  
	  static Calculator calculator = new Calculator();

    public double SquareRoot(double x) {
        double root;
        root = Math.sqrt(x);
        return root;
    }

    public double Factorial(double x) {
        if (x == 1 || x==0) {
            return 1;
        }
        return x * Factorial(x - 1);
    }

    public double Power(double x, double y) {
        double p;
        p = Math.pow(x, y);
        return p;
    }

    public double Log(double x) {
        double l;
        l = Math.log(x);
        return l;
    }

    public static void main(String[] args) {
        // System.out.print("Calculator in JAVA\n");
        Scanner myObj = new Scanner(System.in);

       

        double a, b;
        int z=0;
    
        System.out.print("WHAT YOU WANT TO FIND: \n" );
        System.out.print("Press '1' for Square root (√x) \n");
        System.out.print("Press '2' for Factorial (x!) \n");
        System.out.print("Press '3' for Natural Logarithm (ln(x)) \n");
        System.out.print("Press '4' for Power (x^b) \n");
    
        if( myObj.hasNext()){
            z = myObj.nextInt();
        }
        switch (z)
        {
        case 1:
            System.out.print("Enter the Number for Calculating Square Root \n");
            a = myObj.nextDouble();
            System.out.print("Square root of " + a + " is "+ calculator.SquareRoot(a) + "\n");
            break;
           
        case 2:
            System.out.print("Enter the Number for Calculating Factorial \n");
            a = myObj.nextDouble();
            System.out.print("Factorial of " + a + " is " + calculator.Factorial(a) + "\n");
            break;
    
        case 3:
            System.out.print("Enter the Number for Calculating Log \n");
            a = myObj.nextDouble();
            System.out.print("Log of of " + a + " is " + calculator.Log(a) + "\n");
            break;
    
        case 4:
            System.out.print("Enter the Number for Calculating its Power: \n");
            a = myObj.nextDouble();
            System.out.print("Enter the Power for a Number: \n" );
            b = myObj.nextDouble();
            System.out.print(a + " to the power " + b + " is " + calculator.Power(a, b) + "\n");
            break;
           
        }
        myObj.close();
    }
}

