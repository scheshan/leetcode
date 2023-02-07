package leetcode.p1604;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/7
 */
public class Solution {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            List<Integer> list = map.get(name);
            if (list == null) {
                list = new ArrayList<>();
                map.put(name, list);
            }
            list.add(parseTime(keyTime[i]));
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() < 3) {
                continue;
            }
            list.sort(Integer::compareTo);
            for (int i = 2; i < list.size(); i++) {
                if (list.get(i) <= list.get(i - 2) + 60) {
                    res.add(entry.getKey());
                    break;
                }
            }
        }
        res.sort(String::compareTo);
        return res;
    }

    private int parseTime(String time) {
        int res = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
        res *= 60;
        res += (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        return res;
    }
}
