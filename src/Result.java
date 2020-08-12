import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.awt.event.ActionEvent;

public class Result extends JFrame {
public static Connection c = null;
public static String connectString;
private JPanel contentPane;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
private JTextField textField_3;
private JTextField textField_4;
static boolean flag=false;
static String s1="";
static boolean con_mysql() throws ClassNotFoundException
{
// Connection c=null;
boolean flag=false;
   connectString="jdbc:mysql://127.0.0.1:3306/studentinfo?serverTimezone=UTC";
  Class.forName("com.mysql.cj.jdbc.Driver");
   try {
c=DriverManager.getConnection(connectString,"Shirisha","Shirisha@1029");
flag=true;
} catch (SQLException e) {
// TODO Auto-generated catch block
// e.printStackTrace();
}
   return flag;
}

public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Result frame = new Result();
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
public Result() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 1168, 784);
contentPane = new JPanel();
contentPane.setBackground(new Color(255, 248, 220));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblNewLabel = new JLabel("Update Results");
lblNewLabel.setForeground(new Color(220, 20, 60));
lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
lblNewLabel.setBounds(393, 28, 233, 61);
contentPane.add(lblNewLabel);

JLabel lblNewLabel_1 = new JLabel("Name");
lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
lblNewLabel_1.setForeground(new Color(0, 0, 0));
lblNewLabel_1.setBounds(265, 249, 137, 30);
contentPane.add(lblNewLabel_1);

JLabel lblNewLabel_2 = new JLabel("Roll No.");
lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
lblNewLabel_2.setBounds(272, 180, 97, 25);
contentPane.add(lblNewLabel_2);

JLabel lblNewLabel_3 = new JLabel("Class");
lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
lblNewLabel_3.setForeground(new Color(0, 0, 0));
lblNewLabel_3.setBounds(265, 324, 104, 37);
contentPane.add(lblNewLabel_3);

JLabel lblNewLabel_4 = new JLabel("Status");
lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 23));
lblNewLabel_4.setBounds(265, 407, 105, 30);
contentPane.add(lblNewLabel_4);

JLabel lblNewLabel_5 = new JLabel("Percentage");
lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 23));
lblNewLabel_5.setBounds(265, 492, 137, 37);
contentPane.add(lblNewLabel_5);

JButton btnNewButton = new JButton("Cancel");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
dispose();
Options.main(null);
}
});
btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
btnNewButton.setBounds(355, 643, 137, 37);
contentPane.add(btnNewButton);

textField = new JTextField();
textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
textField.setBounds(499, 168, 297, 37);
contentPane.add(textField);
textField.setColumns(10);

textField_1 = new JTextField();
textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
textField_1.setBounds(499, 250, 297, 37);
contentPane.add(textField_1);
textField_1.setColumns(10);

textField_2 = new JTextField();
textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
textField_2.setBounds(499, 324, 297, 37);
contentPane.add(textField_2);
textField_2.setColumns(10);

textField_3 = new JTextField();
textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
textField_3.setBounds(499, 393, 297, 37);
contentPane.add(textField_3);
textField_3.setColumns(10);

textField_4 = new JTextField();
textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
textField_4.setBounds(499, 478, 297, 37);
contentPane.add(textField_4);
textField_4.setColumns(10);

JButton btnNewButton_1 = new JButton("Submit");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

String roll=textField.getText();
String name=textField_1.getText();
String class1=textField_2.getText();
String status=textField_3.getText();
String per=textField_4.getText();
try {
Process p = java.lang.Runtime.getRuntime().exec("ping www.geeksforgeeks.org");
int x1=p.waitFor();
while((con_mysql()==true)&&(x1==0)){


try {
System.out.println("Hello");

Statement stmt=null;
System.out.println("MYSQL DB connection");
stmt=c.createStatement();
String sql = "INSERT INTO result3 VALUES('"+roll+"','"+name+"','"+class1+"','"+status+"','"+per+"')";

int x=stmt.executeUpdate(sql);
if(x>0)
{
break;
}
}catch(Exception mysql) {}

try {
Class.forName("org.sqlite.JDBC");
Connection c1=DriverManager.getConnection("jdbc:sqlite:D:\\project\\StudentInfo.db");
System.out.println("connection true online");
String updated="YES";
String sql = "INSERT INTO result VALUES('"+roll+"','"+name+"','"+class1+"','"+status+"','"+per+"','"+updated+"')";

Statement st=c1.createStatement();

int x=st.executeUpdate(sql);
}catch(Exception sqlite) {
sqlite.printStackTrace();
}
}


System.out.println(" SQLITE DATABASE ");
String sql="";
if(x1==0)
{
String updated="YES";
sql = "INSERT INTO result VALUES('"+roll+"','"+name+"','"+class1+"','"+status+"','"+per+"','"+updated+"')";
}
if(x1==1)
{
String updated="NO";
  sql = "INSERT INTO result VALUES('"+roll+"','"+name+"','"+class1+"','"+status+"','"+per+"','"+updated+"')";
RandomAccessFile raf,raf1;
try {

raf=new RandomAccessFile("D:\\Log\\Result.txt", "rw");
raf1=new RandomAccessFile("D:\\Log\\Pointer2.txt", "rw");
long j=Long.parseLong(raf1.readLine());
raf.seek(j);
String sql1 = "INSERT INTO result3 VALUES('"+roll+"','"+name+"','"+class1+"','"+status+"','"+per+"')";
raf.writeBytes(sql1+"\n");
String s=Long.toString(raf.getFilePointer());
raf1.seek(0);
raf1.writeBytes(s);
raf.close();
raf1.close();

} catch (IOException e1) {

}
}
try
{
Class.forName("org.sqlite.JDBC");
Connection c1=DriverManager.getConnection("jdbc:sqlite:D:\\project\\StudentInfo.db");
System.out.println("connection true");


s1=sql;
flag=true;


Statement st=c1.createStatement();

int x=st.executeUpdate(sql);
}
catch(Exception e1) {
   e1.getMessage();


}
}

catch(Exception p)
{

}

JOptionPane.showMessageDialog(null, "Result has been updated");
}
});
btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
btnNewButton_1.setBounds(595, 641, 127, 37);
contentPane.add(btnNewButton_1);


JButton btnNewButton_11 = new JButton("Submit");
btnNewButton_11.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {}
});

}
}

