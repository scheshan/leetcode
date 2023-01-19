package leetcode.p1171;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> nodeMap = new HashMap<>();

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int cnt = 0;

        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            cnt += head.val;
            if (cnt == 0) {
                nodeMap.clear();
                dummy.next = null;
                tail = dummy;
            } else {
                if (nodeMap.containsKey(cnt)) {
                    ListNode preNode = nodeMap.get(cnt);
                    ListNode tmp = preNode.next;
                    int tmpCount = cnt;
                    while (tmp != null) {
                        tmpCount += tmp.val;
                        nodeMap.remove(tmpCount);
                        tmp = tmp.next;
                    }

                    preNode.next = null;
                    tail = preNode;
                } else {
                    nodeMap.put(cnt, head);
                    tail.next = head;
                    tail = head;
                }
            }
            head = next;
        }
        return dummy.next;
    }
}
