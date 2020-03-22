package l682;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int calPoints(String[] ops) {
        int res = 0;

        Deque<Integer> deque = new LinkedList<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int x = deque.pop();
                int y = deque.pop();

                res += x + y;

                deque.push(y);
                deque.push(x);
                deque.push(x + y);
            } else if (op.equals("D")) {
                int x = deque.peek() * 2;

                res += x;

                deque.push(x);
            } else if (op.equals("C")) {
                int x = deque.pop();
                res -= x;
            } else {
                int x = Integer.parseInt(op);
                res += x;
                deque.push(x);
            }
        }

        return res;
    }
}
