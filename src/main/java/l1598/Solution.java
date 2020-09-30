package l1598;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/9/30
 */
public class Solution {

    public int minOperations(String[] logs) {
        int res = 0;

        for (int i = 0; i < logs.length; i++) {
            String log = logs[i];

            if (log.startsWith("..")) {
                res--;
                if (res < 0) {
                    res = 0;
                }
            } else if (log.startsWith(".")) {

            } else {
                res++;
            }
        }

        return res;
    }
}
