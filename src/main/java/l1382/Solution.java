package l1382;

import shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/26
 */
public class Solution {

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        travel(root, nodes);

        return build(nodes, 0, nodes.size() - 1);
    }

    private void travel(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        travel(node.left, nodes);

        nodes.add(node);

        travel(node.right, nodes);
    }

    private TreeNode build(List<TreeNode> nodes, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode node = nodes.get(mid);
        node.left = build(nodes, left, mid - 1);
        node.right = build(nodes, mid + 1, right);
        return node;
    }
}
