package leetcode.p2138;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Solution {

    public String[] divideString(String s, int k, char fill) {
        int len = s.length() / k;
        if (s.length() % k > 0) {
            len++;
        }

        String[] res = new String[len];
        for (int i = 0; i < res.length; i++) {
            if (i < res.length - 1) {
                res[i] = s.substring(i * k, i * k + k);
            } else {
                char[] arr = new char[k];
                for (int j = 0; j < arr.length; j++) {
                    if (i * k + j < s.length()) {
                        arr[j] = s.charAt(i * k + j);
                    } else {
                        arr[j] = fill;
                    }
                }
                res[i] = new String(arr);
            }
        }
        return res;
    }
}
