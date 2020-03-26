package l748;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/26
 */
public class Solution {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] license = toArray(licensePlate);

        String res = null;
        for (String word : words) {
            if (match(license, toArray(word))) {
                if (res == null || word.length() < res.length()) {
                    res = word;
                }
            }
        }

        return res;
    }

    private boolean match(int[] license, int[] word) {
        for (int i = 0; i < license.length; i++) {
            if (license[i] > word[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] toArray(String word) {
        int[] res = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int c = Character.toLowerCase(word.charAt(i)) - 'a';
            if (c >= 0 && c < 26) {
                res[c]++;
            }
        }

        return res;
    }
}
