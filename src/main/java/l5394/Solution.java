package l5394;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/26
 */
public class Solution {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            count += nums.get(i).size();
        }

        int[] res = new int[count];
        int ind = 0;

        Queue<int[]> queue = new LinkedList<>();
        addQueue(queue, 0, 0, nums);

        while (!queue.isEmpty()) {
            int[] item = queue.remove();
            res[ind++] = item[2];

            addQueue(queue, item[0] + 1, item[1], nums);
            addQueue(queue, item[0], item[1] + 1, nums);
        }

        return res;
    }

    private void addQueue(Queue<int[]> queue, int i, int j, List<List<Integer>> nums) {
        if (i >= nums.size() || j >= nums.get(i).size() || nums.get(i).get(j) < 0) {
            return;
        }

        int n = nums.get(i).get(j);
        nums.get(i).set(j, -n);
        queue.add(new int[]{i, j, n});
    }
}
