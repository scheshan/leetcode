package l1528;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/8/2
 */
public class Solution {

    public String restoreString(String s, int[] indices) {
        char[] res = new char[s.length()];

        for (int i = 0; i < indices.length; i++) {
            res[indices[i]] = s.charAt(i);
        }

        return new String(res);
    }
}
