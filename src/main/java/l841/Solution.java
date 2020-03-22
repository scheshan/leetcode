package l841;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        int visites = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int room = queue.remove();
            visites++;

            List<Integer> keys = rooms.get(room);
            for (int key : keys) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.add(key);
                }
            }
        }

        return visites == rooms.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList());
        rooms.add(Arrays.asList(0, 3));
        rooms.add(Arrays.asList(1));
        new Solution().canVisitAllRooms(rooms);
    }
}
