package sit707_tasks;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Boundary Value Analysis Tests for DateUtil
 *
 * Naming convention:  test_<BVA-ID>_<description>
 *
 * BVA-Y01~06  : Year boundaries          (isValidDate)
 * BVA-M01~06  : Month boundaries         (isValidDate)
 * BVA-D01~06  : Day boundaries, 31-day month – January   (isValidDate)
 * BVA-D07~08  : Day boundaries, 30-day month – April     (isValidDate)
 * BVA-D09~11  : Day boundaries, February leap year       (isValidDate)
 * BVA-D12~13  : Day boundaries, February non-leap year   (isValidDate)
 * BVA-L01~06  : Leap-year boundary years (isLeapYear)
 * BVA-MD01~05 : Month duration boundary  (monthDuration)
 * BVA-DB01~09 : daysBetween boundaries   (daysBetween)
 * BVA-C01~03  : Constructor boundaries   (DateUtil constructor)
 *
 * Total: 48 test cases
 */
public class DateUtilBoundaryTest {

    // =========================================================
    // isValidDate – Year boundaries   [BVA-Y01 ~ BVA-Y06]
    // =========================================================

    @Test
    public void test_BVAY01_Year_JustBeforeMin_1699_Invalid() {
        assertFalse("Year 1699 should be invalid", DateUtil.isValidDate(1, 1, 1699));
    }

    @Test
    public void test_BVAY02_Year_Min_1700_Valid() {
        assertTrue("Year 1700 should be valid", DateUtil.isValidDate(1, 1, 1700));
    }

    @Test
    public void test_BVAY03_Year_MinPlusOne_1701_Valid() {
        assertTrue("Year 1701 should be valid", DateUtil.isValidDate(1, 1, 1701));
    }

    @Test
    public void test_BVAY04_Year_MaxMinusOne_2023_Valid() {
        assertTrue("Year 2023 should be valid", DateUtil.isValidDate(1, 1, 2023));
    }

    @Test
    public void test_BVAY05_Year_Max_2024_Valid() {
        assertTrue("Year 2024 should be valid", DateUtil.isValidDate(1, 1, 2024));
    }

    @Test
    public void test_BVAY06_Year_JustAfterMax_2025_Invalid() {
        assertFalse("Year 2025 should be invalid", DateUtil.isValidDate(1, 1, 2025));
    }

    // =========================================================
    // isValidDate – Month boundaries   [BVA-M01 ~ BVA-M06]
    // =========================================================

    @Test
    public void test_BVAM01_Month_JustBeforeMin_0_Invalid() {
        assertFalse("Month 0 should be invalid", DateUtil.isValidDate(1, 0, 2000));
    }

    @Test
    public void test_BVAM02_Month_Min_1_Valid() {
        assertTrue("Month 1 should be valid", DateUtil.isValidDate(1, 1, 2000));
    }

    @Test
    public void test_BVAM03_Month_MinPlusOne_2_Valid() {
        assertTrue("Month 2 should be valid", DateUtil.isValidDate(1, 2, 2000));
    }

    @Test
    public void test_BVAM04_Month_MaxMinusOne_11_Valid() {
        assertTrue("Month 11 should be valid", DateUtil.isValidDate(1, 11, 2000));
    }

    @Test
    public void test_BVAM05_Month_Max_12_Valid() {
        assertTrue("Month 12 should be valid", DateUtil.isValidDate(1, 12, 2000));
    }

    @Test
    public void test_BVAM06_Month_JustAfterMax_13_Invalid() {
        assertFalse("Month 13 should be invalid", DateUtil.isValidDate(1, 13, 2000));
    }

    // =========================================================
    // isValidDate – Day, 31-day month (January)   [BVA-D01 ~ BVA-D06]
    // =========================================================

    @Test
    public void test_BVAD01_Day_JustBeforeMin_January_0_Invalid() {
        assertFalse("Day 0 in January should be invalid", DateUtil.isValidDate(0, 1, 2000));
    }

    @Test
    public void test_BVAD02_Day_Min_January_1_Valid() {
        assertTrue("Day 1 in January should be valid", DateUtil.isValidDate(1, 1, 2000));
    }

    @Test
    public void test_BVAD03_Day_MinPlusOne_January_2_Valid() {
        assertTrue("Day 2 in January should be valid", DateUtil.isValidDate(2, 1, 2000));
    }

    @Test
    public void test_BVAD04_Day_MaxMinusOne_January_30_Valid() {
        assertTrue("Day 30 in January should be valid", DateUtil.isValidDate(30, 1, 2000));
    }

    @Test
    public void test_BVAD05_Day_Max_January_31_Valid() {
        assertTrue("Day 31 in January should be valid", DateUtil.isValidDate(31, 1, 2000));
    }

    @Test
    public void test_BVAD06_Day_JustAfterMax_January_32_Invalid() {
        assertFalse("Day 32 in January should be invalid", DateUtil.isValidDate(32, 1, 2000));
    }

    // =========================================================
    // isValidDate – Day, 30-day month (April)   [BVA-D07 ~ BVA-D08]
    // =========================================================

    @Test
    public void test_BVAD07_Day_Max_April_30_Valid() {
        assertTrue("Day 30 in April should be valid", DateUtil.isValidDate(30, 4, 2000));
    }

    @Test
    public void test_BVAD08_Day_JustAfterMax_April_31_Invalid() {
        assertFalse("Day 31 in April should be invalid", DateUtil.isValidDate(31, 4, 2000));
    }

    // =========================================================
    // isValidDate – Day, February leap year (2000)   [BVA-D09 ~ BVA-D11]
    // =========================================================

    @Test
    public void test_BVAD09_Day_LeapYear_February_28_Valid() {
        assertTrue("Day 28 in Feb of leap year should be valid", DateUtil.isValidDate(28, 2, 2000));
    }

    @Test
    public void test_BVAD10_Day_LeapYear_February_29_Valid() {
        assertTrue("Day 29 in Feb of leap year (2000) should be valid", DateUtil.isValidDate(29, 2, 2000));
    }

    @Test
    public void test_BVAD11_Day_LeapYear_February_30_Invalid() {
        assertFalse("Day 30 in Feb of leap year should be invalid", DateUtil.isValidDate(30, 2, 2000));
    }

    // =========================================================
    // isValidDate – Day, February non-leap year (2001)   [BVA-D12 ~ BVA-D13]
    // =========================================================

    @Test
    public void test_BVAD12_Day_NonLeapYear_February_28_Valid() {
        assertTrue("Day 28 in Feb of non-leap year should be valid", DateUtil.isValidDate(28, 2, 2001));
    }

    @Test
    public void test_BVAD13_Day_NonLeapYear_February_29_Invalid() {
        assertFalse("Day 29 in Feb of non-leap year should be invalid", DateUtil.isValidDate(29, 2, 2001));
    }

    // =========================================================
    // isLeapYear – boundary years   [BVA-L01 ~ BVA-L06]
    // =========================================================

    @Test
    public void test_BVAL01_LeapYear_1700_NotLeap() {
        // Divisible by 100 but NOT 400 → not leap
        assertFalse("1700 should NOT be a leap year", DateUtil.isLeapYear(1700));
    }

    @Test
    public void test_BVAL02_LeapYear_1704_Leap() {
        assertTrue("1704 should be a leap year", DateUtil.isLeapYear(1704));
    }

    @Test
    public void test_BVAL03_LeapYear_1800_NotLeap() {
        assertFalse("1800 should NOT be a leap year", DateUtil.isLeapYear(1800));
    }

    @Test
    public void test_BVAL04_LeapYear_1900_NotLeap() {
        assertFalse("1900 should NOT be a leap year", DateUtil.isLeapYear(1900));
    }

    @Test
    public void test_BVAL05_LeapYear_2000_Leap() {
        assertTrue("2000 should be a leap year", DateUtil.isLeapYear(2000));
    }

    @Test
    public void test_BVAL06_LeapYear_2024_Leap() {
        assertTrue("2024 should be a leap year", DateUtil.isLeapYear(2024));
    }

    // =========================================================
    // monthDuration – boundary months   [BVA-MD01 ~ BVA-MD05]
    // =========================================================

    @Test
    public void test_BVAMD01_MonthDuration_January_31() {
        assertEquals(31, DateUtil.monthDuration(1, 2000));
    }

    @Test
    public void test_BVAMD02_MonthDuration_February_NonLeap_28() {
        assertEquals(28, DateUtil.monthDuration(2, 2001));
    }

    @Test
    public void test_BVAMD03_MonthDuration_February_Leap_29() {
        assertEquals(29, DateUtil.monthDuration(2, 2000));
    }

    @Test
    public void test_BVAMD04_MonthDuration_April_30() {
        assertEquals(30, DateUtil.monthDuration(4, 2000));
    }

    @Test
    public void test_BVAMD05_MonthDuration_December_31() {
        assertEquals(31, DateUtil.monthDuration(12, 2000));
    }

    // =========================================================
    // daysBetween – boundary scenarios   [BVA-DB01 ~ BVA-DB09]
    // =========================================================

    @Test
    public void test_BVADB01_DaysBetween_SameDate_Zero() {
        DateUtil d = new DateUtil(15, 6, 2000);
        assertEquals(0, DateUtil.daysBetween(d, d));
    }

    @Test
    public void test_BVADB02_DaysBetween_AdjacentDays_One() {
        DateUtil d1 = new DateUtil(1, 1, 2000);
        DateUtil d2 = new DateUtil(2, 1, 2000);
        assertEquals(1, DateUtil.daysBetween(d1, d2));
    }

    @Test
    public void test_BVADB03_DaysBetween_ReverseOrder_SameResult() {
        DateUtil d1 = new DateUtil(1, 1, 2000);
        DateUtil d2 = new DateUtil(2, 1, 2000);
        assertEquals(DateUtil.daysBetween(d1, d2), DateUtil.daysBetween(d2, d1));
    }

    @Test
    public void test_BVADB04_DaysBetween_EndOfYear_ToStartOfNext() {
        // Dec 31 → Jan 1: exactly 1 day
        DateUtil d1 = new DateUtil(31, 12, 2000);
        DateUtil d2 = new DateUtil(1, 1, 2001);
        assertEquals(1, DateUtil.daysBetween(d1, d2));
    }

    @Test
    public void test_BVADB05_DaysBetween_StartOfRange_1700Jan1_To_1700Jan2() {
        DateUtil d1 = new DateUtil(1, 1, 1700);
        DateUtil d2 = new DateUtil(2, 1, 1700);
        assertEquals(1, DateUtil.daysBetween(d1, d2));
    }

    @Test
    public void test_BVADB06_DaysBetween_LeapDay_Feb28_To_Mar1_LeapYear() {
        // Leap year: Feb 28 → Mar 1 = 2 days (Feb 29 sits between them)
        DateUtil d1 = new DateUtil(28, 2, 2000);
        DateUtil d2 = new DateUtil(1, 3, 2000);
        assertEquals(2, DateUtil.daysBetween(d1, d2));
    }

    @Test
    public void test_BVADB07_DaysBetween_LeapDay_Feb28_To_Mar1_NonLeapYear() {
        // Non-leap year: Feb 28 → Mar 1 = 1 day (no Feb 29)
        DateUtil d1 = new DateUtil(28, 2, 2001);
        DateUtil d2 = new DateUtil(1, 3, 2001);
        assertEquals(1, DateUtil.daysBetween(d1, d2));
    }

    @Test
    public void test_BVADB08_DaysBetween_WholeLeapYear_365DaySpan() {
        // Jan 1 to Dec 31 in a leap year = 365 days apart
        DateUtil d1 = new DateUtil(1, 1, 2000);
        DateUtil d2 = new DateUtil(31, 12, 2000);
        assertEquals(365, DateUtil.daysBetween(d1, d2));
    }

    @Test
    public void test_BVADB09_DaysBetween_WholeNonLeapYear_364DaySpan() {
        // Jan 1 to Dec 31 in a non-leap year = 364 days apart
        DateUtil d1 = new DateUtil(1, 1, 2001);
        DateUtil d2 = new DateUtil(31, 12, 2001);
        assertEquals(364, DateUtil.daysBetween(d1, d2));
    }

    // =========================================================
    // Constructor – boundary edge dates   [BVA-C01 ~ BVA-C03]
    // =========================================================

    @Test
    public void test_BVAC01_Constructor_MinDate_1700Jan1_Valid() {
        DateUtil d = new DateUtil(1, 1, 1700);
        assertEquals(1, d.getDay());
        assertEquals(1, d.getMonth());
        assertEquals(1700, d.getYear());
    }

    @Test
    public void test_BVAC02_Constructor_MaxDate_2024Dec31_Valid() {
        DateUtil d = new DateUtil(31, 12, 2024);
        assertEquals(31, d.getDay());
        assertEquals(12, d.getMonth());
        assertEquals(2024, d.getYear());
    }

    @Test(expected = RuntimeException.class)
    public void test_BVAC03_Constructor_InvalidDate_Throws() {
        new DateUtil(29, 2, 2001); // non-leap year Feb 29
    }
}