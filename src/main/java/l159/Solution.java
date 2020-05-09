package l159;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/9
 */
public class Solution {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> count = new HashMap<>();

        int left = 0;
        int right = 0;
        int res = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            count.compute(ch, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });

            if (count.size() <= 2) {
                res = Math.max(res, right - left + 1);
            }

            right++;

            while (count.size() > 2) {
                int num = count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                if (num == 1) {
                    count.remove(s.charAt(left));
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstringTwoDistinct("eceba");
    }
}
