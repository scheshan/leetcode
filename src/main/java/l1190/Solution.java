package l1190;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/1
 */
public class Solution {

    public String reverseParentheses(String s) {
        Deque<Character> deque = new LinkedList<>();
        Deque<Character> temp = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ')') {
                deque.addLast(s.charAt(i));
            } else {
                while (!deque.isEmpty()) {
                    char ch = deque.removeLast();
                    if (ch != '(') {
                        temp.addLast(ch);
                    } else {
                        break;
                    }
                }

                while (!temp.isEmpty()) {
                    deque.addLast(temp.removeFirst());
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}
