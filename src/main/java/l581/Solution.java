package l581;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/17
 */
public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);

        int left = -1;
        int right = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != nums[i]) {
                left = i;
                break;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != nums[i]) {
                right = i;
                break;
            }
        }

        return right == left ? 0 : right - left + 1;
    }
}
