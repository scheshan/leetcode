package l339;

import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/14
 */
public class Solution {

    public int depthSum(List<NestedInteger> nestedList) {
        return travel(nestedList, 1);
    }

    private int travel(List<NestedInteger> list, int level) {
        int res = 0;

        for (NestedInteger i : list) {
            if (i.isInteger()) {
                res += i.getInteger() * level;
            }

            res += travel(i.getList(), level + 1);
        }

        return res;
    }
}
