package l165;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/17
 */
public class Solution {

    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int v1 = 0, v2 = 0;

        int tmp = 0;
        while (i < version1.length() && j < version2.length()) {
            tmp = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                tmp = tmp * 10 + version1.charAt(i) - '0';
                i++;
            }
            i++;
            v1 = tmp;

            tmp = 0;
            while (j < version2.length() && version2.charAt(j) != '.') {
                tmp = tmp * 10 + version2.charAt(j) - '0';
                j++;
            }
            j++;
            v2 = tmp;

            if (v1 != v2) {
                return Integer.compare(v1, v2);
            }
        }

        if (i < version1.length()) {
            while (i < version1.length()) {
                if (version1.charAt(i) != '.' || version1.charAt(i) != '0') {
                    return 1;
                }
                i++;
            }
        } else if (j < version2.length()) {
            while (j < version2.length()) {
                if (version2.charAt(j) != '.' || version2.charAt(j) != '0') {
                    return -1;
                }
                j++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int res = new Solution().compareVersion("7.5.2.4", "7.5.3");
        System.out.println(res);
    }
}
