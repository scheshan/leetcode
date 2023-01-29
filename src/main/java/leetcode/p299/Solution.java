package leetcode.p299;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public String getHint(String secret, String guess) {
        int[] map = new int[10];
        int a = 0, b = 0;

        for (int i = 0; i < secret.length(); i++) {
            map[secret.charAt(i) - '0']++;
        }
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                map[guess.charAt(i) - '0']--;
                a++;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                if (map[guess.charAt(i) - '0'] > 0) {
                    b++;
                    map[guess.charAt(i) - '0']--;
                }
            }
        }

        return String.format("%sA%sB", a, b);
    }
}
