package l1636;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2021/1/15
 */
public class Solution {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            countMap.compute(n, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        Item[] items = new Item[countMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            Item item = new Item();
            item.val = entry.getKey();
            item.count = entry.getValue();
            items[i++] = item;
        }

        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.count == o2.count) {
                    return o2.val - o1.val;
                }

                return o1.count - o2.count;
            }
        });

        int[] res = new int[nums.length];
        i = 0;
        for (Item item : items) {
            for (int j = 0; j < item.count; j++) {
                res[i++] = item.val;
            }
        }

        return res;
    }

    private class Item {

        int val;

        int count;
    }
}
