package leetcode.p26;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            nums[slow++] = nums[fast++];

            while (fast < nums.length && nums[fast] == nums[fast - 1]) {
                fast++;
            }
        }

        return slow;
    }
}
