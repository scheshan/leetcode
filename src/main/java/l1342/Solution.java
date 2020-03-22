package l1342;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int numberOfSteps(int num) {
        int res = 0;

        while (num > 0) {
            if ((num & 1) == 1) {
                num -= 1;
            } else {
                num >>= 1;
            }

            res++;
        }

        return res;
    }
}
