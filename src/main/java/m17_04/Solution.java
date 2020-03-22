package m17_04;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int missingNumber(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length + 1; i++) {
            res = res ^ i;

            if (i < nums.length) {
                res = res ^ nums[i];
            }
        }

        return res;
    }
}
