package leetcode.p190;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                res |= (1 << (32 - i));
            }
        }
        return res;
    }
}
