package paal;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GUI extends JFrame {

    private JPanel inhaltsPanel;
    private CardLayout kartenLayout = new CardLayout();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GUI frame = new GUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GUI() {
        setTitle("PAAL Lernplattform - Erweitert");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        JMenuBar menuLeiste = new JMenuBar();
        setJMenuBar(menuLeiste);

        JMenu dateiMenu = new JMenu("Datei");
        JMenuItem speichernItem = new JMenuItem("Speichern");
        dateiMenu.add(speichernItem);

        JMenuItem beendenItem = new JMenuItem("Beenden");
        beendenItem.addActionListener(e -> System.exit(0));
        dateiMenu.add(beendenItem);
        menuLeiste.add(dateiMenu);

        JMenu bearbeitenMenu = new JMenu("Bearbeiten");
        menuLeiste.add(bearbeitenMenu);

        JMenu einfuegenMenu = new JMenu("Einfügen");
        JMenuItem bilderItem = new JMenuItem("Bilder");
        einfuegenMenu.add(bilderItem);
        JMenuItem videosItem = new JMenuItem("Videos");
        einfuegenMenu.add(videosItem);
        menuLeiste.add(einfuegenMenu);

        JMenu hilfeMenu = new JMenu("Hilfe");
        menuLeiste.add(hilfeMenu);

        inhaltsPanel = new JPanel(kartenLayout);
        setContentPane(inhaltsPanel);

        inhaltsPanel.add(erstelleStatistikPanel(), "Statistik");
        inhaltsPanel.add(erstelleLernplanPanel(), "Lernplan");
        inhaltsPanel.add(erstelleKalenderPanel(), "Kalender");
        inhaltsPanel.add(erstelleNotenModulPanel(), "NotenModule");

        // Button to switch to different panels
        addSwitchButton(menuLeiste, "Statistik", "Statistik");
        addSwitchButton(menuLeiste, "Lernplan", "Lernplan");
        addSwitchButton(menuLeiste, "Kalender", "Kalender");
        addSwitchButton(menuLeiste, "Noten & Module", "NotenModule");
    }

    private void addSwitchButton(JMenuBar menuBar, String title, String panelName) {
        JButton button = new JButton(title);
        button.addActionListener(e -> kartenLayout.show(inhaltsPanel, panelName));
        menuBar.add(button);
    }

    private JPanel erstelleStatistikPanel() {
        return createPanelWithImage("screen-time.jpg");
    }

    private JPanel erstelleLernplanPanel() {
        return createPanelWithImage("lernplan.png");
    }

    private JPanel erstelleKalenderPanel() {
        // Corrected the file name here
        return createPanelWithImage("calendar2024.png");
    }

    private JPanel erstelleNotenModulPanel() {
        return createPanelWithImage("noten_und_module.png");
    }

    // Utility method to create a panel with an image
    private JPanel createPanelWithImage(String imagePath) {
        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                URL imgUrl = getClass().getClassLoader().getResource(imagePath);
                if (imgUrl != null) {
                    ImageIcon icon = new ImageIcon(imgUrl);
                    Image img = icon.getImage();
                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                } else {
                    g.drawString("Image not found", 10, 20);
                }
            }
        };
        return panel;
    }
}
