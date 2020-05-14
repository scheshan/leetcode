package l1430;

import shared.TreeNode;
import shared.Wrapper;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/14
 */
public class Solution {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }

    private boolean dfs(TreeNode node, int[] arr, int i) {
        if (node == null || i == arr.length || node.val != arr[i]) {
            return false;
        }

        if (node.left == null && node.right == null && i == arr.length - 1) {
            return true;
        }

        return dfs(node.left, arr, i + 1) || dfs(node.right, arr, i + 1);
    }

    public static void main(String[] args) {
        TreeNode root = Wrapper.stringToTreeNode("[8,3,null,2,1,5,4]");

        System.out.println(new Solution().isValidSequence(root, new int[]{8}));
    }
}
