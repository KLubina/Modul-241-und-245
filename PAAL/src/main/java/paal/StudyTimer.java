package paal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudyTimer extends JFrame implements ActionListener {
    // Properties
    private Timer timer;
    private int duration; // Der Anfangswert der konstant bleibt
    private int countdownMinutes; // Anfangswert für den Timer in Minuten, wird upgedatet
    private int score = 0;
    private int scoreAmountPerMin;
    private double penalty = 0;
    private JLabel timerLabel;
    private JLabel scoreLabel;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private JButton cancelButton;
    private User user;

    // Constructor
    public StudyTimer(int scoreAmount, int suIndex, User user) {
        penalty = 0.8;
        this.user = user;
        scoreAmountPerMin = scoreAmount;
        StudyUnit SUnit = user.getStudyUnits().get(suIndex);
        duration = SUnit.getDurationM();
        countdownMinutes = SUnit.getDurationM();
        setTitle(SUnit.toString());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(3, 1));

        timerLabel = new JLabel("Verbleibende Zeit: " + countdownMinutes + " Minuten");
        add(timerLabel);

        scoreLabel = new JLabel("Punkte: " + score);
        add(scoreLabel);

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        buttonPanel.add(startButton);

        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);
        buttonPanel.add(stopButton);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        buttonPanel.add(cancelButton);

        add(buttonPanel);

        timer = new Timer(2000, this); // Timer feuert (zu Testzwecken) erst Mal alle zwei Sekunden
    }

    // Methods
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            timer.start();
        } else if (e.getSource() == stopButton) {
            timer.stop();
        } else if (e.getSource() == resetButton) {
            timer.stop();
            countdownMinutes = duration;
            user.exP += score;
            score = 0;
            updateLabels();
        } else if (e.getSource() == timer) {
            countdownMinutes--;
            if (countdownMinutes >= 0) {
                updateLabels();
                score += scoreAmountPerMin;
                scoreLabel.setText("Punkte: " + score);
            } else {
                timer.stop();
                JButton proceedButton = new JButton("Proceed without Joker");
                JButton chooseJokerButton = new JButton("Choose Joker Card");
                JButton stopLearningButton = new JButton("Stop Learning");
                Object[] options = {proceedButton, chooseJokerButton, stopLearningButton};
                JOptionPane.showOptionDialog(this, "Bist du bereit noch mehr zu lernen? Der EXP Bonus beträgt 20%. "
                                +"Falls du Jokerkarten hast, kannst du auch Karten einsetzen.",
                        "Weiterlernen", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            }
        }
    }

    private void updateLabels() {
        timerLabel.setText("Verbleibende Zeit: " + countdownMinutes + " Minuten");
    }

    private void doAtEnd() {
        if(true) {
            SwingUtilities.invokeLater(() -> {
                ExcessTimer timerGUI = new ExcessTimer();
                timerGUI.setVisible(true);
            });
        }
    }

    public java.util.List<Card> checkCards(User user) {
        return user.getCards();
    }

    public void distributeExP(User user) {
        user.setExP(user.getExP()+score);

    }
}
