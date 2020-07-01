package l1493;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/6/30
 */
public class Solution {

    public int longestSubarray(int[] nums) {
        int l = 0, r = 0, count = 0;
        int res = 0;

        while (r < nums.length) {
            if (nums[r] == 1) {
                r++;
            } else if (count == 0) {
                count++;
                r++;
            } else {
                while (count > 0) {
                    if (nums[l++] == 0) {
                        count--;
                    }
                }
            }

            res = Math.max(res, r - l - count);
        }
        return res == nums.length ? res - 1 : res;
    }

    public static void main(String[] args) {
        final int res = new Solution().longestSubarray(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1});
        System.out.println(res);
    }
}
