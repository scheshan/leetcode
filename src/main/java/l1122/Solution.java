package l1122;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/31
 */
public class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr2) {
            map.put(num, 0);
        }

        for (int num : arr1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
        }

        int r = arr1.length - 1;
        for (int j = arr1.length - 1; j >= 0; j--) {
            if (!map.containsKey(arr1[j])) {
                arr1[r--] = arr1[j];
            }
        }

        Arrays.sort(arr1, r + 1, arr1.length);

        for (int j = arr2.length - 1; j >= 0; j--) {
            for (int i = 0; i < map.get(arr2[j]); i++) {
                arr1[r--] = arr2[j];
            }
        }

        return arr1;
    }

    public static void main(String[] args) {
        new Solution().relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6});
    }
}
