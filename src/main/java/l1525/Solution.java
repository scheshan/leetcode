package l1525;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/8/2
 */
public class Solution {

    public int numSplits(String s) {
        char[] left = new char[26];
        char[] right = new char[26];
        int l = 0;
        int r = 0;

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int ind = s.charAt(i) - 'a';
            if (right[ind] == 0) {
                r++;
            }
            right[ind]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int ind = s.charAt(i) - 'a';
            right[ind]--;
            if (right[ind] == 0) {
                r--;
            }
            if (left[ind] == 0) {
                l++;
            }
            left[ind]++;

            if (l == r) {
                res++;
            }
        }
        return res;
    }
}
