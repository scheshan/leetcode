package leetcode.p71;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/9
 */
public class Solution {

    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();

        int ind = 0;
        while (ind < path.length()) {
            int pre = ind + 1;
            ind++;
            while (ind < path.length() && path.charAt(ind) != '/') {
                ind++;
            }
            String seg = path.substring(pre, ind);
            switch (seg) {
                case "":
                case ".":
                    break;
                case "..":
                    if (!deque.isEmpty()) {
                        deque.removeLast();
                    }
                    break;
                default:
                    deque.addLast(seg);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String seg : deque) {
            sb.append("/");
            sb.append(seg);
        }

        if (sb.length() == 0) {
            return "/";
        }
        return sb.toString();
    }
}
