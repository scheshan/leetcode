package leetcode.p1282;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (size == 1) {
                res.add(Arrays.asList(i));
            } else if (map.containsKey(size)) {
                List<Integer> list = map.get(size);
                list.add(i);

                if (list.size() == size) {
                    map.remove(size);
                    res.add(list);
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(size, list);
            }
        }
        return res;
    }
}
