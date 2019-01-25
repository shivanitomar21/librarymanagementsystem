import javax.swing.*;
import java.awt.*;

class Ex extends JFrame 
{
   JLabel l1;
   JButton b1;
   JTextField t1;
   
   Ex()
   {
      l1=new JLabel();

	  l1.setBounds(10,10,225,30);
	  l1.setBackground(Color.white);
	l1.setOpaque(true);
	
	  b1=new JButton("<html><u>show</u></html>");
	  b1.setBounds(155,5,65,20);
	  b1.setForeground(Color.blue);
	  b1.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.red));
	  b1.setBackground(Color.white);

	  t1=new JTextField("bfjhbxjldhjfdddddddgbhdak");
	  t1.setBounds(5,5,140,20);
	  
	  add(l1);
	  l1.add(t1);
	  l1.add(b1);
	  
	  l1.setBackground( t1.getBackground() );
      l1.setBorder( t1.getBorder() );
      t1.setBorder(null);
	  
	  setLayout(null);
	  setSize(500,500);
	  setVisible(true);
   }
   public static void main(String...a)
   {
      new Ex();
	  
   }
}