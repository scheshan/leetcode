package l1331;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/3
 */
public class Solution {

    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] clone = Arrays.copyOf(arr, arr.length);
        Arrays.sort(clone);

        int index = 0;
        for (int i = 0; i < clone.length; i++) {
            if (!map.containsKey(clone[i])) {
                map.put(clone[i], ++index);
            }
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = map.get(arr[i]);
        }

        return res;
    }
}
