package l5389;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> tableMap = new TreeMap<>();
        Set<String> foods = new TreeSet<>();

        for (List<String> order : orders) {
            Integer table = Integer.valueOf(order.get(1));
            String food = order.get(2);

            foods.add(food);
            Map<String, Integer> map = tableMap.get(table);
            if (map == null) {
                map = new HashMap<>();
                tableMap.put(table, map);
            }

            map.compute(food, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        List<List<String>> res = new LinkedList<>();
        int rowSize = foods.size() + 1;
        List<String> head = new ArrayList<>(rowSize);
        head.add("Table");
        for (String food : foods) {
            head.add(food);
        }
        res.add(head);

        for (Map.Entry<Integer, Map<String, Integer>> tableEntry : tableMap.entrySet()) {
            List<String> row = new ArrayList<>(rowSize);
            row.add(tableEntry.getKey().toString());

            for (String food : foods) {
                if (tableEntry.getValue().containsKey(food)) {
                    row.add(tableEntry.getValue().get(food).toString());
                } else {
                    row.add("0");
                }
            }
            res.add(row);
        }

        return res;
    }
}
