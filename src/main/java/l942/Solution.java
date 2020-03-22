package l942;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int[] diStringMatch(String S) {
        int[] res = new int[S.length() + 1];

        int low = 0;
        int high = S.length();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                res[i] = low++;
            } else {
                res[i] = high--;
            }
        }

        res[res.length - 1] = high;

        return res;
    }
}
