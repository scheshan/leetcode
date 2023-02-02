package leetcode.p1455;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int isPrefixOfWord(String sentence, String searchWord) {
        int ind = 0;
        int l = 0;
        int r = 0;
        while (r < sentence.length()) {
            ind++;
            while (r < sentence.length() && sentence.charAt(r) != ' ') {
                r++;
            }

            if (isPrefix(sentence, l, r, searchWord)) {
                return ind;
            }
            r++;
            l = r;
        }
        return -1;
    }

    private boolean isPrefix(String str, int begin, int end, String searchWord) {
        if (end - begin < searchWord.length()) {
            return false;
        }

        boolean res = true;
        for (int i = 0; i < searchWord.length(); i++) {
            if (str.charAt(begin + i) != searchWord.charAt(i)) {
                res = false;
                break;
            }
        }
        return res;
    }
}
