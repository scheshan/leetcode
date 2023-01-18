package leetcode.p942;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];

        int l = 0;
        int r = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                res[i] = l++;
            } else {
                res[i] = r--;
            }
        }
        res[res.length - 1] = l;

        return res;
    }
}
