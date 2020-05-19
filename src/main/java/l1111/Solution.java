package l1111;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/18
 */
public class Solution {

    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];

        int a = 0;
        int b = 0;
        int ind = 0;
        for (int i = 0; i < seq.length(); i++) {
            char ch = seq.charAt(i);
            if (ch == '(') {
                if (a > b) {
                    b++;
                    res[ind++] = 1;
                } else {
                    a++;
                    res[ind++] = 0;
                }
            } else {
                if (a > b) {
                    a--;
                    res[ind++] = 0;
                } else {
                    b--;
                    res[ind++] = 1;
                }
            }
        }
        return res;
    }
}
