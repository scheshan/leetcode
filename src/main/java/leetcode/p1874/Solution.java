package leetcode.p1874;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            res += nums1[i] * nums2[nums2.length - i - 1];
        }
        return res;
    }
}
