
package Test;
//aiugfezfgeIZGFDAIUÖF
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Tutorial extends JFrame {

	//Fenster erstellen
	public Tutorial()
	{
		setTitle("Unsere GUI");
		setSize(800, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Layout Children können ins Layout inportiert werden.
		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);
		
		//Button erstellen
		JButton button = new JButton("Ende");
		button.addActionListener(new ActionListener() {
			
			//Was soll der Button Machen
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		//Button am GroupLayout hinzufügen
		gl.setVerticalGroup(gl.createSequentialGroup().addComponent(button));
		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(button));
		
	}
	
	//Einstiegspunkt
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Tutorial m = new Tutorial();
				m.setVisible(true);
			}
			
		});
	}
}