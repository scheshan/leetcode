package l189;

/**
 * Solution
 *
 * @author heshan
 * @date 2021/1/8
 */
public class Solution {

    public void rotate(int[] nums, int k) {
        rotate(nums, 0, nums.length - 1);

        k = k % nums.length;

        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }

    private void rotate(int[] nums, int begin, int end) {
        while (begin < end) {
            int tmp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = tmp;

            begin++;
            end--;
        }
    }
}
