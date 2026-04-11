package sit707_week6;

import java.util.logging.Logger;

public class PartBUtils {
    private static final Logger LOGGER = Logger.getLogger(PartBUtils.class.getName());

    /**
     * (a) A conditional loop with simple instructions.
     * Logic: Calculates the sum of all integers from 1 up to 'n'.
     */
    public static int simpleLoopSum(int n) {
        LOGGER.info("Starting simpleLoopSum for n = " + n);
        int sum = 0;
     
        for (int i = 1; i <= n; i++) {
            sum += i; 
        }
        return sum;
    }

    /**
     * (b) A conditional loop containing a conditional statement.
     * Logic: Counts how many even numbers exist between 1 and the 'limit'.
     */
    public static int loopWithConditional(int limit) {
        LOGGER.info("Starting loopWithConditional for limit = " + limit);
        int count = 0;
        // Conditional loop
        for (int i = 1; i <= limit; i++) {
            if (i % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}