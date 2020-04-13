package l687;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/13
 */
public class Solution {

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = singleWay(root.left, root.val) + singleWay(root.right, root.val);

        res = Math.max(res, longestUnivaluePath(root.left));
        res = Math.max(res, longestUnivaluePath(root.right));

        return res;
    }

    private int singleWay(TreeNode root, int v) {
        if (root == null || root.val != v) {
            return 0;
        }

        int res = 1;
        res += Math.max(singleWay(root.left, v), singleWay(root.right, v));
        return res;
    }
}
