package l105;

import shared.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, preorder.length, 0, inorder.length, indexMap);
    }

    private TreeNode build(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2, Map<Integer, Integer> indexMap) {
        if (l1 >= r1 || l2 >= r2) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[l1]);

        int index = indexMap.get(root.val);
        int leftSize = index - l2;

        root.left = build(preorder, inorder, l1 + 1, l1 + 1 + leftSize, l2, l2 + leftSize, indexMap);
        root.right = build(preorder, inorder, l1 + 1 + leftSize, r1, l2 + leftSize + 1, r2, indexMap);

        return root;
    }
}
