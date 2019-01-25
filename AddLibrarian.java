import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class AddLibrarian extends JFrame implements ActionListener,KeyListener,FocusListener,ItemListener
{
	int i=0,j=0;
	JLabel l1,unl,l2,l3,l4,l5,l6,l7,l8,l9,l0;
    JLabel euname,el1,el2,el3,el4,el5,el6,el0,ltb1,ltb2,ltb3,ltb4,ltb5;
	JTextField t0,t1,t2,t5;
	JPasswordField p1,p2;
	JButton b1,b2,bt1,bt2,bt3,bt4,bt5;
    JRadioButton rb1,rb2,rb3;
	JCheckBox ch1,ch2,ch3;
	JComboBox cmbo1,cmbo2;
	DefaultComboBoxModel dc0,dc1,dc2,dc3;
	 
	AddLibrarian()
	{
	    String select[]={""};
		String India[]={"---select city---","meerut","delhi","noida"};
		String USA[]={"---select city---","London"};
		String America[]={"---select city---","paris"};
		 
		//setContentPane(new JLabel(new ImageIcon("E:\\minipro\\bookimage3.jpg")));
		
		l1=new JLabel("<html><u>Add Librarian</u></html>");
		l1.setBounds(200,10,400,50);
		//l1.setForeground(new Color(124,252,0));
		l1.setFont(new Font("Lucida Handwriting",Font.BOLD,33));

		l2=new JLabel("Username:");
		l2.setBounds(160,78,200,30);
		//l2.setForeground(new Color(124,252,0));
		l2.setFont(new Font("Lucida Handwriting",Font.BOLD,17));

		l3=new JLabel("name:");
		l3.setBounds(160,125,200,30);
		//l3.setForeground(new Color(124,252,0));
		l3.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		
		l4=new JLabel("Password:");
		l4.setBounds(160,170,200,30);
		//l4.setForeground(new Color(124,252,0));
		l4.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		
		l5=new JLabel("Confirm Password:");
		l5.setBounds(160,215,200,30);
		//l5.setForeground(new Color(124,252,0));
		l5.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		
		l6=new JLabel("Gender:");
		l6.setBounds(160,260,200,30);
		//l6.setForeground(new Color(124,252,0));
		l6.setFont(new Font("Lucida Handwriting",Font.BOLD,17));		
		
		l7=new JLabel("Email:");
		l7.setBounds(160,350,200,30);
		//l7.setForeground(new Color(124,252,0));
		l7.setFont(new Font("Lucida Handwriting",Font.BOLD,17));

		l8=new JLabel("Country:");
		l8.setBounds(160,400,200,30);
		//l8.setForeground(new Color(124,252,0));
		l8.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		
		l9=new JLabel("City:");
		l9.setBounds(160,450,200,30);
		//l9.setForeground(new Color(124,252,0));
		l9.setFont(new Font("Lucida Handwriting",Font.BOLD,17));

		l0=new JLabel("contact no.:");
		l0.setBounds(160,500,200,30);
		//l0.setForeground(new Color(124,252,0));
		l0.setFont(new Font("Lucida Handwriting",Font.BOLD,17));

	    ltb1=new JLabel();
	    ltb1.setBounds(370,78,150,30);
	    ltb1.setBackground(Color.white);
	    ltb1.setOpaque(true);
	    ltb1.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
		
		t0=new JTextField();//username
		t0.setBounds(30,5,110,20);
		t0.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));

	    bt1=new JButton();
	    bt1.setBounds(5,5,20,20);
	    bt1.setForeground(Color.blue);
	    bt1.setBackground(Color.white);
	    bt1.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));
		bt1.setIcon(new ImageIcon("E:\\minipro\\user.png"));
		
		add(ltb1);
		ltb1.add(t0);
		ltb1.add(bt1);
		
		t1=new JTextField();//name
		t1.setBounds(370,125,150,30);
		
	    ltb2=new JLabel();
	    ltb2.setBounds(370,170,150,30);
	    ltb2.setBackground(Color.white);
	    ltb2.setOpaque(true);
	    ltb2.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
		
		p1=new JPasswordField();//password
		p1.setBounds(5,5,100,20);
	    p1.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));

	    bt2=new JButton();
	    bt2.setBounds(120,5,20,20);
	    bt2.setForeground(Color.blue);
	    bt2.setBackground(Color.white);
	    bt2.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));
		bt2.setIcon(new ImageIcon("E:\\minipro\\eye.png"));
		
		bt2.addActionListener(this);
		
		add(ltb2);
		ltb2.add(p1);
		ltb2.add(bt2);

	    ltb3=new JLabel();
	    ltb3.setBounds(370,215,150,30);
	    ltb3.setBackground(Color.white);
	    ltb3.setOpaque(true);
	    ltb3.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
		
		p2=new JPasswordField();//confirm password
		p2.setBounds(5,3,100,20);
	    p2.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));

	    bt3=new JButton();
	    bt3.setBounds(120,5,20,20);
	    bt3.setForeground(Color.blue);
	    bt3.setBackground(Color.white);
	    bt3.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));
		bt3.setIcon(new ImageIcon("E:\\minipro\\eye.png"));
		
		bt3.addActionListener(this);
		
		add(ltb3);
		ltb3.add(p2);
		ltb3.add(bt3);

	    ltb4=new JLabel();
	    ltb4.setBounds(370,350,150,30);
	    ltb4.setBackground(Color.white);
	    ltb4.setOpaque(true);
	    ltb4.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
		
		t2=new JTextField();//Email field
		t2.setBounds(30,3,110,20);
	    t2.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.gray));
		
	    bt4=new JButton();
	    bt4.setBounds(5,3,20,20);
	    bt4.setForeground(Color.blue);
	    bt4.setBackground(Color.white);
	    bt4.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));
		bt4.setIcon(new ImageIcon("E:\\minipro\\email.png"));

		add(ltb4);
		ltb4.add(t2);
		ltb4.add(bt4);
		
		t5=new JTextField();

		rb1=new JRadioButton("Male");
        rb1.setBounds(370,265,70,20);
		rb2=new JRadioButton("Female");
        rb2.setBounds(450,265,70,20);
		rb3=new JRadioButton("default");
		rb3.setBounds(570,265,70,20);
		
		ButtonGroup bg=new ButtonGroup();
		
		ch1=new JCheckBox("UG");
		ch1.setBounds(170,310,100,20);
		ch2=new JCheckBox("PG");
		ch2.setBounds(295,310,100,20);
		ch3=new JCheckBox("Phd");
		ch3.setBounds(420,310,100,20);
		
		String country[]={"---Select Country---","india","USA","America"};
		cmbo1=new JComboBox(country);
		cmbo1.setBounds(370,400,150,30);
		
		cmbo2=new JComboBox();
		cmbo2.setBounds(370,450,150,30);

		dc0=new DefaultComboBoxModel(select);
        dc1=new DefaultComboBoxModel(India);		
        dc2=new DefaultComboBoxModel(USA);		
        dc3=new DefaultComboBoxModel(America);

	    ltb5=new JLabel();
	    ltb5.setBounds(370,500,150,30);
	    ltb5.setBackground(Color.white);
	    ltb5.setOpaque(true);
	    ltb5.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));

		t5=new JTextField();//contact no.
		t5.setBounds(30,5,110,20);
	    t5.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.gray));

	    bt5=new JButton();
	    bt5.setBounds(5,5,20,20);
	    bt5.setForeground(Color.blue);
	    bt5.setBackground(Color.white);
	    bt5.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));
		bt5.setIcon(new ImageIcon("E:\\minipro\\phone.png"));

		add(ltb5);
		ltb5.add(t5);
		ltb5.add(bt5);
		
		b1=new JButton("Add Librarian");
		b1.setBounds(150,560,200,40);
		b1.setForeground(new Color(0,0,128));
		b1.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		b1.addKeyListener(this);

		b2=new JButton("Back");
		b2.setBounds(420,560,200,40);
		b2.setForeground(new Color(0,0,128));
		b2.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		b2.addKeyListener(this);
        
        t1.addKeyListener(this);
		
		euname=new JLabel("");
        el1=new JLabel();
        el2=new JLabel();
        el3=new JLabel();
        el4=new JLabel();
		el0=new JLabel();
        el5=new JLabel("Note : password must contain upper case and lower case characters,digit and special characters");
        el6=new JLabel("email address must contain '@' and must end with '.com' or '.in'");

		euname.setBounds(540,78,350,30);//username
		euname.setFont(new Font("Arial",Font.BOLD,15));
        euname.setForeground(Color.red);
		
        el1.setBounds(540,125,250,30);//name
		el1.setFont(new Font("Arial",Font.BOLD,15));
        el1.setForeground(Color.red);
		
        el2.setBounds(540,170,350,30);//password
		el2.setFont(new Font("Arial",Font.BOLD,15));
        el2.setForeground(Color.red);
	
	    el0.setBounds(540,215,350,30);//confirm password
		el0.setFont(new Font("Arial",Font.BOLD,15));
        el0.setForeground(Color.red);
		
        el3.setBounds(540,350,250,30);//email
		el3.setFont(new Font("Arial",Font.BOLD,15));
        el3.setForeground(Color.red);

        el4.setBounds(540,500,250,30);//contact no.
		el4.setFont(new Font("Arial",Font.BOLD,15));
        el4.setForeground(Color.red);
		
        el5.setBounds(80,615,700,30);
		el5.setFont(new Font("Arial",Font.BOLD,15));
        el5.setForeground(Color.red);
		
        el6.setBounds(124,647,700,30);
        el6.setFont(new Font("Arial",Font.BOLD,15));
        el6.setForeground(Color.red);

	    getRootPane().setDefaultButton(b1);
        b1.requestFocus();
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l0);
		
		//add(t0);
		add(t1);
		//add(p1);
		//add(p2);
		//add(t2);
		//add(t5);
		add(b1);
		add(b2);
        
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		add(rb1);
		add(rb2);
		
		add(ch1);
		add(ch2);
		add(ch3);
		
		add(cmbo1);
		add(cmbo2);
		
		add(euname);
        add(el1);
        add(el2);
        add(el3);
        add(el4);
        add(el5);
        add(el6);
        add(el0);
		
		t1.addFocusListener(this);
		p1.addFocusListener(this);
		p2.addFocusListener(this);
		t2.addFocusListener(this);
		t5.addFocusListener(this);
		
		cmbo1.addItemListener(this);
		
		b1.addActionListener(this);
		b2.addActionListener(this);

		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		int w=(int)d.getWidth();
		int h=(int)d.getHeight();
		setLocation((w-900)/2,(h-750)/2);
		
		setSize(900,750);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void itemStateChanged(ItemEvent e)
	{
		if(cmbo1.getSelectedIndex()==0)
		{
			cmbo2.setModel(dc0);
		}
	    if(cmbo1.getSelectedIndex()==1 )
		{
			cmbo2.setModel(dc1);
			cmbo2.setSelectedIndex(0);
		}
	    if(cmbo1.getSelectedIndex()==2 )
		{
			cmbo2.setModel(dc2);
			cmbo2.setSelectedIndex(0);
		}
	    if(cmbo1.getSelectedIndex()==3 )
		{
			cmbo2.setModel(dc3);
			cmbo2.setSelectedIndex(0);
		}		
	}
	
	public void focusGained(FocusEvent e)
	{
		if(t0.getText().isEmpty())
		{
		   //System.out.println("username");
		   euname.setText("");
		   ltb1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}			
		//empty check
	    if(t0.isFocusOwner())//username
		{
		   System.out.println("username");
		   euname.setText("");
		   ltb1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));	
		}
		if(t1.isFocusOwner() || t1.getText().isEmpty())//name
		{
		  //System.out.println("name");
		   el1.setText("");
		   t1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}
		if(p1.isFocusOwner() || p1.getText().isEmpty())//password
		{
	       el2.setText("");
		   ltb2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}
		if(p2.isFocusOwner() || p2.getText().isEmpty())//confirm password
		{
		   el0.setText("");
		   ltb3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}
		if(t2.isFocusOwner() || t2.getText().isEmpty())//email
		{
		   el3.setText("");
		   ltb4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}
		if(t5.isFocusOwner() || t5.getText().isEmpty())//phone no.
		{
		   el4.setText("");
		   ltb5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}
		
	  //username constraint
	  if(!t0.isFocusOwner() && !t0.getText().isEmpty() )
      {
		  int uc=usernameConstraint();
		  
			if(uc==1)
			{
			  euname.setText(" ");
			  ltb1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
			}
			else
			{
			  ltb1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
			}
	  }
	}
	
	public void focusLost(FocusEvent e)
	{
     /*//username constraint
	  if(!t0.isFocusOwner() && !t0.getText().isEmpty() )
      {
		  int uc=usernameConstraint();
		  
			if(uc==1)
			{
			  t0.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));

			}
			else
			{
			  t0.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
			}
	  }*/
	  //name constraint
	  if(!t1.isFocusOwner() && !t1.getText().isEmpty() )
      {
		  int nc=nameConstraint();
		  
			if(nc==1)
			{
			  t1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));

			}
			else
			{
			  t1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
			}
	  }	
	  //password constraint
	  if(!p1.isFocusOwner() && !p1.getText().isEmpty() )
	  {
		  int pc=passwordConstraint();
		  
			if(pc==1)
			{
			  ltb2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
			}
			else
			{
			  ltb2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
			}
	  }
	  //confirm password constraint
	  if(!p2.isFocusOwner() && !p2.getText().isEmpty() )  
	  {
		  int cp=confirmPassword();
		  
			if(cp==1)
			{
			  ltb3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
			}
			else
			{
			  ltb3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
			}
	  }
	  //email constraint
	  if(!t2.isFocusOwner() && !t2.getText().isEmpty() )  
	  {
		  int ec=emailConstraint();
		  
			if(ec==1)
			{
			  ltb4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
			}
			else
			{
			  el3.setText("enter correct email address");
		      el3.setForeground(Color.red);
			  ltb4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
			}
	  }
	  //phone no. constraint
	  if(!t5.isFocusOwner() && !t5.getText().isEmpty() )  
	  {
		  int cc=contactConstraint();
		  
			if(cc==1)
			{
			  ltb5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
			}
			 else
			{
			  ltb5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
			}
	  }		
	}
	
	public void keyPressed(KeyEvent e)
	{
       if(e.getKeyCode()==KeyEvent.VK_ENTER)
       {
       	  if(b1.isFocusOwner())
       	  {
		    int fa=fieldsEmptyConstraint();//***fields empty condition***
		 
		    if(fa==1)//no field empty
			{
			 int uc=usernameConstraint(); //***username constraint***
			 
             int nc=nameConstraint();     //***name constraint***
		
		     int pc=passwordConstraint(); //***password constraint***
		
             int cp=confirmPassword();    //***confirm password***    
  
		     int ec=emailConstraint();    //***email constraint***
         
             int cc=contactConstraint();  //***contact no. constraint***
       
			 if( (uc==1) && (nc==1) && (pc==1) && (cp==1) && (ec==1) && (cc==1) && (fa==1) )
			 {
                fillValue(); //method for inserting values in the database table
			
               	reset();     //method for resetting values			  
		 	 }
		   }
		    if(fa==0)
		    	JOptionPane.showMessageDialog(this,"you are required to enter all the fields","alert message",JOptionPane.WARNING_MESSAGE);
       	  }
       	  else if(b2.isFocusOwner())
       	  {
       	  	new AdminSection();
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
        if(e.getSource()==bt2)
	    {
		  i++;
		  if(i%2!=0)
		  {
		     p1.setEchoChar((char)0);
			 bt2.setIcon(new ImageIcon("E:\\minipro\\eyeclose.png"));
		    // bt.setText("<html><u>hide</u></html>");
		  }
		  else if(i%2==0)
		  {
 		     p1.setEchoChar('*');
			 bt2.setIcon(new ImageIcon("E:\\minipro\\eye.png"));
		     //bt.setText("<html><u>show</u></html>");
		  }
	    }
        if(e.getSource()==bt3)
	    {
		  j++;
		  if(j%2!=0)
		  {
		     p2.setEchoChar((char)0);
			 bt3.setIcon(new ImageIcon("E:\\minipro\\eyeclose.png"));
		    // bt.setText("<html><u>hide</u></html>");
		  }
		  else if(j%2==0)
		  {
 		     p2.setEchoChar('*');
			 bt3.setIcon(new ImageIcon("E:\\minipro\\eye.png"));
		     //bt.setText("<html><u>show</u></html>");
		  }
	    }
	   /*if(e.getActionCommand().equals("<html><u>sh</u></html>"))
	   {
		  bt2.setText("<html><u>hi</u></html>");
		  p1.setEchoChar((char)0);
	   }
	   else if(e.getActionCommand().equals("<html><u>hi</u></html>"))
	   {
		  bt2.setText("<html><u>sh</u></html>");
		  p1.setEchoChar('*');
	   }
	   if(e.getActionCommand().equals("<html><u>sh0</u></html>"))
	   {
		  bt3.setText("<html><u>hi0</u></html>");
		  p2.setEchoChar((char)0);
	   }
	   else if(e.getActionCommand().equals("<html><u>hi0</u></html>"))
	   {
		  bt3.setText("<html><u>sh0</u></html>");
		  p2.setEchoChar('*');
	   }
	*/
		if(e.getSource()==b1)
		{
           int fa=fieldsEmptyConstraint();//***fields empty condition***
		
         if(fa==1)
         {	
		   int uc=usernameConstraint();   //***username constraint***
	 
           int nc=nameConstraint();       //***name constraint***
		
		   int pc=passwordConstraint();   //***password constraint***
		
           int cp=confirmPassword();      //***confirm password***    
  
		   int ec=emailConstraint();      //***email constraint***
         
           int cc=contactConstraint();    //***contact no. constraint***
       
			if( (uc==1) && (nc==1) && (pc==1) && (cp==1) && (ec==1) && (cc==1) && (fa==1) )
			{
                fillValue(); //method for inserting values in the database table
			
               	reset();     //method for resetting values			  
			}
		 }
		 if(fa==0)
		   JOptionPane.showMessageDialog(this,"you are required to enter all the fields","alert message",JOptionPane.WARNING_MESSAGE);		  
	    }
	
		else if(e.getSource()==b2)
		{
			new AdminSection();
       	  	dispose();
		}
	}
	public int fieldsEmptyConstraint()
	{
		int fa=1;

		if( t1.getText().isEmpty() || t2.getText().isEmpty() || t5.getText().isEmpty() || p1.getText().isEmpty() || p2.getText().isEmpty() || !(rb1.isSelected() || rb2.isSelected()) || !(ch1.isSelected() || ch2.isSelected() || ch3.isSelected() ) ||cmbo1.getSelectedIndex()==0 ||cmbo2.getSelectedIndex()==0) 
			fa=0;
		
		return fa;
	}
	public int usernameConstraint()
	{
		String username="";
		int uc=1;
		
		try
		{
		    Class.forName("com.mysql.jdbc.Driver");
			  
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			
		    Statement st=con.createStatement();
	   
	        ResultSet rs=st.executeQuery("select username from librarian");

	         while(rs.next())
	         {
           		 username=rs.getString(1);
				
	    		 if(t0.getText().equals(username) )
	             {
					 uc=0;
					 euname.setText("username already registered");
					 break;
	             }
	          }
		 }
		 catch(Exception e)
		 {
		   System.out.println(e);
		 }
		 return uc;
	}
	public int nameConstraint()
	{
		int nc=1;
		
		 String name1=t1.getText();
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
			el1.setText("name must contain char's only");
			el1.setForeground(Color.red);
		}
		else el1.setText("");  
		   
		return nc;
	}
	public int passwordConstraint()
	{
        String s=p1.getText();
        char pwd[]=s.toCharArray();
        int c1=0,c2=0,c3=0,c4=0,c5=0,pc=0;
        for(char c:pwd)
        {
        	if(Character.isAlphabetic(c))
        	{
        		if(Character.isLowerCase(c))
        		{
                   c1=1;
        		}
        		if(Character.isUpperCase(c))
        		{
        			c2=1;
        		}
        	}
        	if(Character.isDigit(c))
        		c3=1;
        	if( (c>=0&&c<=47) || (c>=58&&c<=64) ||(c>=91&&c<=96) || (c>=123&&c<=127) )
        		c4=1;
        }
		if(s.length()>=6)
		  c5=1;
		if(c1==1&&c2==1&&c3==1&&c4==1&&c5==1)
		{
			pc=1;
			el2.setText("");
		}
		if(c5==0)
			{
				el2.setText("password must contain atleast 6 characters");
			    el2.setForeground(Color.red);
			}
		else if( c1==0 ||c2==0 || c3==0 ||c4==0 )
			{
				el2.setText("please enter strong password");
			    el2.setForeground(Color.red);
			}
			return pc;
	}
	public int confirmPassword()
	{
		int cp=0;
		
		if( p1.getText().equals(p2.getText()) )
			cp=1;
        if(cp==0)
            {
				el0.setText("password not matching");
			    el0.setForeground(Color.red);
			}	
		else el0.setText("");
		return cp;
	}
	public int emailConstraint()
	{
        int ec=0;
        String s3=t2.getText();
           
        if(s3.contains("@") && (s3.endsWith(".com") || (s3.endsWith(".in"))) )
        	ec=1;
		  
	    if(ec==0 && !t5.getText().isEmpty())
		  {
			el3.setText("enter correct email address");
		    el3.setForeground(Color.red);		    	
		   }
	    else el3.setText("");
		return ec;
	}
	public int contactConstraint()
	{
		int flag2=0,count=0;
		
          if(!t5.getText().isEmpty())
          {
            String st1=t5.getText();
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
           		el4.setText("no. must contain digits only");
                el4.setForeground(Color.red);
				return chr;
            }

            if(chr==1)
            {
		 	    long num=Long.parseLong(t5.getText());			

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
				   el4.setText("contact no. must be of 10 digits");
				   el4.setForeground(Color.red);
			    }
			    else if(flag2==1)
				  el4.setText("");
             }
         } 
		 return flag2;
	}
	public void reset()
	{
		t1.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
		
		euname.setText("");
		el1.setText("");
		el2.setText("");
		el3.setText("");
		el4.setText("");
		el0.setText("");
		JOptionPane.showMessageDialog(this,"Librarian added successfully");
		t0.setText("");
		t1.setText("");
		p1.setText("");
		p2.setText("");
		t2.setText("");
		t5.setText("");
		
		rb3.setSelected(true);
		ch1.setSelected(false);
		ch2.setSelected(false);
		ch3.setSelected(false);
		
		ltb1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
	    t1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		ltb2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
	    ltb3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		ltb4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		ltb5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		
		cmbo1.setSelectedIndex(0);
		cmbo2.setSelectedIndex(0);
	}
     public void fillValue()
	 {
         try
		 {	
		    Class.forName("com.mysql.jdbc.Driver");
					 
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
					
		    PreparedStatement ps=con.prepareStatement("insert into librarian values(?,?,?,?,?,?,?,?,?,?)");
					
			ps.setInt(1,0);
			ps.setString(2,t0.getText());
			ps.setString(3,t1.getText());
			ps.setString(4,p1.getText());
			ps.setString(5,t2.getText());
			
			if(rb1.isSelected())
			  ps.setString(6,"M");
		    else if(rb2.isSelected())
			  ps.setString(6,"F");
		  
		    if(ch3.isSelected())
				ps.setString(7,"Phd");
			else if(ch2.isSelected())
			  ps.setString(7,"PG");
			else if(ch1.isSelected())
			  ps.setString(7,"UG");
		  
			ps.setString(8,(String)cmbo1.getSelectedItem());
			ps.setString(9,(String)cmbo2.getSelectedItem());
			ps.setLong(10,Long.parseLong(t5.getText()));
					
			ps.execute();		
		}
		catch(Exception e0)
		{
			System.out.println(e0);
		}
	 }
	 
	public static void main(String[] args) {
		new AddLibrarian();
	}
}
