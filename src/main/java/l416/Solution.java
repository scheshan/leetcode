package l416;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/11
 */
public class Solution {

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if ((total & 1) == 1) {
            return false;
        }
        total >>= 1;
        Set<Integer> visited = new HashSet<>();

        return dfs(nums, 0, total, visited);
    }

    private boolean dfs(int[] nums, int i, int total, Set<Integer> visited) {
        if (total == 0) {
            return true;
        }
        if (total < 0 || i >= nums.length) {
            return false;
        }

        visited.add(total);

        return (!visited.contains(total - nums[i]) && dfs(nums, i + 1, total - nums[i], visited))
                || dfs(nums, i + 1, total, visited);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
