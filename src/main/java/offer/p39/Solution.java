package offer.p39;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public int majorityElement(int[] nums) {
        int res = 0;
        int votes = 0;

        for (int n : nums) {
            if (votes == 0) {
                res = n;
                votes++;
            } else if (res == n) {
                votes++;
            } else {
                votes--;
            }
        }

        return res;
    }
}
