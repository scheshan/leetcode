package lcp8;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] C = new int[increase.length + 1];
        int[] R = new int[increase.length + 1];
        int[] H = new int[increase.length + 1];

        for (int i = 0; i < increase.length; i++) {
            C[i + 1] = C[i] + increase[i][0];
            R[i + 1] = R[i] + increase[i][1];
            H[i + 1] = H[i] + increase[i][2];
        }

        int[] res = new int[requirements.length];
        for (int i = 0; i < requirements.length; i++) {
            int[] require = requirements[i];

            int d1 = index(C, require[0]);
            if (d1 == -1) {
                res[i] = -1;
                continue;
            }
            int d2 = index(R, require[1]);
            if (d2 == -1) {
                res[i] = -1;
                continue;
            }
            int d3 = index(H, require[2]);
            if (d3 == -1) {
                res[i] = -1;
                continue;
            }

            int d = Math.max(d1, Math.max(d2, d3));
            res[i] = d;
        }
        return res;
    }

    private int index(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                if (mid < nums.length - 1 && nums[mid + 1] > target) {
                    return mid + 1;
                }
                left = mid + 1;
            } else if (nums[mid] > target) {
                if (mid > 0 && nums[mid - 1] < target) {
                    return mid;
                }
                right = mid;
            } else {
                while (mid > 0 && nums[mid - 1] == nums[mid]) {
                    mid--;
                }
                return mid;
            }
        }

        return -1;
    }
}
