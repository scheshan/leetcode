package leetcode.p224;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/18
 */
public class Solution {

    public int calculate(String s) {
        Deque<String> deque = new LinkedList<>();

        int ind = 0, sign = 1, cur = 0;
        while (ind < s.length()) {
            char ch = s.charAt(ind++);
            if (ch == ' ') {
                continue;
            } else if (ch == '(') {
                deque.addLast(String.valueOf(sign));
                deque.addLast("(");
                sign = 1;
            } else if (ch == ')') {
                int sum = 0;
                while (!deque.isEmpty() && !deque.peekLast().equals("(")) {
                    sum += Integer.parseInt(deque.removeLast());
                }
                deque.removeLast();
                sum *= Integer.parseInt(deque.removeLast());
                deque.addLast(String.valueOf(sum));
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else {
                cur = ch - '0';
                while (ind < s.length() && s.charAt(ind) >= '0' && s.charAt(ind) <= '9') {
                    cur = cur * 10 + (s.charAt(ind++) - '0');
                }
                deque.addLast(String.valueOf(sign * cur));
            }
        }

        int res = 0;
        while (!deque.isEmpty()) {
            res += Integer.parseInt(deque.removeLast());
        }

        return sign * res;
    }
}
