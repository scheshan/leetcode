package leetcode.p1512;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public int numIdenticalPairs(int[] nums) {
        int[] map = new int[101];
        int res = 0;

        for (int num : nums) {
            res += map[num];
            map[num]++;
        }

        return res;
    }
}
