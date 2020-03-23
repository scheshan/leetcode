package l609;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] arr = path.split(" ");

            String directory = arr[0];
            for (int i = 1; i < arr.length; i++) {
                int ind = arr[i].indexOf('(');
                String file = directory + "/" + arr[i].substring(0, ind);

                String content = arr[i].substring(ind + 1);

                map.compute(content, (k, v) -> {
                    if (v == null) {
                        v = new LinkedList<>();
                    }
                    v.add(file);
                    return v;
                });
            }
        }

        List<List<String>> res = new ArrayList<>(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.add(entry.getValue());
            }
        }

        return res;
    }
}
