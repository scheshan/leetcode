package leetcode.p1456;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int maxVowels(String s, int k) {
        int res = 0, l = 0, r = 0, cnt = 0;

        while (r < s.length()) {
            char ch = s.charAt(r++);
            if (isVowel(ch)) {
                cnt++;
            }
            if (r - l > k) {
                ch = s.charAt(l++);
                if (isVowel(ch)) {
                    cnt--;
                }
            }
            if (r - l == k) {
                res = Math.max(res, cnt);
            }
        }

        return res;
    }

    private boolean isVowel(char ch) {
        return ch == 'a'
                || ch == 'e'
                || ch == 'i'
                || ch == 'o'
                || ch == 'u';
    }
}
