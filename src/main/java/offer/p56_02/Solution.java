package offer.p56_02;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int singleNumber(int[] nums) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    cnt++;
                }
            }
            if (cnt % 3 != 0) {
                res |= 1 << i;
            }
        }

        return res;
    }
}
