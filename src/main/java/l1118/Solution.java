package l1118;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/26
 */
public class Solution {

    public int numberOfDays(int Y, int M) {
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int res = days[M - 1];
        if (M == 2 && (Y % 400 == 0 || (Y % 4 == 0 && Y % 100 != 0))) {
            res++;
        }
        return res;
    }
}
