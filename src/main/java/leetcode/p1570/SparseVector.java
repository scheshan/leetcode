package leetcode.p1570;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class SparseVector {

    private List<int[]> queue;

    SparseVector(int[] nums) {
        queue = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                queue.add(new int[]{i, nums[i]});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        List<int[]> q1 = this.queue;
        List<int[]> q2 = vec.queue;

        int l = 0;
        int r = 0;
        while (l < q1.size() && r < q2.size()) {
            if (q1.get(l)[0] == q2.get(r)[0]) {
                res += q1.get(l++)[1] * q2.get(r++)[1];
            } else if (q1.get(l)[0] < q2.get(r)[0]) {
                l++;
            } else {
                r++;
            }
        }

        return res;
    }
}
