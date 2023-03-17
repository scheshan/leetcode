package leetcode.p388;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/17
 */
public class Solution {

    public int lengthLongestPath(String input) {
        Deque<Integer> deque = new ArrayDeque<>();
        int depth = 0;
        int res = 0;
        int curLength = 0;
        int ind = 0;

        while (ind < input.length()) {
            int d = 0;
            while (ind < input.length() && input.charAt(ind) == '\t') {
                ind++;
                d++;
            }

            int pre = ind;
            boolean isFile = false;
            while (ind < input.length() && input.charAt(ind) != '\n' && input.charAt(ind) != '\t') {
                if (input.charAt(ind) == '.') {
                    isFile = true;
                }
                ind++;
            }
            while (depth >= d && !deque.isEmpty()) {
                int preLength = deque.removeLast();
                curLength -= preLength;
                depth--;
            }

            int fileLength = ind - pre;
            if (deque.size() > 0) {
                fileLength++;
            }
            curLength += fileLength;
            deque.addLast(fileLength);
            depth = d;

            if (isFile) {
                res = Math.max(res, curLength);
            }

            if (ind < input.length() && input.charAt(ind) == '\n') {
                ind++;
            }
        }

        return res;
    }
}
