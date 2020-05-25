package l1456;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/25
 */
public class Solution {

    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int cur = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s, i)) {
                cur++;
            }
        }
        int res = cur;
        right = k;
        while (right < s.length()) {
            if (isVowel(s, right++)) {
                cur++;
            }
            if (isVowel(s, left++)) {
                cur--;
            }
            res = Math.max(res, cur);
        }
        return res;
    }

    private boolean isVowel(String s, int i) {
        char c = s.charAt(i);
        return c == 'a' || c == 'e' || c == 'i' | c == 'o' || c == 'u';
    }
}
