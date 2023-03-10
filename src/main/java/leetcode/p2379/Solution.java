package leetcode.p2379;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/9
 */
public class Solution {

    public int minimumRecolors(String blocks, int k) {
        int l = 0, r = 0, cnt = 0, res = blocks.length();
        while (r < blocks.length()) {
            if (blocks.charAt(r++) == 'W') {
                cnt++;
            }
            if (r - l > k) {
                if (blocks.charAt(l++) == 'W') {
                    cnt--;
                }
            }
            if (r - l == k) {
                res = Math.min(res, cnt);
            }
        }

        return res;
    }
}
