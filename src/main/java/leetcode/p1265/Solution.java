package leetcode.p1265;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) {
            return;
        }

        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}
