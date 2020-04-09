package l371;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/9
 */
public class Solution {

    public int getSum(int a, int b) {
        int res = a ^ b;
        int d = (a & b) << 1;

        while (d != 0) {
            int tmp = (d & res) << 1;
            res = res ^ d;

            d = tmp;
        }

        return res;
    }
}
