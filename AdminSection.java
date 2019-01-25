import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class AdminSection extends JFrame implements ActionListener,KeyListener
{
	JButton b1,b2,b3,b4,b5;
	JLabel l1;

	AdminSection()
	{
		//setContentPane(new JLabel(new ImageIcon("E:\\minipro\\bookimage2.jpg")));
		
		l1=new JLabel("<html><u>Admin Section</u></html>");
		l1.setBounds(118,50,350,40);
		l1.setFont(new Font("Lucida Handwriting",Font.BOLD,36));
		//l1.setForeground(new Color(0,191,255));
		
		b1=new JButton("Add Librarian");
		b1.setBounds(160,130,250,50);
		b1.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		b1.setForeground(new Color(0,0,128));
		
		b2=new JButton("View Librarian");
		b2.setBounds(160,215,250,50);
		b2.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		b2.setForeground(new Color(0,0,128));
		
		b3=new JButton("Delete Librarian");
		b3.setBounds(160,300,250,50);
		b3.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		b3.setForeground(new Color(0,0,128));
	
		b5=new JButton("Edit Profile");
		b5.setBounds(160,390,250,50);
		b5.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	    b5.setForeground(new Color(0,0,128));
		
		b4=new JButton("Logout");
		b4.setBounds(160,475,250,50);
		b4.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	    b4.setForeground(new Color(0,0,128));

		
		getRootPane().setDefaultButton(b1);
        b1.requestFocus();
		
		add(l1);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
        add(b5);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
        b5.addActionListener(this);
		
        b1.addKeyListener(this);
		b2.addKeyListener(this);
        b4.addKeyListener(this);
        b3.addKeyListener(this);
        b5.addKeyListener(this);
		
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		int w=(int)d.getWidth();
		int h=(int)d.getHeight();
		setLocation((w-550)/2,(h-600)/2);

		setResizable(false);
		setLayout(null);
		setSize(550,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			if(b1.isFocusOwner())
			{
				new Add();
				dispose();
			}
			else if(b2.isFocusOwner())
			{
				new ViewLibrarian();
				dispose();
			}
			else if(b3.isFocusOwner())
			{
               new DeleteLibrarian();
               dispose();
			}
			else if(b4.isFocusOwner())
			{
                 new AdminLogin();
                 dispose();
			}
			else if(b5.isFocusOwner())
			{
				new VarifyLibrarian();
			}
		}
	}
	
	public void keyReleased(KeyEvent e){}
	
	public void keyTyped(KeyEvent e){}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			Add ob=new Add();
			dispose();
		}
		else if(e.getSource()==b2)
		{
			new ViewLibrarian();
			dispose();
		}
		else if(e.getSource()==b3)
		{
			DeleteLibrarian ob=new DeleteLibrarian();
			dispose();
		}
		else if(e.getSource()==b4)
		{
			Admin ob=new Admin();
			dispose();
		}
		else if(b5.isFocusOwner())
		{
			new VarifyLibrarian();
		
		}
	}

	public static void main(String[] args) {
		new AdminSection();
	}
}
