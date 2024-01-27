package leetcode.p71;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/27
 */
public class Solution {

    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();

        int ind = 0;
        while (ind < path.length()) {
            if (path.charAt(ind) == '/') {
                ind++;
            }

            int start = ind;
            while (ind < path.length() && path.charAt(ind) != '/') {
                ind++;
            }

            String name = path.substring(start, ind);
            if (name.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
            } else if (name.isEmpty() || name.equals(".")) {
                continue;
            } else {
                deque.addLast(name);
            }
        }

        if (deque.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append('/');
            sb.append(deque.removeFirst());
        }

        return sb.toString();
    }
}
