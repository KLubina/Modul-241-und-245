package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PAALGUI extends JFrame {

    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);

    public PAALGUI() {
        initUI();
    }

    private void initUI() {
        setTitle("PAAL - Personal Active Analytic Learning");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JToolBar toolBar = new JToolBar();
        addButtonsToToolBar(toolBar);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        createMenu(menuBar);

        JPanel homePanel = createPanel(Color.BLUE, "Home");
        JPanel notesPanel = createPanel(Color.YELLOW, "Notizblock");
        JPanel calendarPanel = createPanel(Color.GREEN, "Kalender");
        JPanel statsPanel = createPanel(Color.LIGHT_GRAY, "Statistik");

        cardPanel.add(homePanel, "Home");
        cardPanel.add(notesPanel, "Notizblock");
        cardPanel.add(calendarPanel, "Kalender");
        cardPanel.add(statsPanel, "Statistik");

        getContentPane().add(toolBar, BorderLayout.NORTH);
        getContentPane().add(cardPanel, BorderLayout.CENTER);
    }

    private void addButtonsToToolBar(JToolBar toolBar) {
        JButton btnHome = new JButton("Home");
        btnHome.addActionListener(e -> cardLayout.show(cardPanel, "Home"));
        toolBar.add(btnHome);

        JButton btnNotes = new JButton("Notizblock");
        btnNotes.addActionListener(e -> cardLayout.show(cardPanel, "Notizblock"));
        toolBar.add(btnNotes);

        JButton btnCalendar = new JButton("Kalender");
        btnCalendar.addActionListener(e -> cardLayout.show(cardPanel, "Kalender"));
        toolBar.add(btnCalendar);

        // Weitere Buttons können hier hinzugefügt werden
    }

    private void createMenu(JMenuBar menuBar) {
        JMenu fileMenu = new JMenu("Datei");
        JMenuItem exitItem = new JMenuItem("Beenden");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        // Weitere Menüpunkte können hier hinzugefügt werden
    }

    private JPanel createPanel(Color color, String title) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.add(new JLabel(title));
        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            PAALGUI frame = new PAALGUI();
            frame.setVisible(true);
        });
    }
}