package offer2.p068;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        int res = nums.length;
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid;
            }
        }
        return res;
    }
}
