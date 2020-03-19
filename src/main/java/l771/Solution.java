package l771;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/19
 */
public class Solution {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }

        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (set.contains(ch)) {
                result++;
            }
        }

        return result;
    }
}
