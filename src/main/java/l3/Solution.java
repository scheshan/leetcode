package l3;

import java.util.HashSet;
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

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(left++));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().lengthOfLongestSubstring("pwwkew");
        System.out.println(res);
    }
}
