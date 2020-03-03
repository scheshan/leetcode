package l872;

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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();

        getLeafs(root1, l1);
        getLeafs(root2, l2);

        return l1.equals(l2);
    }

    private void getLeafs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            getLeafs(root.left, list);
            getLeafs(root.right, list);
        }
    }
}
