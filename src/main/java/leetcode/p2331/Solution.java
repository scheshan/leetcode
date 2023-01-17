package leetcode.p2331;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public boolean evaluateTree(TreeNode root) {
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else if(root.val == 3) {
            return evaluateTree(root.left) && evaluateTree(root.right);
        } else {
            return root.val == 1;
        }
    }
}
