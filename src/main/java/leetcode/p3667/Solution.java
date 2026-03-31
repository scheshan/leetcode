package leetcode.p3667;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] sortByAbsoluteValue(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }

        list.sort((l, r) -> {
            int n1 = Math.abs(l);
            int n2 = Math.abs(r);
            return Integer.compare(n1, n2);
        });

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
