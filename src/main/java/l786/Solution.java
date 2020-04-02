package l786;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/2
 */
public class Solution {

    private class Pair {

        int p;

        int q;

        double value;

        public Pair(int p, int q) {
            this.p = p;
            this.q = q;

            value = 1.0 * p / q;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(K, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Double.compare(o2.value, o1.value);
            }
        });

        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j < A.length; j++) {
                Pair p = new Pair(A[i], A[j]);
                if (queue.size() < K) {
                    queue.add(p);
                } else {
                    if (p.value < queue.peek().value) {
                        queue.remove();
                        queue.add(p);
                    }
                }
            }
        }

        return new int[]{queue.peek().p, queue.peek().q};
    }
}
