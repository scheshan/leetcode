package leetcode.p339;

import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    public interface NestedInteger {
        // Constructor initializes an empty nested list.

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    int res;

    public int depthSum(List<NestedInteger> nestedList) {
        sum(nestedList, 1);
        return res;
    }

    private void sum(List<NestedInteger> nestedList, int level) {
        if (nestedList == null || nestedList.size() == 0) {
            return;
        }

        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                res += ni.getInteger() * level;
            } else {
                sum(ni.getList(), level + 1);
            }
        }
    }
}
