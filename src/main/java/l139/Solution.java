package l139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> visited = new HashSet<>();
        return perm(s, 0, wordDict, visited);
    }

    private boolean perm(String s, int i, List<String> words, Set<String> visited) {
        if (s.length() == i) {
            return true;
        }

        if (i > 0) {
            if (visited.contains(s.substring(0, i))) {
                return false;
            }
            visited.add(s.substring(0, i));
        }
        visited.add(s.substring(0, i));

        for (String word : words) {
            if (eq(s, i, word)) {
                if (perm(s, i + word.length(), words, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean eq(String s, int i, String word) {
        if (word.length() > s.length() - i) {
            return false;
        }

        for (int j = 0; j < word.length(); j++) {
            if (s.charAt(i + j) != word.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
