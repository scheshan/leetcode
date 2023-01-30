package leetcode.p1165;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public int calculateTime(String keyboard, String word) {
        int[] map = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            map[keyboard.charAt(i) - 'a'] = i;
        }

        int res = 0;
        int cur = 0;
        for (int i = 0; i < word.length(); i++) {
            int next = map[word.charAt(i) - 'a'];
            res += Math.abs(next - cur);
            cur = next;
        }
        return res;
    }
}
