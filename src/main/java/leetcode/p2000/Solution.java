package leetcode.p2000;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public String reversePrefix(String word, char ch) {
        int ind = 0;
        while (ind < word.length()) {
            if (word.charAt(ind) == ch) {
                break;
            }
            ind++;
        }

        if (ind >= word.length()) {
            return word;
        }

        StringBuilder res = new StringBuilder(word.length());
        for (int i = ind; i >= 0; i--) {
            res.append(word.charAt(i));
        }
        for (int i = ind + 1; i < word.length(); i++) {
            res.append(word.charAt(i));
        }
        return res.toString();
    }
}
