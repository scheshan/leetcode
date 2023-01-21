package leetcode.p1603;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class ParkingSystem {

    private int[] positions;

    public ParkingSystem(int big, int medium, int small) {
        positions = new int[3];
        positions[0] = big;
        positions[1] = medium;
        positions[2] = small;
    }

    public boolean addCar(int carType) {
        if (positions[carType - 1] > 0) {
            positions[carType - 1]--;
            return true;
        }
        return false;
    }
}
