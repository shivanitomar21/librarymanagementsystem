import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Admin extends JFrame implements ActionListener,KeyListener
{
	JLabel l1;
	JButton b1,b2,b0,b3;

	Admin()
	{
		//setContentPane(new JLabel(new ImageIcon("E:\\minipro\\bookimage.jpg")));
		
		l1=new JLabel("<html><u>Library Management</u></html>");
		l1.setBounds(20,50,500,50);
		l1.setFont(new Font("Lucida Handwriting",Font.BOLD,35));
		//l1.setForeground(new Color(124,252,0));
		
		b1=new JButton("Admin Login");
		b1.setBounds(120,150,250,50);
		b1.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		b1.setForeground(new Color(0,0,128));
		
		b2=new JButton("Librarian Login");
		b2.setBounds(120,250,250,50);
		b2.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		b2.setForeground(new Color(0,0,128));
		
		b0=new JButton("<html><i><u>give feedback</u></i></html>");
	    b0.setBounds(170,370,150,30);
	    b0.setForeground(Color.blue);
        b0.setOpaque(false);
        b0.setBackground(Color.lightGray);
		b0.setFont(new Font("Arial",Font.BOLD,17));
        b0.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.red));

		b0.addActionListener(this);
		
		b3=new JButton("<html><i><u>view feedback</u></i></html>");
	    b3.setBounds(170,420,150,30);
	    b3.setForeground(Color.blue);
        b3.setOpaque(false);
        b3.setBackground(Color.lightGray);
		b3.setFont(new Font("Arial",Font.BOLD,17));
        b3.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.red));

		b3.addActionListener(this);
	    
		b1.addActionListener(this);
        b2.addActionListener(this);
		
		b1.addKeyListener(this);
		b2.addKeyListener(this);
		
	    getRootPane().setDefaultButton(b1);
        b1.requestFocus();
		
		add(l1);
		add(b1);
		add(b2);
		add(b0);
        add(b3);
		
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		int w=(int)(d.getWidth());
		int h=(int)(d.getHeight());
		setLocation((w-500)/2,(h-500)/2);
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		setVisible(true);

	}
	public void keyPressed(KeyEvent e)
	{
	    if(e.getKeyCode()==e.VK_ENTER)
		{
			if(b1.isFocusOwner())
			{
				new AdminLogin();
				dispose();
			}
			else if(b2.isFocusOwner())
			{
				new LibrarianLogin();
				dispose();
			}
		}
	}
	public void keyReleased(KeyEvent e)
	{}
	public void keyTyped(KeyEvent e)
	{}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b0)
		{
			new Feedback();
			dispose();
		}
		else if(e.getSource()==b3)
		{
			new ViewFeedback();
			dispose();
		}
		else if(e.getSource()==b1)
		{
		  AdminLogin a=new AdminLogin();
		  dispose();
		}
		else if(e.getSource()==b2)
		{
			new LibrarianLogin();
			dispose();
		}

	}

	public static void main(String[] args) 
	{
		//new MainWindow();
		new Admin();
	}
}
class MainWindow extends JFrame implements ActionListener
{
	JMenuBar mb;
	JMenu home,admin,librarian;
	JMenuItem a1,a2,a3;
	JMenuItem l1,l2,l3,l4,l5;
	
	MainWindow()
	{
		home=new JMenu("home");
		admin=new JMenu("admin");
		librarian=new JMenu("librarian");
		
		a1=new JMenuItem("add librarian");
		a2=new JMenuItem("view librarian");
		a3=new JMenuItem("delete librarian");
			
        l1=new JMenuItem("add books");			
        l2=new JMenuItem("view books");			
        l3=new JMenuItem("issue book");			
        l4=new JMenuItem("view issued books");			
        l5=new JMenuItem("return book");			
        
		JMenuBar mb=new JMenuBar();
		mb.add(home);
		mb.add(admin);
		mb.add(librarian);
		
		admin.add(a1);
		admin.addSeparator();
		admin.add(a2);
		admin.addSeparator();
		admin.add(a3);
		
		librarian.add(l1);
		librarian.addSeparator();
		librarian.add(l2);
		librarian.addSeparator();
		librarian.add(l3);
		librarian.addSeparator();
		librarian.add(l4);
		librarian.addSeparator();
		librarian.add(l5);
		
		setJMenuBar(mb);
		
		a1.addActionListener(this);
		a2.addActionListener(this);
		a3.addActionListener(this);
		
		l1.addActionListener(this);
		l2.addActionListener(this);
		l3.addActionListener(this);
		l4.addActionListener(this);
		
		setSize(1000,1000);
		setLayout(null);
		setVisible(true);
	}
   public void actionPerformed(ActionEvent e)
   {
	   if(e.getSource()==a1)
	   {
		  new AdminSection();
          new AddLibrarian();
	   }
	   else if(e.getSource()==a2)
	   {
		  new AdminSection();
          new ViewLibrarian();
	   }
	   else if(e.getSource()==a3)
	   {
		  new AdminSection();
		  new DeleteLibrarian();
	   }
	   else if(e.getSource()==l1)
	   {
		  new LibrarianSection();
		  new AddBooks();
	   }
	   if(e.getSource()==l2)
	   {
		  new LibrarianSection();
		  new ViewBooks();
	   }
	   if(e.getSource()==l3)
	   {
		  new LibrarianSection();
		  new IssueBook();  
	   }
	   if(e.getSource()==l4)
	   {
		  new LibrarianSection();
		  new ViewIssuedBook();
	   }
	   if(e.getSource()==l5)
	   {
		  new LibrarianSection();
		  new ReturnBook();
	   }	   
   }
}