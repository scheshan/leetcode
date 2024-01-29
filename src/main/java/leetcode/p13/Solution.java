package leetcode.p13;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int romanToInt(String s) {
        int res = 0, ind = 0;

        while (ind < s.length()) {
            char ch = s.charAt(ind++);
            if (ch == 'M') {
                res += 1000;
            } else if (ch == 'D') {
                res += 500;
            } else if (ch == 'C') {
                if (ind < s.length() && s.charAt(ind) == 'D') {
                    res += 400;
                    ind++;
                } else if (ind < s.length() && s.charAt(ind) == 'M') {
                    res += 900;
                    ind++;
                } else {
                    res += 100;
                }
            } else if (ch == 'L') {
                res += 50;
            } else if (ch == 'X') {
                if (ind < s.length() && s.charAt(ind) == 'L') {
                    res += 40;
                    ind++;
                } else if (ind < s.length() && s.charAt(ind) == 'C') {
                    res += 90;
                    ind++;
                } else {
                    res += 10;
                }
            } else if (ch == 'V') {
                res += 5;
            } else {
                if (ind < s.length() && s.charAt(ind) == 'X') {
                    res += 9;
                    ind++;
                } else if (ind < s.length() && s.charAt(ind) == 'V') {
                    res += 4;
                    ind++;
                } else {
                    res++;
                }
            }
        }

        return res;
    }
}
