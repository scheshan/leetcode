package leetcode.p169;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int majorityElement(int[] nums) {
        int res = nums[0], vote = 1;
        for (int i = 1; i < nums.length; i++) {
            if (vote == 0) {
                res = nums[i];
                vote = 1;
            } else if (res == nums[i]) {
                vote++;
            } else {
                vote--;
            }
        }

        return res;
    }
}
