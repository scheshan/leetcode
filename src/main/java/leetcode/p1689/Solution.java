package leetcode.p1689;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/5
 */
public class Solution {

    public int minPartitions(String n) {
        int res = 0;
        for (int i = 0; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            if (num > res) {
                res = num;
            }
        }
        return res;
    }
}
