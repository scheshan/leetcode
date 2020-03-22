package l414;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int thirdMax(int[] nums) {
        Integer m1 = null;
        Integer m2 = null;
        Integer m3 = null;

        for (int n : nums) {
            if (m1 == null || n > m1) {
                m3 = m2;
                m2 = m1;
                m1 = n;
            } else if (m2 == null || n > m2) {
                if (n != m1) {
                    m3 = m2;
                    m2 = n;
                }
            } else if (m3 == null || n > m3) {
                if (n != m2) {
                    m3 = n;
                }
            }
        }

        if (m3 != null) {
            return m3;
        } else {
            return m1;
        }
    }
}
