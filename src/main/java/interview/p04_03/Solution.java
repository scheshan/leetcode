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
 * @date 2024/1/29
 */
public class Solution {

    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (tree != null) {
            queue.add(tree);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            ListNode dummy = new ListNode();
            ListNode tail = dummy;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                ListNode listNode = new ListNode(node.val);
                tail.next = listNode;
                tail = tail.next;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            list.add(dummy.next);
        }

        ListNode[] res = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
