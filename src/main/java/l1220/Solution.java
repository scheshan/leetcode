package l1220;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/21
 */
public class Solution {

    public int countVowelPermutation(int n) {
        //a:0, e:1, i:2, o:3, u:4
        //a: e,i,u
        //e: a,i
        //i: e,o
        //o: i
        //u: i,o

        long a = 1, e = 1, i = 1, o = 1, u = 1;

        int mod = 1000000007;

        long a1 = 0, e1 = 0, i1 = 0, o1 = 0, u1 = 0;
        for (int j = 1; j < n; j++) {
            a1 = (e + i + u) % mod;
            e1 = (a + i) % mod;
            i1 = (e + o) % mod;
            o1 = i % mod;
            u1 = (i + o) % mod;

            a = a1;
            e = e1;
            i = i1;
            o = o1;
            u = u1;
        }

        int res = (int) ((a + e + i + o + u) % mod);
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().countVowelPermutation(5);
        System.out.println(res);
    }
}
