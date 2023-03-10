package leetcode.p886;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/7
 */
public class Solution {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            edges[dislike[0]].add(dislike[1]);
            edges[dislike[1]].add(dislike[0]);
        }

        int[] visit = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visit[i] == 0 && !dfs(i, edges, visit, 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int i, List<Integer>[] edges, int[] visit, int v) {
        if (visit[i] != 0) {
            return visit[i] == v;
        }

        visit[i] = v;
        List<Integer> edge = edges[i];
        for (int next : edge) {
            if (!dfs(next, edges, visit, -v)) {
                return false;
            }
        }

        return true;
    }
}
