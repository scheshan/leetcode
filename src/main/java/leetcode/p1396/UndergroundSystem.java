package leetcode.p1396;

import java.util.HashMap;
import java.util.Map;

/**
 * UndergroundSystem
 *
 * @author heshan
 * @date 2023/2/22
 */
public class UndergroundSystem {

    private Map<Integer, String> userStationMap;

    private Map<Integer, Integer> userTimeMap;

    private Map<String, Map<String, int[]>> stationMap;

    public UndergroundSystem() {
        userStationMap = new HashMap<>();
        userTimeMap = new HashMap<>();
        stationMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        userStationMap.put(id, stationName);
        userTimeMap.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
        String startStation = userStationMap.remove(id);
        int startTime = userTimeMap.remove(id);

        Map<String, int[]> m = stationMap.get(startStation);
        if (m == null) {
            m = new HashMap<>();
            stationMap.put(startStation, m);
        }

        int[] arr = m.get(stationName);
        if (arr == null) {
            arr = new int[2];
            m.put(stationName, arr);
        }

        arr[0] += t - startTime;
        arr[1]++;
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] arr = stationMap.get(startStation).get(endStation);
        return arr[0] * 1.0 / arr[1];
    }
}
