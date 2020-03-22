package l1365;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];

        int[] order = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            order[i] = nums[i];
        }
        Arrays.sort(order);

        for (int i = 0; i < nums.length; i++) {
            int ind = search(order, nums[i]);
            res[i] = ind;
        }

        return res;
    }

    private int search(int[] nums, int v) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == v) {
                while (mid >= l && mid > 0 && nums[mid - 1] == v) {
                    mid--;
                }
                return mid;
            } else if (nums[mid] < v) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        new Solution().smallerNumbersThanCurrent(new int[]{7, 7, 7, 7});
    }
}
