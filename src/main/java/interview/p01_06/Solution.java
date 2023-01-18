package interview.p01_06;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public String compressString(String S) {
        StringBuilder res = new StringBuilder();

        int ind = 0;
        while (ind < S.length()) {
            int fast = ind + 1;
            while (fast < S.length() && S.charAt(fast) == S.charAt(ind)) {
                fast++;
            }

            res.append(S.charAt(ind));
            res.append(fast - ind);
            ind = fast;

            if (res.length() >= S.length()) {
                break;
            }
        }

        if (res.length() >= S.length()) {
            return S;
        }

        return res.toString();
    }
}
