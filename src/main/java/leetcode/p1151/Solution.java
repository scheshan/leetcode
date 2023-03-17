package leetcode.p1151;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/15
 */
public class Solution {

    public int minSwaps(int[] data) {
        int cnt = 0;
        for (int num : data) {
            if (num == 1) {
                cnt++;
            }
        }

        int res = cnt;
        int l = 0;
        int r = 0;
        int cur = 0;
        while (r < data.length) {
            if (data[r++] == 1) {
                cur++;
            }

            if (r - l > cnt) {
                if (data[l++] == 1) {
                    cur--;
                }
            }

            if (r - l == cnt) {
                res = Math.min(res, cnt - cur);
            }
        }

        return res;
    }
}
