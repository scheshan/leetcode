package leetcode.p1742;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public int countBalls(int lowLimit, int highLimit) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int j = cal(i);
            int c = map.getOrDefault(j, 0) + 1;
            if (c > res) {
                res = c;
            }
            map.put(j, c);
        }
        return res;
    }

    private int cal(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}
