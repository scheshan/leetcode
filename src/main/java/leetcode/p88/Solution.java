package leetcode.p88;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ind = nums1.length - 1;

        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] < nums2[n]) {
                nums1[ind--] = nums2[n--];
            } else {
                nums1[ind--] = nums1[m--];
            }
        }

        while (m >= 0) {
            nums1[ind--] = nums1[m--];
        }
        while (n >= 0) {
            nums1[ind--] = nums2[n--];
        }
    }
}
