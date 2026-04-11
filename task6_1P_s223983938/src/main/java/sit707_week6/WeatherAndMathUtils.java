package sit707_week6;

public class WeatherAndMathUtils {
	public static final double DANGEROUS_WINDSPEED = 70.0;
	public static final double DANGEROUS_RAINFALL = 6.0;
	public static final double CONCERNING_WINDSPEED = 45.0;
	public static final double CONCERNING_RAINFALL = 4.0;

	/**
	 * Advises weather alert based on wind-speed and precipitation.
	 * 
	 * 
	 * @param windSpeed
	 * @param precipitation
	 * @return
	 */
	public static String weatherAdvice(double windSpeed, double precipitation) {
		if (windSpeed < 0) {
	        throw new IllegalArgumentException("Wind speed cannot be negative");
	    }
	    if (precipitation < 0) {
	        throw new IllegalArgumentException("Precipitation cannot be negative");
	    }

		String advice = "ALL CLEAR";

		if (windSpeed > DANGEROUS_WINDSPEED || precipitation > DANGEROUS_RAINFALL
				|| (windSpeed > CONCERNING_WINDSPEED && precipitation > CONCERNING_RAINFALL)) {
			advice = "CANCEL";
		} else if (windSpeed > CONCERNING_WINDSPEED || precipitation > CONCERNING_RAINFALL) {
			advice = "WARN";
		}

		return advice;
	}

	/**
	 * Calculates if a number is even.
	 * 
	 * @param a
	 * @return
	 */
	public static boolean isEven(int a) {
		if (a % 2 == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Calculates if a number is prime.
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n) {
	    if (n <= 1) {
	        return false;
	    }
	    
	    // Check for divisors from 2 up to n-1
	    for (int i = 2; i < n; i++) {
	        // If n is divisible by i, it is NOT prime
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    // Number is prime
	    return true;
	}
}
