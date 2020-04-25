package l50;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }

        return pow(x, n);
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        double res = new Solution().myPow(2.00000, -2147483648);
        System.out.println(res);
    }
}
