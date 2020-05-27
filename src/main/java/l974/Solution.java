package l974;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/27
 */
public class Solution {

    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int res = 0;
        for (int num : A) {
            sum += num;
            int key = (sum % K + K) % K;

            if (map.containsKey(key)) {
                res += map.get(key);
            }
            map.compute(key, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        return res;
    }
}
