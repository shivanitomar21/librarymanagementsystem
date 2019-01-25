import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class ViewLibrarian extends JFrame implements ActionListener
{
   JButton b1;
   int rows=0,col=0;
   Object [][]data=null;
		  
   ViewLibrarian()
   {
	 b1=new JButton("Back");
	 b1.setBounds(1200,600,100,30);
	 add(b1);
	 b1.addActionListener(this);

	 String []column=null;//{"id","username","name","email","gender","qualification","country","city","contact_no","s_que","s_ans"};
	 
	 try
	 {
        Class.forName("com.mysql.jdbc.Driver");
	   
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	   
	    Statement st=con.createStatement();
	   
	    ResultSet rs=st.executeQuery("select id,username,name,email,gender,qualification,country,city,contact_no,s_que,s_ans from librarian");	
		
		ResultSetMetaData rsmd=rs.getMetaData();
		
		col=rsmd.getColumnCount();
		column=new String[col];
		
		for(int i=1;i<=col;i++)
		{
			column[i-1]=rsmd.getColumnName(i);
			System.out.println(column[i-1]);
		}
		
		rs.last();
		rows=rs.getRow();
		rs.beforeFirst();
		
		data=new Object[rows][col];
		
		int count=0;
		while(rs.next())
		{
			for(int i=1;i<=col;i++)
			{
				data[count][i-1]=rs.getString(i);
			}
			count++;
		}
		
	  /*  for(int i1=0;i1<rows;i1++)
		{
			rs.next();
			for(int j1=0;j1<col;j1++)
			{
				data[i1][j1]=rs.getString(j1+1);
			}
		}*/
		rs.close();
		con.close();
		st.close();
	 }
	 catch(Exception e)
	 {
	    System.out.println(e);
	 }
	 
	JTable table=new JTable(data,column);

	getRootPane().setDefaultButton(b1);
    b1.requestFocus();
		
	add(table);
	JScrollPane sp=new JScrollPane(table);
	add(sp);
	
    setSize(1400,900);
	setVisible(true);
   }
   public void actionPerformed(ActionEvent e)
   {
	   dispose();
	   new AdminSection();
   }
   public static void main(String...a)
   {
	   new ViewLibrarian();
   }
}