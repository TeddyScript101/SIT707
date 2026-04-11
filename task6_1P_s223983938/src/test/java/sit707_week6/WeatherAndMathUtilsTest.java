package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "223983938"; 
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Teddy Yee"; 
        Assert.assertNotNull("Student name is null", studentName);
    }

    // --- Weather Advice: Exception Branches ---

    @Test(expected = IllegalArgumentException.class)
    public void testWeatherAdviceNegativeWind() {
        WeatherAndMathUtils.weatherAdvice(-1.0, 5.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWeatherAdviceNegativeRain() {
        WeatherAndMathUtils.weatherAdvice(10.0, -1.0);
    }
    
    @Test
    public void testWeatherAdviceCancelJustDangerousWind() {
        // Covers the first part of the OR: wind > 70
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(71.0, 1.0));
    }

    @Test
    public void testWeatherAdviceCancelJustDangerousRain() {
        // Covers the second part: rain > 6
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(10.0, 6.1));
    }

    @Test
    public void testWeatherAdviceWarnWindBoundary() {
        // Specifically checks the 'else if' for windSpeed > 45
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(46.0, 2.0));
    }

    @Test
    public void testWeatherAdviceWarnRainBoundary() {
        // Specifically checks the 'else if' for precipitation > 4
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(10.0, 4.1));
    }

  
    // --- Weather Advice: Decision Logic Branches ---

    @Test
    public void testWeatherAdviceAllClear() {
        // Both values below concerning thresholds
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(30.0, 2.0));
    }

    @Test
    public void testWeatherAdviceCancelDangerousWind() {
        // Triggers (windSpeed > DANGEROUS_WINDSPEED)
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }

    @Test
    public void testWeatherAdviceCancelDangerousRain() {
        // Triggers (precipitation > DANGEROUS_RAINFALL)
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 6.1));
    }

    @Test
    public void testWeatherAdviceCancelBothConcerning() {
        // Triggers (windSpeed > CONCERNING_WINDSPEED && precipitation > CONCERNING_RAINFALL)
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(46.0, 4.1));
    }

    @Test
    public void testWeatherAdviceWarnWindOnly() {
        // Triggers the else-if: (windSpeed > CONCERNING_WINDSPEED)
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(46.0, 2.0));
    }

    @Test
    public void testWeatherAdviceWarnRainOnly() {
        // Triggers the else-if: (precipitation > CONCERNING_RAINFALL)
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(20.0, 4.1));
    }

    // --- Math Utils: isEven ---

    @Test
    public void testIsEvenTrue() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(2));
        Assert.assertTrue(WeatherAndMathUtils.isEven(0));
    }

    @Test
    public void testIsEvenFalse() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(3));
    }

    // --- Math Utils: isPrime ---

    @Test
    public void testIsPrimeLessOrEqualOne() {
        // Triggers if (n <= 1)
        Assert.assertFalse(WeatherAndMathUtils.isPrime(1));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(0));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(-5));
    }

    @Test
    public void testIsPrimeTwo() {
        // Loop (i=2; i < 2) does not execute, returns true
        Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
    }

    @Test
    public void testIsPrimeTrueOdd() {
        // Loop executes, never hits (n % i == 0), returns true
        Assert.assertTrue(WeatherAndMathUtils.isPrime(7));
    }

    @Test
    public void testIsPrimeFalseComposite() {
        // Loop executes and hits (n % i == 0) for i=2
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
    }

    @Test
    public void testIsPrimeFalseCompositeOdd() {
        // Loop executes and hits (n % i == 0) for i=3
        Assert.assertFalse(WeatherAndMathUtils.isPrime(9));
    }

    @Test
    public void testConstructor() {
        // Covers the implicit/default constructor of the utility class
        new WeatherAndMathUtils();
    }
}