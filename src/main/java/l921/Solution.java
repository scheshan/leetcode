package l921;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public int minAddToMakeValid(String S) {
        int res = 0;
        int left = 0;

        for(int i = 0;i<S.length();i++){
            if(S.charAt(i) == '(') {
                left++;
            } else {
                if(left > 0){
                    left--;
                } else {
                    res++;
                }
            }
        }

        return res + left;
    }
}
