package leetcode.p106;

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(postorder, 0, postorder.length - 1, 0, postorder.length - 1, map);
    }

    private TreeNode build(int[] postorder, int l1, int r1, int l2, int r2, Map<Integer, Integer> map) {
        if (l1 > r1) {
            return null;
        }

        TreeNode res = new TreeNode(postorder[r1]);
        int ind = map.get(res.val);

        res.left = build(postorder, l1, l1 + ind - l2 - 1, l2, ind - 1, map);
        res.right = build(postorder, l1 + ind - l2, r1 - 1, ind + 1, r2, map);

        return res;
    }
}
