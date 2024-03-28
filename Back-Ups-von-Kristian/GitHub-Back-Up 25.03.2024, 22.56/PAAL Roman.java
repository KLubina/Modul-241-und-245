package Test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalBorders;
import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.Component;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setForeground(new Color(240, 240, 240));
		setFont(null);
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 537);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		setContentPane(panel);
	
		
		JMenuBar menuLeiste = new JMenuBar();
		setJMenuBar(menuLeiste);
		
		JMenu mnNewMenu = new JMenu("Datei");
		menuLeiste.add(mnNewMenu);
		
		JButton btnNewButton = new JButton("Speichern");
		mnNewMenu.add(btnNewButton);
		
		JMenu mnNewMenu_1 = new JMenu("Bearbeiten");
		menuLeiste.add(mnNewMenu_1);
		
		JMenu mnNewMenu_3 = new JMenu("Einf\u00FCgen");
		menuLeiste.add(mnNewMenu_3);
		
		JButton btnNewButton_1 = new JButton("Bilder");
		mnNewMenu_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Videos");
		mnNewMenu_3.add(btnNewButton_2);
		
		JMenu mnNewMenu_2 = new JMenu("Help");
		menuLeiste.add(mnNewMenu_2);
		
		
		JButton buttonHS = new JButton("Haupseite ");
		menuLeiste.add(buttonHS);
		
		JButton buttonNB = new JButton("Notizblock");
		menuLeiste.add(buttonNB);
		
		
		JButton buttonK = new JButton("Kalender");
		menuLeiste.add(buttonK);
		
		//JPanel HauptSeite
		JPanel panelHauptSeite = new JPanel();
		panel.add(panelHauptSeite);
		panelHauptSeite.setBackground(Color.blue);
		
		
		
		//JPanel Notitzblock
		JPanel panelNotizBlock = new JPanel();
		panel.add(panelNotizBlock);
		panelNotizBlock.setBackground(Color.yellow);
		
		//JPanel Kalender
		JPanel panelKalender = new JPanel();
		panel.add(panelKalender);
		panelKalender.setBackground(Color.green);
		
		//Action Notizblock
		buttonNB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(panelNotizBlock, BorderLayout.CENTER);
				panel.updateUI();
			}
		});
		
		
		//Action Hauptseite
		buttonHS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(panelHauptSeite, BorderLayout.CENTER);
				panel.updateUI();
			}
		});
		
		
		//Action kalender
		buttonK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(panelKalender, BorderLayout.CENTER);
				panel.updateUI();
			}
		});
	}

}
