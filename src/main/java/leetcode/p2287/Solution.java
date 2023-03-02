package leetcode.p2287;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public int rearrangeCharacters(String s, String target) {
        int[] c1 = new int[26];
        for (int i = 0; i < target.length(); i++) {
            c1[target.charAt(i) - 'a']++;
        }
        int[] c2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c2[s.charAt(i) - 'a']++;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (c1[i] == 0) {
                continue;
            }

            res = Math.min(res, c2[i] / c1[i]);
        }

        return res;
    }
}
