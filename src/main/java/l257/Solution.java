package l257;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/10
 */
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        List<String> result = new LinkedList<>();

        perm(root, list, result);

        return result;
    }

    private void perm(TreeNode node, LinkedList<TreeNode> list, List<String> result) {
        if (node == null) {
            return;
        }

        list.add(node);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (TreeNode item : list) {
                if (sb.length() > 0) {
                    sb.append("->");
                }
                sb.append(item.val);
            }
            result.add(sb.toString());
        } else {
            perm(node.left, list, result);
            perm(node.right, list, result);
        }

        list.removeLast();
    }
}
