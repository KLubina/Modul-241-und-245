package paal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExcessTimer extends JFrame implements ActionListener {
    // Properties
    private Timer timer;
    private int countupMinutes=0; // Anfangswert für den Timer in Minuten, wird upgedatet
    private int score = 0;
    private int scoreAmountPerM;
    private JLabel timerLabel;
    private JLabel scoreLabel;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private JButton cancelButton;

    // Constructor
    public ExcessTimer() {
        scoreAmountPerM = 12;
        setTitle("Title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(3, 1));

        timerLabel = new JLabel("Verbleibende Zeit: " + countupMinutes + " Minuten");
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
            countupMinutes = 0;
            score = 0;
            updateLabels();
        } else if (e.getSource() == timer) {
            countupMinutes--;
            if (countupMinutes >= 0) {
                updateLabels();
                score += scoreAmountPerM;
                scoreLabel.setText("Punkte: " + score);
            } else {
                timer.stop();
                JButton proceedButton = new JButton("Proceed without Joker");
                JButton chooseJokerButton = new JButton("Choose Joker Card");
                JButton stopLearningButton = new JButton("Stop Learning");
                Object[] options = {proceedButton, chooseJokerButton, stopLearningButton};
                JOptionPane.showOptionDialog(this, "Bist du bereit noch mehr zu lernen? Der EXP Bonus beträgt 20%",
                        "Weiterlernen", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            }
        }
    }

    private void updateLabels() {
        timerLabel.setText("Verbleibende Zeit: " + countupMinutes + " Minuten");
    }

    private void doAtEnd() {
        if(true) {
        }
    }

    public java.util.List<Card> checkCards(User user) {
        return user.getCards();
    }

    public void distributeExP(User user) {
        user.setExP(user.getExP()+score);

    }
}