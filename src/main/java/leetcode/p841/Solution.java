package leetcode.p841;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visit = new boolean[rooms.size()];
        int total = rooms.size();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visit[0] = true;

        while (!queue.isEmpty()) {
            int n = queue.remove();
            total--;

            List<Integer> edge = rooms.get(n);
            for (Integer next : edge) {
                if (!visit[next]) {
                    visit[next] = true;
                    queue.add(next);
                }
            }
        }

        return total == 0;
    }
}
