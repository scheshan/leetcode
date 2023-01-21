package leetcode.p169;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public int majorityElement(int[] nums) {
        int res = 0;
        int vote = 0;

        for (int num : nums) {
            if (vote == 0) {
                res = num;
            }
            if (res == num) {
                vote++;
            } else {
                vote--;
            }
        }
        return res;
    }
}
