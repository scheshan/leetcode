package l1461;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/6/13
 */
public class Solution {

    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }

        return set.size() == Math.pow(2, k);
    }
}
