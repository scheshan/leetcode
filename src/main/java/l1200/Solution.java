package l1200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/4
 */
public class Solution {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> res = new LinkedList<>();

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int n = Math.abs(arr[i] - arr[i - 1]);

            if (n <= min) {
                if (n < min) {
                    min = n;
                    res.clear();
                }
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return res;
    }
}
