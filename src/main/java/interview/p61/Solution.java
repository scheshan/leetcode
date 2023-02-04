package interview.p61;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/4
 */
public class Solution {

    public boolean isStraight(int[] nums) {
        int min = 14;
        int max = 0;
        int cnt = 0;

        for (int num : nums) {
            if (num == 0) {
                continue;
            }

            if ((cnt & (1 << num)) != 0) {
                return false;
            }
            cnt |= 1 << num;
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        return max - min < 5;
    }
}
