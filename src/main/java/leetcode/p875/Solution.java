package leetcode.p875;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int num : piles) {
            r = Math.max(r, num);
        }

        int res = 0;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            long time = count(piles, mid);
            if (time <= h) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private long count(int[] piles, int speed) {
        long res = 0;
        for (int num : piles) {
            res += num / speed;
            if (num % speed > 0) {
                res++;
            }
        }
        return res;
    }
}
