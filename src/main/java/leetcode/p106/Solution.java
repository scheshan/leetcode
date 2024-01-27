package leetcode.p106;

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(postorder, inorder, 0, postorder.length, 0, inorder.length, map);
    }

    private TreeNode build(int[] postorder, int[] inorder, int l1, int r1, int l2, int r2, Map<Integer, Integer> map) {
        if (l1 >= r1) {
            return null;
        }

        TreeNode res = new TreeNode(postorder[r1 - 1]);

        int ind = map.get(res.val);
        res.left = build(postorder, inorder, l1, l1 + ind - l2, l2, ind, map);
        res.right = build(postorder, inorder, l1 + ind - l2, r1 - 1, ind + 1, r2, map);

        return res;
    }
}
