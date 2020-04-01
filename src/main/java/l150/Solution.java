package l150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/1
 */
public class Solution {

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    deque.addLast(deque.removeLast() + deque.removeLast());
                    break;
                case "-":
                    deque.addLast(0 - deque.removeLast() + deque.removeLast());
                    break;
                case "*":
                    deque.addLast(deque.removeLast() * deque.removeLast());
                    break;
                case "/":
                    int x = deque.removeLast();
                    int y = deque.removeLast();
                    deque.addLast(y / x);
                    break;
                default:
                    deque.addLast(Integer.valueOf(token));
                    break;
            }
        }

        return deque.removeLast();
    }
}
