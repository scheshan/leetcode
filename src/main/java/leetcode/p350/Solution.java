package leetcode.p350;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/20
 */
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] cnt = new int[1001];
        for (int num : nums1) {
            cnt[num]++;
        }

        int slow = 0, fast = 0;
        while (fast < nums2.length) {
            if (cnt[nums2[fast]] > 0) {
                cnt[nums2[fast]]--;
                nums2[slow++] = nums2[fast];
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
