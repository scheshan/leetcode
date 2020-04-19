package l796;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        return (B + B).contains(A);
    }
}
