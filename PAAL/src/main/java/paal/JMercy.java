package paal;

public class JMercy extends Card{

    public JMercy(String name, int quant) {
        super(name, quant);
        // TODO Auto-generated constructor stub
    }

    // Methods
    @Override
    public void crdAction(StudyUnit sU) {
        // Neutralisiert den Penalty auf den Score beim verfrühten Abbruch der Studieneinheit

    }

    public String toString() {
        return super.toString();
    }
}
