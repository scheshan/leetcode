package leetcode.p88;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ind = nums1.length - 1;

        int l = m - 1, r = n - 1;
        while (l >= 0 || r >= 0) {
            int n1 = Integer.MIN_VALUE;
            if (l >= 0) {
                n1 = nums1[l];
            }
            int n2 = Integer.MIN_VALUE;
            if (r >= 0) {
                n2 = nums2[r];
            }

            if (n1 > n2) {
                nums1[ind--] = nums1[l--];
            } else {
                nums1[ind--] = nums2[r--];
            }
        }
    }
}
