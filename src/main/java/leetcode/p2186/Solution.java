package leetcode.p2186;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public int minSteps(String s, String t) {
        int[] c1 = new int[26];

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res++;
            c1[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            int ind = t.charAt(i) - 'a';
            if (c1[ind] > 0) {
                c1[ind]--;
                res--;
            } else {
                res++;
            }
        }

        return res;
    }
}
