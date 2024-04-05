package Test;

import java.util.HashMap;
import java.util.Map;

public class StatisticsManager {
    private Map<String, Integer> sessionDurations = new HashMap<>();

    public void recordSession(String subject, int duration) {
        sessionDurations.merge(subject, duration, Integer::sum);
    }

    public int getAverageDuration(String subject) {
        return sessionDurations.getOrDefault(subject, 0);
    }

	public Map<String, Integer> getStudyTimesForUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}