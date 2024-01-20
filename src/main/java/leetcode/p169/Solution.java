package leetcode.p169;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/20
 */
public class Solution {

    public int majorityElement(int[] nums) {
        int res = -1, cnt = 0;

        for (int num : nums) {
            if (res == num) {
                cnt++;
            } else {
                if (cnt > 0) {
                    cnt--;
                } else {
                    res = num;
                    cnt = 1;
                }
            }
        }

        return res;
    }
}
