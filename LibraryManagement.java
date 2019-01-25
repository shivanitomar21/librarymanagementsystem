import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LibraryManagement extends JFrame implements ActionListener
{
  JButton b1,b2;
  JLabel t1;
  
  LibraryManagement()
  {
     b1=new JButton("Admin Login");
	 b2=new JButton("Librarian Login");
	 
	 t1=new JLabel("Library Management");
	 
	 t1.setFont(new Font("Lucida Handwriting",Font.BOLD,25));
	 t1.setBounds(30,30,330,40);
	 b1.setBounds(120,100,120,60);
	 b2.setBounds(120,180,120,60);
	 
	 b1.addActionListener(this);
	 b2.addActionListener(this);
	 
	 add(b1);
	 add(b2);
	 add(t1);
	 
	 setSize(400,350);
	 setLayout(null);
	 setVisible(true);
  }
  public void actionPerformed(ActionEvent e)
  {
	  /*if(e.getSource()==b1)
	  {}*/
	  if(e.getSource()==b2)
	  {
		  System.out.println("OUTPUT");
		new LibrarianLogin(); 
		//new Libraria();
        dispose();		
	  }
  }
  public static void main(String...a)
  {
	  new LibraryManagement();
  }
}