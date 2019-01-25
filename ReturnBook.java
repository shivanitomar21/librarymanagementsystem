import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ReturnBook extends JFrame implements ActionListener,KeyListener
{
   JLabel l1,l2,l3,l4;
   JLabel el0,el1;
   JTextField t1,t2;
   JButton b1,b2;
   
   
   ReturnBook()
   {
	 //setContentPane(new JLabel(new ImageIcon("E:\\minipro\\bookimage.jpg")));
	  
     l1=new JLabel("<html><u>Return Book</u></html>");
	 l1.setFont(new Font("Lucida Handwriting",Font.BOLD,37));
	 //l1.setForeground(new Color(124,252,0));
	 l1.setBounds(80,30,320,50);
	 
     l2=new JLabel("Book Call No.:");
	 l2.setBounds(40,110,150,30);
	 //l2.setForeground(new Color(124,252,0));
	 l2.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	 
     l3=new JLabel("Student ID:");
	 l3.setBounds(40,170,150,30);
	 //l3.setForeground(new Color(124,252,0));
	 l3.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	 
     l4=new JLabel("Note: Check the book properly!");
	 l4.setForeground(Color.red);
	 l4.setFont(new Font("Arial",Font.BOLD,17));
	 l4.setBounds(40,310,400,30);
	 
	 t1=new JTextField();
	 t1.setBounds(215,110,120,30);
	 
	 t2=new JTextField();
	 t2.setBounds(215,170,120,30);
	 
	 b1=new JButton("Return Book");
	 b1.setBounds(40,240,160,40);
	 b1.setForeground(new Color(0,0,128));
	 b1.setFont(new Font("Lucida Handwriting",Font.BOLD,15));
	 
	 b2=new JButton("Back");
	 b2.setBounds(250,240,160,40);
	 b2.setForeground(new Color(0,0,128));
	 b2.setFont(new Font("Lucida Handwriting",Font.BOLD,15));
	 
	 el0=new JLabel();
	 el0.setBounds(345,110,200,30);
	 el0.setFont(new Font("Arial",Font.BOLD,17));
	 el0.setForeground(Color.red);
	 
	 el1=new JLabel();
	 el1.setBounds(345,170,200,30);
	 el1.setFont(new Font("Arial",Font.BOLD,17));
	 el1.setForeground(Color.red);
				
	getRootPane().setDefaultButton(b1);
    b1.requestFocus();
	
	 add(l1);
	 add(l2);
	 add(l3);
	 add(l4);
	 
	 add(t1);
	 add(t2);
	 
	 add(b1);
	 add(b2);
	 
	 add(el0);
	 add(el1);
	 
	 b1.addActionListener(this);
	 b2.addActionListener(this);
	 
	 b1.addKeyListener(this);
	 b2.addKeyListener(this);
	
     Toolkit t=Toolkit.getDefaultToolkit();
     Dimension d=t.getScreenSize();
     int w=(int)d.getWidth();
     int h=(int)d.getHeight();
     setLocation((w-500)/2,(h-500)/2);
	 
	 setResizable(false);
	 setSize(500,400);
	 setLayout(null);
	 setVisible(true);
   }
   public void keyTyped(KeyEvent e)
   {}
   public void keyReleased(KeyEvent e)
   {}
   public void keyPressed(KeyEvent e)
   {
	  if(e.getKeyCode()==e.VK_ENTER)
      {
    if(e.getSource()==b1)
	 {
		String s1=t1.getText();
		String s2=t2.getText();
		if( s1.isEmpty() || s2.isEmpty() )
			JOptionPane.showMessageDialog(this,"all Fields required","alert message",JOptionPane.WARNING_MESSAGE);
		
	  else 
	  {
		int cc=callNoConstraint();
		
		if(cc==1)
		{
		   int ic=IdConstraint();
		
		   if(ic==1)
	       {
			  int ar=checkAlreadyReturnedAndUpdateadd_books();
			  
			  if(ar==0)
			  {
			    fillValue();
			  
		        el0.setText("");
		        el1.setText("");
	            JOptionPane.showMessageDialog(this,"book returned successfully");
		        t1.setText("");
		        t2.setText("");
			  }
			  else
			  {
	            JOptionPane.showMessageDialog(this,"already the book has been returned");
			  }
	       }
	    }
	 }
   }
	 else if(e.getSource()==b2)
	 {
	   new LibrarianSection();
	   dispose();
	 }
   }		  
 }
   public void actionPerformed(ActionEvent e)
   {
     if(e.getSource()==b1)
	 {
		String s1=t1.getText();
		String s2=t2.getText();
		if( s1.isEmpty() || s2.isEmpty() )
			JOptionPane.showMessageDialog(this,"all Fields required","alert message",JOptionPane.WARNING_MESSAGE);

	  else 
	  {
		int cc=callNoConstraint();
		
		if(cc==1)
		{
		   int ic=IdConstraint();
		
		   if(ic==1)
	       {
			  int ar=checkAlreadyReturnedAndUpdateadd_books();
			  
			  if(ar==0)
			  {
			    fillValue();
			  
		        el0.setText("");
		        el1.setText("");
	            JOptionPane.showMessageDialog(this,"book returned successfully");
		        t1.setText("");
		        t2.setText("");
			  }
			  else
			  {
	            JOptionPane.showMessageDialog(this,"unable to return the book");
			  }
	       }
	    }
	 }
   }
	 else if(e.getSource()==b2)
	 {
	   new LibrarianSection();
	   dispose();
	 }
 }
 public int checkAlreadyReturnedAndUpdateadd_books()
 {
	 int ar=0;
	 String ret="";
	  try
	  {
		   Class.forName("com.mysql.jdbc.Driver");
					 
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		   
    	   //Selection
           PreparedStatement ps1=con.prepareStatement("select returned from issue_book where book_call_no=? and Student_id=?");
           ps1.setString(1,t1.getText());
		   ps1.setInt(2,Integer.parseInt(t2.getText()) );
			  
	       ResultSet rs=ps1.executeQuery();            
		   
		   while(rs.next())
		   {
	         ret=rs.getString(1);
		  
	        if(ret.equals("yes"))
			   ar=1;
		    else
			{
				int q=0,i=0;
				
				PreparedStatement ps2=con.prepareStatement("select quantity,issued from add_books where call_no=?");
                ps2.setString(1,t1.getText());
		 
	            rs=ps2.executeQuery(); 
				while(rs.next())
				{
				   q=rs.getInt(1);
                   i=rs.getInt(2);				   
				}
				q++;i--;
				System.out.println("q="+q+"i="+i);
				
  		       //Update add_books table
               PreparedStatement ps3=con.prepareStatement("update add_books set quantity=?,issued=? where call_no=?");  

			   ps3.setInt(1,q);
			   ps3.setInt(2,i);
		       ps3.setString(3,t1.getText());	
               ps3.executeUpdate();			   
			}
		  }	   
	  }
	  catch(Exception e)
	  {
		  System.out.println(e+"**");
	  }
	  return ar;
 }
 public void fillValue()
 {
	  try
	  {
		   Class.forName("com.mysql.jdbc.Driver");
					 
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
					
		   //Update issue_book table
           PreparedStatement ps1=con.prepareStatement("update issue_book set return_date=?,returned=? where book_call_no=? and Student_id=?");  
  	  	   
		   Timestamp date=new Timestamp(new java.util.Date().getTime());
		   ps1.setTimestamp(1,date);
		   ps1.setString(2,"yes");
		   ps1.setString(3,t1.getText());
		   ps1.setInt(4,Integer.parseInt(t2.getText()) );
		
           int i3=ps1.executeUpdate();  
           System.out.println(i3+" record updated");   
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
 }
   public int IdConstraint()
   {
	   int ic=1;
	   
	   String id=t2.getText();
	   
	   String sid="";
	   
		try
		{
		    Class.forName("com.mysql.jdbc.Driver");
			  
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	   
	        PreparedStatement ps=con.prepareStatement("select student_id from issue_book where book_call_no=?");

            ps.setString(1,t1.getText()); 	
			
    	    ResultSet rs=ps.executeQuery();
			
	         while(rs.next())
	         {
				 sid=rs.getString(1);
				
	    		 if(id.equals(sid) )
	             {
					 ic=1;
					 el1.setText("");
					 break;
	             }
				 else
				 {
					 ic=0;
				 }
	          }
			if(ic==0)
		      el1.setText("invalid id");
		 }
		 catch(Exception e)
		 {
		   System.out.println(e);
		 }
		 return ic;
   }
   public int callNoConstraint()
  {
	  int cc=1;
	  String cno=t1.getText().toLowerCase();
	  String callno="";
		try
		{
		    Class.forName("com.mysql.jdbc.Driver");
			  
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			
		    Statement st=con.createStatement();
	   
	        ResultSet rs=st.executeQuery("select book_call_no from issue_book");

	         while(rs.next())
	         {
           		 callno=rs.getString(1).toLowerCase();
				
	    		 if(cno.equals(callno) )
	             {
					 cc=1;
					 el0.setText("");
					 break;
	             }
				 else
				 {
					 cc=0;
				 }
	          }
			if(cc==0)
		      el0.setText("invalid book call no");
		    else if(cc==1)
			  el0.setText("");
		 }
		 catch(Exception e)
		 {
		   System.out.println(e);
		 }
		 return cc;
  }
   public static void main(String...a)
   {
	   new ReturnBook();
   }
}