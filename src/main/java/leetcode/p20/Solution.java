package leetcode.p20;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                deque.addLast(ch);
            } else if (ch == ')') {
                if (deque.isEmpty() || deque.removeLast() != '(') {
                    return false;
                }
            } else if (ch == ']') {
                if (deque.isEmpty() || deque.removeLast() != '[') {
                    return false;
                }
            } else {
                if (deque.isEmpty() || deque.removeLast() != '{') {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }
}
