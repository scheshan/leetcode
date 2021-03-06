package l392;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/10
 */
public class Solution {

    public boolean isSubsequence(String s, String t) {
        int left = 0;
        int right = 0;

        while (left < s.length() && right < t.length()) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
                right++;
            } else {
                right++;
            }
        }

        return left == s.length();
    }
}
