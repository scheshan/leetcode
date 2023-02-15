package leetcode.p1086;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/15
 */
public class Solution {

    public int[][] highFive(int[][] items) {
        Map<Integer, int[]> map = new TreeMap<>();
        for (int[] item : items) {
            int[] arr = map.get(item[0]);
            if (arr == null) {
                arr = new int[5];
                Arrays.fill(arr, Integer.MIN_VALUE);
                map.put(item[0], arr);
            }

            for (int i = 4; i >= 0; i--) {
                if (arr[i] < item[1]) {
                    if (i == 4) {
                        arr[i] = item[1];
                    } else {
                        swap(arr, i, i + 1);
                    }
                } else {
                    break;
                }
            }
        }

        int[][] res = new int[map.size()][2];
        int ind = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int sum = 0;
            for (int p : entry.getValue()) {
                sum += p;
            }
            res[ind][0] = entry.getKey();
            res[ind][1] = sum / 5;
            ind++;
        }
        return res;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
