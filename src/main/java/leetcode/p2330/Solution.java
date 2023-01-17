package leetcode.p2330;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public boolean makePalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        int cnt = 2;

        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                if (cnt > 0) {
                    cnt--;
                    l++;
                    r--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
