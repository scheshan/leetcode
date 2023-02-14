package leetcode.p1859;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public String sortSentence(String s) {
        String[] arr = new String[9];

        int ind = 0;
        while (ind < s.length()) {
            int pre = ind;
            while (ind < s.length() && s.charAt(ind) != ' ') {
                ind++;
            }

            arr[s.charAt(ind - 1) - '1'] = s.substring(pre, ind - 1);
            ind++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                break;
            }
            if (sb.length() != 0) {
                sb.append(' ');
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
