package l250;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    private int res = 0;

    public int countUnivalSubtrees(TreeNode root) {
        count(root);
        return res;
    }

    private boolean count(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            res++;
            return true;
        } else if (node.left == null) {
            if (count(node.right) && node.val == node.right.val) {
                res++;
                return true;
            }
            return false;
        } else if (node.right == null) {
            if (count(node.left) && node.val == node.left.val) {
                res++;
                return true;
            }
            return false;
        } else {
            boolean b1 = count(node.left);
            boolean b2 = count(node.right);
            if (b1 && b2 && node.val == node.left.val && node.val == node.right.val) {
                res++;
                return true;
            }
            return false;
        }
    }
}
