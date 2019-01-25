import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

class Feedback extends JFrame implements ActionListener,FocusListener
{
	JLabel l0,l1,l2,l3,l4;
	JTextField t1,t2;
	JTextArea ta1;
	JButton b1,b2;
    JRadioButton rb1,rb2,rb3,rb4;
	
	Feedback()
	{
		l0=new JLabel("<html><u>Feedback Form</u></html>");
		l0.setBounds(150,15,250,30);
		l0.setFont(new Font("Lucida Handwriting",Font.BOLD,27));
		//l0.setForeground(Color.blue);
	
		l1=new JLabel("Student Id :");
		l1.setBounds(100,90,170,30);
		l1.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		
		l2=new JLabel("Student Name :");
		l2.setBounds(100,150,170,30); 
		l2.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		
		t1=new JTextField();
		t1.setBounds(280,90,150,30);
		t1.addFocusListener(this);
		
		t2=new JTextField();
		t2.setBounds(280,150,150,30);
		
		l3=new JLabel("How do you rate the project :");
		l3.setBounds(150,220,300,30);
		l3.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		
		rb1=new JRadioButton("Poor");
		rb1.setBounds(110,260,70,30);
		
		rb2=new JRadioButton("Good");
		rb2.setBounds(190,260,70,30);
		
		rb3=new JRadioButton("Very Good");
		rb3.setBounds(290,260,110,30);
		
		rb4=new JRadioButton("Excellent");
		rb4.setBounds(400,260,110,30);
		
		ButtonGroup bg=new ButtonGroup();
		
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		bg.add(rb4);
		
		add(rb1);
		add(rb2);
		add(rb3);
		add(rb4);
		
		l4=new JLabel("please give Suggestions for the betterment :");
		l4.setBounds(60,330,460,30);
		l4.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		
		ta1=new JTextArea();
		ta1.setBounds(120,370,320,70);
        ta1.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
			
		b1=new JButton("Submit");
		b1.setBounds(150,480,120,40);
		b1.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		b1.setForeground(Color.blue);
		
		b2=new JButton("Back");
		b2.setBounds(300,480,120,40);
		b2.setFont(new Font("Lucida Handwriting",Font.BOLD,17));
		b2.setForeground(Color.blue);		
		
	    getRootPane().setDefaultButton(b1);
        b1.requestFocus();
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		add(l0);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		
		add(t1);
		add(t2);
		
		add(ta1);
		
		add(b1);
		add(b2);
		
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		int w=(int)d.getWidth();
		int h=(int)d.getHeight();
		setLocation((w-600)/2,(h-600)/2);
		
		setLayout(null);
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void focusLost(FocusEvent e)
	{
		int flag=0;
		
		try
		{
	       Class.forName("com.mysql.jdbc.Driver");  
	   
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	   
	       PreparedStatement ps=con.prepareStatement("select name from student where id=?");
		   
		   int id=Integer.parseInt(t1.getText());
				   
		   ps.setInt(1,id);
				   
		   ResultSet rs=ps.executeQuery();
	
		   while(rs.next())
		   {
			   flag=1;
			   String s=rs.getString(1);
			   
			   t2.setText(s);
		   }
		}
		catch(Exception e0)
		{
			System.out.println(e0);
		}
		if(flag==0)
		{
			t1.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.red));
			JOptionPane.showMessageDialog(this,"invalid id");
		}
		if(flag==1)
		{
			t1.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.green));
		}
	}
	public void focusGained(FocusEvent e)
	{
		
	}
    public void actionPerformed(ActionEvent e)
    {
		if(e.getSource()==b1)
		{
		  try
		  {
	         Class.forName("com.mysql.jdbc.Driver");  
	   
	         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	   
	         PreparedStatement ps=con.prepareStatement("insert into feedback (st_id,s_name,rate,suggestion,date) values(?,?,?,?,?)");
		   
		     int id=Integer.parseInt(t1.getText());
		     ps.setInt(1,id);
		   
  		     ps.setString(2,t2.getText());
		     		   
		     if(rb1.isSelected())
		        ps.setString(3,"Poor");
		     if(rb2.isSelected())
		        ps.setString(3,"Good");
		     if(rb3.isSelected())
		        ps.setString(3,"Very Good");
		     if(rb4.isSelected())
	   	        ps.setString(3,"Excellent");
           			
		     ps.setString(4,ta1.getText());
		   	
		     Timestamp date=new Timestamp(new java.util.Date().getTime());
		     ps.setTimestamp(5,date);
		   					   
	         ps.execute();
			 
		     JOptionPane.showMessageDialog(this,"record Updated successfully");
			 
			 t1.setText("");
			 t2.setText("");
			 rb1.setSelected(false);
			 rb2.setSelected(false);
			 rb3.setSelected(false);
			 rb4.setSelected(false);
			 ta1.setText("");
			 t1.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
		  }
		  catch(Exception e0)
		  {
			  System.out.println(e0);
		  }			
	    }
		else if(e.getSource()==b2) 
		{
			new Admin();
			dispose();
		}
	}	
	/*public int emptyCheck()
	{
		int ec=0;
		
		if(t1.isEmpty() || t2.isEmpty() || !rb1.isSelected() || !(rb2.isSelected()) || !(rb3.isSelected()) || !(rb4.isSelected()) || ta1.getText().equals("") )
		{
			ec=1;
		}	
		if(ec==1)
			JOptionPane.showMessageDialog(this,"all fields required");
		
		return ec;
	}*/
	public static void main(String...a)
	{
		new Feedback();
	}
}