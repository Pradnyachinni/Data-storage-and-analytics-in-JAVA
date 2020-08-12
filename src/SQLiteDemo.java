import java.awt.*;
//import java.lang.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import javax.swing.border.EmptyBorder;
//import javax.swing.text.Caret;
public class SQLiteDemo extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JPanel contentPane;
private JTextField textField;
private JTextField textField_1;
static boolean flag=false;
static String s1="";

/**
* Launch the application.
*/
public static Connection c = null;
public static String connectString;
private JTextField textField_4;
private JTextField textField_2;
private JTextField textField_3;
private JTextField textField_5;

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
SQLiteDemo frame = new SQLiteDemo();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
System.out.println(s1);

}

/**
* Create the frame.
*/

public SQLiteDemo() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 1168, 784);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblNewLabel = new JLabel("Name");
lblNewLabel.setForeground(new Color(0, 0, 128));
lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
lblNewLabel.setBounds(261, 154, 111, 37);
contentPane.add(lblNewLabel);

textField = new JTextField();
textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
textField.setBounds(515, 158, 211, 39);
contentPane.add(textField);
textField.setColumns(10);

JLabel lblNewLabel_1 = new JLabel("Address");
lblNewLabel_1.setForeground(new Color(0, 0, 128));
lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
lblNewLabel_1.setBounds(261, 292, 95, 37);
contentPane.add(lblNewLabel_1);

textField_1 = new JTextField();
textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
textField_1.setBounds(515, 224, 211, 39);
contentPane.add(textField_1);
textField_1.setColumns(10);

JLabel lblNewLabel_2 = new JLabel("Class");
lblNewLabel_2.setForeground(new Color(0, 0, 128));
lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
lblNewLabel_2.setBounds(261, 437, 95, 48);
contentPane.add(lblNewLabel_2);

JLabel lblNewLabel_3 = new JLabel("ContactNo");
lblNewLabel_3.setForeground(new Color(0, 0, 128));
lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
lblNewLabel_3.setBounds(261, 522, 133, 33);
contentPane.add(lblNewLabel_3);

JButton btnSubmit = new JButton("Submit");
btnSubmit.setForeground(new Color(75, 0, 130));
btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 25));
JButton btnSynchr = new JButton("Synchr");

btnSubmit.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {

String name=textField.getText();
String DOB=textField_1.getText();
String Address=textField_2.getText();
String RollNO=textField_3.getText();
String class1=textField_4.getText();
String Contact=textField_5.getText();

/*Network Available*/

try {
Process p = java.lang.Runtime.getRuntime().exec("ping www.geeksforgeeks.org");
int x1=p.waitFor();
while((con_mysql()==true)&&(x1==0)){


try {
System.out.println("Hello");
 
Statement stmt=null;
System.out.println("MYSQL DB connection");
stmt=c.createStatement();
String sql = "INSERT INTO student5 VALUES('"+name+"','"+DOB+"','"+Address+"','"+RollNO+"','"+class1+"','"+Contact+"')";

int x=stmt.executeUpdate(sql);
System.out.println(x);
if(x>0)
{
break;
}
}catch(Exception mysql) {
	mysql.printStackTrace();
}

try {
Class.forName("org.sqlite.JDBC");
Connection c1=DriverManager.getConnection("jdbc:sqlite:D:\\project\\StudentInfo.db");
System.out.println("connection true online");
String updated="YES";
System.out.println(name);
String sql = "INSERT INTO stud VALUES('"+name+"','"+DOB+"','"+Address+"','"+RollNO+"','"+class1+"','"+Contact+"','"+updated+"')";

 Statement st=c1.createStatement();

int x=st.executeUpdate(sql);
if(x>0)
{
	break;
}
}catch(Exception sqlite) {
sqlite.printStackTrace();
}
}


System.out.println(" SQLITE DATABASE ");
String sql="";
if(x1==0)
{
String updated="YES";
sql = "INSERT INTO stud VALUES('"+name+"','"+DOB+"','"+Address+"','"+RollNO+"','"+class1+"','"+Contact+"','"+updated+"')";
}
if(x1==1)
{
String updated="NO";
sql = "INSERT INTO stud VALUES('"+name+"','"+DOB+"','"+Address+"','"+RollNO+"','"+class1+"','"+Contact+"','"+updated+"')";
RandomAccessFile raf,raf1;
try {

raf=new RandomAccessFile("D:\\Log\\Queries.txt", "rw");
raf1=new RandomAccessFile("D:\\Log\\Pointer.txt", "rw");
long j=Long.parseLong(raf1.readLine());
raf.seek(j);
String sql1 = "INSERT INTO student5 VALUES('"+name+"','"+DOB+"','"+Address+"','"+RollNO+"','"+class1+"','"+Contact+"')";
raf.writeBytes(sql1+"\n");
String s=Long.toString(raf.getFilePointer());
raf1.seek(0);
raf1.writeBytes(s);
raf.close();
raf1.close();

} catch (IOException e) {
	e.printStackTrace();

}
}
try
{
Class.forName("org.sqlite.JDBC");
Connection c1=DriverManager.getConnection("jdbc:sqlite:D:\\project\\StudentInfo.db");
System.out.println("connection true");


//s1=sql;
System.out.println(sql);
flag=true;


 Statement st=c1.createStatement();

int x=st.executeUpdate(sql);
System.out.println(x);
}
catch(Exception e1) {
    e1.getMessage();


}
}catch(Exception e) {
	
e.printStackTrace();
}
JOptionPane.showMessageDialog(null, "Admission Done!!!");
}


});
btnSubmit.setBounds(232, 654, 191, 37);
contentPane.add(btnSubmit);
contentPane.add(btnSynchr);
JLabel lblNewLabel_4 = new JLabel("Student Information");
lblNewLabel_4.setForeground(new Color(255, 0, 0));
lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
lblNewLabel_4.setBounds(316, 46, 370, 40);
contentPane.add(lblNewLabel_4);
JLabel lblDateOfBirth = new JLabel("Date Of Birth");
lblDateOfBirth.setForeground(new Color(0, 0, 128));
lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 25));
lblDateOfBirth.setBounds(261, 220, 153, 37);
contentPane.add(lblDateOfBirth);
textField_4 = new JTextField();
textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
textField_4.setBounds(515, 448, 211, 37);
contentPane.add(textField_4);
textField_4.setColumns(10);
JLabel label = new JLabel("Roll No");
label.setForeground(new Color(0, 0, 128));
label.setFont(new Font("Tahoma", Font.PLAIN, 25));
label.setBounds(261, 367, 95, 37);
contentPane.add(label);
textField_2 = new JTextField();
textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
textField_2.setColumns(10);
textField_2.setBounds(515, 297, 211, 37);
contentPane.add(textField_2);
textField_3 = new JTextField();
textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
textField_3.setColumns(10);
textField_3.setBounds(515, 372, 211, 37);
contentPane.add(textField_3);
textField_5 = new JTextField();
textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
textField_5.setColumns(10);
textField_5.setBounds(515, 525, 211, 37);
contentPane.add(textField_5);
JButton btnNewButton = new JButton("Cancel");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
//Options.main(null);
dispose();
}
});
btnNewButton.setForeground(new Color(0, 0, 128));
btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
btnNewButton.setBounds(519, 653, 207, 37);
contentPane.add(btnNewButton);

}
}



