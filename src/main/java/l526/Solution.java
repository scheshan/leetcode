package l526;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public int countArrangement(int N) {
        return perm(new HashSet<>(), 1, N);
    }

    private int perm(Set<Integer> visited, int i, int N) {
        if (i > N) {
            return 1;
        }

        int res = 0;

        for (int j = 1; j <= N; j++) {
            if (visited.contains(j)) {
                continue;
            }
            if (j % i != 0 && i % j != 0) {
                continue;
            }

            visited.add(j);
            res += perm(visited, i + 1, N);
            visited.remove(j);
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().countArrangement(2);
    }
}
