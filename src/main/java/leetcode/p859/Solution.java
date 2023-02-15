package leetcode.p859;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/15
 */
public class Solution {

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int cnt = 0;
        int pre = -1;

        int[] map = new int[26];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                cnt++;
                if (cnt > 2) {
                    return false;
                } else if (cnt == 1) {
                    pre = i;
                } else {
                    if (s.charAt(pre) != goal.charAt(i) || s.charAt(i) != goal.charAt(pre)) {
                        return false;
                    }
                }
            }
            map[s.charAt(i) - 'a']++;
        }

        if (cnt == 2) {
            return true;
        } else if (cnt == 0) {
            for (int i = 0; i < 26; i++) {
                if (map[i] >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
