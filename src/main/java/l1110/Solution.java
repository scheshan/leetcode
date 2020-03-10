package l1110;

import shared.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/10
 */
public class Solution {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int n : to_delete) {
            set.add(n);
        }

        delNodes(root, result, true, set);

        return result;
    }

    private TreeNode delNodes(TreeNode root, List<TreeNode> result, boolean parentDeleted, Set<Integer> set) {
        if (root == null) {
            return null;
        }

        if (set.contains(root.val)) {
            root.left = delNodes(root.left, result, true, set);
            root.right = delNodes(root.right, result, true, set);
            return null;
        } else {
            if (parentDeleted) {
                result.add(root);
            }
            root.left = delNodes(root.left, result, false, set);
            root.right = delNodes(root.right, result, false, set);
            return root;
        }
    }
}
