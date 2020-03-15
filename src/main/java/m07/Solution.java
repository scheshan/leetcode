package m07;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2) {
        if (l1 >= r1 || l2 >= r2) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[l1]);

        int index = index(inorder, l2, r2, root.val);
        int leftSize = index - l2;
        int rightSize = r2 - index;

        root.left = build(preorder, inorder, l1 + 1, l1 + 1 + leftSize, l2, l2 + leftSize);
        root.right = build(preorder, inorder, l1 + 1 + leftSize, r1, l2 + leftSize + 1, r2);

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

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        new Solution().buildTree(preorder, inorder);
    }
}
