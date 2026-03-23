package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * Comprehensive test suite for DateUtil transitions.
 * Includes every Month-End Increment, Month-Start Decrement, and Nominal cases.
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
    public void test00_StudentIdentity() {
        System.out.println("Student ID: 223983938");
        Assert.assertNotNull("223983938");
    }

    // --- JANUARY / FEBRUARY ---
    @Test
    public void test01_Jan31ToFeb1_2024() {
        DateUtil date = new DateUtil(31, 1, 2024);
        DateUtil initial = new DateUtil(31, 1, 2024);
        date.increment();
        logTest("January End", initial, "increment()", date);
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test02_Feb1ToJan31_2024() {
        DateUtil date = new DateUtil(1, 2, 2024);
        DateUtil initial = new DateUtil(1, 2, 2024);
        date.decrement();
        logTest("February Start", initial, "decrement()", date);
        Assert.assertEquals(31, date.getDay());
    }

    // --- FEBRUARY / MARCH (LEAP VS NON-LEAP) ---
    @Test
    public void test03_Feb29ToMar1_2024_Leap() {
        DateUtil date = new DateUtil(29, 2, 2024);
        DateUtil initial = new DateUtil(29, 2, 2024);
        date.increment();
        logTest("Leap Year Feb End (2024)", initial, "increment()", date);
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test04_Mar1ToFeb29_2024_Leap() {
        DateUtil date = new DateUtil(1, 3, 2024);
        DateUtil initial = new DateUtil(1, 3, 2024);
        date.decrement();
        logTest("March Start (Leap Year)", initial, "decrement()", date);
        Assert.assertEquals(29, date.getDay());
    }

    @Test
    public void test05_Feb28ToMar1_2023_NonLeap() {
        DateUtil date = new DateUtil(28, 2, 2023);
        DateUtil initial = new DateUtil(28, 2, 2023);
        date.increment();
        logTest("Non-Leap Feb End (2023)", initial, "increment()", date);
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test06_Mar1ToFeb28_2023_NonLeap() {
        DateUtil date = new DateUtil(1, 3, 2023);
        DateUtil initial = new DateUtil(1, 3, 2023);
        date.decrement();
        logTest("March Start (Non-Leap)", initial, "decrement()", date);
        Assert.assertEquals(28, date.getDay());
    }

    // --- MARCH / APRIL ---
    @Test
    public void test07_Mar31ToApr1_2024() {
        DateUtil date = new DateUtil(31, 3, 2024);
        DateUtil initial = new DateUtil(31, 3, 2024);
        date.increment();
        logTest("March End", initial, "increment()", date);
        Assert.assertEquals(4, date.getMonth());
    }

    @Test
    public void test08_Apr1ToMar31_2024() {
        DateUtil date = new DateUtil(1, 4, 2024);
        DateUtil initial = new DateUtil(1, 4, 2024);
        date.decrement();
        logTest("April Start", initial, "decrement()", date);
        Assert.assertEquals(31, date.getDay());
    }

    // --- APRIL / MAY ---
    @Test
    public void test09_Apr30ToMay1_2024() {
        DateUtil date = new DateUtil(30, 4, 2024);
        DateUtil initial = new DateUtil(30, 4, 2024);
        date.increment();
        logTest("April End (30 Days)", initial, "increment()", date);
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test10_May1ToApr30_2024() {
        DateUtil date = new DateUtil(1, 5, 2024);
        DateUtil initial = new DateUtil(1, 5, 2024);
        date.decrement();
        logTest("May Start", initial, "decrement()", date);
        Assert.assertEquals(30, date.getDay());
    }

    // --- MAY / JUNE ---
    @Test
    public void test11_May31ToJun1_2024() {
        DateUtil date = new DateUtil(31, 5, 2024);
        DateUtil initial = new DateUtil(31, 5, 2024);
        date.increment();
        logTest("May End", initial, "increment()", date);
        Assert.assertEquals(6, date.getMonth());
    }

    @Test
    public void test12_Jun1ToMay31_2024() {
        DateUtil date = new DateUtil(1, 6, 2024);
        DateUtil initial = new DateUtil(1, 6, 2024);
        date.decrement();
        logTest("June Start", initial, "decrement()", date);
        Assert.assertEquals(31, date.getDay());
    }

    // --- JUNE / JULY ---
    @Test
    public void test13_Jun30ToJul1_2024() {
        DateUtil date = new DateUtil(30, 6, 2024);
        DateUtil initial = new DateUtil(30, 6, 2024);
        date.increment();
        logTest("June End (30 Days)", initial, "increment()", date);
        Assert.assertEquals(7, date.getMonth());
    }

    @Test
    public void test14_Jul1ToJun30_2024() {
        DateUtil date = new DateUtil(1, 7, 2024);
        DateUtil initial = new DateUtil(1, 7, 2024);
        date.decrement();
        logTest("July Start", initial, "decrement()", date);
        Assert.assertEquals(30, date.getDay());
    }

    // --- JULY / AUGUST ---
    @Test
    public void test15_Jul31ToAug1_2024() {
        DateUtil date = new DateUtil(31, 7, 2024);
        DateUtil initial = new DateUtil(31, 7, 2024);
        date.increment();
        logTest("July End", initial, "increment()", date);
        Assert.assertEquals(8, date.getMonth());
    }

    @Test
    public void test16_Aug1ToJul31_2024() {
        DateUtil date = new DateUtil(1, 8, 2024);
        DateUtil initial = new DateUtil(1, 8, 2024);
        date.decrement();
        logTest("August Start", initial, "decrement()", date);
        Assert.assertEquals(31, date.getDay());
    }

    // --- AUGUST / SEPTEMBER ---
    @Test
    public void test17_Aug31ToSep1_2024() {
        DateUtil date = new DateUtil(31, 8, 2024);
        DateUtil initial = new DateUtil(31, 8, 2024);
        date.increment();
        logTest("August End", initial, "increment()", date);
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test18_Sep1ToAug31_2024() {
        DateUtil date = new DateUtil(1, 9, 2024);
        DateUtil initial = new DateUtil(1, 9, 2024);
        date.decrement();
        logTest("September Start", initial, "decrement()", date);
        Assert.assertEquals(31, date.getDay());
    }

    // --- SEPTEMBER / OCTOBER ---
    @Test
    public void test19_Sep30ToOct1_2024() {
        DateUtil date = new DateUtil(30, 9, 2024);
        DateUtil initial = new DateUtil(30, 9, 2024);
        date.increment();
        logTest("September End (30 Days)", initial, "increment()", date);
        Assert.assertEquals(10, date.getMonth());
    }

    @Test
    public void test20_Oct1ToSep30_2024() {
        DateUtil date = new DateUtil(1, 10, 2024);
        DateUtil initial = new DateUtil(1, 10, 2024);
        date.decrement();
        logTest("October Start", initial, "decrement()", date);
        Assert.assertEquals(30, date.getDay());
    }

    // --- OCTOBER / NOVEMBER ---
    @Test
    public void test21_Oct31ToNov1_2024() {
        DateUtil date = new DateUtil(31, 10, 2024);
        DateUtil initial = new DateUtil(31, 10, 2024);
        date.increment();
        logTest("October End", initial, "increment()", date);
        Assert.assertEquals(11, date.getMonth());
    }

    @Test
    public void test22_Nov1ToOct31_2024() {
        DateUtil date = new DateUtil(1, 11, 2024);
        DateUtil initial = new DateUtil(1, 11, 2024);
        date.decrement();
        logTest("November Start", initial, "decrement()", date);
        Assert.assertEquals(31, date.getDay());
    }

    // --- NOVEMBER / DECEMBER ---
    @Test
    public void test23_Nov30ToDec1_2024() {
        DateUtil date = new DateUtil(30, 11, 2024);
        DateUtil initial = new DateUtil(30, 11, 2024);
        date.increment();
        logTest("November End (30 Days)", initial, "increment()", date);
        Assert.assertEquals(12, date.getMonth());
    }

    @Test
    public void test24_Dec1ToNov30_2024() {
        DateUtil date = new DateUtil(1, 12, 2024);
        DateUtil initial = new DateUtil(1, 12, 2024);
        date.decrement();
        logTest("December Start", initial, "decrement()", date);
        Assert.assertEquals(30, date.getDay());
    }

    // --- YEAR TRANSITIONS (Allowed range 1700-2024) ---
    @Test
    public void test25_Dec31ToJan1_YearTransition() {
        DateUtil date = new DateUtil(31, 12, 2023);
        DateUtil initial = new DateUtil(31, 12, 2023);
        date.increment();
        logTest("Year End Transition", initial, "increment()", date);
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void test26_Jan1ToDec31_YearTransitionBackwards() {
        DateUtil date = new DateUtil(1, 1, 2024);
        DateUtil initial = new DateUtil(1, 1, 2024);
        date.decrement();
        logTest("Year Start Transition (Backwards)", initial, "decrement()", date);
        Assert.assertEquals(2023, date.getYear());
    }

    // --- NOMINAL CASES (Mid-Month) ---
    @Test
    public void test27_NominalIncrement() {
        DateUtil date = new DateUtil(15, 6, 2024);
        DateUtil initial = new DateUtil(15, 6, 2024);
        date.increment();
        logTest("Nominal Increment", initial, "increment()", date);
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test28_NominalDecrement() {
        DateUtil date = new DateUtil(15, 6, 2024);
        DateUtil initial = new DateUtil(15, 6, 2024);
        date.decrement();
        logTest("Nominal Decrement", initial, "decrement()", date);
        Assert.assertEquals(14, date.getDay());
    }
}