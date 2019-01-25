import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ViewFeedback extends JFrame implements ActionListener
{
   JButton b1;
   int rows=0;int col=0;
   Object [][]data;
   String s_id="";
   String s_name="";
   String rate="";
   String suggestion="";
   String date="";
  
  ViewFeedback()
  {  
   	 b1=new JButton("Back");
	 b1.setBounds(1200,600,100,30);
	 add(b1);
	 b1.addActionListener(this);
	 
  	 String []column={"id","name","rate","suggestion","date"};
	  String name[]=new String[6];
	  
	  try
	  {
	        Class.forName("com.mysql.jdbc.Driver");  
	   
	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	   
	        Statement st=con.createStatement();
		
            ResultSet rs = st.executeQuery("SELECT st_id,s_name,rate,suggestion,date FROM feedback");
			
            ResultSetMetaData rsmd = rs.getMetaData();
			
            int col = rsmd.getColumnCount();

            for (int i = 1; i <= col; i++ ) 
			{
               name[i] = rsmd.getColumnName(i);
			   
			   System.out.println(name[i]);
            }
          			
			s_id=name[1];
			s_name=name[2];
			rate=name[3];
			suggestion=name[4];
			date=name[5];
            rows++;		
			
			while(rs.next())
			{
			   s_id=rs.getString(1);
			   s_name=rs.getString(2);
			   rate=rs.getString(3);
			   suggestion=rs.getString(4);
			   date=rs.getString(5);			   
			   
			   rows++;
			}
			//System.out.println(rows);
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	 try
	 {	
        Class.forName("com.mysql.jdbc.Driver");
	   
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	   
	    Statement st=con.createStatement();
		
        ResultSet rs = st.executeQuery("SELECT st_id,s_name,rate,suggestion,date FROM feedback");
			  
		ResultSetMetaData rsmd=rs.getMetaData();
		
		col=rsmd.getColumnCount();
		
		data=new Object[rows][5];
				
	    for(int i1=0;i1<rows;i1++)
		{
			rs.next();
			for(int j1=0;j1<col;j1++)
			{
				data[i1][j1]=rs.getString(j1+1);
			}
		}
		System.out.println("complete");
		rs.close();
		con.close();
		st.close();
	 }
	 catch(Exception e)
	 {
	    System.out.println(e);
	 }
	  JTable table=new JTable(data,column);

	//getRootPane().setDefaultButton(b1);
    //b1.requestFocus();
		
	add(table);
	
    setSize(1400,900);
	setVisible(true);
  }
  public void actionPerformed(ActionEvent e)
  {
	  new Admin();
	  dispose();
  }
  public static void main(String...a)
  {
     new ViewFeedback();
  }
}