package l830;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < S.length();) {
            int j = i + 1;
            for (; j < S.length() && S.charAt(j) == S.charAt(i); j++) {

            }

            if (j - i >= 3) {
                res.add(Arrays.asList(i, j - 1));
            }

            i = j;
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().largeGroupPositions("abbxxxxzzy");
    }
}
