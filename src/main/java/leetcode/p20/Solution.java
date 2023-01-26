package leetcode.p20;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                deque.addLast(ch);
            } else if (ch == ')') {
                if (!deque.isEmpty() && deque.peekLast() == '(') {
                    deque.removeLast();
                } else {
                    return false;
                }
            } else if (ch == ']') {
                if (!deque.isEmpty() && deque.peekLast() == '[') {
                    deque.removeLast();
                } else {
                    return false;
                }
            } else if (ch == '}') {
                if (!deque.isEmpty() && deque.peekLast() == '{') {
                    deque.removeLast();
                } else {
                    return false;
                }
            }
        }
        return deque.size() == 0;
    }
}
