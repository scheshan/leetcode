package l344;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;

        while (l < r) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;

            l++;
            r--;
        }
    }
}
