package l5374;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public String getHappyString(int n, int k) {
        Queue<String> queue = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        perm(queue, new StringBuilder(), n, k);
        if (queue.size() == k) {
            return queue.remove();
        } else {
            return "";
        }
    }

    private void perm(Queue<String> queue, StringBuilder sb, int n, int k) {
        if (sb.length() == n) {
            String str = sb.toString();
            if (queue.size() < k) {
                queue.add(str);
            } else {
                if (str.compareTo(queue.peek()) < 0) {
                    queue.remove();
                    queue.add(str);
                }
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            char ch = (char) ('a' + i);
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ch) {
                continue;
            }
            sb.append(ch);

            perm(queue, sb, n, k);

            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String res = new Solution().getHappyString(10, 100);
        System.out.println(res);
    }
}
