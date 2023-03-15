package test;
import org.junit.Test;
import static org.junit.Assert.*;
import main.Calculator;

public class CalculatorTest {
    private static final double DELTA = 1e-15;
    Calculator calculator = new Calculator();


    @Test
    public void factorialTruePositive(){
        assertEquals("Finding factorial of a number for True Positive", 720, calculator.Factorial(6), DELTA);
        assertEquals("Finding factorial of a number for True Positive", 1, calculator.Factorial(1), DELTA);
        assertEquals("Finding factorial of a number for True Positive", 6, calculator.Factorial(3), DELTA);
        assertEquals("Finding factorial of a number for True Positive", 24, calculator.Factorial(4), DELTA);
        assertEquals("Finding factorial of a number for True Positive", 1, calculator.Factorial(0), DELTA);
    }

    @Test
    public void factorialFalsePositive(){
        assertNotEquals("Finding factorial of a number for False Positive", 113, calculator.Factorial(5), DELTA);
        assertNotEquals("Finding factorial of a number for False Positive", 10, calculator.Factorial(6), DELTA);
        assertNotEquals("Finding factorial of a number for False Positive", 42, calculator.Factorial(4), DELTA);
        assertNotEquals("Finding factorial of a number for False Positive", 9, calculator.Factorial(2), DELTA);
        assertNotEquals("Finding factorial of a number for False Positive", 0, calculator.Factorial(0), DELTA);
    }

    @Test
    public void powerTruePositive(){
        assertEquals("Finding power for True Positive", 8, calculator.Power(2, 3), DELTA);
        assertEquals("Finding power for True Positive", 1, calculator.Power(1, 3), DELTA);
        assertEquals("Finding power for True Positive", 81, calculator.Power(3, 4), DELTA);
        assertEquals("Finding power for True Positive", 64, calculator.Power(4, 3), DELTA);
        assertEquals("Finding power for True Positive", 25, calculator.Power(5, 2), DELTA);
    }

    @Test
    public void powerFalsePositive(){
        assertNotEquals("Finding power for False Positive", 6, calculator.Power(2, 3), DELTA);
        assertNotEquals("Finding power for False Positive", -7, calculator.Power(3, 3), DELTA);
        assertNotEquals("Finding power for False Positive", 99, calculator.Power(4, 3), DELTA);
        assertNotEquals("Finding power for False Positive", -12, calculator.Power(5, 3), DELTA);
    }

    @Test
    public void logTruePositive(){
        assertEquals("Finding natural log for True Positive", 0, calculator.Log(1), DELTA);

    }

    @Test
    public void logFalsePositive(){
        assertNotEquals("Finding natural log for False Positive", 60, calculator.Log(2.4), DELTA);
        assertNotEquals("Finding natural log for False Positive", 4.7, calculator.Log(2.1), DELTA);
    }

    @Test
    public void squareRootTruePositive(){
        assertEquals("Finding square root for True Positive", 4, calculator.SquareRoot(16), DELTA);
        assertEquals("Finding square root for True Positive", 1, calculator.SquareRoot(1), DELTA);
        assertEquals("Finding square root for True Positive", 9, calculator.SquareRoot(81), DELTA);
        assertEquals("Finding square root for True Positive", 6, calculator.SquareRoot(36), DELTA);
    }

    @Test
    public void squareRootFalsePositive(){
        assertNotEquals("Finding square root for False Positive", 1, calculator.SquareRoot(3), DELTA);
        assertNotEquals("Finding square root for False Positive", 3, calculator.SquareRoot(4), DELTA);
        assertNotEquals("Finding square root for False Positive", 4, calculator.SquareRoot(81), DELTA);
        assertNotEquals("Finding square root for False Positive", 2, calculator.SquareRoot(36), DELTA);

    }


}
