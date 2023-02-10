package leetcode.p1008;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[l]);
        int mid = l + 1;
        while (mid <= r && preorder[mid] < node.val) {
            mid++;
        }
        node.left = build(preorder, l + 1, mid - 1);
        node.right = build(preorder, mid, r);
        return node;
    }
}
