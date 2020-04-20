package m61;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/20
 */
public class Solution {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        int zero = 0;
        int prev = 0;

        for (int num : nums) {
            if (num == 0) {
                zero++;
                continue;
            }

            if (prev != 0) {
                if (num == prev) {
                    return false;
                }
                if (num > prev + 1) {
                    int require = num - prev - 1;
                    if (zero < require) {
                        return false;
                    }
                    zero -= require;
                }
            }

            prev = num;
        }

        return true;
    }
}
