import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class ConfirmDeleteLibrarian extends JFrame implements ActionListener,KeyListener
{
	JLabel l1,l2,l3,l4,t1,t2,t3;
	JButton b1,b2;
	JTextField id;
	int i=-1;
	
	ConfirmDeleteLibrarian(JTextField id)
	{
		int i=Integer.parseInt(id.getText());
		//System.out.println("inside constructor"+i);
		
		this.id=id;
		
		l1=new JLabel("Id :");
		l1.setBounds(30,30,100,40);
		
		t1=new JLabel();
		t1.setBounds(140,30,100,40);
		
		l2=new JLabel("Username :");
		l2.setBounds(30,70,100,40);

		t2=new JLabel();
		t2.setBounds(140,70,100,40);
		
		l3=new JLabel("Name :");
		l3.setBounds(30,110,100,40);

		t3=new JLabel();
		t3.setBounds(140,110,100,40);
		
		l4=new JLabel("Are you sure you want to delete this Record ?");
		l4.setBounds(30,180,300,40);
		
		b1=new JButton("Yes");
		b1.setBounds(70,220,70,30);

		b2=new JButton("No");
		b2.setBounds(180,220,70,30);
		
	    getRootPane().setDefaultButton(b1);
        b1.requestFocus();
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		
		add(t1);
		add(t2);
		add(t3);
		
		add(b1);
		add(b2);
		
		getValue();
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		b1.addKeyListener(this);
		b2.addKeyListener(this);
		
	    Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		int w=(int)d.getWidth();
		int h=(int)d.getHeight();
		setLocation((w-350)/2,(h-350)/2);
		
		setLayout(null);
		setSize(350,350);
		setVisible(true);
	}
	public void keyPressed(KeyEvent e)
	{
		confirmDelete();
	}
    public void keyReleased(KeyEvent e)
	{
		
	}
	public void keyTyped(KeyEvent e)
	{
		
	}
	public void actionPerformed(ActionEvent e)
    {
		if(e.getSource()==b1)
		{
           confirmDelete();		
		}
		else if(e.getSource()==b2)
		{
		   dispose();		   
		}
	}
	public void confirmDelete()
	{
			dispose();
			
			int x=0;
		
     		try
			{
			  Class.forName("com.mysql.jdbc.Driver");
			  
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			  
			  PreparedStatement ps=con.prepareStatement("delete from librarian where id=?");
	
		      int i=Integer.parseInt(id.getText());
		   
		      ps.setInt(1,i);
		
			  x=ps.executeUpdate();
			}
			catch(Exception e0)
			{
				System.out.println(e0+"jgfhfdgfh");
			}
			if(x==0)
			   JOptionPane.showMessageDialog(this,"no record found");
		    else if(x==1)
			   JOptionPane.showMessageDialog(this,x+" record deleted");
		    else
			   JOptionPane.showMessageDialog(this,x+" records deleted");
		 	
            t1.setText("");	
	}
	public void getValue()
	{
		try
		{
	       Class.forName("com.mysql.jdbc.Driver");
	   
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	   
	       PreparedStatement ps=con.prepareStatement("select id,username,name from librarian where id=?");			
		   
		   int i=Integer.parseInt(id.getText());
		   
		   ps.setInt(1,i);
		   
		   ResultSet rs=ps.executeQuery();
		   
		  while(rs.next())
		  {
		   t1.setText(rs.getString(1));
		   t2.setText(rs.getString(2));
		   t3.setText(rs.getString(3));
		  }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	/*public static void main(String...a)
	{
		new ConfirmDeleteLibrarian(t1);
	}*/
}