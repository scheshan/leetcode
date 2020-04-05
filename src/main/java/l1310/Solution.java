package l1310;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/5
 */
public class Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = prefix[queries[i][1] + 1] ^ prefix[queries[i][0]];
        }

        return res;
    }
}
