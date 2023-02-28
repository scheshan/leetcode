package leetcode.p1376;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/28
 */
public class Solution {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] edge = new List[n];
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] < 0) {
                continue;
            }
            List<Integer> list = edge[manager[i]];
            if (list == null) {
                list = new ArrayList<>();
                edge[manager[i]] = list;
            }
            list.add(i);
        }

        return dfs(edge, headID, informTime);
    }

    private int dfs(List<Integer>[] edge, int i, int[] informTime) {
        int res = informTime[i];
        int nextTime = 0;
        List<Integer> list = edge[i];
        if (list != null) {
            for (int next : list) {
                nextTime = Math.max(nextTime, dfs(edge, next, informTime));
            }
        }

        return res + nextTime;
    }
}
