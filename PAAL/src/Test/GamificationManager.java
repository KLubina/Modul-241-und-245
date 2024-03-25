package Test;

import java.util.HashMap;
import java.util.Map;

public class GamificationManager {
    private Map<String, Integer> userPoints = new HashMap<>();

    public void awardPoints(String userId, int points) {
        userPoints.merge(userId, points, Integer::sum);
    }

    public int getPoints(String userId) {
        return userPoints.getOrDefault(userId, 0);
    }
}
