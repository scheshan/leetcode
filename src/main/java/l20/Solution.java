package l20;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                deque.push(ch);
            } else if (ch == ')') {
                if (deque.isEmpty() || deque.pop() != '(') {
                    return false;
                }
            } else if (ch == ']') {
                if (deque.isEmpty() || deque.pop() != '[') {
                    return false;
                }
            } else {
                if (deque.isEmpty() || deque.pop() != '{') {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }
}
