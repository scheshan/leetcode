package leetcode.p988;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, new ArrayList<>());
    }

    private String dfs(TreeNode node, List<Integer> path) {
        path.add(node.val);
        String res = null;
        if (node.left == null && node.right == null) {
            char[] arr = new char[path.size()];
            for (int i = 0; i < path.size(); i++) {
                arr[path.size() - i - 1] = (char) ('a' + path.get(i));
                res = new String(arr);
            }
        } else if (node.left != null && node.right != null) {
            String left = dfs(node.left, path);
            String right = dfs(node.right, path);
            if (left.compareTo(right) < 0) {
                res = left;
            } else {
                res = right;
            }
        } else {
            res = node.left == null ? dfs(node.right, path) : dfs(node.left, path);
        }
        path.remove(path.size() - 1);
        return res;
    }
}
