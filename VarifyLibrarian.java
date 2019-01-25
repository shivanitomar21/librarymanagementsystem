import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

//import org.jdesktop.swingX.prompt.PromptSupport;

class VarifyLibrarian extends JFrame implements ActionListener,FocusListener,KeyListener
{
   String s1,s2,s3,s4,s5,s6,s7,s8,s10,s11;
   Long s9;
   JLabel l1,l2,ltb1,ltb2;
   JTextField t1,t2;
   JButton b1,b2,bt1,bt2;
   //TextPrompt tp1,tp2;
   
   VarifyLibrarian()
   {
      l1=new JLabel("<html><u>please enter information to search your account</u></html>");
	  l1.setBounds(30,20,300,30);
	  
	  ltb1=new JLabel();
	  ltb1.setBounds(50,70,200,30);
	  ltb1.setBackground(Color.white);
	  ltb1.setOpaque(true);
	  ltb1.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
	  
	  t1=new JTextField("enter Id");
	  t1.setBounds(40,5,155,20);
	  t1.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));	  
      t1.setForeground(Color.gray);
	  
	  bt1=new JButton();
	  bt1.setBounds(5,3,20,20);
	  bt1.setForeground(Color.blue);
	  bt1.setBackground(Color.white);
	  bt1.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));
      bt1.setIcon(new ImageIcon("E:\\minipro\\username.png"));
	  
	  add(ltb1);
	  ltb1.add(bt1);
	  ltb1.add(t1);

	  ltb2=new JLabel();
	  ltb2.setBounds(50,120,200,30);
	  ltb2.setBackground(Color.white);
	  ltb2.setOpaque(true);
	  ltb2.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
	  
	  t2=new JTextField("username");
	  t2.setBounds(40,5,155,20);
	  t2.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));
      t2.setForeground(Color.gray);
	  
	  bt2=new JButton();
	  bt2.setBounds(5,5,20,20);
	  bt2.setForeground(Color.blue);
	  bt2.setBackground(Color.white);
	  bt2.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));
      bt2.setIcon(new ImageIcon("E:\\minipro\\username.png"));
	  
	  add(ltb2);
	  ltb2.add(bt2);
	  ltb2.add(t2);
	  
	  b1=new JButton("Search");
	  b1.setBounds(50,180,100,30);
	  
	  b2=new JButton("Cancel");
	  b2.setBounds(170,180,100,30);
	  
	  l2=new JLabel("Note: you are required to enter both the feilds");
	  l2.setBounds(30,230,300,30);
	  l2.setForeground(Color.red);
	  
	  add(l1);
	  add(l2);
	  
	  //add(t1);
	  //add(t2);
	  
	  add(b1);
	  add(b2);

      b1.addActionListener(this); 
      b2.addActionListener(this);
	  
	  b1.addKeyListener(this);
	  b2.addKeyListener(this);
	  
      t1.addFocusListener(this);
      t2.addFocusListener(this);
	  
	  //getRootPane().setDefaultButton(b1);
      //b1.requestFocus();

	  t1.addKeyListener(this);
      t2.addKeyListener(this);
	  
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
		     if( (t1.getText().isEmpty() || t1.getText().equals("enter Id")) || (t2.getText().isEmpty() || t2.getText().equals("username")) )
			   JOptionPane.showMessageDialog(this,"enter value for both the feilds");
		    
			else
		    {
		       int flag=search();
		
			   if(flag==1)
			   {
				  JOptionPane.showMessageDialog(this,"correct info");
	//			 new ResetPassword(t1,t2);
				 //dispose();
			   }
		    }
	    }
	    else if(e.getSource()==b2)
	    {
		   dispose();
	    }		  
	  }
   }
   public void keyTyped(KeyEvent e)
   {
	   if(e.getSource()==t1)
	   {
		   t1.setForeground(Color.black);
	   }
	   if(e.getSource()==t2)
	   {
		   t2.setForeground(Color.black);
	   }
   }
   public void keyReleased(KeyEvent e)
   {
	  /* if(e.getSource()==t1)
	   {
		   if(t1.getText().isEmpty())
		   {	
              t1.setText("enter Id");	   
		     t1.setForeground(Color.color);
		   }
	   }
	   if(e.getSource()==t2)
	   {
		   if(t2.getText().isEmpty())
		   {
			   t2.setText("enter contact nummber");
		       t2.setForeground(Color.black);
		   }
	   }*/	   
   }
   public void actionPerformed(ActionEvent e)
   {
	   if(e.getSource()==b1)
	   {
		  if( (t1.getText().isEmpty() || t1.getText().equals("enter Id")) || (t2.getText().isEmpty() || t2.getText().equals("username")) )
			  JOptionPane.showMessageDialog(this,"enter value for both the feilds");
		  else
		  {
		    int flag=search();
		
			if(flag==1)
			{
				int id=fetchValues();
				
				new EditLibrarian(id,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11);
				dispose();
				 //JOptionPane.showMessageDialog(this,"correct info");
				//new ResetPassword(t1,t2);
				//dispose();
			}
		  }
	   }
	   else if(e.getSource()==b2)
	   {
		   dispose();
	   }
   }
   public void focusGained(FocusEvent e)
   { 
       // if(t1.isFocusOwner() && !t1.getText().equals("enter Id") && !t1.getText().isEmpty() )
		//{
			//t1.setForeground(Color.black);
	//	}
		
	  	if(t1.isFocusOwner() && t1.getText().equals("enter Id")  ) 
	    {
		   t1.setText("");
		  // t1.ForeColor(Color.red);
		   t1.setForeground(Color.gray);
		}
	    if(t2.isFocusOwner() && t2.getText().equals("username") )
		{
		   t2.setText("");
		   t2.setForeground(Color.gray);
		}
   }
   public void focusLost(FocusEvent e)
   {	  
	  if(t1.getText().isEmpty())
	  {
         t1.setText("enter Id");
		 t1.setForeground(Color.gray);
	  }
      if(t2.getText().isEmpty())
	  {
         t2.setText("username");	
		 t2.setForeground(Color.gray);
	  }
   }
   public int search()
   {
	    int flag=0;
	     
		try
		{
		    Class.forName("com.mysql.jdbc.Driver");
			  
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			
	        PreparedStatement ps=con.prepareStatement("select username from librarian where id=?");

			int id=Integer.parseInt(t1.getText());
       
            ps.setInt(1,id); 	
			
			ResultSet rs=ps.executeQuery();
			
	        while(rs.next())
	        {
				String s=rs.getString(1);
				
				if(t2.getText().equals(s))
				{
					flag=1;
					break;
				}
	        }
			if(flag==0)
				JOptionPane.showMessageDialog(this,"Invalid information");
		 }
		 catch(Exception e)
		 {
		    System.out.println(e);
		 }
	     return flag;
   }
   public int fetchValues()
   {
	   int id=0;
		try
		{
		    Class.forName("com.mysql.jdbc.Driver");
			  
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			
	        PreparedStatement ps=con.prepareStatement("select username,name,password,email,gender,qualification,country,city,contact_no,s_que,s_ans from librarian where id=?");

			id=Integer.parseInt(t1.getText());
       
            ps.setInt(1,id); 	
			
			ResultSet rs=ps.executeQuery();
			
	        while(rs.next())
	        {
				s1=rs.getString(1);
				s2=rs.getString(2);
				s3=rs.getString(3);
				s4=rs.getString(4);
				s5=rs.getString(5);
				s6=rs.getString(6);
				s7=rs.getString(7);
				s8=rs.getString(8);
				s9=Long.parseLong(rs.getString(9));
				s10=rs.getString(10);
				s11=rs.getString(11);
	        }
			//if(flag==0)
				//JOptionPane.showMessageDialog(this,"Invalid information");
		 }
		 catch(Exception e)
		 {
		    System.out.println(e);
		 }
         return id;		 
   }
   public static void main(String...a)
   {
	   new VarifyLibrarian();
   }
}