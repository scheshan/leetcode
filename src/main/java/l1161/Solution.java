package l1161;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int maxLevel = -1;

        int curLevel = 0;

        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            curLevel++;

            List<TreeNode> list = queue;
            queue = new LinkedList<>();

            int sum = 0;
            for (TreeNode node : list) {
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (sum > max) {
                max = sum;
                maxLevel = curLevel;
            }
        }

        return maxLevel;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        new Solution().maxLevelSum(root);
    }
}
