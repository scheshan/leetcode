package leetcode.p860;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public boolean lemonadeChange(int[] bills) {
        int n1 = 0;
        int n2 = 0;

        for (int num : bills) {
            switch (num) {
                case 5:
                    n1++;
                    break;
                case 10:
                    if (n1 == 0) {
                        return false;
                    }
                    n1--;
                    n2++;
                    break;
                case 20:
                    if (n2 > 0 && n1 > 0) {
                        n2--;
                        n1--;
                    } else if (n1 >= 3) {
                        n1 -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
