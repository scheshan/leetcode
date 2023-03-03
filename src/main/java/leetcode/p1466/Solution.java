package leetcode.p1466;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/3
 */
public class Solution {

    public int minReorder(int n, int[][] connections) {
        List<Integer>[] in = new List[n];
        List<Integer>[] out = new List[n];
        for (int[] conn : connections) {
            addList(in, conn[1], conn[0]);
            addList(out, conn[0], conn[1]);
        }

        boolean[] visit = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        addQueue(0, queue, visit);

        int res = 0;
        while (!queue.isEmpty()) {
            int num = queue.remove();
            if (in[num] != null) {
                for (int next : in[num]) {
                    addQueue(next, queue, visit);
                }
            }
            if (out[num] != null) {
                for (int next : out[num]) {
                    if (addQueue(next, queue, visit)) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    private void addList(List<Integer>[] arr, int i, int j) {
        List<Integer> list = arr[i];
        if (list == null) {
            list = new ArrayList<>();
            arr[i] = list;
        }
        list.add(j);
    }

    private boolean addQueue(int i, Queue<Integer> queue, boolean[] visit) {
        if (visit[i]) {
            return false;
        }
        visit[i] = true;
        queue.add(i);
        return true;
    }
}
