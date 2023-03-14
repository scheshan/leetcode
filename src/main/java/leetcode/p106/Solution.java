package leetcode.p106;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/14
 */
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }

    private TreeNode build(int[] inorder, int[] postorder, int b1, int e1, int b2, int e2, Map<Integer, Integer> map) {
        if (b2 > e2) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[e2]);
        int mid = map.get(node.val);
        int leftCount = mid - b1;
        node.left = build(inorder, postorder, b1, mid - 1, b2, b2 + leftCount - 1, map);
        node.right = build(inorder, postorder, mid + 1, e1, b2 + leftCount, e2 - 1, map);
        return node;
    }
}
