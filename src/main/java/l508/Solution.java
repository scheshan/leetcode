package l508;

import shared.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/10
 */
public class Solution {

    private int max;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        sum(root, sumMap);

        List<Integer> list = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
            if (entry.getValue().equals(max)) {
                list.add(entry.getKey());
            }
        }

        int[] result = new int[list.size()];
        int i = 0;
        for (Integer item : list) {
            result[i++] = item;
        }
        return result;
    }

    private int sum(TreeNode root, Map<Integer, Integer> sumMap) {
        if (root == null) {
            return 0;
        }

        int sum = root.val + sum(root.left, sumMap) + sum(root.right, sumMap);
        sumMap.compute(sum, (k, v) -> {
            if (v == null) {
                v = 0;
            }
            v++;
            if (v > max) {
                max = v;
            }
            return v;
        });

        return sum;
    }
}
