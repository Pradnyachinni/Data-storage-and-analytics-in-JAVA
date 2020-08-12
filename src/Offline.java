import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Offline {
public static Connection c = null;
public static String connectString;
boolean con_mysql() throws ClassNotFoundException
{
// Connection c=null;
 boolean flag=false;
    connectString="jdbc:mysql://127.0.0.1:3306/StudentInfo?serverTimezone=UTC";
   Class.forName("com.mysql.cj.jdbc.Driver");
    try {
c=DriverManager.getConnection(connectString,"Shirisha","Shirisha@1029");
flag=true;
} catch (SQLException e) {
}
    return flag;
}
public Offline()
{
try
{
Process p = java.lang.Runtime.getRuntime().exec("ping www.geeksforgeeks.org");
int x1=p.waitFor();
while((con_mysql()==true)&&(x1==0)){

try {
RandomAccessFile raf=new RandomAccessFile("D:\\Log\\Queries.txt", "rw");
RandomAccessFile raf1=new RandomAccessFile("D:\\Log\\Pointer1.txt", "rw");
RandomAccessFile raf2=new RandomAccessFile("D:\\Log\\Result.txt", "rw");
RandomAccessFile raf3=new RandomAccessFile("D:\\Log\\Pointer3.txt", "rw");
raf3.seek(0);
raf1.seek(0);
long j=Long.parseLong(raf3.readLine());
raf2.seek(j);
long k=Long.parseLong(raf1.readLine());
raf.seek(k);
Statement stmt=null;
stmt=c.createStatement();
String sql;
while((sql=raf.readLine())!=null)
{
int x=stmt.executeUpdate(sql);
try {
int start=sql.indexOf("'");
int end=sql.indexOf("'", (start+1));
String roll=sql.substring((start+1), end);
System.out.println(roll);
Class.forName("org.sqlite.JDBC");
Connection c1=DriverManager.getConnection("jdbc:sqlite:D:\\project\\StudentInfo.db");
System.out.println(roll);
String sql1="UPDATE stud SET Updated = ? WHERE Name = ?";
PreparedStatement psmt=c1.prepareStatement(sql1);
psmt.setString(1, "YES");
psmt.setString(2, roll);
psmt.executeUpdate();
c1.close();
String s=Long.toString(raf.getFilePointer());
raf1.seek(0);
raf1.writeBytes(s);
}
catch(Exception e)
{
e.printStackTrace();
}

}
while((sql=raf2.readLine())!=null)
{
int x=stmt.executeUpdate(sql);
try {
int start=sql.indexOf("'");
int end=sql.indexOf("'", (start+1));
String roll=sql.substring((start+1), end);
Class.forName("org.sqlite.JDBC");
Connection c1=DriverManager.getConnection("jdbc:sqlite:D:\\project\\StudentInfo.db");

String sql1="UPDATE result SET Updated = ? WHERE RollNo = ?";
PreparedStatement psmt=c1.prepareStatement(sql1);
psmt.setString(1, "YES");
psmt.setString(2, roll);

psmt.executeUpdate();
// System.out.println(x+" Records updated");
c1.close();
String s=Long.toString(raf2.getFilePointer());
raf3.seek(0);
raf3.writeBytes(s);
}
catch(Exception e)
{
e.printStackTrace();
}

System.out.println(x+" Records Updated");

}
if((raf.readLine()==null) &&(raf2.readLine()==null))
{
x1=1;
break;
}
raf.close();
raf1.close();
raf2.close();
raf3.close();
}catch(Exception mysql) {
mysql.printStackTrace();
}


}
}
catch(Exception e)
{
e.printStackTrace();
}
}
public static void main(String[] arg)
{
Offline o=new Offline();
}
}



