package leetcode.p1678;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public String interpret(String command) {
        StringBuilder res = new StringBuilder();
        int ind = 0;
        while (ind < command.length()) {
            if (command.charAt(ind) == 'G') {
                res.append('G');
                ind++;
            } else if (command.charAt(ind + 1) == ')') {
                res.append('o');
                ind += 2;
            } else {
                res.append("al");
                ind += 4;
            }
        }
        return res.toString();
    }
}
