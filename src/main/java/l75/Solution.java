package l75;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int index = 0;

        while (index <= right) {
            int num = nums[index];
            if (num == 0) {
                swap(nums, left, index);
                if (index == left) {
                    index++;
                }
                left++;
            } else if (num == 2) {
                swap(nums, right, index);
                right--;
            } else {
                index++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        new Solution().sortColors(new int[]{2, 0, 1});
    }
}
