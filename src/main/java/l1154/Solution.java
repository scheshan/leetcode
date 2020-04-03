package l1154;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/3
 */
public class Solution {

    public int dayOfYear(String date) {
        int[] month = new int[13];
        month[2] = month[1] + 31;
        month[3] = month[2] + 28;
        month[4] = month[3] + 31;
        month[5] = month[4] + 30;
        month[6] = month[5] + 31;
        month[7] = month[6] + 30;
        month[8] = month[7] + 31;
        month[9] = month[8] + 31;
        month[10] = month[9] + 30;
        month[11] = month[10] + 31;
        month[12] = month[11] + 30;

        int y = Integer.parseInt(date.substring(0, 4));
        int m = Integer.parseInt(date.substring(5, 7));
        int d = Integer.parseInt(date.substring(8, 10));

        int res = month[m] + d;
        if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
            if (m > 2) {
                res++;
            }
        }

        return res;
    }
}
