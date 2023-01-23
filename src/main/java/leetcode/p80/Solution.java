package leetcode.p80;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            nums[slow++] = nums[fast];
            fast++;
            int cnt = 0;
            while (fast < nums.length && nums[fast] == nums[fast - 1]) {
                if (cnt < 1) {
                    nums[slow++] = nums[fast];
                }
                fast++;
                cnt++;
            }
        }

        return slow;
    }
}
