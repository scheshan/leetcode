package l364;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/14
 */
public class Solution {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> sum = new ArrayList<>();

        travel(nestedList, 0, sum);
        if (sum.get(sum.size() - 1) == 0) {
            sum.remove(sum.size() - 1);
        }

        int res = 0;
        int level = 1;
        for (int i = sum.size() - 1; i >= 0; i--) {
            res += level * sum.get(i);

            level++;
        }
        return res;
    }

    private void travel(List<NestedInteger> list, int level, List<Integer> sum) {
        if (level == sum.size()) {
            sum.add(0);
        }

        for (NestedInteger i : list) {
            if (i.isInteger()) {
                sum.set(level, sum.get(level) + i.getInteger());
            }

            travel(i.getList(), level + 1, sum);
        }
    }
}
