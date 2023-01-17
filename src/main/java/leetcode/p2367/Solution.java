package leetcode.p2367;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int n = nums[i];
            int l = find(nums, i + 1, n + diff);
            if (l < 0) {
                continue;
            }
            if (find(nums, l + 1, n + diff + diff) > 0) {
                res++;
            }
        }
        return res;
    }

    private int find(int[] nums, int begin, int target) {
        int l = begin;
        int r = nums.length;

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            int n = nums[mid];
            if (n == target) {
                return mid;
            } else if (n < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }
}
