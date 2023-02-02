package leetcode.p2490;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public boolean isCircularSentence(String sentence) {
        int l = 0;
        int r = 0;

        while (r < sentence.length()) {
            if (r > 0 && sentence.charAt(r) != sentence.charAt(r - 2)) {
                return false;
            }

            while (r < sentence.length() && sentence.charAt(r) != ' ') {
                r++;
            }
            r++;
            l = r;
        }
        return sentence.charAt(sentence.length() - 1) == sentence.charAt(0);
    }
}
