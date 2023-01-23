package leetcode.p1295;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if (num >= 10 && num <= 99) {
                res++;
            } else if (num >= 1000 && num <= 9999) {
                res++;
            } else if (num >= 100000 && num < 999999) {
                res++;
            }
        }
        return res;
    }
}
