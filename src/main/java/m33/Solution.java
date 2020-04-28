package m33;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/28
 */
public class Solution {

    public boolean verifyPostorder(int[] postorder) {
        return valid(postorder, 0, postorder.length - 1, null);
    }

    private boolean valid(int[] postorder, int l, int r, Integer max) {
        if (l >= r) {
            return true;
        }

        int n = postorder[r];
        if (max != null && n > max) {
            return false;
        }
        int mid = r - 1;
        while (mid >= 0 && postorder[mid] > n) {
            if (max != null && postorder[mid] > max) {
                return false;
            }
            mid--;
        }

        return valid(postorder, l, mid, n) && valid(postorder, mid, r - 1, max);
    }

    public static void main(String[] args) {
        boolean res = new Solution().verifyPostorder(new int[]{5, 4, 3, 2, 1});
        System.out.println(res);
    }
}
