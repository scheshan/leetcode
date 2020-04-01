package l454;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/1
 */
public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                map.compute(A[i] + B[j], (k, v) -> {
                    if (v == null) {
                        v = 0;
                    }
                    return ++v;
                });
            }
        }

        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                res += map.getOrDefault(0 - C[i] - D[j], 0);
            }
        }

        return res;
    }
}
