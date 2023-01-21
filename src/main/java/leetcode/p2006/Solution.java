package leetcode.p2006;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public int countKDifference(int[] nums, int k) {
        int[] map = new int[101];
        int res = 0;

        for (int num : nums) {
            if (k - num >= 0) {
                res += map[k - num];
            }
            if (k + num < map.length) {
                res += map[k + num];
            }
            map[num]++;
        }
        return res;
    }
}
