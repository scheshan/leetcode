package leetcode.p399;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> edges = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            getEdge(edges, equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            getEdge(edges, equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
        }

        double[] res = new double[queries.size()];
        Set<String> visit = new HashSet<>();
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0), b = queries.get(i).get(1);
            Double d;
            if (edges.containsKey(a) && edges.containsKey(b)) {
                d = dfs(queries.get(i).get(0), queries.get(i).get(1), 1, edges, visit);
            } else {
                d = -1d;
            }
            res[i] = d != null ? d : -1;
            visit.clear();
        }

        return res;
    }

    private Double dfs(String a, String b, double cur, Map<String, Map<String, Double>> edges, Set<String> visit) {
        if (visit.contains(a)) {
            return null;
        }
        visit.add(a);
        if (Objects.equals(a, b)) {
            return cur;
        }

        for (Map.Entry<String, Double> entry : getEdge(edges, a).entrySet()) {
            Double next = dfs(entry.getKey(), b, cur * entry.getValue(), edges, visit);
            if (next != null) {
                return next;
            }
        }
        return null;
    }

    private Map<String, Double> getEdge(Map<String, Map<String, Double>> edges, String key) {
        Map<String, Double> res = edges.get(key);
        if (res == null) {
            res = new HashMap<>();
            edges.put(key, res);
        }
        return res;
    }
}
