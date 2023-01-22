package leetcode.p1672;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public int maximumWealth(int[][] accounts) {
        int res = 0;

        for (int[] arr : accounts) {
            int tmp = 0;
            for (int num : arr) {
                tmp += num;
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
}
