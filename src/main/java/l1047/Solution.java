package l1047;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public String removeDuplicates(String S) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (!deque.isEmpty() && deque.peekLast() == ch) {
                deque.removeLast();
            } else {
                deque.addLast(ch);
            }
        }

        StringBuilder sb = new StringBuilder(deque.size());
        while(!deque.isEmpty()){
            sb.append(deque.removeFirst());
        }

        return sb.toString();
    }
}
