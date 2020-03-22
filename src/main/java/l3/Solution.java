package l3;

import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int res = 0;
        int left = 0;
        int right = 0;

        while (left < s.length() && right < s.length()) {
            if (set.contains(s.charAt(right))) {
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("abcabcbb");
    }
}
