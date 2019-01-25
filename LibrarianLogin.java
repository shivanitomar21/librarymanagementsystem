import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class LibrarianLogin extends JFrame implements ActionListener,KeyListener,FocusListener
{
  int i=0;
  JLabel l1,l2,l3,ltb;
  JTextField t1;
  JPasswordField p1;
  JButton b0,b1,b2,bt;
  
  LibrarianLogin()
  {
	//setContentPane(new JLabel(new ImageIcon("E:\\minipro\\bookimage.jpg")));

    l1=new JLabel("<html><u>Librarian Login Form</u></html>");
	l1.setBounds(30,30,420,40);
	//l1.setForeground(new Color(124,252,0));
	l1.setFont(new Font("Lucida Handwriting",Font.BOLD,30));

    l2=new JLabel("Enter Username :");
	l2.setBounds(45,150,180,30);
	//l2.setForeground(new Color(124,252,0));
	l2.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	
	l3=new JLabel("Enter Password :");
	l3.setBounds(45,230,180,30);
	//l3.setForeground(new Color(124,252,0));
	l3.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	
	t1=new JTextField();
	t1.setBounds(240,150,200,30);
	
	ltb=new JLabel();
	ltb.setBounds(240,230,200,30);
	ltb.setBackground(Color.white);
	ltb.setOpaque(true);
	ltb.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
	
	p1=new JPasswordField();
    p1.setBounds(5,5,150,20);
	p1.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));
	
	bt=new JButton();
	bt.setBounds(172,3,20,20);
	bt.setForeground(Color.blue);
	bt.setBackground(Color.white);
	bt.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));
	bt.setIcon(new ImageIcon("E:\\minipro\\eye.png"));
	
	add(ltb);
	ltb.add(p1);
	ltb.add(bt);
	
	b0=new JButton("<html><i><u>forgot password ?</u></i></html>");
	b0.setBounds(310,280,150,20);
	b0.setForeground(Color.blue);
    b0.setOpaque(false);
    b0.setBackground(Color.lightGray);
    b0.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.red));
	
	b0.addActionListener(this);
	b0.addKeyListener(this);
	
	b1=new JButton("Login"); 
	b1.setBounds(90,350,120,50);
	b1.setForeground(new Color(0,0,128));
	b1.setFont(new Font("Lucida Handwriting",Font.BOLD,17));

    b2=new JButton("Back");	
	b2.setBounds(270,350,120,50);
	b2.setForeground(new Color(0,0,128));
	b2.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	
	getRootPane().setDefaultButton(b1);
    b1.requestFocus();
	
	add(l1);
	add(l2);
	add(l3);
	
	add(t1);
	
	add(b0);
	add(b1);
	add(b2);
	
	bt.addActionListener(this);
	b0.addActionListener(this);
	b1.addActionListener(this);
	b2.addActionListener(this);
	
	b1.addKeyListener(this);
	b2.addKeyListener(this);
	
	t1.addFocusListener(this);
	p1.addFocusListener(this);
	
	Toolkit t=Toolkit.getDefaultToolkit();
	Dimension d=t.getScreenSize();
	int w=(int)d.getWidth();
	int h=(int)d.getHeight();
	setLocation((w-500)/2,(h-500)/2);

    setResizable(false);	
	setSize(500,500);
	setLayout(null);
	setVisible(true);
  }
  public void focusGained(FocusEvent e)
  {	
		//empty check
		if(t1.isFocusOwner() || t1.getText().isEmpty())
		{
		   t1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}
		if(p1.isFocusOwner() || p1.getText().isEmpty())
		{
		   ltb.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}
  }
  public void focusLost(FocusEvent e)
  {
		String uname=t1.getText().toLowerCase();
		String pwd= p1.getText();//.toLowerCase();
	
		
	  if(!t1.isFocusOwner() && !t1.getText().isEmpty() )
      {
		  int uc=usernameConstraint();
		  
		  if(uc==1)
		  {
			 t1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
		  }
		  else 
		  {
			 t1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
		  }
	  }		
      if( !p1.isFocusOwner() && !p1.getText().isEmpty())
      {
		  int pc=passwordConstraint();
		  
		  if(pc==1)
		  {
			 ltb.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
		  }
		  else
		  {
			 ltb.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
		  }  		
	  }	
  }
  public void keyPressed(KeyEvent e)
  {
	if(e.getKeyCode()==e.VK_ENTER)
    {
		if(b1.isFocusOwner())
		{
          int uc=usernameConstraint();
	      int pc=passwordConstraint();
	   
	      if(uc==0 && pc==0)
		    JOptionPane.showMessageDialog(this,"both username & password incorrect","check again",JOptionPane.WARNING_MESSAGE);
	 
	      else if(pc==0)
	        JOptionPane.showMessageDialog(this,"incorrect password","check again",JOptionPane.WARNING_MESSAGE);
	 
	      else if(uc==0)
		    JOptionPane.showMessageDialog(this,"incorrect username","check again",JOptionPane.WARNING_MESSAGE);
	   
	      if(uc==1 && pc==1)
	      {
             dispose();
	         new LibrarianSection();  		 		   
	      }       
		}
		else if(b2.isFocusOwner())
		{
			dispose();
			new Admin();
		}
	}		
  }
  public void keyReleased(KeyEvent e)
  {}
  public void keyTyped(KeyEvent e)
  {}
  public void actionPerformed(ActionEvent e)
  {
	  
	//********* [hiding and unhiding password] ********	  
    if(e.getSource()==bt)
	{
		//String s=p1.getText();
		//String s1="";
		/*for(int i=1;i<=s.length();i++)
		{
			s1=s1+"\u2022";
		}*/
		i++;
		if(i%2!=0)
		{
		   p1.setEchoChar((char)0);
		   bt.setIcon(new ImageIcon("E:\\minipro\\eyeclose.png"));
		}
		else if(i%2==0)
		{
 		   p1.setEchoChar('*');
		   //p1.setText(s1);
		   bt.setIcon(new ImageIcon("E:\\minipro\\eye.png"));
		}
	}
	/*
	 if(e.getActionCommand().equals("<html><u>show</u></html>"))
	 {
		bt.setText("<html><u>hide</u></html>");
		p1.setEchoChar((char)0);
	 }
	 else if(e.getActionCommand().equals("<html><u>hide</u></html>"))
	 {
		 bt.setText("<html><u>show</u></html>");
		 p1.setEchoChar('*');
	 }*/
	 else if(e.getSource()==b0)
	 {
		new Varify1();
	 }
	 else if(e.getActionCommand().equals("Login"))
	 {
       int uc=usernameConstraint();
	   int pc=passwordConstraint();
	   
	   if(uc==0 && pc==0)
		 JOptionPane.showMessageDialog(this,"both username & password incorrect","check again",JOptionPane.WARNING_MESSAGE);
	 
	   else if(pc==0)
	     JOptionPane.showMessageDialog(this,"incorrect password","check again",JOptionPane.WARNING_MESSAGE);
	 
	   else if(uc==0)
		   JOptionPane.showMessageDialog(this,"incorrect username","check again",JOptionPane.WARNING_MESSAGE);
	   
	   if(uc==1 && pc==1)
	   {
          dispose();
	      new LibrarianSection();  		 		   
	   }
	 }
	 else if(e.getSource()==b2)
	 {
		 dispose();
		 new Admin();
	 }
  }
  public int usernameConstraint()
  {
	 int uc=1;
	 
	 String uname="";
	 
	 String un=t1.getText().toLowerCase();
		  
	 try
	 {
	      Class.forName("com.mysql.jdbc.Driver");
			
	      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	   
	      Statement st=con.createStatement();
	   
	       ResultSet rs=st.executeQuery("select username from librarian");

	         while(rs.next())
	         {
        		uname=rs.getString(1).toLowerCase();

	    		 if(!un.equals(uname))
	             {  
			         uc=0;
	             }
				 else
			     {
					 uc=1;
					 break;
				 }
	          }	 
	       }
	      catch(Exception e0)
	      {
	         System.out.println(e0);
	      }	  
		 return uc;
  }
  public int passwordConstraint()
  {
	  int pc=1;
	  String pwd="";
	  
	  try
	  {
	     Class.forName("com.mysql.jdbc.Driver");
	     
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	   
	     Statement st=con.createStatement();
	   
	     ResultSet rs=st.executeQuery("select password from librarian");

		 while(rs.next())
	     {
            pwd=rs.getString(1);
				
			if(p1.getText().equals(pwd))
	        { 
		        pc=1;
			    break;
	        }
		    else 
			{
			   pc=0;
		    }	
	     }	  
	   }
	      catch(Exception e0)
	      {
	         System.out.println(e0);
	      }	  
	  return pc;
  }
  public static void main(String...a)
  {
	 new LibrarianLogin();
  }
}