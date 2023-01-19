package offer.p07;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length, 0, inorder.length, map);
    }

    private TreeNode build(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2, Map<Integer, Integer> map) {
        if (l1 >= r1) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[l1]);
        int ind = map.get(node.val);
        int leftSize = ind - l2;

        node.left = build(preorder, inorder, l1 + 1, l1 + 1 + leftSize, l2, ind, map);
        node.right = build(preorder, inorder, l1 + 1 + leftSize, r1, ind + 1, r2, map);
        return node;
    }
}
