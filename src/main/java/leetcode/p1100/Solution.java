package leetcode.p1100;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int numKLenSubstrNoRepeats(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        int[] map = new int[26];
        int l = 0;
        int r = 0;
        int cnt = 0;
        int res = 0;
        while (r < s.length()) {
            int ind = s.charAt(r++) - 'a';
            map[ind]++;
            if (map[ind] == 1) {
                cnt++;
            }
            if (r - l < k) {
                continue;
            }

            if (cnt == k) {
                res++;
            }

            ind = s.charAt(l++) - 'a';
            map[ind]--;
            if (map[ind] == 0) {
                cnt--;
            }
        }
        return res;
    }
}
