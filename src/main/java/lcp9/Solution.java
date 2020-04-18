package lcp9;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int minJump(int[] jump) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.count, o2.count);
            }
        });
        boolean[] visited = new boolean[jump.length];
        Queue<Integer> exist = new LinkedList<>();
        for (int i = 1; i < jump.length; i++) {
            exist.add(i);
        }
        addQueue(queue, 0, 0, visited);

        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            int next = p.index + jump[p.index];
            if (next >= jump.length) {
                return p.count + 1;
            }

            addQueue(queue, next, p.count + 1, visited);
            while (!exist.isEmpty() && exist.peek() < p.index) {
                addQueue(queue, exist.remove(), p.count + 1, visited);
            }
        }
        return -1;
    }

    private void addQueue(Queue<Pair> queue, int i, int count, boolean[] visited) {
        if (visited[i]) {
            return;
        }

        Pair p = new Pair(i, count);
        queue.add(p);
        visited[i] = true;
    }

    private class Pair {

        private int index;

        private int count;

        public Pair(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
