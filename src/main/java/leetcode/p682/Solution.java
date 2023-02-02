package leetcode.p682;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int calPoints(String[] operations) {
        Deque<Integer> deque = new ArrayDeque<>(operations.length);
        for (String op : operations) {
            switch (op) {
                case "C":
                    deque.removeLast();
                    break;
                case "D":
                    deque.addLast(deque.peekLast() << 1);
                    break;
                case "+":
                    int n1 = deque.removeLast();
                    int n2 = deque.removeLast();
                    deque.addLast(n2);
                    deque.addLast(n1);
                    deque.addLast(n1 + n2);
                    break;
                default:
                    deque.addLast(Integer.parseInt(op));
                    break;
            }
        }
        int res = 0;
        while (!deque.isEmpty()) {
            res += deque.removeLast();
        }
        return res;
    }
}
