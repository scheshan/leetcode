package leetcode.p150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/20
 */
public class Solution {

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();

        for (String token : tokens) {
            int x, y;
            switch (token) {
                case "+":
                    y = deque.removeLast();
                    x = deque.removeLast();
                    deque.addLast(x + y);
                    break;
                case "-":
                    y = deque.removeLast();
                    x = deque.removeLast();
                    deque.addLast(x - y);
                    break;
                case "*":
                    y = deque.removeLast();
                    x = deque.removeLast();
                    deque.addLast(x * y);
                    break;
                case "/":
                    y = deque.removeLast();
                    x = deque.removeLast();
                    deque.addLast(x / y);
                    break;
                default:
                    deque.addLast(Integer.valueOf(token));
                    break;
            }
        }

        return deque.removeLast();
    }
}
