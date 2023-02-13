package leetcode.p159;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/13
 */
public class Solution {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        int l = 0;
        int r = 0;

        int res = 0;

        while (r < s.length()) {
            cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            r++;

            while (cnt.size() > 2) {
                int c = cnt.get(s.charAt(l));
                if (c == 1) {
                    cnt.remove(s.charAt(l));
                } else {
                    cnt.put(s.charAt(l), c - 1);
                }
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
