package interview.p17_10;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int res = nums[0];
        int vote = 1;

        for (int i = 1; i < nums.length; i++) {
            if (vote == 0) {
                res = nums[i];
            }
            if (res == nums[i]) {
                vote++;
            } else {
                vote--;
            }
        }

        int cnt = 0;
        for (int num : nums) {
            if (num == res) {
                cnt++;
            }
        }
        if (cnt > nums.length >> 1) {
            return res;
        }
        return -1;
    }
}
