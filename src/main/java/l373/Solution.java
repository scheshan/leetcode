package l373;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/31
 */
public class Solution {

    private class Pair {

        int x;

        int y;

        int sum;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;

            sum = x + y;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.sum - o1.sum;
            }
        });

        for (int n1 : nums1) {
            for (int n2 : nums2) {
                Pair p = new Pair(n1, n2);

                if (queue.size() < k) {
                    queue.add(p);
                } else {
                    if (p.sum < queue.peek().sum) {
                        queue.remove();
                        queue.add(p);
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>(k);
        for (Pair p : queue) {
            res.add(Arrays.asList(p.x, p.y));
        }

        return res;
    }
}
