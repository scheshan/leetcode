package l1323;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int maximum69Number(int num) {
        String str = String.valueOf(num);

        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '6') {
                arr[i] = '9';
                break;
            }
        }

        return Integer.parseInt(new String(arr));
    }
}
