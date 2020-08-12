//import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
//import java.rmi.server.Operation;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Options extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JPanel contentPane;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Options frame = new Options();
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
public Options() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 1657, 777);
contentPane = new JPanel();
contentPane.setBackground(SystemColor.inactiveCaption);
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblNewLabel = new JLabel("Student Information Management System");
lblNewLabel.setForeground(Color.RED);
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
lblNewLabel.setBounds(505, -20, 730, 78);
contentPane.add(lblNewLabel);

JButton btnNewButton = new JButton("New Admission");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
SQLiteDemo.main(null);
}
});
btnNewButton.setForeground(new Color(0, 0, 128));
btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
btnNewButton.setBounds(898, 89, 237, 52);
contentPane.add(btnNewButton);

JButton btnNewButton_1 = new JButton("Update Results");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
dispose();
Result.main(null);
}
});
btnNewButton_1.setForeground(new Color(0, 0, 128));
btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
btnNewButton_1.setBounds(898, 290, 237, 52);
contentPane.add(btnNewButton_1);

JButton btnNewButton_3 = new JButton("Cancel");
btnNewButton_3.setForeground(new Color(0, 0, 128));
btnNewButton_3.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
dispose();
}
});
btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
btnNewButton_3.setBounds(1005, 641, 166, 52);
contentPane.add(btnNewButton_3);

JButton btnNewButton_4 = new JButton("Admission history");
btnNewButton_4.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
Admission.main(null);
}
});
btnNewButton_4.setForeground(new Color(0, 0, 128));
btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
btnNewButton_4.setBounds(898, 190, 237, 52);
contentPane.add(btnNewButton_4);

JButton btnNewButton_5 = new JButton("Previous Results");
btnNewButton_5.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
dispose();
ResultHistory.main(null);
}
});
btnNewButton_5.setForeground(new Color(0, 0, 128));
btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
btnNewButton_5.setBounds(898, 401, 237, 52);
contentPane.add(btnNewButton_5);

JButton btnNewButton_7 = new JButton("Logout");
btnNewButton_7.setForeground(new Color(0, 0, 128));
btnNewButton_7.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
JOptionPane.showMessageDialog(null,"You have successfully Loged Out");
dispose();
}
});
btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
btnNewButton_7.setBounds(827, 531, 172, 52);
contentPane.add(btnNewButton_7);
JButton btnNewButton_2 = new JButton("Sync");
btnNewButton_2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		Offline.main(null);
		
	}
});
btnNewButton_2.setForeground(new Color(0, 0, 128));
btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
btnNewButton_2.setBounds(1143, 532, 172, 51);
contentPane.add(btnNewButton_2);
JLabel lblNewLabel_1 = new JLabel("New label");
lblNewLabel_1.setIcon(new ImageIcon(Options.class.getResource("/images/photo1.jpeg")));
lblNewLabel_1.setBounds(275, -20, 1081, 737);
contentPane.add(lblNewLabel_1);
}
}



