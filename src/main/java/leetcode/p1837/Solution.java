package leetcode.p1837;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/24
 */
public class Solution {

    public int sumBase(int n, int k) {
        int res = 0;

        while (n > 0) {
            res += n % k;
            n /= k;
        }

        return res;
    }
}
