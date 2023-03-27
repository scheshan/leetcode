package leetcode.p402;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/27
 */
public class Solution {

    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new ArrayDeque<>(num.length() - k);
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !deque.isEmpty() && deque.peekLast() > num.charAt(i)) {
                deque.removeLast();
                k--;
            }

            deque.addLast(num.charAt(i));
        }

        while (k > 0) {
            deque.removeLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            char ch = deque.removeFirst();
            if (ch == '0' && sb.length() == 0) {
                continue;
            }
            sb.append(ch);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
