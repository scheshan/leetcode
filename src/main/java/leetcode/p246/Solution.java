package leetcode.p246;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/10
 */
public class Solution {

    public boolean isStrobogrammatic(String num) {
        boolean res = true;
        int l = 0, r = num.length() - 1;
        while (l <= r && res) {
            char c1 = num.charAt(l);
            char c2 = num.charAt(r);

            switch (c1) {
                case '1':
                    res = c2 == '1';
                    break;
                case '6':
                    res = c2 == '9';
                    break;
                case '8':
                    res = c2 == '8';
                    break;
                case '9':
                    res = c2 == '6';
                    break;
                case '0':
                    res = c2 == '0';
                    break;
                default:
                    res = false;
                    break;
            }
            l++;
            r--;
        }
        return res;
    }
}
