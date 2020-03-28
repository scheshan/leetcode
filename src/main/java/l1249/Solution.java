package l1249;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/28
 */
public class Solution {

    public String minRemoveToMakeValid(String s) {
        Set<Integer> set = new HashSet<>();

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                deque.addLast(i);
            } else if (ch == ')') {
                if (!deque.isEmpty()) {
                    int index = deque.removeLast();
                    set.add(index);
                    set.add(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '(' || s.charAt(i) == ')') && !set.contains(i)) {
                continue;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
