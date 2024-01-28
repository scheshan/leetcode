package leetcode.p872;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        travel(root1, l1);
        travel(root2, l2);

        return l1.equals(l2);
    }

    private void travel(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        travel(node.left, list);

        if (node.left == null && node.right == null) {
            list.add(node.val);
        }

        travel(node.right, list);
    }
}
