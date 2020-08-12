import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Login extends JFrame {
private JTextField textField;
private JPasswordField passwordField;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Login frame = new Login();
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
public Login() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 1749, 784);
JPanel contentPane = new JPanel();
contentPane.setBackground(SystemColor.activeCaption);
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblNewLabel = new JLabel("Username");
lblNewLabel.setForeground(new Color(0, 0, 128));
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
lblNewLabel.setBounds(1241, 149, 147, 52);
contentPane.add(lblNewLabel);

JLabel lblNewLabel_2 = new JLabel("Password");
lblNewLabel_2.setForeground(new Color(0, 0, 128));
lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_2.setBounds(1241, 308, 156, 46);
contentPane.add(lblNewLabel_2);

textField = new JTextField();
textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
textField.setBounds(1241, 214, 317, 47);
contentPane.add(textField);
textField.setColumns(10);

passwordField = new JPasswordField();
passwordField.setFont(new Font("Tahoma", Font.PLAIN, 23));
passwordField.setBounds(1241, 367, 317, 42);
contentPane.add(passwordField);

JButton btnNewButton = new JButton("Sign up");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String uname=textField.getText();
String upass=passwordField.getText();
if((uname.contentEquals("Peerless"))&&(upass.contentEquals("Peerless@141")))
{
JOptionPane.showMessageDialog(null, "Login Succeed");
dispose();
Options.main(null);

}
else
{
JOptionPane.showMessageDialog(null, "Login Failed");
}
}
});
btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
btnNewButton.setBounds(1184, 495, 156, 42);
contentPane.add(btnNewButton);

JButton btnNewButton_1 = new JButton("Cancel");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
dispose();
}
});
btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
btnNewButton_1.setBounds(1517, 495, 156, 42);
contentPane.add(btnNewButton_1);
JLabel lblNewLabel_3 = new JLabel("New label");
lblNewLabel_3.setBounds(69, 371, 271, -170);
contentPane.add(lblNewLabel_3);
JLabel lblNewLabel_4 = new JLabel("New label");
lblNewLabel_4.setBounds(0, 0, 1100, 737);
contentPane.add(lblNewLabel_4);
lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/images/loginimage4.jpg")));
}
}



