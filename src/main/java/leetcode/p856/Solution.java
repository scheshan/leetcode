package leetcode.p856;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/1
 */
public class Solution {

    public int scoreOfParentheses(String s) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                deque.addLast(-1);
            } else {
                int n = 0;
                if (deque.peekLast() < 0) {
                    n = 1;
                    deque.removeLast();
                    deque.addLast(n);
                } else {
                    while (deque.peekLast() > 0) {
                        n += deque.removeLast();
                    }
                    deque.removeLast();
                    deque.addLast(n * 2);
                }
            }
        }

        int res = 0;
        while (!deque.isEmpty()) {
            res += deque.removeLast();
        }

        return res;
    }
}
