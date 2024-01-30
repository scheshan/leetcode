package leetcode.p137;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public int singleNumber(int[] nums) {
        int[] cnt = new int[32];

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    cnt[i]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (cnt[i] % 3 != 0) {
                res |= (1 << i);
            }
        }

        return res;
    }
}
