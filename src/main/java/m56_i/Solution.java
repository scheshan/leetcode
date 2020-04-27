package m56_i;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/28
 */
public class Solution {

    public int[] singleNumbers(int[] nums) {
        int all = 0;
        for (int n : nums) {
            all ^= n;
        }

        int a = 0;
        int b = 0;

        int diff = 1;
        while ((all & diff) == 0) {
            diff <<= 1;
        }

        for (int n : nums) {
            if ((n & diff) == diff) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] res = new Solution().singleNumbers(new int[]{1, 2, 5, 2});
        System.out.println(Arrays.toString(res));
    }
}
