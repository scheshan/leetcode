package leetcode.p75;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1, ind = 0;

        while (ind <= r) {
            int num = nums[ind];
            if (num == 0) {
                if (ind != l) {
                    nums[ind] = nums[l];
                    nums[l] = num;
                }
                ind++;
                l++;
            } else if(num == 1) {
                ind++;
            } else {
                nums[ind] = nums[r];
                nums[r] = num;
                r--;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().sortColors(new int[]{2, 0, 1});
    }
}
