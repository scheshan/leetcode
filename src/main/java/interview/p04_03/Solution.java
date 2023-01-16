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
 * @date 2023/1/16
 */
public class Solution {

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return null;
        }

        List<ListNode> list = new ArrayList<ListNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                tail.next = new ListNode(node.val);
                tail = tail.next;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            list.add(dummy.next);
        }

        ListNode[] res = new ListNode[list.size()];
        list.toArray(res);

        return res;
    }
}
