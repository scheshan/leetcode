package m48;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/19
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 1;

        int left = 0;
        int right = 1;

        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (!set.contains(ch)) {
                set.add(ch);
                result = Math.max(result, right - left + 1);
                right++;
            } else {
                while (s.charAt(left) != ch) {
                    set.remove(s.charAt(left));
                    left++;
                }

                set.remove(s.charAt(left));
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("abcabcbb");
    }
}
