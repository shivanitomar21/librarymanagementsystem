import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LibrarianSection extends JFrame implements ActionListener,KeyListener
{
  JLabel l;
  JButton b1,b2,b3,b4,b5,b6;
  
  LibrarianSection()
  {
	//setContentPane(new JLabel(new ImageIcon("E:\\minipro\\bookimage4.jpg")));
	
    l=new JLabel("Librarian Section");
	//l.setForeground(new Color(124,252,0));
	l.setFont(new Font("Lucida Handwriting",Font.BOLD,35));
	l.setBounds(45,35,420,50);
	
	b1=new JButton("Add Books");
	b1.setBounds(130,110,220,40);
	b1.setForeground(new Color(0,0,128));
	b1.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	
	b2=new JButton("View Books");
	b2.setBounds(130,180,220,40);
	b2.setForeground(new Color(0,0,128));
	b2.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	
	b3=new JButton("Issue Book");
	b3.setBounds(130,250,220,40);
	b3.setForeground(new Color(0,0,128));
	b3.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	
	b4=new JButton("View Issued Books");
	b4.setBounds(130,320,220,40);
	b4.setForeground(new Color(0,0,128));
	b4.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	
	b5=new JButton("Return Book");
	b5.setBounds(130,390,220,40);
	b5.setForeground(new Color(0,0,128));
	b5.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	
	b6=new JButton("Logout");
	b6.setBounds(130,460,220,40);
	b6.setForeground(new Color(0,0,128));
	b6.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	
	getRootPane().setDefaultButton(b1);
    b1.requestFocus();
		
	add(l);
	add(b1);
	add(b2);
	add(b3);
	add(b4);
	add(b5);
	add(b6);
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	b5.addActionListener(this);
	b6.addActionListener(this);
	
	b1.addKeyListener(this);
	b2.addKeyListener(this);
	b3.addKeyListener(this);
	b4.addKeyListener(this);
	b5.addKeyListener(this);
	b6.addKeyListener(this);
	
	Toolkit t=Toolkit.getDefaultToolkit();
	Dimension d=t.getScreenSize();
	int w=(int)d.getWidth();
	int h=(int)d.getHeight();
	setLocation((w-500)/2,(h-600)/2);
	
	setResizable(false);
	setSize(500,600);
	setLayout(null);
	setVisible(true);
  }
  
  public void keyReleased(KeyEvent e){}
  
  public void keyTyped(KeyEvent e){}
  
  public void keyPressed(KeyEvent e)
  {
	  if(e.getKeyCode()==e.VK_ENTER)
	  {
		  if(b1.isFocusOwner())
		  {
		    new AddBooks();
			dispose();
		  }
		  else if(b2.isFocusOwner())
		  {
			new ViewBooks();
			dispose();
		  }
		  else if(b3.isFocusOwner())
		  {
			  new IssueBook();
			  dispose();
		  }  
		  else if(b4.isFocusOwner())
		  {
			 new ViewIssuedBook();
			 dispose();
		  }
		  else if(b5.isFocusOwner())
		  {
			  new ReturnBook();
			  dispose();
		  }
		  if(b6.isFocusOwner())
		  {
			  new Admin();
			  dispose();
		  }
	  }
  }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==b1)
	{
		new AddBooks();
		dispose();
	}
	else if(b2.isFocusOwner())
	{
		new ViewBooks();
		dispose();
    }
	else if(e.getSource()==b3)
	{
		new IssueBook();
		dispose();
	}	
	else if(e.getSource()==b4)
	{
		new ViewIssuedBook();
		dispose();
    }	
	else if(e.getSource()==b5)
	{
		new ReturnBook();
		dispose();
	}
	
	else if(e.getSource()==b6)
    {
		new Admin();
		dispose();
	}
  }
  public static void main(String...a)
  {
    new LibrarianSection();
  }
}