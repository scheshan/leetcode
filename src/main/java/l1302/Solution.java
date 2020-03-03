package l1302;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            Queue<TreeNode> tmp = queue;
            queue = new LinkedList<>();

            int n = 0;
            for (TreeNode node : tmp) {
                n += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result = n;
        }

        return result;
    }

    public static void main(String[] args) {
        new Solution().deepestLeavesSum(new TreeNode(1));
    }
}
