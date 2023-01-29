package leetcode.p2389;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            int l = 0;
            int r = nums.length;
            while (l < r) {
                int mid = l + ((r - l) >> 1);
                if (nums[mid] <= q) {
                    res[i] = mid + 1;
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }

        return res;
    }

}
