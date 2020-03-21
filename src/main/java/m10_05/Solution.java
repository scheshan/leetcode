package m10_05;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public int findString(String[] words, String s) {
        int left = 0;
        int right = words.length;

        while (left < right) {
            int mid = (left + right) / 2;
            while (words[mid].length() == 0 && mid > left) {
                mid--;
            }
            if (mid < left) {
                return -1;
            }
            String word = words[mid];
            if (word.equals(s)) {
                return mid;
            } else if (word.compareTo(s) < 0) {
                left = (left + right) / 2 + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
