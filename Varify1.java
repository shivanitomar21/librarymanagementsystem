import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class Varify1 extends JFrame implements ActionListener,FocusListener,KeyListener
{
   JLabel l1,l2,l0,l3,l4;
   JTextField t1,t2;
   JButton b1,b2,bt1,bt2;
   String ans;
   
   Varify1()
   {
      l1=new JLabel("<html><u>please enter information to search your account</u></html>");
	  l1.setBounds(30,20,300,30);
	  
	  l3=new JLabel("Username ");
	  l3.setBounds(30,60,100,30);
	  
	  t2=new JTextField();
	  t2.setBounds(150,60,150,30);
	  
	  l0=new JLabel("<html><u>Question :</u></html>");
      l0.setBounds(30,100,70,30);
	  
	  l4=new JLabel("dfgh");
	  l4.setBounds(100,100,200,30);
	  
	  t1=new JTextField();
	  t1.setBounds(65,135,200,30);
	  	  
	  b1=new JButton("Search");
	  b1.setBounds(50,180,100,30);
	  
	  b2=new JButton("Cancel");
	  b2.setBounds(170,180,100,30);
	  
	  l2=new JLabel("Note: you are required to enter both the fields");
	  l2.setBounds(30,230,300,30);
	  l2.setForeground(Color.red);
	  
	  add(l0);
	  add(l1);
	  add(l2);
	  add(l3);
	  add(l4);
	  
	  add(t1);
	  add(t2);
	  
	  add(b1);
	  add(b2);

      b1.addActionListener(this); 
      b2.addActionListener(this);
	  
	  b1.addKeyListener(this);
	  b2.addKeyListener(this);
	  
      t1.addFocusListener(this);
	  
	  Toolkit t=Toolkit.getDefaultToolkit();
	  Dimension d=t.getScreenSize();
	  int w=(int)d.getWidth();
	  int h=(int)d.getHeight();
	  setLocation((w-350)/2,(h-350)/2);
	  
	  setLayout(null);
	  setSize(350,350);
	  setVisible(true);
   }
   public void keyPressed(KeyEvent e)
   {
      if(e.getKeyCode()==KeyEvent.VK_ENTER) 
	  {
	    if(e.getSource()==b1)
	    {
		     if( t1.getText().isEmpty()&&t2.getText().isEmpty() )
			   JOptionPane.showMessageDialog(this,"enter value for fields");
		    
			else
		    {
		       int flag=search();
		
			   if(flag==1)
			   {
				 new ResetPassword(t1,t2);
				 dispose();
			   }
		    }
	    }
	    else if(e.getSource()==b2)
	    {
		   new LibrarianLogin();
		   dispose();
	    }		  
	  }
   }
   public void keyTyped(KeyEvent e)
   {

   }
   public void keyReleased(KeyEvent e)
   {
	   
   }
   public void actionPerformed(ActionEvent e)
   {
	   if(e.getSource()==b1)
	   {
		     int flag=search();
		   	  if(flag==0)
			    JOptionPane.showMessageDialog(this,"incorrect username");
		
	          else if( t1.getText().isEmpty() || t2.getText().isEmpty())
			    JOptionPane.showMessageDialog(this,"both fields required");
			  
			  else if(t1.getText().equals(ans))
			  {
				System.out.println(ans);
				new ResetPassword(t1,t2);
			  }
			  else if(!t1.getText().equals(ans))
			  {
				JOptionPane.showMessageDialog(this,"wrong answer");  
			  }
	   }
	   else if(e.getSource()==b2)
	   {
		   new LibrarianLogin();
		   dispose();
	   }
   }
   public void focusGained(FocusEvent e)
   { 
      if(t1.isFocusOwner())
		  search();
   }
   public void focusLost(FocusEvent e)
   {
	  // if(!t2.isFocusOwner() && !t2.getText().isEmpty())
        // search();
   }
   public int search()
   {
	    int flag=0;
	     
		try
		{
		    Class.forName("com.mysql.jdbc.Driver");
			  
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			
	        PreparedStatement ps=con.prepareStatement("select s_que,s_ans,username from librarian where username=?");

			ps.setString(1,t2.getText());
			
			ResultSet rs=ps.executeQuery();
			
	        while(rs.next())
	        {
				if(t2.getText().equals(rs.getString(3)))
				{
				  flag=1;
				  String s=rs.getString(1);
								
			      ans=rs.getString(2);

				  l4.setText(s);
				}
	        }
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	     return flag;		 
   }
   public static void main(String...a)
   {
	   new Varify1();
   }
}