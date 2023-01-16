package leetcode.p1265;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    interface ImmutableListNode {
        public void printValue(); // print the value of this node.

        public ImmutableListNode getNext(); // return the next node.
    }

    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) {
            return;
        }

        printLinkedListInReverse(head.getNext());

        head.printValue();
    }
}
