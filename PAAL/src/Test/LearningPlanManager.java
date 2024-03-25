package Test;

import java.util.*;

public class LearningPlanManager {
    private ScheduleManager scheduleManager;
    private StatisticsManager statisticsManager;

    public LearningPlanManager(ScheduleManager scheduleManager, StatisticsManager statisticsManager) {
        this.scheduleManager = scheduleManager;
        this.statisticsManager = statisticsManager;
    }

    public Map<String, List<String>> generateLearningPlan(User user) {
        // Verbessertes Format für den Lernplan: Fach -> Liste von Lernzeiten
        Map<String, List<String>> learningPlan = new HashMap<>();
        Map<String, Integer> studyTimes = statisticsManager.getStudyTimesForUser(user);
        List<String> availableSlots = scheduleManager.getAvailableSlotsForUser(user);

        for (Map.Entry<String, Integer> entry : studyTimes.entrySet()) {
            String subject = entry.getKey();
            Integer studyTime = entry.getValue();
            List<String> slots = new ArrayList<>();

            while (studyTime > 0 && !availableSlots.isEmpty()) {
                String slot = availableSlots.remove(0);
                slots.add(slot);
                studyTime -= 30; // Angenommen, jeder Slot ist 30 Minuten lang
            }

            if (!slots.isEmpty()) {
                learningPlan.put(subject, slots);
            }
        }

        return learningPlan;
    }
}