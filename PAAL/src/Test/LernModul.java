package Test;

public class LernModul {
    private String name;
    private int geplanteLernzeit; // in Minuten

    public LernModul(String name, int geplanteLernzeit) {
        this.name = name;
        this.geplanteLernzeit = geplanteLernzeit;
    }

    // Getter und Setter
    public String getName() {
        return name;
    }

    public int getGeplanteLernzeit() {
        return geplanteLernzeit;
    }

    public void setGeplanteLernzeit(int geplanteLernzeit) {
        this.geplanteLernzeit = geplanteLernzeit;
    }
}