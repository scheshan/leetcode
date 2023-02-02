package leetcode.p1331;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int[] arrayRankTransform(int[] arr) {
        int[] sort = new int[arr.length];
        System.arraycopy(arr, 0, sort, 0, arr.length);
        Arrays.sort(sort);

        Map<Integer, Integer> map = new HashMap<>();
        int ind = 1;
        for (int i = 0; i < sort.length; i++) {
            if (!map.containsKey(sort[i])) {
                map.put(sort[i], ind);
                ind++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
