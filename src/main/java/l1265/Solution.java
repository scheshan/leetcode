package l1265;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
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
