package interview.p04_12;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum, new HashMap<>());
    }

    private int dfs(TreeNode node, long cur, int targetSum, Map<Long, Integer> pre) {
        if (node == null) {
            return 0;
        }

        int res = 0;
        cur += node.val;
        if (cur == targetSum) {
            res++;
        }
        if (pre.containsKey(cur - targetSum)) {
            res += pre.get(cur - targetSum);
        }
        pre.put(cur, pre.getOrDefault(cur, 0) + 1);

        res += dfs(node.left, cur, targetSum, pre);
        res += dfs(node.right, cur, targetSum, pre);

        if (pre.get(cur) == 1) {
            pre.remove(cur);
        } else {
            pre.put(cur, pre.get(cur) - 1);
        }
        return res;
    }
}
