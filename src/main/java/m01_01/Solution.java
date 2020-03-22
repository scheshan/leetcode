package m01_01;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < astr.length(); i++) {
            if (set.contains(astr.charAt(i))) {
                return false;
            }
            set.add(astr.charAt(i));
        }

        return true;
    }
}
