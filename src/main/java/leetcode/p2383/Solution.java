package leetcode.p2383;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/13
 */
public class Solution {

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int res = 0;
        for (int i = 0; i < energy.length; i++) {
            if (initialEnergy <= energy[i]) {
                int n = energy[i] - initialEnergy + 1;
                res += n;
                initialEnergy += n;
            }
            initialEnergy -= energy[i];

            if (initialExperience <= experience[i]) {
                int n = experience[i] - initialExperience + 1;
                res += n;
                initialExperience += n;
            }
            initialExperience += experience[i];
        }

        return res;
    }
}
