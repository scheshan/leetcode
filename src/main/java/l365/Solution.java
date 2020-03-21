package l365;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    private class Tuple {
        int x;

        int y;

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return x == tuple.x &&
                    y == tuple.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean canMeasureWater(int x, int y, int z) {
        Set<Tuple> set = new HashSet<>();

        Queue<Tuple> queue = new LinkedList<>();
        addQueue(queue, set, new Tuple(0, 0));
        while (!queue.isEmpty()) {
            Tuple t = queue.remove();

            if (t.x == z || t.y == z || t.x + t.y == z) {
                return true;
            }

            if (t.x == 0 && t.y == 0) {
                addQueue(queue, set, new Tuple(0, y));
                addQueue(queue, set, new Tuple(x, 0));
                addQueue(queue, set, new Tuple(x, y));
                continue;
            }

            //倒左边
            if (t.x > 0) {
                //清空
                addQueue(queue, set, new Tuple(0, t.y));

                //倒右边
                int right = Math.min(t.x + t.y, y);
                addQueue(queue, set, new Tuple(t.x + t.y - right, right));
            } else {
                addQueue(queue, set, new Tuple(x, t.y));
            }

            //倒右边
            if (t.y > 0) {
                //清空
                addQueue(queue, set, new Tuple(t.x, 0));

                //倒左边
                int left = Math.min(t.x + t.y, x);
                addQueue(queue, set, new Tuple(left, t.x + t.y - left));
            } else {
                addQueue(queue, set, new Tuple(t.x, y));
            }
        }

        return false;
    }

    private void addQueue(Queue<Tuple> queue, Set<Tuple> set, Tuple tuple) {
        if (!set.contains(tuple)) {
            queue.add(tuple);
            set.add(tuple);
        }
    }
}
