package leetcode.p841;

import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/28
 */
public class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visit = new boolean[rooms.size()];
        return dfs(rooms, 0, visit) == rooms.size();
    }

    private int dfs(List<List<Integer>> rooms, int i, boolean[] visit) {
        if (visit[i]) {
            return 0;
        }

        int res = 1;
        visit[i] = true;
        List<Integer> edge = rooms.get(i);
        if (edge != null) {
            for (int next : edge) {
                res += dfs(rooms, next, visit);
            }
        }
        return res;
    }
}
