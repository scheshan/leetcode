package leetcode.p105;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/27
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

        int value = preorder[l1];
        TreeNode res = new TreeNode(value);

        int ind = map.get(value);

        res.left = build(preorder, inorder, l1 + 1, l1 + ind - l2 + 1, l2, ind, map);
        res.right = build(preorder, inorder, l1 + ind - l2 + 1, r1, ind + 1, r2, map);
        return res;
    }
}
