package paal;

public class StudyUnit {
    // Properties
    int durationM;
    String date;
    User user;

    //Constructor
    public StudyUnit (int duration, String date, User user) {
        durationM = duration;
        this.date = date;
        this.user = user;
    }

    // Methods
    public int getDurationM() {
        return durationM;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toString() {
        String suInfo = "Datum: "+date+", Dauer: "+durationM/60+"h "+durationM%60+"min, "+user.firstName+" "+user.lastName+", Mögliche EXP: "
                +durationM*10+"\n";
        return suInfo;
    }
}
