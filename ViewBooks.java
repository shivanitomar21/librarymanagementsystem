import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class ViewBooks extends JFrame implements ActionListener
{
   JButton b1;
   Object [][]data;
   int rows=0;
   String id="";
   String callno="";
   String name="";
   String author="";
   String publisher="";
   String quantity="";
   String issued="";
   String added_date="";
	 
   ViewBooks()
   {
	 b1=new JButton("Back");
	 b1.setBounds(1200,600,100,30);
	 add(b1);
	 b1.addActionListener(this);
	 
	 String []column={"id","callno","name","author","publisher","quantity","issued","added_date"};
	 
	 try
	 {
	   Class.forName("com.mysql.jdbc.Driver");
	   
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	   
	   Statement st=con.createStatement();
	   
	   ResultSet rs=st.executeQuery("select book_id,call_no,name,author,publisher,quantity,issued,added_date from add_books");
	   
	   while(rs.next())
	   {
		   id="book_id";
		   callno="call_no";
		   name="name";
		   author="author";
		   publisher="publisher";
		   quantity="quantity";
		   issued="issued";
		   added_date="added_date";
		   
		   rows++;
	   }
     }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
	 try
	 {
        data=new Object[rows][8];
	
        Class.forName("com.mysql.jdbc.Driver");
	   
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	   
	    Statement st=con.createStatement();
	   
	    ResultSet rs=st.executeQuery("select book_id,call_no,name,author,publisher,quantity,issued,added_date from add_books");	
		
	    for(int i1=0;i1<rows;i1++)
		{
			rs.next();
			for(int j1=0;j1<8;j1++)
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
     new ViewBooks();
   }
}