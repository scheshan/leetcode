package leetcode.p349;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/20
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] exist = new boolean[1001];
        for (int num : nums1) {
            exist[num] = true;
        }

        int slow = 0, fast = 0;
        while (fast < nums2.length) {
            if (exist[nums2[fast]]) {
                nums2[slow++] = nums2[fast];
                exist[nums2[fast]] = false;
            }
            fast++;
        }

        int[] res = new int[slow];
        for (int i = 0; i < slow; i++) {
            res[i] = nums2[i];
        }

        return res;
    }
}
