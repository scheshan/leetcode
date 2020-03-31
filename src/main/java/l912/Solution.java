package l912;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/31
 */
public class Solution {

    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length - 1, temp);

        return nums;
    }

    private void sort(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;
        sort(nums, left, mid, temp);
        sort(nums, mid + 1, right, temp);
        merge(nums, left, mid, right, temp);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int i = 0;

        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                temp[i++] = nums[l++];
            } else {
                temp[i++] = nums[r++];
            }
        }
        while (l <= mid) {
            temp[i++] = nums[l++];
        }
        while (r <= right) {
            temp[i++] = nums[r++];
        }

        for (int j = 0; j < i; j++) {
            nums[left + j] = temp[j];
        }
    }

    public static void main(String[] args) {
        new Solution().sortArray(new int[]{5, 2, 3, 1});
    }
}
