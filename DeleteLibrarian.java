import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class DeleteLibrarian extends JFrame implements ActionListener,KeyListener
{
	JLabel l1;
	JTextField t1;
	JButton b1,b2;

	DeleteLibrarian()
	{
		//setContentPane(new JLabel(new ImageIcon("E:\\minipro\\bookimage.jpg")));
		
		l1=new JLabel("Enter Id:");
		l1.setBounds(60,100,100,30);
		//l1.setForeground(new Color(0,191,255));
		l1.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		
		t1=new JTextField();
		t1.setBounds(200,100,150,30);
		
		b1=new JButton("Delete");
		b1.setBounds(80,240,100,40);
		b1.setForeground(new Color(0,0,128));
		b1.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		
		b2=new JButton("Back");
		b2.setBounds(240,240,100,40);
		b2.setForeground(new Color(0,0,128));
		b2.setFont(new Font("Lucida Handwriting",Font.BOLD,17));

	    getRootPane().setDefaultButton(b1);
        b1.requestFocus();
		
		add(l1);
		add(t1);
		add(b1);
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		b1.addKeyListener(this);
		b2.addKeyListener(this);

		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		int w=(int)d.getWidth();
		int h=(int)d.getHeight();
		setLocation((w-400)/2,(h-400)/2);
		
		setLayout(null);
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==e.VK_ENTER)
		{
			if(b1.isFocusOwner())
			{
			    new ConfirmDeleteLibrarian(t1);
			}
			else if(b2.isFocusOwner())
			{
		    	AdminSection ob=new AdminSection();
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
		if(e.getSource()==b2)
		{
			AdminSection ob=new AdminSection();
			dispose();
		}
		else if(e.getSource()==b1)
		{
			new ConfirmDeleteLibrarian(t1);    
		}
	}

	public static void main(String[] args) {
		new DeleteLibrarian();
	}
}