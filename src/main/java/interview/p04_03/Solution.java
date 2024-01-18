package interview.p04_03;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/19
 */
public class Solution {

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }

        List<ListNode> nodes = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                ListNode n = new ListNode();
                n.val = node.val;

                tail.next = n;
                tail = n;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            nodes.add(dummy.next);
        }

        ListNode[] res = new ListNode[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            res[i] = nodes.get(i);
        }

        return res;
    }
}
