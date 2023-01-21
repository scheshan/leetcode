package leetcode.p1365;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[101];
        for (int num : nums) {
            arr[num]++;
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                nums[i] = 0;
            } else {
                nums[i] = arr[num - 1];
            }
        }
        return nums;
    }
}
