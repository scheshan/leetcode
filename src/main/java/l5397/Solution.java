package l5397;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/17
 */
public class Solution {

    public List<String> simplifiedFractions(int n) {
        Set<Double> visit = new HashSet<>();
        List<String> res = new LinkedList<>();

        for (double x = 1; x < n; x++) {
            for (double y = x + 1; y <= n; y++) {
                if (visit.contains(x / y)) {
                    continue;
                }
                visit.add(x / y);
                res.add((int) x + "/" + (int) y);
            }
        }

        return res;
    }
}
