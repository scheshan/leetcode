package m32_1;

import shared.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/16
 */
public class Solution {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        LinkedList<Integer> list = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            list.addLast(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int[] result = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();

        for (int i = 0; i < result.length; i++) {
            result[i] = iterator.next();
        }

        return result;
    }
}
