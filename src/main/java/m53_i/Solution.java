package m53_i;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        int res = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                res++;

                for (int i = mid - 1; i >= 0 && nums[i] == target; i--) {
                    res++;
                }
                for (int i = mid + 1; i < nums.length && nums[i] == target; i++) {
                    res++;
                }

                return res;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().search(new int[]{1, 3}, 1);
    }
}
