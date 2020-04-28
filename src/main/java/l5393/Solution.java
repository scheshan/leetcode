package l5393;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/26
 */
public class Solution {

    public int maxScore(int[] cardPoints, int k) {
        int left = 0;
        int right = k - 1;

        int res = 0;
        for (int i = left; i <= right; i++) {
            res += cardPoints[i];
        }

        if (k == cardPoints.length) {
            return res;
        }

        int cur = res;
        while (right >= 0) {
            left--;

            cur += cardPoints[(left + cardPoints.length) % cardPoints.length];
            cur -= cardPoints[(right + cardPoints.length) % cardPoints.length];

            right--;

            res = Math.max(res, cur);
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3);
        System.out.println(res);
    }
}
