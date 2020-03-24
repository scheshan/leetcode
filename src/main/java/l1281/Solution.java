package l1281;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public int subtractProductAndSum(int n) {
        int x = 1;
        int y = 0;

        while (n > 0) {
            int num = n % 10;
            x *= num;
            y += num;

            n /= 10;
        }

        return x - y;
    }
}
