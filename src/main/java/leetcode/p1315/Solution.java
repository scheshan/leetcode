package leetcode.p1315;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public int sumEvenGrandparent(TreeNode root) {
        return sum(root, 0, 0);
    }

    private int sum(TreeNode node, int parent, int grandpa) {
        if (node == null) {
            return 0;
        }

        int res = grandpa > 0 && (grandpa & 1) == 0 ? node.val : 0;
        res += sum(node.left, node.val, parent);
        res += sum(node.right, node.val, parent);

        return res;
    }
}
