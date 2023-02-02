package leetcode.p2190;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int mostFrequent(int[] nums, int key) {
        int[] cnt = new int[1001];
        int res = 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == key) {
                cnt[nums[i]]++;
                if (cnt[nums[i]] > max) {
                    max = cnt[nums[i]];
                    res = nums[i];
                }
            }
        }
        return res;
    }
}
