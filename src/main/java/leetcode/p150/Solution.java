package leetcode.p150;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    deque.addLast(deque.removeLast() + deque.removeLast());
                    break;
                case "*":
                    deque.addLast(deque.removeLast() * deque.removeLast());
                    break;
                case "-":
                    int n2 = deque.removeLast();
                    int n1 = deque.removeLast();
                    deque.addLast(n1 - n2);
                    break;
                case "/":
                    int n4 = deque.removeLast();
                    int n3 = deque.removeLast();
                    deque.addLast(n3 / n4);
                    break;
                default:
                    deque.addLast(Integer.parseInt(token));
                    break;
            }
        }
        return deque.removeLast();
    }

    public static void main(String[] args) {
        new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"});
    }
}
