package l1469;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/6/13
 */
public class Solution {

    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(res, root, false);

        return res;
    }

    private void dfs(List<Integer> res, TreeNode node, boolean flag) {
        if (node == null) {
            return;
        }

        if (flag) {
            res.add(node.val);
        }

        flag = node.left == null || node.right == null;
        dfs(res, node.left, flag);
        dfs(res, node.right, flag);
    }
}
