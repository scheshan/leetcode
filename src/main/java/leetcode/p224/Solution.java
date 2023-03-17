package leetcode.p224;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/15
 */
public class Solution {

    public int calculate(String s) {
        Deque<Integer> num = new ArrayDeque<>();

        int res = 0;
        int sign = 1;
        int ind = 0;
        while (ind < s.length()) {
            switch (s.charAt(ind)) {
                case ' ':
                    ind++;
                    break;
                case '+':
                    sign = 1;
                    ind++;
                    break;
                case '-':
                    sign = -1;
                    ind++;
                    break;
                case '(':
                    num.addLast(res);
                    num.addLast(sign);
                    res = 0;
                    sign = 1;
                    ind++;
                    break;
                case ')':
                    int preSign = num.removeLast();
                    int preRes = num.removeLast();
                    res = preRes + preSign * res;
                    sign = 1;
                    ind++;
                    break;
                default:
                    int n = 0;
                    while (ind < s.length() && Character.isDigit(s.charAt(ind))) {
                        n = 10 * n + s.charAt(ind) - '0';
                        ind++;
                    }
                    res = res + sign * n;
                    break;
            }
        }

        return res;
    }
}
