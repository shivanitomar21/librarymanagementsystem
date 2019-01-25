import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class IssueBook extends JFrame implements ActionListener,KeyListener,FocusListener
{
  JLabel l1,l2,l3,l4,l5,l6;
  JLabel el0,el1,el2,el3;
  JTextField t1,t2,t3,t4;
  JButton b1,b2;
  
  IssueBook()
  {
	//setContentPane(new JLabel(new ImageIcon("E:\\minipro\\bookimage4.jpg")));
	
	l1=new JLabel("Issue Book");
	l1.setBounds(130,30,300,50);
	//l1.setForeground(new Color(124,252,0));
	l1.setFont(new Font("Lucida Handwriting",Font.BOLD,37));

	l2=new JLabel("Book Call No. :");	
	l2.setBounds(60,110,170,30);
	//l2.setForeground(new Color(124,252,0));
	l2.setFont(new Font("Lucida Handwriting",Font.BOLD,17));

	l3=new JLabel("Student id :");	
	l3.setBounds(60,170,170,30);
	//l3.setForeground(new Color(124,252,0));
	l3.setFont(new Font("Lucida Handwriting",Font.BOLD,17));

	l4=new JLabel("Student Name :");	
	l4.setBounds(60,230,170,30);
	//l4.setForeground(new Color(124,252,0));
	l4.setFont(new Font("Lucida Handwriting",Font.BOLD,17));

	l5=new JLabel("Student Contact :");	
	l5.setBounds(60,290,200,30);
	//l5.setForeground(new Color(124,252,0));
	l5.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	
	l6=new JLabel("Note: please check Student ID carefully before issuing Book!");
	l6.setForeground(Color.red);
	l6.setBounds(30,410,480,30);
	l6.setFont(new Font("Arial",Font.BOLD,17));
	
	el0=new JLabel();
	el0.setBounds(370,110,200,30);
	el0.setFont(new Font("Arial",Font.BOLD,17));
	el0.setForeground(Color.red);
	
	el1=new JLabel();
	el1.setBounds(370,170,200,30);
	el1.setFont(new Font("Arial",Font.BOLD,17));
	
	el2=new JLabel();
	el2.setBounds(370,230,200,30);
	el2.setFont(new Font("Arial",Font.BOLD,17));
	
	el3=new JLabel();
	el3.setBounds(370,290,300,30);
	el3.setFont(new Font("Arial",Font.BOLD,17));
	
	t1=new JTextField();
	t1.setBounds(260,110,100,30);
	
	t2=new JTextField();
	t2.setBounds(260,170,100,30);
	
	t3=new JTextField();
	t3.setBounds(260,230,100,30);
	
	t4=new JTextField();
	t4.setBounds(260,290,100,30);

	b1=new JButton("Issue Book");	
	b1.setBounds(70,350,150,40);
	b1.setForeground(new Color(0,0,128));
	b1.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	
	b2=new JButton("Back");
	b2.setBounds(270,350,150,40);
	b2.setForeground(new Color(0,0,128));
	b2.setFont(new Font("Lucida Handwriting",Font.BOLD,17));

	getRootPane().setDefaultButton(b1);
	b1.requestFocus();
		
	add(l1);
	add(l2);
	add(l3);
	add(l4);
	add(l5);
	add(l6);
	
	add(t1);
	add(t2);
	add(t3);
	add(t4);
	
	add(el0);
	add(el1);
	add(el2);
	add(el3);
	
	add(b1);
	add(b2);
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	
	b1.addKeyListener(this);
	b2.addKeyListener(this);
	
	t1.addFocusListener(this);
	t2.addFocusListener(this);
	t3.addFocusListener(this);
	t4.addFocusListener(this);
	
	Toolkit t=Toolkit.getDefaultToolkit();
	Dimension d=t.getScreenSize();
	int w=(int)d.getWidth();
	int h=(int)d.getHeight();
	setLocation((w-600)/2,(h-510)/2);
	
	setResizable(false);
	setSize(600,510);
	setLayout(null);
	setVisible(true);
  }
  public void focusGained(FocusEvent e)
  {
		//empty check
		if(t1.isFocusOwner() || t1.getText().isEmpty())//call_no
		{ 
		   el0.setText("");
		   t1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}
		if(t2.isFocusOwner() || t2.getText().isEmpty())//Book_name
		{
		   el1.setText("");
		   t2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}
		if(t3.isFocusOwner() || t3.getText().isEmpty())//author
		{
	       el2.setText("");
		   t3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}
		if(t4.isFocusOwner() || t4.getText().isEmpty())//publisher
		{
		   el3.setText("");
		   t4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}
  }
  public void focusLost(FocusEvent e)
  {
	  //Book_call_no constraint
	  if(!t1.isFocusOwner() && !t1.getText().isEmpty() )
      {
		  int cc=callNoConstraint();
		  
			if(cc==1)
			{
			  el0.setText("");
			  t1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
			}
			else
			{
			  t1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
		    }
	  }
	  //Student_id constraint
	  if(!t2.isFocusOwner() && !t2.getText().isEmpty() )
      {
		  int ic=idConstraint();
		  
			if(ic==1)
			{
			  el1.setText("");
			  t2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
			  
			  try
		      {
	            Class.forName("com.mysql.jdbc.Driver");  
	   
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	   
	            PreparedStatement ps=con.prepareStatement("select name from student where id=?");
		   
		        int id=Integer.parseInt(t2.getText());
				   
		        ps.setInt(1,id);
				   
		        ResultSet rs=ps.executeQuery();
	
		        while(rs.next())
		        {
			      String s=rs.getString(1);
			   
			      t3.setText(s);
		        }
		      }
	    	  catch(Exception e0)
		      {
			     System.out.println(e0);
		      }
			}
			 else
			{
			  t2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
			}
	  }
	  //Student_name constraint
	  if(!t3.isFocusOwner() && !t3.getText().isEmpty() )
      {
		  int nc=nameConstraint();
		  
			if(nc==1)
			{
			  el2.setText("");
			  t3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
			}
			 else
			{
			  t3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
			}
	  }
	  //Student_contact_no constraint
	  if(!t4.isFocusOwner() && !t4.getText().isEmpty() )
      {
		  int cc=contactConstraint();
		  
			if(cc==1)
			{
			  el3.setText("");
			  t4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
			}
			 else
			{
			  t4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
			}
	  }
  }
  public void keyPressed(KeyEvent e)
  {
     if(e.getKeyCode()==e.VK_ENTER)
     {
	   if(e.getSource()==b1)
	   {
		 int ec=emptyConstraint();
		 
		 if(ec==0)//no field is empty
		 {
			int cn=callNoConstraint();
			
            int i1=idConstraint();
		 
		    int cc=contactConstraint();

	        int nc=nameConstraint();
			
	        if( (cc==1) && (i1==1) && (nc==1) && (cn==1) )
		    {
			   fillValue();
            
			   reset();
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
  public void keyReleased(KeyEvent e)
  {
	  
  }
  public void keyTyped(KeyEvent e)
  {

  }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==b1)
	 {
		 int ec=emptyConstraint();
		 
		 if(ec==0)//no field is empty
		 {
            int i1=idConstraint();
		 
		    int cn=contactConstraint();

	        int nc=nameConstraint();
		
	        if( (i1==1) && (nc==1) && (cn==1) )
		    {
        	   fillValue();

			   reset();
			}
	      }
	 }
	else if(e.getSource()==b2)
	  {
	    new LibrarianSection();
		dispose();
	  }
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
	   
	        ResultSet rs=st.executeQuery("select call_no from add_books");

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
		 }
		 catch(Exception e)
		 {
		   System.out.println(e);
		 }
		 return cc;
  }
  public int nameConstraint()
  {
	 int nc=1;
		
	 String name1=t3.getText();
     char name2[]=name1.toCharArray();

     for(char i:name2)
     {
         if(!Character.isLetter(i))
         {
			 if(i!=' ')
			 {
        	   nc=0;
        	   break;
			 }
         }
     }
	 if(nc==0)
	 {
		el2.setText("invalid name");
		el2.setForeground(Color.red);
	 }
	 else el2.setText("");
	 return nc;
	 
  }
  public int emptyConstraint()
  {
	 int ec=0;
	 
	if(t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() )
	{
	   ec=1;
	   JOptionPane.showMessageDialog(this,"all fields required","alert message",JOptionPane.WARNING_MESSAGE);
	}
	return ec;
  }

	public int contactConstraint()
	{
		int flag2=0,count=0;
		
          if(!t4.getText().isEmpty())
          {
            String st1=t4.getText();
            char str[]=st1.toCharArray();
            int chr=1;

            for(char ch:str)
            {
           		if(!(ch>=48 && ch<=57))
				{
           			chr=0;
					break;
				}
            }

            if(chr==0)
            {
           		el3.setText("no. must contain digits only");
                el3.setForeground(Color.red);
				return chr;
            }

            if(chr==1)
            {
		 	    long num=Long.parseLong(t4.getText());			

			    while(num>0)
			    {
				  count++;
				  num=num/10;
			    }
			    if(count==10)
				  flag2=1;
			    else flag2=0;
			
		    	if(flag2==0)
			    {
				   el3.setText("contact no. must be of 10 digits");
				   el3.setForeground(Color.red);
			    }
			    else if(flag2==1)
				  el3.setText("");
             }
         } 
		 return flag2;
	}
  public int idConstraint()
  {
	int flag=0;
	
	try
	{
	   Class.forName("com.mysql.jdbc.Driver");
	   
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	   
	   PreparedStatement ps=con.prepareStatement("select * from student where id=?");

		        int id=Integer.parseInt(t2.getText());
				   
		        ps.setInt(1,id);	   
	 
	   ResultSet rs=ps.executeQuery();
	   
	   while(rs.next())
	   {
		   flag=1;
	   }
	   
	}
	catch(Exception e)
	{
         System.out.println(e);		
	}
	 if(flag==0)
	 {
		el1.setText("invalid id");
		el1.setForeground(Color.red);
	 }
	 else el1.setText("");
	 
	 return flag;
  }
  public void fillValue()
  {
	  int book_id=0;
	  String iss="";
	  int issue=0;
	  try
	  {
		   Class.forName("com.mysql.jdbc.Driver");
					 
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
					
		   PreparedStatement ps1=con.prepareStatement("insert into issue_book (book_id,book_call_no,student_id,student_name,student_contact,issued_date) values(?,?,?,?,?,?)");
		   
		   ps1.setInt(1,book_id);
		   ps1.setString(2,t1.getText());
		   ps1.setString(3,t2.getText());
		   ps1.setString(4,t3.getText());
		   ps1.setLong(5,Long.parseLong(t4.getText()) );
		   
		   Timestamp date=new Timestamp(new java.util.Date().getTime());
		   ps1.setTimestamp(6,date);
		   
		   iss=t1.getText();
		   
		   ps1.execute();
		   
		   int q=0,i=0;
				
		   PreparedStatement ps2=con.prepareStatement("select quantity,issued from add_books where call_no=?");
           ps2.setString(1,t1.getText());
		 
	       ResultSet rs=ps2.executeQuery(); 
		   while(rs.next())
	   	   {
			    q=rs.getInt(1);
                i=rs.getInt(2);				   
		   }
		   q--;i++;
		   System.out.println("q="+q+"i="+i);
				
  		   //Update add_books table
           PreparedStatement ps3=con.prepareStatement("update add_books set quantity=?,issued=? where call_no=?");  

		   ps3.setInt(1,q);
		   ps3.setInt(2,i);
		   ps3.setString(3,t1.getText());	
		   
           ps3.executeUpdate();			   
	  }
	  catch(Exception e)
	  {
		  System.out.println(e+"******");
	  }
  }
  public void reset()
  {
	el1.setText("");
	el2.setText("");
	el3.setText("");
    JOptionPane.showMessageDialog(this,"Book issued successfully!");
    t1.setText("");
    t2.setText("");
	t3.setText("");
	t4.setText("");
	t1.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
	t2.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
	t3.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
	t4.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
  }
  public static void main(String...a)
  {
	  new IssueBook();
  }
}