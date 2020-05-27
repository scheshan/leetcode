package l1457;

import shared.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/27
 */
public class Solution {

    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(new HashSet<>(), root);
    }

    private int dfs(Set<Integer> set, TreeNode node) {
        if (node == null) {
            return 0;
        }

        boolean hasValue = set.contains(node.val);
        if (hasValue) {
            set.remove(node.val);
        } else {
            set.add(node.val);
        }

        int res = 0;
        if (node.left == null && node.right == null) {
            if (set.size() <= 1) {
                res = 1;
            }
        } else {
            res = dfs(set, node.left) + dfs(set, node.right);
        }

        if (hasValue) {
            set.add(node.val);
        } else {
            set.remove(node.val);
        }
        return res;
    }
}
