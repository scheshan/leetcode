package leetcode.p1929;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length << 1];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
            res[i + nums.length] = nums[i];
        }
        return res;
    }
}
