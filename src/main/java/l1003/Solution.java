package l1003;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/1
 */
public class Solution {

    public boolean isValid(String S) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch != 'c') {
                deque.addLast(ch);
            } else {
                if (deque.isEmpty() || deque.peekLast() != 'b') {
                    return false;
                }
                deque.removeLast();
                if (deque.isEmpty() || deque.peekLast() != 'a') {
                    return false;
                }
                deque.removeLast();
            }
        }

        return deque.isEmpty();
    }
}
