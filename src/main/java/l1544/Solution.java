package l1544;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/9/30
 */
public class Solution {

    public String makeGood(String s) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!deque.isEmpty() && (deque.peekLast() ^ 32) == ch) {
                deque.removeLast();
            } else {
                deque.addLast(ch);
            }
        }

        StringBuilder sb = new StringBuilder(deque.size());
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}
