package l752;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for (String d : deadends) {
            visited.add(d);
        }
        addQueue(queue, visited, "0000");

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.remove();
                if (str.equals(target)) {
                    return step;
                }
                char[] arr = str.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];

                    arr[j] = (char) ((old - '0' + 1) % 10 + '0');
                    addQueue(queue, visited, new String(arr));


                    arr[j] = (char) ((old - '0' + 9) % 10 + '0');
                    addQueue(queue, visited, new String(arr));

                    arr[j] = old;
                }
            }

            step++;
        }
        return -1;
    }

    private void addQueue(Queue<String> queue, Set<String> visited, String str) {
        if (visited.contains(str)) {
            return;
        }

        visited.add(str);
        queue.add(str);
    }

    public static void main(String[] args) {
        int res = new Solution().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
        System.out.println(res);
    }
}
