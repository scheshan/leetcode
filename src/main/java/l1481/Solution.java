package l1481;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/6/15
 */
public class Solution {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.compute(n, (key, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        List<int[]> list = new ArrayList<>(map.size());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        while (k > 0) {
            int[] item = list.get(list.size() - 1);
            k -= item[1];

            if (k >= 0) {
                list.remove(list.size() - 1);
            }
        }
        return list.size();
    }
}
