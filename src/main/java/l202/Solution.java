package l202;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/1
 */
public class Solution {

    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        return valid(n, visited);
    }

    private boolean valid(int n, Set<Integer> visited) {
        if (n == 1) {
            return true;
        }
        if (visited.contains(n)) {
            return false;
        }
        visited.add(n);

        int t = 0;
        while (n > 0) {
            t += (n % 10) * (n % 10);
            n /= 10;
        }

        return valid(t, visited);
    }

    public static void main(String[] args) {
        new Solution().isHappy(19);
    }
}
