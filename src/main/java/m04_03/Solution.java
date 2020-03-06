package m04_03;

import shared.ListNode;
import shared.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/6
 */
public class Solution {

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }

        List<ListNode> resultList = new LinkedList<>();

        List<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            List<TreeNode> tmp = queue;
            queue = new LinkedList<>();

            ListNode head = null;
            ListNode cur = null;

            for (TreeNode node : tmp) {
                if (head == null) {
                    head = new ListNode(node.val);
                    cur = head;
                } else {
                    cur.next = new ListNode(node.val);
                    cur = cur.next;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            resultList.add(head);
        }

        ListNode[] result = new ListNode[resultList.size()];
        int i = 0;
        for (ListNode head : resultList) {
            result[i++] = head;
        }

        return result;
    }
}
