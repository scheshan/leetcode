package leetcode.p344;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/20
 */
public class Solution {

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char ch = s[l];
            s[l] = s[r];
            s[r] = ch;
            l++;
            r--;
        }
    }
}
