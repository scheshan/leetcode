package l145;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        travel(root, result);

        return result;
    }

    private void travel(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        travel(node.left, list);
        travel(node.right, list);

        list.add(node.val);
    }
}
