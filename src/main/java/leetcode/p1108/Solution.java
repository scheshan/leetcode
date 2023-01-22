package leetcode.p1108;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public String defangIPaddr(String address) {
        char[] res = new char[address.length() + 6];
        int ind = 0;
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                res[ind++] = '[';
                res[ind++] = '.';
                res[ind++] = ']';
            } else {
                res[ind++] = address.charAt(i);
            }
        }
        return new String(res);
    }
}
