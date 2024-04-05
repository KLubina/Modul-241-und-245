package Test;

import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private List<String> appointments = new ArrayList<>();

    public void addAppointment(String appointment) {
        appointments.add(appointment);
    }

    public boolean removeAppointment(String appointment) {
        return appointments.remove(appointment);
    }

    public List<String> getAppointments() {
        return appointments;
    }

	public List<String> getAvailableSlotsForUser1(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getAvailableSlotsForUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}