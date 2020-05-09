package l340;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/9
 */
public class Solution {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();

        int left = 0;
        int right = 0;
        int res = 0;

        while (right < s.length()) {
            count.compute(s.charAt(right), (key, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });

            if (count.size() <= k) {
                res = Math.max(res, right - left + 1);
            }

            right++;

            while (count.size() > k) {
                char ch = s.charAt(left++);
                int c = count.compute(ch, (key, v) -> --v);
                if (c == 0) {
                    count.remove(ch);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstringKDistinct("eceba", 2);
    }
}
