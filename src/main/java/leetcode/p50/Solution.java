package leetcode.p50;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    public double myPow(double x, int n) {
        if (x == 1 || x == 0) {
            return x;
        }
        if (x == -1) {
            return (n & 1) == 0 ? 1 : -1;
        }

        Map<Integer, Double> visit = new HashMap<>();
        visit.put(0, 1.0);
        visit.put(1, x);
        visit.put(-1, 1 / x);

        return pow(x, n, visit);
    }

    private double pow(double x, int n, Map<Integer, Double> visit) {
        if (visit.containsKey(n)) {
            return visit.get(n);
        }

        double res = pow(x, n >> 1, visit);
        if (n - (n >> 1) != 0) {
            res = res * pow(x, n - (n >> 1), visit);
        }
        visit.put(n, res);
        return res;
    }
}
