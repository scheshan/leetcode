package leetcode.p2363;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Comparator<int[]> comparator = (o1, o2) -> o1[0] - o2[0];

        Arrays.sort(items1, comparator);
        Arrays.sort(items2, comparator);

        List<List<Integer>> res = new ArrayList<>();
        int l = 0;
        int r = 0;
        while (l < items1.length && r < items2.length) {
            if (items1[l][0] < items2[r][0]) {
                res.add(Arrays.asList(items1[l][0], items1[l][1]));
                l++;
            } else if (items1[l][0] > items2[r][0]) {
                res.add(Arrays.asList(items2[r][0], items2[r][1]));
                r++;
            } else {
                res.add(Arrays.asList(items1[l][0], items1[l][1] + items2[r][1]));
                l++;
                r++;
            }
        }

        while (l < items1.length) {
            res.add(Arrays.asList(items1[l][0], items1[l][1]));
            l++;
        }
        while (r < items2.length) {
            res.add(Arrays.asList(items2[r][0], items2[r][1]));
            r++;
        }
        return res;
    }
}
