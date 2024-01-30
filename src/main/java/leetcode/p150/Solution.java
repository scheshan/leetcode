package leetcode.p150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    deque.addLast(deque.removeLast() + deque.removeLast());
                    break;
                case "-":
                    deque.addLast(-deque.removeLast() + deque.removeLast());
                    break;
                case "*":
                    deque.addLast(deque.removeLast() * deque.removeLast());
                    break;
                case "/":
                    int num = deque.removeLast();
                    deque.addLast(deque.removeLast() / num);
                    break;
                default:
                    deque.addLast(Integer.valueOf(token));
                    break;
            }
        }

        return deque.removeLast();
    }
}
