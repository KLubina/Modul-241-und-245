package paal;

import java.util.ArrayList;
import java.util.List;

public class User {
    // Properties
    String lastName;
    String firstName;
    String birthDate;
    int exP;
    int level;
    Calendar calendar;
    List<StudyUnit> studyUnits;
    List<Card> cards;

    // Constructor
    public User(String lName, String fName, String bDate, int exP, int level) {
        lastName = lName;
        firstName = fName;
        birthDate = bDate;
        this.exP = exP;
        this.level = level;
        studyUnits = new ArrayList<StudyUnit>();
        cards = new ArrayList<Card>();
        calendar = new Calendar();
    }

    // Methods
    public int getExP() {
        return exP;
    }

    public void setExP(int exP) {
        this.exP = exP;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<StudyUnit> getStudyUnits() {
        return studyUnits;
    }

    public void createAddStudyUnit(String date, int duration) {
        studyUnits.add(new StudyUnit(duration, date, this));
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public String toString() {
        String userInfo = firstName+", "+lastName+" ("+birthDate+")"+"\nErfahrungspunkte: "+exP+"\nLevel: "+level+"\n";
        return userInfo;
    }

    public void printSUnits() {
        for(int i=0; i<studyUnits.size(); i++) {
            System.out.println(this.studyUnits.get(i));
        }
    }

    public void printCards() {
        for(int i=0; i<cards.size(); i++) {
            System.out.println(this.cards.get(i));
        }
    }
}
