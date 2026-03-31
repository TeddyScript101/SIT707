package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;


public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
        String studentName = "Teddy Yee";
        Assert.assertNotNull(studentName);
        Assert.assertFalse(studentName.isEmpty());
    }

    @Test
    public void testStudentId() {
        String studentId = "s223983938";
        Assert.assertNotNull(studentId);
        Assert.assertFalse(studentId.isEmpty());
    }

    // -----------------------------------------------------------------------
    // D1 x M1 x Y2  — day 1-28, 31-day month, non-leap year
    // Expected: increment moves normally within month
    // -----------------------------------------------------------------------

    @Test
    public void testD1_M1_Y2_increment() {
        // day=15 (D1), month=3 March (M1), year=2023 (Y2)
        DateUtil date = new DateUtil(15, 3, 2023);
        System.out.println("Before: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testD1_M1_Y2_decrement() {
        // day=15 (D1), month=3 March (M1), year=2023 (Y2)
        DateUtil date = new DateUtil(15, 3, 2023);
        System.out.println("Before: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    // -----------------------------------------------------------------------
    // D1 x M2 x Y2  — day 1-28, 30-day month, non-leap year
    // -----------------------------------------------------------------------

    @Test
    public void testD1_M2_Y2_increment() {
        // day=10 (D1), month=4 April (M2), year=2023 (Y2)
        DateUtil date = new DateUtil(10, 4, 2023);
        System.out.println("Before: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(11, date.getDay());
        Assert.assertEquals(4, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    // -----------------------------------------------------------------------
    // D1 x M3 x Y1  — day 1-28, February, leap year
    // -----------------------------------------------------------------------

    @Test
    public void testD1_M3_Y1_increment() {
        // day=14 (D1), month=2 February (M3), year=2000 (Y1 leap)
        DateUtil date = new DateUtil(14, 2, 2000);
        System.out.println("Before: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(15, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2000, date.getYear());
    }

    @Test
    public void testD1_M3_Y2_increment() {
        // day=14 (D1), month=2 February (M3), year=2023 (Y2 non-leap)
        DateUtil date = new DateUtil(14, 2, 2023);
        System.out.println("Before: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(15, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    // -----------------------------------------------------------------------
    // D2 x M3 x Y1  — day=29, February, leap year → last valid day in Feb
    // -----------------------------------------------------------------------

    @Test
    public void testD2_M3_Y1_increment() {
        // day=29 (D2), month=2 February (M3), year=2000 (Y1 leap)
        // Incrementing day 29 of Feb in a leap year should roll to March 1
        DateUtil date = new DateUtil(29, 2, 2000);
        System.out.println("Before: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2000, date.getYear());
    }

    @Test
    public void testD2_M3_Y1_decrement() {
        // day=29 (D2), month=2 February (M3), year=2000 (Y1 leap)
        // Decrementing day 29 Feb leap year → day 28
        DateUtil date = new DateUtil(29, 2, 2000);
        System.out.println("Before: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);
        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2000, date.getYear());
    }

    // -----------------------------------------------------------------------
    // D2 x M1 x Y2  — day=29, 31-day month, non-leap year
    // -----------------------------------------------------------------------

    @Test
    public void testD2_M1_Y2_increment() {
        // day=29 (D2), month=1 January (M1), year=2023 (Y2)
        DateUtil date = new DateUtil(29, 1, 2023);
        System.out.println("Before: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    // -----------------------------------------------------------------------
    // D3 x M1 x Y2  — day=30, 31-day month, non-leap year
    // -----------------------------------------------------------------------

    @Test
    public void testD3_M1_Y2_increment() {
        // day=30 (D3), month=1 January (M1), year=2023 (Y2)
        DateUtil date = new DateUtil(30, 1, 2023);
        System.out.println("Before: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testD3_M2_Y2_increment() {
        // day=30 (D3), month=4 April (M2), year=2023 (Y2)
        // Incrementing last valid day of 30-day month → roll to May 1
        DateUtil date = new DateUtil(30, 4, 2023);
        System.out.println("Before: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testD3_M2_Y2_decrement() {
        // day=30 (D3), month=4 April (M2), year=2023 (Y2)
        DateUtil date = new DateUtil(30, 4, 2023);
        System.out.println("Before: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(4, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    // -----------------------------------------------------------------------
    // D4 x M1 x Y2  — day=31, 31-day month, non-leap year
    // -----------------------------------------------------------------------

    @Test
    public void testD4_M1_Y2_increment() {
        // day=31 (D4), month=1 January (M1), year=2023 (Y2)
        // Incrementing last day of January → February 1
        DateUtil date = new DateUtil(31, 1, 2023);
        System.out.println("Before: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testD4_M1_Y2_decrement() {
        // day=31 (D4), month=1 January (M1), year=2023 (Y2)
        DateUtil date = new DateUtil(31, 1, 2023);
        System.out.println("Before: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testD4_M1_December_Y2_increment() {
        // day=31 (D4), month=12 December (M1), year=2023 (Y2)
        // Incrementing last day of December → January 1 next year
        DateUtil date = new DateUtil(31, 12, 2023);
        System.out.println("Before: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // -----------------------------------------------------------------------
    // Day 1 roll-back across months — boundary decrement
    // -----------------------------------------------------------------------

    @Test
    public void testD1_day1_M1_Y2_decrement() {
        // day=1 (D1 boundary), month=3 March (M1), year=2023 (Y2)
        // Decrementing day 1 of March → Feb 28 in non-leap year
        DateUtil date = new DateUtil(1, 3, 2023);
        System.out.println("Before: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);
        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testD1_day1_M1_Y1_decrement() {
        // day=1 (D1 boundary), month=3 March (M1), year=2000 (Y1 leap)
        // Decrementing day 1 of March → Feb 29 in leap year
        DateUtil date = new DateUtil(1, 3, 2000);
        System.out.println("Before: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2000, date.getYear());
    }

    @Test
    public void testD1_day1_January_Y2_decrement() {
        // day=1 (D1 boundary), month=1 January (M1), year=2023 (Y2)
        // Decrementing day 1 of January → December 31 previous year
        DateUtil date = new DateUtil(1, 1, 2023);
        System.out.println("Before: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2022, date.getYear());
    }
}