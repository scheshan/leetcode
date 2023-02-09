package leetcode.p1980;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/9
 */
public class Solution {

    String res = null;

    public String findDifferentBinaryString(String[] nums) {
        Set<String> exist = new HashSet<>();
        for (String num : nums) {
            exist.add(num);
        }
        backtrack(0, new byte[nums.length], exist);
        return res;
    }

    private void backtrack(int ind, byte[] path, Set<String> exist) {
        if (ind == path.length) {
            String str = new String(path);
            if (!exist.contains(str)) {
                res = str;
            }
            return;
        }
        if (res != null) {
            return;
        }
        path[ind] = '0';
        backtrack(ind + 1, path, exist);

        if (res != null) {
            return;
        }
        path[ind] = '1';
        backtrack(ind + 1, path, exist);
    }
}
