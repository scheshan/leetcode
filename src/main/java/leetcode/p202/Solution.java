package leetcode.p202;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();

        while (n != 1) {
            if (visit.contains(n)) {
                return false;
            }
            visit.add(n);

            n = cal(n);
        }
        return true;
    }

    private int cal(int n) {
        int res = 0;
        while (n != 0) {
            int d = n % 10;
            res += d * d;
            n /= 10;
        }
        return res;
    }
}
