package l961;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int n : A) {
            if (set.contains(n)) {
                return n;
            }

            set.add(n);
        }

        return -1;
    }
}
