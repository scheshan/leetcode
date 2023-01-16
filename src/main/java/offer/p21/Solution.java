package offer.p21;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public int[] exchange(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if ((nums[l] & 1) == 1) {
                l++;
            } else {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                r--;
            }
        }

        return nums;
    }
}
