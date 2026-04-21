package sit707_tasks;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Equivalence Class Tests for DateUtil
 *
 * Naming convention:  test_<EC-ID>_<description>
 *
 * 30 Equivalence Classes (EC1 – EC24 + supporting tests):
 *
 * YEAR (isValidDate):
 *   EC1  (valid)   : 1700 <= year <= 2024
 *   EC2  (invalid) : year < 1700
 *   EC3  (invalid) : year > 2024
 *
 * MONTH (isValidDate):
 *   EC4  (valid)   : 1 <= month <= 12
 *   EC5  (invalid) : month < 1
 *   EC6  (invalid) : month > 12
 *
 * DAY – 31-day month (isValidDate):
 *   EC7  (valid)   : 1 <= day <= 31
 *   EC8  (invalid) : day < 1
 *   EC9  (invalid) : day > 31
 *
 * DAY – 30-day month (isValidDate):
 *   EC10 (valid)   : 1 <= day <= 30
 *   EC11 (invalid) : day > 30
 *
 * DAY – February, leap year (isValidDate):
 *   EC12 (valid)   : 1 <= day <= 29
 *   EC13 (invalid) : day > 29
 *
 * DAY – February, non-leap year (isValidDate):
 *   EC14 (valid)   : 1 <= day <= 28
 *   EC15 (invalid) : day > 28
 *
 * isLeapYear:
 *   EC16 : year divisible by 400              → true
 *   EC17 : year divisible by 100, not by 400  → false
 *   EC18 : year divisible by 4, not by 100    → true
 *   EC19 : year not divisible by 4            → false
 *
 * daysBetween:
 *   EC20 : same date                          → 0
 *   EC21 : dates within same month            → positive int
 *   EC22 : dates crossing a month boundary
 *   EC23 : dates crossing a year boundary
 *   EC24 : dates spanning multiple years
 *
 * Additional tests (support EC coverage, not separate classes):
 *   EC-MD01~04 : monthDuration – one test per month-length category
 *   EC-DB-SYM  : daysBetween symmetry property
 *   EC-C01~05  : Constructor valid + invalid inputs (year / month / day / Feb non-leap)
 *   EC-TS01    : toString format check
 *
 * Total: 35 test methods covering 30 equivalence classes
 */
public class DateUtilEquivalenceTest {

    // =========================================================
    // isValidDate – Year equivalence classes   [EC1 ~ EC3]
    // =========================================================

    /** EC1: year in valid range [1700, 2024] */
    @Test
    public void test_EC1_Year_ValidRange() {
        assertTrue("Mid-range year 2000 should be valid", DateUtil.isValidDate(15, 6, 2000));
    }

    /** EC2: year below minimum (< 1700) */
    @Test
    public void test_EC2_Year_BelowMin() {
        assertFalse("Year 1500 should be invalid", DateUtil.isValidDate(15, 6, 1500));
    }

    /** EC3: year above maximum (> 2024) */
    @Test
    public void test_EC3_Year_AboveMax() {
        assertFalse("Year 2100 should be invalid", DateUtil.isValidDate(15, 6, 2100));
    }

    // =========================================================
    // isValidDate – Month equivalence classes   [EC4 ~ EC6]
    // =========================================================

    /** EC4: month in valid range [1, 12] */
    @Test
    public void test_EC4_Month_ValidRange() {
        assertTrue("Month 7 should be valid", DateUtil.isValidDate(15, 7, 2000));
    }

    /** EC5: month below minimum (< 1) */
    @Test
    public void test_EC5_Month_BelowMin() {
        assertFalse("Month -1 should be invalid", DateUtil.isValidDate(15, -1, 2000));
    }

    /** EC6: month above maximum (> 12) */
    @Test
    public void test_EC6_Month_AboveMax() {
        assertFalse("Month 15 should be invalid", DateUtil.isValidDate(15, 15, 2000));
    }

    // =========================================================
    // isValidDate – Day, 31-day month (January)   [EC7 ~ EC9]
    // =========================================================

    /** EC7: valid day in a 31-day month */
    @Test
    public void test_EC7_Day_Valid_31DayMonth() {
        assertTrue("Day 15 in January should be valid", DateUtil.isValidDate(15, 1, 2000));
    }

    /** EC8: day below minimum (< 1) */
    @Test
    public void test_EC8_Day_BelowMin() {
        assertFalse("Day -5 should be invalid", DateUtil.isValidDate(-5, 1, 2000));
    }

    /** EC9: day above 31-day month maximum (> 31) */
    @Test
    public void test_EC9_Day_Above31DayMax() {
        assertFalse("Day 32 in January should be invalid", DateUtil.isValidDate(32, 1, 2000));
    }

    // =========================================================
    // isValidDate – Day, 30-day month (April)   [EC10 ~ EC11]
    // =========================================================

    /** EC10: valid day in a 30-day month */
    @Test
    public void test_EC10_Day_Valid_30DayMonth() {
        assertTrue("Day 20 in April should be valid", DateUtil.isValidDate(20, 4, 2000));
    }

    /** EC11: day above 30-day month maximum (> 30) */
    @Test
    public void test_EC11_Day_Above30DayMax() {
        assertFalse("Day 31 in April should be invalid", DateUtil.isValidDate(31, 4, 2000));
    }

    // =========================================================
    // isValidDate – Day, February leap year (2000)   [EC12 ~ EC13]
    // =========================================================

    /** EC12: valid day in February of a leap year (up to 29) */
    @Test
    public void test_EC12_Day_Valid_FebLeapYear() {
        assertTrue("Day 29 in Feb 2000 (leap) should be valid", DateUtil.isValidDate(29, 2, 2000));
    }

    /** EC13: day above February leap-year maximum (> 29) */
    @Test
    public void test_EC13_Day_Above_FebLeapYearMax() {
        assertFalse("Day 30 in Feb 2000 (leap) should be invalid", DateUtil.isValidDate(30, 2, 2000));
    }

    // =========================================================
    // isValidDate – Day, February non-leap year (2001)   [EC14 ~ EC15]
    // =========================================================

    /** EC14: valid day in February of a non-leap year (up to 28) */
    @Test
    public void test_EC14_Day_Valid_FebNonLeapYear() {
        assertTrue("Day 28 in Feb 2001 should be valid", DateUtil.isValidDate(28, 2, 2001));
    }

    /** EC15: day above February non-leap-year maximum (> 28) */
    @Test
    public void test_EC15_Day_Above_FebNonLeapYearMax() {
        assertFalse("Day 29 in Feb 2001 should be invalid", DateUtil.isValidDate(29, 2, 2001));
    }

    // =========================================================
    // isLeapYear – equivalence classes   [EC16 ~ EC19]
    // =========================================================

    /** EC16: year divisible by 400 → leap */
    @Test
    public void test_EC16_LeapYear_DivisibleBy400() {
        assertTrue("2000 divisible by 400 should be leap", DateUtil.isLeapYear(2000));
    }

    /** EC17: year divisible by 100 but not 400 → not leap */
    @Test
    public void test_EC17_LeapYear_DivisibleBy100NotBy400() {
        assertFalse("1900 divisible by 100 but not 400 should not be leap", DateUtil.isLeapYear(1900));
    }

    /** EC18: year divisible by 4 but not 100 → leap */
    @Test
    public void test_EC18_LeapYear_DivisibleBy4NotBy100() {
        assertTrue("1996 divisible by 4 but not 100 should be leap", DateUtil.isLeapYear(1996));
    }

    /** EC19: year not divisible by 4 → not leap */
    @Test
    public void test_EC19_LeapYear_NotDivisibleBy4() {
        assertFalse("2001 not divisible by 4 should not be leap", DateUtil.isLeapYear(2001));
    }

    // =========================================================
    // monthDuration – one test per month-length category
    //                 [EC-MD01 ~ EC-MD04]
    // These tests verify monthDuration output for each class of month.
    // They support EC7/EC10/EC12/EC14 and are labelled separately.
    // =========================================================

    @Test
    public void test_ECMD01_MonthDuration_31DayMonth() {
        assertEquals("March should have 31 days", 31, DateUtil.monthDuration(3, 2000));
    }

    @Test
    public void test_ECMD02_MonthDuration_30DayMonth() {
        assertEquals("June should have 30 days", 30, DateUtil.monthDuration(6, 2000));
    }

    @Test
    public void test_ECMD03_MonthDuration_FebLeapYear() {
        assertEquals("Feb in leap year should have 29 days", 29, DateUtil.monthDuration(2, 2000));
    }

    @Test
    public void test_ECMD04_MonthDuration_FebNonLeapYear() {
        assertEquals("Feb in non-leap year should have 28 days", 28, DateUtil.monthDuration(2, 2001));
    }

    // =========================================================
    // daysBetween – equivalence classes   [EC20 ~ EC24]
    // =========================================================

    /** EC20: same date → 0 days */
    @Test
    public void test_EC20_DaysBetween_SameDate() {
        DateUtil d = new DateUtil(10, 5, 2010);
        assertEquals(0, DateUtil.daysBetween(d, d));
    }

    /** EC21: dates within same month → positive integer */
    @Test
    public void test_EC21_DaysBetween_SameMonth() {
        DateUtil d1 = new DateUtil(5, 3, 2010);
        DateUtil d2 = new DateUtil(20, 3, 2010);
        assertEquals(15, DateUtil.daysBetween(d1, d2));
    }

    /** EC22: dates crossing a month boundary */
    @Test
    public void test_EC22_DaysBetween_CrossMonth() {
        DateUtil d1 = new DateUtil(28, 1, 2001);  // Jan 28
        DateUtil d2 = new DateUtil(3, 2, 2001);   // Feb 3
        assertEquals(6, DateUtil.daysBetween(d1, d2));
    }

    /** EC23: dates crossing a year boundary */
    @Test
    public void test_EC23_DaysBetween_CrossYear() {
        DateUtil d1 = new DateUtil(1, 12, 2010);  // Dec 1
        DateUtil d2 = new DateUtil(10, 1, 2011);  // Jan 10
        assertEquals(40, DateUtil.daysBetween(d1, d2));
    }

    /** EC24: dates spanning multiple years */
    @Test
    public void test_EC24_DaysBetween_MultipleYears() {
        DateUtil d1 = new DateUtil(1, 1, 2000);
        DateUtil d2 = new DateUtil(1, 1, 2003);
        // 2000(leap=366) + 2001(365) + 2002(365) = 1096
        assertEquals(1096, DateUtil.daysBetween(d1, d2));
    }

    /** EC-DB-SYM: symmetry — daysBetween(a,b) == daysBetween(b,a) */
    @Test
    public void test_ECDBSYM_DaysBetween_Symmetry() {
        DateUtil d1 = new DateUtil(15, 8, 2005);
        DateUtil d2 = new DateUtil(3, 11, 2007);
        assertEquals(DateUtil.daysBetween(d1, d2), DateUtil.daysBetween(d2, d1));
    }

    // =========================================================
    // Constructor – valid and invalid inputs   [EC-C01 ~ EC-C05]
    // =========================================================

    @Test
    public void test_ECC01_Constructor_ValidDate_NoException() {
        DateUtil d = new DateUtil(20, 6, 2010);
        assertEquals(20, d.getDay());
        assertEquals(6, d.getMonth());
        assertEquals(2010, d.getYear());
    }

    @Test(expected = RuntimeException.class)
    public void test_ECC02_Constructor_InvalidYear_ThrowsException() {
        new DateUtil(1, 1, 2025);
    }

    @Test(expected = RuntimeException.class)
    public void test_ECC03_Constructor_InvalidMonth_ThrowsException() {
        new DateUtil(1, 13, 2000);
    }

    @Test(expected = RuntimeException.class)
    public void test_ECC04_Constructor_InvalidDay_ThrowsException() {
        new DateUtil(32, 1, 2000); // day out of range for any month
    }

    @Test(expected = RuntimeException.class)
    public void test_ECC05_Constructor_FebNonLeapInvalidDay_ThrowsException() {
        new DateUtil(29, 2, 2003); // non-leap year, Feb 29 invalid
    }

    // =========================================================
    // toString – format check   [EC-TS01]
    // =========================================================

    @Test
    public void test_ECTS01_ToString_Format() {
        DateUtil d = new DateUtil(5, 3, 2000);
        assertEquals("05/03/2000", d.toString());
    }
}