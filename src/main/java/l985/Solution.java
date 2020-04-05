package l985;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/5
 */
public class Solution {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        for (int num : A) {
            if (isEven(num)) {
                sum += num;
            }
        }

        int[] res = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            int x = A[query[1]];
            int y = query[0];

            if (isEven(x)) {
                if (isEven(y)) {
                    sum += y;
                } else {
                    sum -= x;
                }
            } else {
                if (!isEven(y)) {
                    sum += x + y;
                }
            }
            A[query[1]] = x + y;
            res[i++] = sum;
        }

        return res;
    }

    private boolean isEven(int n) {
        return (n & 1) == 0;
    }
}
