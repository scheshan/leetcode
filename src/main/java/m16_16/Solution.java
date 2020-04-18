package m16_16;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int[] subSort(int[] array) {
        int[] nums = array.clone();
        Arrays.sort(nums);

        int left = -1;
        int right = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != nums[i]) {
                left = i;
                break;
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != nums[i]) {
                right = i;
                break;
            }
        }
        return left == right ? new int[]{-1, -1} : new int[]{left, right};
    }
}
