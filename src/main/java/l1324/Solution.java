package l1324;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/27
 */
public class Solution {

    public List<String> printVertically(String s) {
        List<String> res = new LinkedList<>();

        int cols = 0;
        String[] arr = s.split(" ");
        for (String str : arr) {
            cols = Math.max(cols, str.length());
        }

        for (int col = 0; col < cols; col++) {
            StringBuilder sb = new StringBuilder();

            for (int row = 0; row < arr.length; row++) {
                if (col >= arr[row].length()) {
                    sb.append(" ");
                } else {
                    sb.append(arr[row].charAt(col));
                }
            }

            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            res.add(sb.toString());
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().printVertically("TO BE OR NOT TO BE");
    }
}
