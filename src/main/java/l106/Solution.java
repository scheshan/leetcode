package l106;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    private TreeNode build(int[] inorder, int[] postorder, int l1, int r1, int l2, int r2) {
        if (l1 >= r1 || l2 >= r2) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[r2 - 1]);
        int index = index(inorder, l1, r1, root.val);
        int leftSize = index - l1;

        root.left = build(inorder, postorder, l1, index, l2, l2 + leftSize);
        root.right = build(inorder, postorder, index + 1, r1, l2 + leftSize, r2 - 1);

        return root;
    }

    private int index(int[] arr, int l, int r, int target) {
        for (int i = l; i < r; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
