package l451;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.compute(s.charAt(i), (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.size());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(entry);
        }

        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        char[] arr = new char[s.length()];
        int i = 0;

        for (Map.Entry<Character, Integer> entry : list) {
            for (int j = 0; j < entry.getValue(); j++) {
                arr[i++] = entry.getKey();
            }
        }

        return new String(arr);
    }
}
