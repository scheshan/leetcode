package l690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/26
 */
public class Solution {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }

        return dfs(map, id);
    }

    private int dfs(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);

        int res = employee.importance;
        for (int subordinate : employee.subordinates) {
            res += dfs(map, subordinate);
        }

        return res;
    }
}
