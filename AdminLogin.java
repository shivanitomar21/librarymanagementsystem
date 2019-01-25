import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class AdminLogin extends JFrame implements ActionListener,KeyListener,FocusListener
{
	int i=0;
	JLabel l1,l2,l3;
	JTextField t1;
	JLabel el1,ltb;
	JPasswordField p1;
	JButton b1,b2,bt;
	
	AdminLogin()
	{
		//setContentPane(new JLabel(new ImageIcon("E:\\minipro\\bookimage.jpg")));
		
		l1=new JLabel("<html><u>Admin Login Form</u></html>");
		l1.setBounds(40,50,400,50);
		l1.setFont(new Font("Lucida Handwriting",Font.BOLD,33));
		//l1.setForeground(new Color(124,252,0));
		
		l2=new JLabel("Enter Name : ");
		l2.setBounds(30,150,200,30);
		l2.setFont(new Font("Lucida Handwriting",Font.BOLD,19));
		//l2.setForeground(new Color(124,252,0));
		
		l3=new JLabel("Enter Password : ");
		l3.setBounds(30,240,2000,30);
		l3.setFont(new Font("Lucida Handwriting",Font.BOLD,19));
		//l3.setForeground(new Color(124,252,0));

		t1=new JTextField();
		t1.setBounds(230,150,200,30);
		
	    ltb=new JLabel();
	    ltb.setBounds(230,240,200,30);
	    ltb.setBackground(Color.white);
	    ltb.setOpaque(true);
	    ltb.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
		
		p1=new JPasswordField();
		p1.setBounds(5,5,150,20);
	    p1.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));

	    bt=new JButton();
	    bt.setBounds(170,3,20,20);
	    bt.setForeground(Color.blue);
	    bt.setBackground(Color.white);
	    bt.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));
		bt.setIcon(new ImageIcon("E:\\minipro\\eye.png"));
		
		bt.addActionListener(this);
		
		add(ltb);
	    ltb.add(p1);
	    ltb.add(bt);
		
		b1=new JButton("Login");
		b1.setBounds(120,350,100,40);
		b1.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		b1.setForeground(new Color(0,0,128));
		
		b1.addActionListener(this);
        b1.addKeyListener(this);
		
	    b2=new JButton("Back");
		b2.setBounds(275,350,100,40);
		b2.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		b2.setForeground(new Color(0,0,128));
		
		b2.addActionListener(this);
		b2.addKeyListener(this);
		
		t1.addFocusListener(this);
		p1.addFocusListener(this);
		
        t1.addKeyListener(this);
        p1.addKeyListener(this);

	    getRootPane().setDefaultButton(b1);
        b1.requestFocus();
		
		add(l1);
		add(l2);
		add(l3);
		
		//add(t2);
		//add(t3);
	    add(t1);
		//add(p1);
		
		//add(b0);
		add(b1);
		add(b2);

		//ch1.addActionListener(this);
		//add(ch1);
		
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		int w=(int)d.getWidth();
		int h=(int)d.getHeight();
		setLocation((w-500)/2,(h-500)/2);

		setSize(500,500);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			if(uname.equals("admin"))
			{
			  t1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
			}
			 else if(!(uname.equals("admin") ))
			{
			  t1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
			}
	  }		
      if( !p1.isFocusOwner() && !p1.getText().isEmpty())
      {
			if(pwd.equals("admin"))
			{
			  ltb.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
			}
			else if(!(pwd.equals("admin") ))
			{
			  ltb.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
			}  		
	  }					
	}
    public void keyPressed(KeyEvent e)
    {
		String uname=t1.getText().toLowerCase();
		String pwd=p1.getText();//toLowerCase();

        if(e.getKeyCode()==KeyEvent.VK_ENTER) 
        {
	 	  /*if(e.getSource()==b0)
		  {
			 new Varify();
			 dispose();
		  }*/
		  if(e.getSource()==b1)
		  {
			 if(t1.getText().isEmpty() || p1.getText().isEmpty())
			    JOptionPane.showMessageDialog(this,"enter value for both the fields");
			
		     else if((uname.equals("admin"))&&(pwd.equals("admin")))
		     {
			    AdminSection ob=new AdminSection();
			    dispose();
		     }
		     else
		     {
			    JOptionPane.showMessageDialog(this,"username or password incorrect");
			    //dispose();
		     }
		  }
		  else if(b2.isFocusOwner())
		  {
			  new Admin();
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
		String uname=t1.getText().toLowerCase();
		String pwd=p1.getText();//toLowerCase();
		
		//********* [hiding and unhiding password] ********
        if(e.getSource()==bt)
	    {
		  i++;
		  if(i%2!=0)
		  {
		     p1.setEchoChar((char)0);
			 bt.setIcon(new ImageIcon("E:\\minipro\\eyeclose.png"));
		    // bt.setText("<html><u>hide</u></html>");
		  }
		  else if(i%2==0)
		  {
 		     p1.setEchoChar('*');
			 bt.setIcon(new ImageIcon("E:\\minipro\\eye.png"));
		     //bt.setText("<html><u>show</u></html>");
		  }
	    }
	 /*if(e.getActionCommand().equals("<html><u>show</u></html>"))
	 {
		bt.setText("<html><u>hide</u></html>");
		p1.setEchoChar((char)0);
	 }
	 else if(e.getActionCommand().equals("<html><u>hide</u></html>"))
	 {
		 bt.setText("<html><u>show</u></html>");
		 p1.setEchoChar('*');
	 }
	*/
	    if(e.getSource()==b1)
		{
		  if((uname.equals("admin"))&&(pwd.equals("admin")))
		  {
			  AdminSection ob=new AdminSection();
			  dispose();
		  }
		  else
		  {
			  JOptionPane.showMessageDialog(this,"username or password incorrect");
			  //dispose();
		  }
		}
		else if(e.getSource()==b2)
		{
			new Admin();
			dispose();
		}
	}

	public static void main(String[] args) {
		new AdminLogin();
	}
}
