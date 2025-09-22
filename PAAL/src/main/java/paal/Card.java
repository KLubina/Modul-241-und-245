package paal;

public abstract class Card {
    // Properties
    private String name;
    private int quant;

    // Constructor
    public Card(String name, int quant) {
        this.name = name;
        this.quant = quant;
    }

    // Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public void crdAction(StudyUnit sU) {
    }

    public String toString() {
        String crdInfo = "Karte: "+name+", Anzahl: "+quant;
        return crdInfo;
    }
}
