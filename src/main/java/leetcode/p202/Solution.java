package leetcode.p202;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/23
 */
public class Solution {

    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();
        visit.add(n);

        while (n != 1) {
            n = cal(n);
            if (visit.contains(n)) {
                return false;
            }
            visit.add(n);
        }

        return true;
    }

    private int cal(int num) {
        int res = 0;

        while (num != 0) {
            int n = num % 10;
            res += n * n;
            num /= 10;
        }

        return res;
    }
}
