package leetcode.p495;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/13
 */
public class Solution {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int pre = -1;

        for (int time : timeSeries) {
            if (pre < 0) {
                pre = time;
            } else if (time - pre > duration - 1) {
                res += duration;
                pre = time;
            } else {
                res += time - pre;
                pre = time;
            }
        }
        res += duration;

        return res;
    }

    public static void main(String[] args) {
        new Solution().findPoisonedDuration(new int[]{1, 4}, 2);
    }
}

