package leetcode.p2570;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/23
 */
public class Solution {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> list = new ArrayList<>();
        int l = 0;
        int r = 0;
        while (l < nums1.length && r < nums2.length) {
            int[] item = new int[2];
            if (nums1[l][0] < nums2[r][0]) {
                list.add(nums1[l++]);
            } else if (nums1[l][0] > nums2[r][0]) {
                list.add(nums2[r++]);
            } else {
                nums1[l][1] += nums2[r][1];
                list.add(nums1[l]);
                l++;
                r++;
            }
        }
        while (l < nums1.length) {
            list.add(nums1[l++]);
        }
        while (r < nums2.length) {
            list.add(nums2[r++]);
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
