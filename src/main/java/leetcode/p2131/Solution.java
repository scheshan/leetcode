package leetcode.p2131;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/5
 */
public class Solution {

    public int longestPalindrome(String[] words) {
        Map<String, Integer> exist = new HashMap<>();
        Set<String> selfPalindrome = new HashSet<>();

        int res = 0;
        for (String word : words) {
            String str = reverse(word);
            if (exist.containsKey(str)) {
                int cnt = exist.get(str);
                if (cnt > 1) {
                    exist.put(str, cnt - 1);
                } else {
                    exist.remove(str);
                    selfPalindrome.remove(str);
                }
                res += word.length() << 1;
            } else {
                exist.put(word, exist.getOrDefault(word, 0) + 1);
                if (isPalindrome(word)) {
                    selfPalindrome.add(word);
                }
            }
        }

        if (selfPalindrome.size() > 0) {
            int max = 0;
            for (String str : selfPalindrome) {
                max = Math.max(max, str.length());
            }
            res += max;
        }
        return res;
    }

    private boolean isPalindrome(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    private String reverse(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[str.length() - i - 1] = str.charAt(i);
        }
        return new String(arr);
    }
}
