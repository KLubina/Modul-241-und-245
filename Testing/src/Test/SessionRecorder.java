package Test;

public class SessionRecorder {
    private StatisticsManager statisticsManager;

    public SessionRecorder(StatisticsManager statisticsManager) {
        this.statisticsManager = statisticsManager;
    }

    public void recordSession(String subject, int duration) {
        statisticsManager.recordSession(subject, duration);
    }
}