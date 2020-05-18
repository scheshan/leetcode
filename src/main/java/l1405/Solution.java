package l1405;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/18
 */
public class Solution {

    public String longestDiverseString(int a, int b, int c) {
        Queue<Tuple> queue = new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o2.count - o1.count;
            }
        });

        addQueue(queue, new Tuple('a', a));
        addQueue(queue, new Tuple('b', b));
        addQueue(queue, new Tuple('c', c));

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Tuple first = queue.remove();
            if (sb.length() > 2 && sb.charAt(sb.length() - 1) == first.ch && sb.charAt(sb.length() - 2) == first.ch) {
                if (queue.isEmpty()) {
                    break;
                }

                Tuple second = queue.remove();
                sb.append(second.ch);
                second.count--;
                sb.append(first.ch);
                first.count--;
                addQueue(queue, second);
                addQueue(queue, first);
            } else {
                sb.append(first.ch);
                first.count--;
                addQueue(queue, first);
            }
        }

        return sb.toString();
    }

    private void addQueue(Queue<Tuple> queue, Tuple tuple) {
        if (tuple.count > 0) {
            queue.add(tuple);
        }
    }

    private class Tuple {

        char ch;

        int count;

        public Tuple(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        String res = new Solution().longestDiverseString(0, 2, 5);
        System.out.println(res);
    }
}
