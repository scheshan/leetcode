package leetcode.p1634;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    class PolyNode {
        int coefficient, power;
        PolyNode next = null;

        PolyNode() {
        }

        PolyNode(int x, int y) {
            this.coefficient = x;
            this.power = y;
        }

        PolyNode(int x, int y, PolyNode next) {
            this.coefficient = x;
            this.power = y;
            this.next = next;
        }
    }

    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode dummy = new PolyNode(0, 0);
        PolyNode tail = dummy;

        while (poly1 != null && poly2 != null) {
            if (poly1.power == poly2.power) {
                poly1.coefficient += poly2.coefficient;
                if (poly1.coefficient != 0) {
                    tail.next = poly1;
                    tail = poly1;
                }
                poly1 = poly1.next;
                poly2 = poly2.next;
            } else if (poly1.power > poly2.power) {
                tail.next = poly1;
                tail = poly1;
                poly1 = poly1.next;
            } else {
                tail.next = poly2;
                tail = poly2;
                poly2 = poly2.next;
            }
        }

        tail.next = poly1;
        if (poly2 != null) {
            tail.next = poly2;
        }
        return dummy.next;
    }
}
