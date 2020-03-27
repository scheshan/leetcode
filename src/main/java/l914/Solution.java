package l914;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/27
 */
public class Solution {

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            map.compute(num, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        int prev = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (prev == 0) {
                prev = entry.getValue();
            } else {
                prev = gcd(prev, entry.getValue());
            }
        }

        return prev >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }

    public static void main(String[] args) {
        new Solution().hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1});
    }
}
