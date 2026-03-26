package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * Test suite for DateUtil based on boundary value analysis test cases.
 * A-series = decrement() tests (Expected Previous)
 * B-series = increment() tests (Expected Next)
 * @author Teddy Yee
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DateUtilTest {

    private void logTest(String description, DateUtil before, String action, DateUtil after) {
        System.out.println(String.format("[%s]", description.toUpperCase()));
        System.out.println("  Input:  " + before);
        System.out.println("  Action: " + action);
        System.out.println("  Result: " + after);
        System.out.println("------------------------------------------");
    }

    @Test
    public void test00_testStudentIdentity() {
    	String studentId = "223983938";
		Assert.assertNotNull("Student ID is ", studentId);
    }
    
    
    @Test
    public void test00a_testStudentNamm() {
    	 String studentName = "Tsz Hin Yee";
    	 Assert.assertNotNull("Student name is ", studentName);
    }

    // --- Day boundary tests (Month=6, Year=1994) ---

    /** 01A: Day=1, Month=6, Year=1994 → Previous = 31-5-1994 */
    @Test
    public void test01A_Day1_Month6_Year1994_Decrement() {
        DateUtil initial = new DateUtil(1, 6, 1994);
        DateUtil date = new DateUtil(1, 6, 1994);
        date.decrement();
        logTest("01A Day=1 Month=6 Year=1994 Decrement", initial, "decrement()", date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    /** 02A: Day=2, Month=6, Year=1994 → Previous = 1-6-1994 */
    @Test
    public void test02A_Day2_Month6_Year1994_Decrement() {
        DateUtil initial = new DateUtil(2, 6, 1994);
        DateUtil date = new DateUtil(2, 6, 1994);
        date.decrement();
        logTest("02A Day=2 Month=6 Year=1994 Decrement", initial, "decrement()", date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    /** 03A: Day=15, Month=6, Year=1994 → Previous = 14-6-1994 */
    @Test
    public void test03A_Day15_Month6_Year1994_Decrement() {
        DateUtil initial = new DateUtil(15, 6, 1994);
        DateUtil date = new DateUtil(15, 6, 1994);
        date.decrement();
        logTest("03A Day=15 Month=6 Year=1994 Decrement", initial, "decrement()", date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    /** 04A: Day=30, Month=6, Year=1994 → Previous = 29-6-1994 */
    @Test
    public void test04A_Day30_Month6_Year1994_Decrement() {
        DateUtil initial = new DateUtil(30, 6, 1994);
        DateUtil date = new DateUtil(30, 6, 1994);
        date.decrement();
        logTest("04A Day=30 Month=6 Year=1994 Decrement", initial, "decrement()", date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    /** 05A: Day=31, Month=6, Year=1994 → Invalid Date (June has only 30 days) */
    @Test
    public void test05A_Day31_Month6_Year1994_InvalidDate() {
        String desc = "05A Day=31 Month=6 Year=1994 Invalid Date";
        try {
            new DateUtil(31, 6, 1994);
            Assert.fail("Expected RuntimeException for Day 31 in June");
        } catch (RuntimeException e) {
            System.out.println(String.format("[%s]", desc.toUpperCase()));
            System.out.println("  Input:  31 June 1994");
            System.out.println("  Action: new DateUtil()");
            System.out.println("  Status: Caught expected exception: " + e.getMessage());
            System.out.println("------------------------------------------");
        }
    }

    // --- Month boundary tests (Day=15, Year=1994) ---

    /** 06A: Day=15, Month=1, Year=1994 → Previous = 14-1-1994 */
    @Test
    public void test06A_Day15_Month1_Year1994_Decrement() {
        DateUtil initial = new DateUtil(15, 1, 1994);
        DateUtil date = new DateUtil(15, 1, 1994);
        date.decrement();
        logTest("06A Day=15 Month=1 Year=1994 Decrement", initial, "decrement()", date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    /** 07A: Day=15, Month=2, Year=1994 → Previous = 14-2-1994 */
    @Test
    public void test07A_Day15_Month2_Year1994_Decrement() {
        DateUtil initial = new DateUtil(15, 2, 1994);
        DateUtil date = new DateUtil(15, 2, 1994);
        date.decrement();
        logTest("07A Day=15 Month=2 Year=1994 Decrement", initial, "decrement()", date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    /** 08A: Day=15, Month=11, Year=1994 → Previous = 14-11-1994 */
    @Test
    public void test08A_Day15_Month11_Year1994_Decrement() {
        DateUtil initial = new DateUtil(15, 11, 1994);
        DateUtil date = new DateUtil(15, 11, 1994);
        date.decrement();
        logTest("08A Day=15 Month=11 Year=1994 Decrement", initial, "decrement()", date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    /** 09A: Day=15, Month=12, Year=1994 → Previous = 14-12-1994 */
    @Test
    public void test09A_Day15_Month12_Year1994_Decrement() {
        DateUtil initial = new DateUtil(15, 12, 1994);
        DateUtil date = new DateUtil(15, 12, 1994);
        date.decrement();
        logTest("09A Day=15 Month=12 Year=1994 Decrement", initial, "decrement()", date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    // --- Year boundary tests (Day=15, Month=6) ---

    /** 10A: Day=15, Month=6, Year=1700 → Previous = 14-6-1700 */
    @Test
    public void test10A_Day15_Month6_Year1700_Decrement() {
        DateUtil initial = new DateUtil(15, 6, 1700);
        DateUtil date = new DateUtil(15, 6, 1700);
        date.decrement();
        logTest("10A Day=15 Month=6 Year=1700 Decrement", initial, "decrement()", date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1700, date.getYear());
    }

    /** 11A: Day=15, Month=6, Year=1701 → Previous = 14-6-1701 */
    @Test
    public void test11A_Day15_Month6_Year1701_Decrement() {
        DateUtil initial = new DateUtil(15, 6, 1701);
        DateUtil date = new DateUtil(15, 6, 1701);
        date.decrement();
        logTest("11A Day=15 Month=6 Year=1701 Decrement", initial, "decrement()", date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1701, date.getYear());
    }

    /** 12A: Day=15, Month=6, Year=2023 → Previous = 14-6-2023 */
    @Test
    public void test12A_Day15_Month6_Year2023_Decrement() {
        DateUtil initial = new DateUtil(15, 6, 2023);
        DateUtil date = new DateUtil(15, 6, 2023);
        date.decrement();
        logTest("12A Day=15 Month=6 Year=2023 Decrement", initial, "decrement()", date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    /** 13A: Day=15, Month=6, Year=2024 → Previous = 14-6-2024 */
    @Test
    public void test13A_Day15_Month6_Year2024_Decrement() {
        DateUtil initial = new DateUtil(15, 6, 2024);
        DateUtil date = new DateUtil(15, 6, 2024);
        date.decrement();
        logTest("13A Day=15 Month=6 Year=2024 Decrement", initial, "decrement()", date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // --- Leap year decrement cases ---

    /** 14A: Day=28, Month=2, Year=2024 → Previous = 27-2-2024 */
    @Test
    public void test14A_Day28_Month2_Year2024_Decrement() {
        DateUtil initial = new DateUtil(28, 2, 2024);
        DateUtil date = new DateUtil(28, 2, 2024);
        date.decrement();
        logTest("14A Day=28 Month=2 Year=2024 Decrement", initial, "decrement()", date);
        Assert.assertEquals(27, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    /** 15A: Day=29, Month=2, Year=2024 → Previous = 28-2-2024 */
    @Test
    public void test15A_Day29_Month2_Year2024_Decrement() {
        DateUtil initial = new DateUtil(29, 2, 2024);
        DateUtil date = new DateUtil(29, 2, 2024);
        date.decrement();
        logTest("15A Day=29 Month=2 Year=2024 Decrement", initial, "decrement()", date);
        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    /** 16A: Day=1, Month=3, Year=2024 → Previous = 29-2-2024 (leap year) */
    @Test
    public void test16A_Day1_Month3_Year2024_Decrement() {
        DateUtil initial = new DateUtil(1, 3, 2024);
        DateUtil date = new DateUtil(1, 3, 2024);
        date.decrement();
        logTest("16A Day=1 Month=3 Year=2024 Decrement", initial, "decrement()", date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // =========================================================
    // B-SERIES: increment() — Expected Next Date
    // Day varies (01B–05B), Month varies (06B–09B), Year varies (10B–13B)
    // Plus leap year cases (14B–17B)
    // =========================================================

    // --- Day boundary tests (Month=6, Year=1994) ---

    /** 01B: Day=1, Month=6, Year=1994 → Next = 2-6-1994 */
    @Test
    public void test01B_Day1_Month6_Year1994_Increment() {
        DateUtil initial = new DateUtil(1, 6, 1994);
        DateUtil date = new DateUtil(1, 6, 1994);
        date.increment();
        logTest("01B Day=1 Month=6 Year=1994 Increment", initial, "increment()", date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    /** 02B: Day=2, Month=6, Year=1994 → Next = 3-6-1994 */
    @Test
    public void test02B_Day2_Month6_Year1994_Increment() {
        DateUtil initial = new DateUtil(2, 6, 1994);
        DateUtil date = new DateUtil(2, 6, 1994);
        date.increment();
        logTest("02B Day=2 Month=6 Year=1994 Increment", initial, "increment()", date);
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    /** 03B: Day=15, Month=6, Year=1994 → Next = 16-6-1994 */
    @Test
    public void test03B_Day15_Month6_Year1994_Increment() {
        DateUtil initial = new DateUtil(15, 6, 1994);
        DateUtil date = new DateUtil(15, 6, 1994);
        date.increment();
        logTest("03B Day=15 Month=6 Year=1994 Increment", initial, "increment()", date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    /** 04B: Day=30, Month=6, Year=1994 → Next = 1-7-1994 */
    @Test
    public void test04B_Day30_Month6_Year1994_Increment() {
        DateUtil initial = new DateUtil(30, 6, 1994);
        DateUtil date = new DateUtil(30, 6, 1994);
        date.increment();
        logTest("04B Day=30 Month=6 Year=1994 Increment", initial, "increment()", date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    /** 05B: Day=31, Month=6, Year=1994 → Invalid Date (June has only 30 days) */
    @Test
    public void test05B_Day31_Month6_Year1994_InvalidDate() {
        String desc = "05B Day=31 Month=6 Year=1994 Invalid Date";
        try {
            new DateUtil(31, 6, 1994);
            Assert.fail("Expected RuntimeException for Day 31 in June");
        } catch (RuntimeException e) {
            System.out.println(String.format("[%s]", desc.toUpperCase()));
            System.out.println("  Input:  31 June 1994");
            System.out.println("  Action: new DateUtil()");
            System.out.println("  Status: Caught expected exception: " + e.getMessage());
            System.out.println("------------------------------------------");
        }
    }

    // --- Month boundary tests (Day=15, Year=1994) ---

    /** 06B: Day=15, Month=1, Year=1994 → Next = 16-1-1994 */
    @Test
    public void test06B_Day15_Month1_Year1994_Increment() {
        DateUtil initial = new DateUtil(15, 1, 1994);
        DateUtil date = new DateUtil(15, 1, 1994);
        date.increment();
        logTest("06B Day=15 Month=1 Year=1994 Increment", initial, "increment()", date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    /** 07B: Day=15, Month=2, Year=1994 → Next = 16-2-1994 */
    @Test
    public void test07B_Day15_Month2_Year1994_Increment() {
        DateUtil initial = new DateUtil(15, 2, 1994);
        DateUtil date = new DateUtil(15, 2, 1994);
        date.increment();
        logTest("07B Day=15 Month=2 Year=1994 Increment", initial, "increment()", date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    /** 08B: Day=15, Month=11, Year=1994 → Next = 16-11-1994 */
    @Test
    public void test08B_Day15_Month11_Year1994_Increment() {
        DateUtil initial = new DateUtil(15, 11, 1994);
        DateUtil date = new DateUtil(15, 11, 1994);
        date.increment();
        logTest("08B Day=15 Month=11 Year=1994 Increment", initial, "increment()", date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    /** 09B: Day=15, Month=12, Year=1994 → Next = 16-12-1994 */
    @Test
    public void test09B_Day15_Month12_Year1994_Increment() {
        DateUtil initial = new DateUtil(15, 12, 1994);
        DateUtil date = new DateUtil(15, 12, 1994);
        date.increment();
        logTest("09B Day=15 Month=12 Year=1994 Increment", initial, "increment()", date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    // --- Year boundary tests (Day=15, Month=6) ---

    /** 10B: Day=15, Month=6, Year=1700 → Next = 16-6-1700 */
    @Test
    public void test10B_Day15_Month6_Year1700_Increment() {
        DateUtil initial = new DateUtil(15, 6, 1700);
        DateUtil date = new DateUtil(15, 6, 1700);
        date.increment();
        logTest("10B Day=15 Month=6 Year=1700 Increment", initial, "increment()", date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1700, date.getYear());
    }

    /** 11B: Day=15, Month=6, Year=1701 → Next = 16-6-1701 */
    @Test
    public void test11B_Day15_Month6_Year1701_Increment() {
        DateUtil initial = new DateUtil(15, 6, 1701);
        DateUtil date = new DateUtil(15, 6, 1701);
        date.increment();
        logTest("11B Day=15 Month=6 Year=1701 Increment", initial, "increment()", date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1701, date.getYear());
    }

    /** 12B: Day=15, Month=6, Year=2023 → Next = 16-6-2023 */
    @Test
    public void test12B_Day15_Month6_Year2023_Increment() {
        DateUtil initial = new DateUtil(15, 6, 2023);
        DateUtil date = new DateUtil(15, 6, 2023);
        date.increment();
        logTest("12B Day=15 Month=6 Year=2023 Increment", initial, "increment()", date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    /** 13B: Day=15, Month=6, Year=2024 → Next = 16-6-2024 */
    @Test
    public void test13B_Day15_Month6_Year2024_Increment() {
        DateUtil initial = new DateUtil(15, 6, 2024);
        DateUtil date = new DateUtil(15, 6, 2024);
        date.increment();
        logTest("13B Day=15 Month=6 Year=2024 Increment", initial, "increment()", date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // --- Leap year increment cases ---

    /** 14B: Day=28, Month=2, Year=2024 → Next = 29-2-2024 (leap year) */
    @Test
    public void test14B_Day28_Month2_Year2024_Increment() {
        DateUtil initial = new DateUtil(28, 2, 2024);
        DateUtil date = new DateUtil(28, 2, 2024);
        date.increment();
        logTest("14B Day=28 Month=2 Year=2024 Increment", initial, "increment()", date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    /** 15B: Day=29, Month=2, Year=2024 → Next = 1-3-2024 (leap year end) */
    @Test
    public void test15B_Day29_Month2_Year2024_Increment() {
        DateUtil initial = new DateUtil(29, 2, 2024);
        DateUtil date = new DateUtil(29, 2, 2024);
        date.increment();
        logTest("15B Day=29 Month=2 Year=2024 Increment", initial, "increment()", date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    /** 17B: Day=30, Month=2, Year=2024 → Invalid date (February never has 30 days) */
    @Test
    public void test17B_Day30_Month2_Year2024_InvalidDate() {
        String desc = "17B Day=30 Month=2 Year=2024 Invalid Date";
        try {
            new DateUtil(30, 2, 2024);
            Assert.fail("Expected RuntimeException for Day 30 in February");
        } catch (RuntimeException e) {
            System.out.println(String.format("[%s]", desc.toUpperCase()));
            System.out.println("  Input:  30 February 2024");
            System.out.println("  Action: new DateUtil()");
            System.out.println("  Status: Caught expected exception: " + e.getMessage());
            System.out.println("------------------------------------------");
        }
    }
}