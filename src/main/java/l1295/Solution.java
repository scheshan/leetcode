package l1295;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int findNumbers(int[] nums) {
        int res = 0;

        for (int num : nums) {
            if ((String.valueOf(num).length() & 1) == 0) {
                res++;
            }
        }

        return res;
    }
}
