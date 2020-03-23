package l386;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new LinkedList<>();

        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(0);

        while (!deque.isEmpty()) {
            int num = deque.removeFirst();

            if (num > 0) {
                res.add(num);
            }

            num *= 10;
            for (int i = 9; i >= 0; i--) {
                if (num + i > 0 && num + i <= n) {
                    deque.addFirst(num + i);
                }
            }
        }


        return res;
    }

    public static void main(String[] args) {
        new Solution().lexicalOrder(13);
    }
}
