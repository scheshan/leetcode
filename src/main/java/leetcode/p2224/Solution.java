package leetcode.p2224;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/3
 */
public class Solution {

    public int convertTime(String current, String correct) {
        int t1 = convert(current);
        int t2 = convert(correct);

        int[] times = new int[]{60, 15, 5, 1};

        int res = 0;
        for (int time : times) {
            if (t2 - t1 >= time) {
                int n = (t2 - t1) / time;
                res += n;
                t2 -= n * time;
            }
        }

        return res;
    }

    private int convert(String time) {
        int hours = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
        int minutes = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        return hours * 60 + minutes;
    }
}
