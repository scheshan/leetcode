package l930;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/1
 */
public class Solution {

    public int numSubarraysWithSum(int[] A, int S) {
        int[] prefix = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            prefix[i + 1] = prefix[i] + A[i];
        }

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int p : prefix) {
            int num = p - S;

            if (map.containsKey(num)) {
                res += map.get(num);
            }

            map.compute(p, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2);
    }
}
