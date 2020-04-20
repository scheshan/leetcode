package l567;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/20
 */
public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.compute(s1.charAt(i), this::compute);
        }

        int left = 0;
        int right = 0;

        Map<Character, Integer> found = new HashMap<>();

        while (right < s2.length()) {
            char ch = s2.charAt(right);
            if (!map.containsKey(ch)) {
                found.clear();
                right++;
                left = right;
                continue;
            }

            found.compute(ch, this::compute);
            while (found.get(ch) > map.get(ch)) {
                found.compute(s2.charAt(left), (k, v) -> --v);
                left++;
            }

            if (right - left + 1 == s1.length()) {
                return true;
            }
            right++;
        }
        return false;
    }

    private Integer compute(Character key, Integer value) {
        if (value == null) {
            value = 0;
        }
        return ++value;
    }

    public static void main(String[] args) {
        boolean res = new Solution().checkInclusion("ky",
                "ainwkckifykxlribaypk");
        System.out.println(res);
    }
}
