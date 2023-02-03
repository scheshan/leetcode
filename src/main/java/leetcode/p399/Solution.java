package leetcode.p399;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    private class Item {
        String item;
        double value;

        public Item(String item, double value) {
            this.item = item;
            this.value = value;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Item>> edges = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            addEdge(edges, equations.get(i).get(0), equations.get(i).get(1), values[i]);
            addEdge(edges, equations.get(i).get(1), equations.get(i).get(0), 1 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = calc(edges, queries.get(i).get(0), queries.get(i).get(1));
        }
        return res;
    }

    private void addEdge(Map<String, List<Item>> edges, String x, String y, double value) {
        List<Item> list = edges.get(x);
        if (list == null) {
            list = new ArrayList<>();
            edges.put(x, list);
        }
        Item item = new Item(y, value);
        list.add(item);
    }

    private double calc(Map<String, List<Item>> edges, String x, String y) {
        if (!edges.containsKey(x) || !edges.containsKey(y)) {
            return -1;
        }
        if (x.equals(y)) {
            return 1;
        }

        Queue<Item> queue = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        queue.add(new Item(x, 1));
        visit.add(x);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Item item = queue.remove();

                List<Item> next = edges.get(item.item);
                if (next != null) {
                    for (Item n : next) {
                        if (visit.contains(n.item)) {
                            continue;
                        }
                        visit.add(n.item);

                        if (y.equals(n.item)) {
                            return item.value * n.value;
                        }
                        queue.add(new Item(n.item, item.value * n.value));
                    }
                }
            }
        }

        return -1.0;
    }
}
