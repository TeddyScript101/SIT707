package web.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for MathQuestionService.
 * Ensures math logic is correct, identifies wrong answers, 
 * and handles bad user input without crashing.
 */
public class TestMathQuestionService {

    // Delta constant for floating point comparisons (1 + 1 could be 2.000000000000004)
    private static final double DELTA = 0.001;

    // ---------------------------------------------------------
    // Q1: Addition Tests
    // ---------------------------------------------------------

    @Test
    public void q1Addition_ValidNumbers_ReturnsCorrectSum() {
        Assert.assertEquals(15.0, MathQuestionService.q1Addition("10", "5"), DELTA);
        Assert.assertEquals(0.0, MathQuestionService.q1Addition("-5", "5"), DELTA);
    }

    @Test
    public void q1Addition_WrongAnswer_ShouldNotMatch() {
        double result = MathQuestionService.q1Addition("1", "1");
        // Verify 1+1 is NOT 3
        Assert.assertNotEquals(3.0, result, DELTA);
    }

    @Test
    public void q1Addition_InvalidInput_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition("abc", "5")));
        Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition(null, "5")));
        Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition("", "")));
    }

    // ---------------------------------------------------------
    // Q2: Subtraction Tests
    // ---------------------------------------------------------

    @Test
    public void q2Subtraction_ValidNumbers_ReturnsCorrectDifference() {
        Assert.assertEquals(5.0, MathQuestionService.q2Subtraction("10", "5"), DELTA);
        Assert.assertEquals(-15.0, MathQuestionService.q2Subtraction("-10", "5"), DELTA);
    }

    @Test
    public void q2Subtraction_WrongAnswer_ShouldNotMatch() {
        double result = MathQuestionService.q2Subtraction("10", "5");
        // Verify 10-5 is NOT 4
        Assert.assertNotEquals(4.0, result, DELTA);
    }

    @Test
    public void q2Subtraction_InvalidInput_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q2Subtraction("10.5x", "5")));
        Assert.assertTrue(Double.isNaN(MathQuestionService.q2Subtraction("10", null)));
    }

    // ---------------------------------------------------------
    // Q3: Multiplication Tests
    // ---------------------------------------------------------

    @Test
    public void q3Multiplication_ValidNumbers_ReturnsCorrectProduct() {
        Assert.assertEquals(50.0, MathQuestionService.q3Multiplication("10", "5"), DELTA);
        Assert.assertEquals(1.5, MathQuestionService.q3Multiplication("0.5", "3"), DELTA);
    }

    @Test
    public void q3Multiplication_WrongAnswer_ShouldNotMatch() {
        double result = MathQuestionService.q3Multiplication("5", "5");
        // Verify 5*5 is NOT 20
        Assert.assertNotEquals(20.0, result, DELTA);
    }

    @Test
    public void q3Multiplication_InvalidInput_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q3Multiplication(" ", "5")));
        Assert.assertTrue(Double.isNaN(MathQuestionService.q3Multiplication("five", "5")));
    }
}