package leetcode.p26;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            nums[slow++] = nums[fast++];

            while (fast < nums.length && nums[fast] == nums[fast - 1]) {
                fast++;
            }
        }

        return slow;
    }
}
