package offer2.p070;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = l + ((r - l) >> 1);

            if (mid == 0 && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (mid == nums.length - 1 && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            if ((mid & 1) == 0) {
                if (nums[mid] == nums[mid - 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }
        return -1;
    }
}
