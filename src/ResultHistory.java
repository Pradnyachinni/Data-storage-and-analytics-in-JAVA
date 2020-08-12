import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ResultHistory extends JFrame {

private JPanel contentPane;

/**
* Launch the application.
*/
public static String toString(int a){
return ""+a;
}
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
ResultHistory frame = new ResultHistory();
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
public ResultHistory() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(0, 0, 1400, 800);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JButton viewbooks = new JButton("View History");
viewbooks.setFont(new Font("Tahoma", Font.PLAIN, 16));
viewbooks.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
try{
/*Connection conn=BookDB.getConnection();
PreparedStatement ps = conn.prepareStatement("select * from sold");*/
Class.forName("org.sqlite.JDBC");
Connection c1=DriverManager.getConnection("jdbc:sqlite:D:\\project\\StudentInfo.db");
System.out.println("connection true");
//String sql = "INSERT INTO student VALUES('"+t+"','"+t1+"','"+t2+"','"+t3+"')";
PreparedStatement ps = c1.prepareStatement("select * from result");


ResultSet rs = ps.executeQuery();
Container con;
con = getContentPane();
con.setLayout(null);

DefaultTableModel dtm;
JTable tb;
String headers [] = {"Roll No.","Name","Class","Status","Percentage","Updated"};
dtm = new DefaultTableModel();
dtm.setColumnIdentifiers(headers);
tb = new JTable(dtm);
JScrollPane jsp = new JScrollPane(tb);
jsp.setBounds(40,300, 1800, 300);
//jsp.setBounds(50,250, 1250, 300);
con.add(jsp);
String row[];
while(rs.next())
{
String roll = rs.getString(1);
String name= rs.getString(2);
String class1= rs.getString(3);
String status=rs.getString(4);
String per=rs.getString(5);
String updated=rs.getString(6);
row = new String[] {roll,name,class1,status,per,updated};
dtm.addRow(row);
}

rs.close();
ps.close();
c1.close();
}catch(Exception e){

}
}
});
viewbooks.setBounds(808, 52, 198, 42);
contentPane.add(viewbooks);
JButton btnNewButton = new JButton("Cancel");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
dispose();
Options.main(null);
}
});
btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
btnNewButton.setBounds(618, 678, 208, 46);
contentPane.add(btnNewButton);
JButton btnNewButton_1 = new JButton("OK");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
dispose();
Options.main(null);
}
});
btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
btnNewButton_1.setBounds(1049, 674, 208, 53);
contentPane.add(btnNewButton_1);
}
}


