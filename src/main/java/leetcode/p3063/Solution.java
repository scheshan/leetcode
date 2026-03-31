package leetcode.p3063;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        while (head != null) {
            int cnt = map.getOrDefault(head.val, 0);
            map.put(head.val, ++cnt);
            head = head.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            tail.next = new ListNode(entry.getValue());
            tail = tail.next;
        }

        return dummy.next;
    }
}
