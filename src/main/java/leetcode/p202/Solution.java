package leetcode.p202;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Solution {

    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();
        while (n != 0) {
            int tmp = count(n);
            if (tmp == 1) {
                return true;
            }
            if (visit.contains(tmp)) {
                return false;
            }
            visit.add(tmp);
            n = tmp;
        }
        return true;
    }

    private int count(int num) {
        int res = 0;
        while (num > 0) {
            res += (num % 10) * (num % 10);
            num /= 10;
        }
        return res;
    }
}
