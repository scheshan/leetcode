package leetcode.p2553;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/12
 */
public class Solution {

    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            separate(num, list);
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void separate(int num, List<Integer> list) {
        int start = list.size();

        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }

        int end = list.size() - 1;
        while (start < end) {
            int tmp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, tmp);
            start++;
            end--;
        }
    }
}
