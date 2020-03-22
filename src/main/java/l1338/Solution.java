package l1338;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.compute(n, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        List<Integer> list = new ArrayList<>(map.size());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        int res = 0;
        int total = 0;
        int i = 0;

        while (total < arr.length / 2) {
            total += list.get(i++);
            res++;
        }

        return res;
    }
}
