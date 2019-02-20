package hdu.hdu_1000_1099.hdu_1079;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        init();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();

            if (Boolean.TRUE == map.get(getDate(year, month, day))) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }

    static int[] days = {29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static Map<String, Boolean> map = new HashMap<>();

    static void init() {
        int year = 2001;
        int month = 11;
        int day = 4;

        map.put(getDate(2001, 11, 3), Boolean.TRUE);
        map.put(getDate(2001, 10, 4), Boolean.TRUE);
        while (year >= 1900) {
            int nextDayYear = year;
            int nextDayMonth = month;
            int nextDayDay = day;

            Boolean nextDayResult = map.get(getDate(nextDayYear, nextDayMonth, nextDayDay));

            day--;
            if (day == 0) {
                month--;
                if (month == 0) {
                    year--;
                    month = 12;
                }
                if (month == 2 && isLeap(year)) {
                    day = days[0];
                } else {
                    day = days[month];
                }
            }

            if (map.containsKey(getDate(year, month, day))) {
                continue;
            }

            int nextMonthYear = year;
            int nextMonthMonth = month;
            int nextMonthDay = day;
            int nextMonthMonthDays;

            nextMonthMonth++;
            if (nextMonthMonth == 13) {
                nextMonthYear++;
                nextMonthMonth = 1;
            }

            if (nextMonthMonth == 2 && isLeap(nextMonthYear)) {
                nextMonthMonthDays = days[0];
            } else {
                nextMonthMonthDays = days[nextMonthMonth];
            }

            Boolean nextMonthResult;

            if (nextMonthDay > nextMonthMonthDays || isOver(nextMonthYear, nextMonthMonth, nextMonthDay)) {

                if (Boolean.TRUE == nextDayResult) {
                    map.put(getDate(year, month, day), Boolean.FALSE);
                }

                if (Boolean.FALSE == nextDayResult) {
                    map.put(getDate(year, month, day), Boolean.TRUE);
                }

            } else {

                nextMonthResult = map.get(getDate(nextMonthYear, nextMonthMonth, nextMonthDay));

                if (Boolean.TRUE == nextDayResult && Boolean.TRUE == nextMonthResult) {
                    map.put(getDate(year, month, day), Boolean.FALSE);
                }

                if (Boolean.FALSE == nextDayResult || Boolean.FALSE == nextMonthResult) {
                    map.put(getDate(year, month, day), Boolean.TRUE);
                }
            }
        }

    }

    static String getDate(int year, int month, int day) {
        return new StringBuffer(year).append("-").append(month).append("-").append(day).toString();
    }

    static boolean isOver(int year, int month, int day) {
        if (year < 2001) {
            return false;
        }

        if (year > 2001) {
            return true;
        }

        if (month < 11) {
            return false;
        }

        if (month > 11) {
            return true;
        }

        if (day < 4) {
            return false;
        }

        return true;
    }

    static boolean isLeap(int year) {
        if (year % 400 == 0) {
            return true;
        }

        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }

        return false;
    }
}
