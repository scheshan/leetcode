package leetcode.p1154;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public int dayOfYear(String date) {
        int[] monthDays = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = readInt(date, 0) * 1000 + readInt(date, 1) * 100 + readInt(date, 2) * 10 + readInt(date, 3);
        if ((year % 100 != 0 && year % 4 == 0) || (year % 400 == 0)) {
            monthDays[2] = 29;
        }
        int month = readInt(date, 5) * 10 + readInt(date, 6);
        int day = readInt(date, 8) * 10 + readInt(date, 9);

        int res = 0;
        for (int i = 0; i < month; i++) {
            res += monthDays[i];
        }
        res += day;
        return res;
    }

    private int readInt(String str, int ind) {
        return str.charAt(ind) - '0';
    }
}
