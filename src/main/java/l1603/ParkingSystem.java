package l1603;

/**
 * ParkingSystem
 *
 * @author heshan
 * @date 2020/10/13
 */
public class ParkingSystem {

    private int[] allow = new int[4];

    private int[] current = new int[4];

    public ParkingSystem(int big, int medium, int small) {
        allow[1] = big;
        allow[2] = medium;
        allow[3] = small;
    }

    public boolean addCar(int carType) {
        if (current[carType] >= allow[carType]) {
            return false;
        }
        current[carType]++;
        return true;
    }
}
