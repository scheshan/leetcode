package leetcode.p20;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/5
 */
public class Solution {

    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    deque.add(ch);
                    break;
                case ')':
                    if (!check(deque, '(')) {
                        return false;
                    }
                    break;
                case ']':
                    if (!check(deque, '[')) {
                        return false;
                    }
                    break;
                case '}':
                    if (!check(deque, '{')) {
                        return false;
                    }
                    break;
            }
        }

        return deque.isEmpty();
    }

    private boolean check(Deque<Character> deque, char ch) {
        if (deque.isEmpty()) {
            return false;
        }
        if (deque.getLast() != ch) {
            return false;
        }

        deque.removeLast();
        return true;
    }

    public static void main(String[] args) {
        new Solution().isValid("(){}}{");
    }
}
