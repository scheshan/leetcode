package leetcode.p1137;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/15
 */
public class Solution {

    public int tribonacci(int n) {
        if (n <= 1) {
            return n;
        } else if (n == 2) {
            return 1;
        }

        int n1 = 0;
        int n2 = 1;
        int n3 = 1;
        for (int i = 3; i <= n; i++) {
            int num = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = num;
        }
        return n3;
    }
}
