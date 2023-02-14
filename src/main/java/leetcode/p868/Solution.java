package leetcode.p868;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public int binaryGap(int n) {
        int max = 0;
        int pre = -1;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                if (pre >= 0) {
                    max = Math.max(max, i - pre);
                }
                pre = i;
            }
        }
        return max;
    }
}
