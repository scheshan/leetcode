package l1071;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/12
 */
public class Solution {

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }
}
