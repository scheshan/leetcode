package leetcode.p1190;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/10
 */
public class Solution {

    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int depth = 0;
        Deque<Character> d1 = new ArrayDeque<>(s.length());
        Deque<Character> d2 = new ArrayDeque<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                depth++;
                d1.addLast(ch);
            } else if (ch == ')') {
                depth--;
                while (d1.peekLast() != '(') {
                    d2.addLast(d1.removeLast());
                }
                d1.removeLast();

                if (depth == 0) {
                    while (!d2.isEmpty()) {
                        sb.append(d2.removeFirst());
                    }
                } else {
                    while (!d2.isEmpty()) {
                        d1.addLast(d2.removeFirst());
                    }
                }
            } else {
                if (depth == 0) {
                    sb.append(ch);
                } else {
                    d1.addLast(ch);
                }
            }
        }

        return sb.toString();
    }
}
