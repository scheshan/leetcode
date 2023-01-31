package leetcode.p1160;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public int countCharacters(String[] words, String chars) {
        int[] count = count(chars);

        int res = 0;
        for (String word : words) {
            boolean valid = true;
            int[] c1 = count(word);

            for (int i = 0; i < 26; i++) {
                if (count[i] < c1[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                res += word.length();
            }
        }
        return res;
    }

    private int[] count(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }
}
