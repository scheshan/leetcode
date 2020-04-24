package l1165;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    public int calculateTime(String keyboard, String word) {
        int[] map = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            map[keyboard.charAt(i) - 'a'] = i;
        }

        int res = 0;
        int prev = 0;
        for (int i = 0; i < word.length(); i++) {
            res += Math.abs(map[word.charAt(i) - 'a'] - prev);
            prev = map[word.charAt(i) - 'a'];
        }
        return res;
    }
}
