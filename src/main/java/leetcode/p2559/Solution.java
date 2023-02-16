package leetcode.p2559;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/17
 */
public class Solution {

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] pre = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                pre[i + 1] = pre[i] + 1;
            } else {
                pre[i + 1] = pre[i];
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            int[] query = queries[i];
            res[i] = pre[query[1] + 1] - pre[query[0]];
        }
        return res;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
