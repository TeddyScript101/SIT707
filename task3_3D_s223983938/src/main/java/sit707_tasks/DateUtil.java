package sit707_tasks;

public class DateUtil {
    private int day, month, year;

    public DateUtil(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new RuntimeException("Invalid date: " + day + "/" + month + "/" + year);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }


    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }


    public static int monthDuration(int month, int year) {
        if (month == 2) return isLeapYear(year) ? 29 : 28;
        if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
        return 31;
    }


    public static boolean isValidDate(int d, int m, int y) {
        if (y < 1700 || y > 2024) return false; 
        if (m < 1 || m > 12) return false;      
        if (d < 1 || d > monthDuration(m, y)) return false; 
        return true;
    }


    public static int daysBetween(DateUtil start, DateUtil end) {
        return Math.abs(getTotalDaysFromRef(end) - getTotalDaysFromRef(start));
    }

    private static int getTotalDaysFromRef(DateUtil date) {
        int total = 0;
        for (int y = 1700; y < date.getYear(); y++) {
            total += isLeapYear(y) ? 366 : 365;
        }
        for (int m = 1; m < date.getMonth(); m++) {
            total += monthDuration(m, date.getYear());
        }
        total += date.getDay();
        return total;
    }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", day, month, year);
    }
}