package leetcode.p433;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/5
 */
public class Solution {

    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] chars = new char[]{'A', 'T', 'G', 'C'};

        Set<String> valid = new HashSet<>();
        for (String str : bank) {
            valid.add(str);
        }
        valid.add(startGene);

        if (!valid.contains(endGene)) {
            return -1;
        }

        Set<String> visit = new HashSet<>();

        int res = 0;
        Queue<String> queue = new LinkedList<>();
        addQueue(queue, startGene, visit, valid);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String gene = queue.remove();
                if (gene.equals(endGene)) {
                    return res;
                }

                char[] arr = gene.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    for (int k = 0; k < chars.length; k++) {
                        char t = arr[j];
                        arr[j] = chars[k];
                        addQueue(queue, new String(arr), visit, valid);
                        arr[j] = t;
                    }
                }
            }
            res++;
        }

        return -1;
    }

    private void addQueue(Queue<String> queue, String str, Set<String> visit, Set<String> valid) {
        if (visit.contains(str) || !valid.contains(str)) {
            return;
        }
        visit.add(str);
        queue.add(str);
    }
}
