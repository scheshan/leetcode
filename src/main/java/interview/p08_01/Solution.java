package interview.p08_01;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/4
 */
public class Solution {

    public int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }

        long n1 = 1;
        long n2 = 2;
        long n3 = 4;

        for (int i = 4; i <= n; i++) {
            long num = n1 + n2 + n3;
            num %= 1000000007;
            n1 = n2;
            n2 = n3;
            n3 = num;
        }
        return (int) n3;
    }
}
