import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddBooks extends JFrame implements ActionListener,KeyListener,FocusListener
{
  JLabel l1,l2,l3,l4,l5,l6;
  JLabel el1,el2;
  JTextField t1,t2,t3,t4,t5;
  JButton b1,b2;
  
  AddBooks()
  {
	//setContentPane(new JLabel(new ImageIcon("E:\\minipro\\bookimage2.jpg")));
	
    l1=new JLabel("<html><u>Add Books</u></html>");
	l1.setFont(new Font("Lucida Handwriting",Font.BOLD,35));
	//l1.setForeground(new Color(124,252,0));
	l1.setBounds(100,30,300,50);
	
	l2=new JLabel("Call No.:");
	l2.setBounds(70,110,120,30);
	l2.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	//l2.setForeground(new Color(124,252,0));
	
	l3=new JLabel("Book Name:");
	l3.setBounds(70,170,150,30);
	l3.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	//l3.setForeground(new Color(124,252,0));
	
	l4=new JLabel("Author:");
	l4.setBounds(70,230,120,30);
	l4.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	//l4.setForeground(new Color(124,252,0));
	
	l5=new JLabel("Publisher:");
	l5.setBounds(70,290,120,30);
	l5.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	//l5.setForeground(new Color(124,252,0));
	
	l6=new JLabel("Quantity:");
	l6.setBounds(70,350,120,30);
	l6.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
	//l6.setForeground(new Color(124,252,0));
	
	el1=new JLabel();
	el1.setBounds(340,230,200,30);
	el1.setFont(new Font("Arial",Font.BOLD,15));
	
	el2=new JLabel();
	el2.setBounds(340,350,250,30);
	el2.setFont(new Font("Arial",Font.BOLD,15));
	
	t1=new JTextField();
	t1.setBounds(220,110,110,30);
	
	t2=new JTextField();
	t2.setBounds(220,170,110,30);
	
	t3=new JTextField();
	t3.setBounds(220,230,110,30);
	
	t4=new JTextField();
	t4.setBounds(220,290,110,30);
	
	t5=new JTextField();
	t5.setBounds(220,350,110,30);
	
	b1=new JButton("Add Books");
	b1.setBounds(75,410,140,40);
	b1.setForeground(new Color(0,0,128));
	b1.setFont(new Font("Lucida Handwriting",Font.BOLD,16));
	
	b2=new JButton("Back");
	b2.setBounds(265,410,140,40);
	b2.setForeground(new Color(0,0,128));
	b2.setFont(new Font("Lucida Handwriting",Font.BOLD,16));

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
	add(t5);
	
	t1.addFocusListener(this);
	t2.addFocusListener(this);
	t3.addFocusListener(this);
	t4.addFocusListener(this);
	t5.addFocusListener(this);
	
	add(el1);
	add(el2);
	
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
	setLocation((w-500)/2,(h-520)/2);
	
	setResizable(false);
	setSize(500,520);
	setLayout(null);
	setVisible(true);
  }
  public void focusGained(FocusEvent e)
  {
		//empty check
		if(t1.isFocusOwner() || t1.getText().isEmpty())//call_no
		{
		   t1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}
		if(t2.isFocusOwner() || t2.getText().isEmpty())//Book_name
		{
		   t2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}
		if(t3.isFocusOwner() || t3.getText().isEmpty())//author
		{
	       el1.setText("");
		   t3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}
		if(t4.isFocusOwner() || t4.getText().isEmpty())//publisher
		{
		   t4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}
		if(t5.isFocusOwner() || t5.getText().isEmpty())//Quantity
		{
		   el2.setText("");
		   t5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));	
		}
  }
  public void focusLost(FocusEvent e)
  {
	  //call_no constraint
	  if(!t1.isFocusOwner() && !t1.getText().isEmpty() )
      {
		 t1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
	  }
	  //book_name constraint
	  if(!t2.isFocusOwner() && !t2.getText().isEmpty() )
      {
		 t2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
	  }
	  //author constraint
	  if(!t3.isFocusOwner() && !t3.getText().isEmpty() )
      {
		  int ac=authorConstraint();
		  
			if(ac==1)
			{
			  el1.setText(" ");
			  t3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
			}
			 else
			{
			  t3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
			}
	  }
	  //publisher constraint
	  if(!t4.isFocusOwner() && !t4.getText().isEmpty() )
      {
		 t4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
	  }
	  //Quantity constraint
	  if(!t5.isFocusOwner() && !t5.getText().isEmpty() )
      {
		  int q=quantityConstraint();
		  
			if(q==1)
			{
			  el2.setText(" ");
			  t5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
			}
			 else
			{
			  t5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
			}
	  }
  }
  public void keyPressed(KeyEvent e)
  {
	  if(e.getKeyCode()==e.VK_ENTER)
	  {
		if(e.getSource()==b1)
	    {
		 int fa=fieldsEmptyConstraint();//***fields empty condition***
         
         if(fa==1)//no field is empty
         {	
           int a1=authorConstraint();//author name should contain characters only		 

		   int q=quantityConstraint();//quantity must be in digits only
		   
		   if(q==1 && a1==1)
		   {
			 fillValue();
			 
			 resetValues();
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
  public void keyTyped(KeyEvent e)
  {
	  
  }
  public void keyReleased(KeyEvent e)
  {
	  
  }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==b1)
	 {
		 int fa=fieldsEmptyConstraint();//***fields empty condition***
         
         if(fa==1)//no field is empty
         {	
           int a1=authorConstraint();//author name should contain characters only		 

		   int q=quantityConstraint();//quantity must be in digits only

		   
		   if(q==1 && a1==1)
		   {
			 fillValue();
			 
			 resetValues();
		   }
		 }
	 }
	else if(e.getSource()==b2)
	  {
	    new LibrarianSection();
		dispose();
	  }
  }
  public int quantityConstraint()
  {
	 int q=1;
	 String s2=t5.getText();
     char qu[]=s2.toCharArray();
		 
	 for(char c:qu)
     {
	   if(!Character.isDigit(c))
	    {
		   q=0;
		   break;
	    }
	 }
	  if(q==0)
	  {
		el2.setText("only digits allowed");
		el2.setForeground(Color.red);
	  }
	  else el2.setText("");
	  
	 return q;
  }
  public int authorConstraint()
  {
	   int a1=1; 
	   String s1=t3.getText();
	   char au[]=s1.toCharArray();
		 
	   for(char c:au)
	   {
		 if(!Character.isAlphabetic(c))
		 {
			 if(c!=' ')
		     {
			   a1=0;
			   break;
			 }
		 }
	   }
	   if(a1==1)
		 el1.setText("");
		   
	   else if(a1==0)
	   {
		el1.setText("characters only");
		el1.setForeground(Color.red);
	   }
	   return a1;
  }
  public void resetValues()
  {
	  el1.setText("");
      el2.setText("");		  
      JOptionPane.showMessageDialog(this,"Books added successfully!");
      t1.setText("");
      t2.setText("");
	  t3.setText("");
      t4.setText("");
      t5.setText("");
  }
  public void fillValue()
  {
	  try
	  {
		   Class.forName("com.mysql.jdbc.Driver");
					 
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
					
		   PreparedStatement ps=con.prepareStatement("insert into add_books values(?,?,?,?,?,?,?,?)");
		   
		   ps.setInt(1,0);
		   ps.setString(2,t1.getText());
		   ps.setString(3,t2.getText());
		   ps.setString(4,t3.getText());
		   ps.setString(5,t4.getText());
		   ps.setInt(6,Integer.parseInt(t5.getText()) );
		   ps.setInt(7,0);
		   
		   Timestamp date=new Timestamp(new java.util.Date().getTime());
		   ps.setTimestamp(8,date);
		   
		   ps.execute();
	  }
	  catch(Exception e)
	  {
		  System.out.println(e+"****");
	  }
  }
  public int fieldsEmptyConstraint()
  {
	 int fa=1;
	 
	 if(t1.getText().isEmpty() || t2.getText().isEmpty() ||t3.getText().isEmpty() ||t4.getText().isEmpty() ||t5.getText().isEmpty() )
		fa=0;
	
	  if(fa==0)
	     JOptionPane.showMessageDialog(this,"All fields required","Alert Message",JOptionPane.WARNING_MESSAGE);
	  
	  return fa;
  }
  public static void main(String...a)
  {
	  new AddBooks();
  }
}