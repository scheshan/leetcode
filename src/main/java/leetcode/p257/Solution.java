package leetcode.p257;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        travel(root, res, new LinkedList<>());

        return res;
    }

    private void travel(TreeNode node, List<String> res, Deque<TreeNode> path) {
        if (node == null) {
            return;
        }

        path.addLast(node);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();

            for (TreeNode n : path) {
                if (sb.length() > 0) {
                    sb.append("->");
                }
                sb.append(n.val);
            }
            res.add(sb.toString());
        } else {
            travel(node.left, res, path);
            travel(node.right, res, path);
        }
        path.removeLast();
    }
}
