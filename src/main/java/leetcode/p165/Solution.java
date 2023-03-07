package leetcode.p165;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/7
 */
public class Solution {

    public int compareVersion(String version1, String version2) {
        int leftInd = 0, rightInd = 0;

        while (leftInd < version1.length() || rightInd < version2.length()) {
            int v1 = 0, v2 = 0;
            while (leftInd < version1.length() && version1.charAt(leftInd) != '.') {
                v1 = v1 * 10 + version1.charAt(leftInd++) - '0';
            }
            while (rightInd < version2.length() && version2.charAt(rightInd) != '.') {
                v2 = v2 * 10 + version2.charAt(rightInd++) - '0';
            }

            if (v1 != v2) {
                return v1 < v2 ? -1 : 1;
            }
            leftInd++;
            rightInd++;
        }

        return 0;
    }
}
