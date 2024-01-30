package leetcode.p875;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        int l = 1, r = max, res = 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            long time = 0;
            for (int i = 0; i < piles.length; i++) {
                time += time(piles[i], mid);
            }

            if (time <= h) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private int time(int pile, int speed) {
        int res = pile / speed;
        if (pile % speed > 0) {
            res++;
        }
        return res;
    }
}
