package l1013;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/11
 */
public class Solution {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int n : A) {
            sum += n;
        }

        if (sum % 3 != 0) {
            return false;
        }
        sum = sum / 3;

        int tmp = 0;

        int i = 0;
        for (; i < A.length - 2; i++) {
            tmp += A[i];
            if (tmp == sum) {
                break;
            }
        }
        if (tmp != sum) {
            return false;
        }

        tmp = 0;

        int j = i + 1;
        for (; j < A.length - 1; j++) {
            tmp += A[j];
            if (tmp == sum) {
                break;
            }
        }
        if (tmp != sum) {
            return false;
        }

        return true;
    }
}
