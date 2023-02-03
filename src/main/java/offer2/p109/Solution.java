package offer2.p109;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public int openLock(String[] deadends, String target) {
        Set<String> visit = new HashSet<>();
        for (String dead : deadends) {
            visit.add(dead);
        }

        Queue<String> queue = new LinkedList<>();
        addQueue(queue, "0000", visit);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.remove();
                if (str.equals(target)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    addQueue(queue, incr(str, j, 1), visit);
                    addQueue(queue, incr(str, j, -1), visit);
                }
            }

            step++;
        }
        return -1;
    }

    private void addQueue(Queue<String> queue, String str, Set<String> visit) {
        if (visit.contains(str)) {
            return;
        }
        visit.add(str);
        queue.add(str);
    }

    private String incr(String str, int ind, int value) {
        char[] arr = str.toCharArray();
        arr[ind] += value;
        if (arr[ind] < '0') {
            arr[ind] = '9';
        }
        if (arr[ind] > '9') {
            arr[ind] = '0';
        }
        return new String(arr);
    }
}
