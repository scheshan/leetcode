package leetcode.p2418;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public String[] sortPeople(String[] names, int[] heights) {
        List<Integer> list = new ArrayList<>(names.length);
        for (int i = 0; i < names.length; i++) {
            list.add(i);
        }

        list.sort((o1, o2) -> {
            int h1 = heights[o1];
            int h2 = heights[o2];
            return Integer.compare(h2, h1);
        });

        String[] res = new String[names.length];
        for (int i = 0; i < list.size(); i++) {
            res[i] = names[list.get(i)];
        }
        return res;
    }
}
