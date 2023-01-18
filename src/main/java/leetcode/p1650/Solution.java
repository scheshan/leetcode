package leetcode.p1650;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Integer> visit = new HashSet<>();
        while (p != null || q != null) {
            if (p != null) {
                if (visit.contains(p.val)) {
                    return p;
                }
                visit.add(p.val);
                p = p.parent;
            }
            if (q != null) {
                if (visit.contains(q.val)) {
                    return q;
                }
                visit.add(q.val);
                q = q.parent;
            }
        }
        return null;
    }
}
