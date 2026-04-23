package web.service;

public class MathQuestionService {

    public static double q1Addition(String number1, String number2) {
        try {
            return Double.parseDouble(number1) + Double.parseDouble(number2);
        } catch (NumberFormatException | NullPointerException e) {
            return Double.NaN;
        }
    }

    public static double q2Subtraction(String number1, String number2) {
        try {
            return Double.parseDouble(number1) - Double.parseDouble(number2);
        } catch (NumberFormatException | NullPointerException e) {
            return Double.NaN;
        }
    }

    public static double q3Multiplication(String n1, String n2) {
        try {
            return Double.parseDouble(n1) * Double.parseDouble(n2);
        } catch (NumberFormatException | NullPointerException e) {
            return Double.NaN;
        }
    }
}