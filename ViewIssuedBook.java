import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class ViewIssuedBook extends JFrame implements ActionListener
{
  JButton b1;
  Object [][]data;
  int rows=0;
  String id="";
  String callno="";
  String studentid="";
  String name="";
  String contact="";
  
  ViewIssuedBook()
  {
	b1=new JButton("Back");
	b1.setBounds(1200,600,100,30);
	add(b1);
	b1.addActionListener(this);
	
    String []column={"id","book_call_no","student_id","student_name","student_contact"};
	
	try
	{
	   Class.forName("com.mysql.jdbc.Driver");
	   
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	   
	   Statement st=con.createStatement();
	   
	   ResultSet rs=st.executeQuery("select book_id,book_call_no,Student_id,student_name,student_contact from issue_book");
	   
	   while(rs.next())
	   {
		   id="book_id";
		   callno="book_call_no";
		   studentid="student_id";
		   name="Student_name";
		   contact="Student_contact";
		   
		   rows++;
	   }
     }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
	 try
	 {
        data=new Object[rows][6];
	
        Class.forName("com.mysql.jdbc.Driver");
	   
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	   
	    Statement st=con.createStatement();
	   
	    ResultSet rs=st.executeQuery("select book_id,book_call_no,Student_id,student_name,student_contact from issue_book");	
		
	    for(int i1=0;i1<rows;i1++)
		{
			rs.next();
			for(int j1=0;j1<5;j1++)
			{
				data[i1][j1]=rs.getString(j1+1);
			}
		}
	 }
	 catch(Exception e)
	 {
	    System.out.println(e);
	 }
	 
	JTable table=new JTable(data,column);
	add(table);
	
	setSize(1400,900);
	setVisible(true);
  }
  public void actionPerformed(ActionEvent e)
  {
	  dispose();
	  new LibrarianSection();
  }
  public static void main(String...a)
  {
    new ViewIssuedBook();
  }
}