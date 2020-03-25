package l844;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/25
 */
public class Solution {

    public boolean backspaceCompare(String S, String T) {
        int l = S.length() - 1;
        int r = T.length() - 1;

        while (l >= 0 && r >= 0) {
            l = next(S, l);
            r = next(T, r);

            if (l < 0 || r < 0) {
                break;
            }

            if (S.charAt(l) != T.charAt(r)) {
                return false;
            }

            l--;
            r--;
        }

        if (l >= 0) {
            l = next(S, l);
        }
        if (r >= 0) {
            r = next(T, r);
        }

        return l == -1 && r == -1;
    }

    private int next(String str, int i) {
        int c = 0;
        while (i >= 0) {
            if (str.charAt(i) == '#') {
                c++;
                i--;
            } else if (c > 0) {
                c--;
                i--;
            } else {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        new Solution().backspaceCompare("", "#");
    }
}
