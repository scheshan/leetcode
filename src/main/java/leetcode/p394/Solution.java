package leetcode.p394;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public String decodeString(String s) {
        Deque<String> deque = new LinkedList<>();

        int ind = 0;
        while (ind < s.length()) {
            if (Character.isDigit(s.charAt(ind))) {
                int n = 0;
                while (ind < s.length() && Character.isDigit(s.charAt(ind))) {
                    n = n * 10 + s.charAt(ind++) - '0';
                }

                deque.addLast(String.valueOf(n));
            } else if (s.charAt(ind) == '[') {
                deque.addLast("[");
                ind++;
            } else if (s.charAt(ind) == ']') {
                List<String> list = new ArrayList<>();
                while (!deque.peekLast().equals("[")) {
                    list.add(deque.removeLast());
                }
                deque.removeLast();
                int n = Integer.valueOf(deque.removeLast());

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    for (int i = list.size() - 1; i >= 0; i--) {
                        sb.append(list.get(i));
                    }
                }
                deque.addLast(sb.toString());
                ind++;
            } else {
                int start = ind;
                while (ind < s.length() && s.charAt(ind) >= 'a' && s.charAt(ind) <= 'z') {
                    ind++;
                }
                deque.addLast(s.substring(start, ind));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }

        return sb.toString();
    }
}
