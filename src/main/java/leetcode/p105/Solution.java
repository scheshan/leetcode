package leetcode.p105;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, 0, preorder.length - 1, map);
    }

    private TreeNode build(int[] preorder, int l1, int r1, int l2, int r2, Map<Integer, Integer> map) {
        if (l1 > r1) {
            return null;
        }

        TreeNode res = new TreeNode(preorder[l1]);
        int ind = map.get(res.val);

        res.left = build(preorder, l1 + 1, l1 + ind - l2, l2, ind - 1, map);
        res.right = build(preorder, l1 + ind - l2 + 1, r1, ind + 1, r2, map);
        return res;
    }
}
