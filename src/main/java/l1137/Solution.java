package l1137;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n < 3) {
            return 1;
        }

        int n1 = 0;
        int n2 = 1;
        int n3 = 1;

        for (int i = 3; i <= n; i++) {
            int sum = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = sum;
        }

        return n3;
    }
}
