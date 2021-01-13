package l350;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/19
 */
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] arr = new int[Math.min(nums1.length, nums2.length)];
        int ind = 0;
        int l = 0;
        int r = 0;

        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] == nums2[r]) {
                arr[ind++] = nums1[l];
                l++;
                r++;
            } else if (nums1[l] < nums2[r]) {
                l++;
            } else {
                r++;
            }
        }

        int[] res = new int[ind];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[i];
        }

        return res;
    }
}
