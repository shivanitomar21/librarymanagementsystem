import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class ResetPassword extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JLabel el1,el2;
	JPasswordField p1,p2;
	JTextField t1,t2;
	JButton b1;
	
	ResetPassword(JTextField t1,JTextField t2)
	{
		this.t1=t1;
		this.t2=t2;
		
		l1=new JLabel("New Password :");
		l1.setBounds(40,30,120,30);
		
		l2=new JLabel("Confirm password :");
		l2.setBounds(40,90,120,30);
		
		el1=new JLabel();
		el1.setBounds(40,60,200,30);
		el1.setForeground(Color.red);
		
		el2=new JLabel();
		el2.setBounds(40,120,200,30);
		el2.setForeground(Color.red);
		
		p1=new JPasswordField();
		p1.setBounds(170,30,100,30);
		
		p2=new JPasswordField();
		p2.setBounds(170,90,100,30);
		
		b1=new JButton("Reset");
		b1.setBounds(140,150,70,30);
		
		l3=new JLabel("Note : password must contain upper case ,lower case");
		l3.setBounds(30,195,320,30);
		l3.setForeground(Color.red);
		
		l4=new JLabel("letters ,digit and special characters.");
		l4.setBounds(65,215,220,30);
		l4.setForeground(Color.red);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		
		add(el1);
		add(el2);
		
		add(p1);
		add(p2);
		
		add(b1);
		
		b1.addActionListener(this);
		
		getRootPane().setDefaultButton(b1);
        b1.requestFocus();
		
	    Toolkit t=Toolkit.getDefaultToolkit();
	    Dimension d=t.getScreenSize();
	    int w=(int)d.getWidth();
	    int h=(int)d.getHeight();
	    setLocation((w-400)/2,(h-300)/2);
	  
		setLayout(null);
		setSize(400,300);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(p1.getText().isEmpty() || p2.getText().isEmpty())
			JOptionPane.showMessageDialog(this,"enter value for both the fields");
		else
		{
		   int pc=passwordConstraint();
		   int cp=confirmPassword();
		
		   if(pc==1 && cp==1)
		   {
			  resetpwd();
		   }
		}
	}
	public void resetpwd()
	{
		try
		{
		    Class.forName("com.mysql.jdbc.Driver");
			  
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	   
	        PreparedStatement ps=con.prepareStatement("update librarian set password=? where email=? and contact_no=?");

            ps.setString(1,p1.getText()); 	
			
			ps.setString(2,t1.getText());
		
            ps.setLong(3,Long.parseLong(t2.getText()) );		
			
	 	    int i=ps.executeUpdate();
			
			if(i>0)
			{
				JOptionPane.showMessageDialog(this,i+" record updated");
				new LibrarianLogin();
				dispose();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public int passwordConstraint()
	{
        String s=p1.getText();
        char pwd[]=s.toCharArray();
        int c1=0,c2=0,c3=0,c4=0,c5=0,pc=0;
        for(char c:pwd)
        {
        	if(Character.isAlphabetic(c))
        	{
        		if(Character.isLowerCase(c))
        		{
                   c1=1;
        		}
        		if(Character.isUpperCase(c))
        		{
        			c2=1;
        		}
        	}
        	if(Character.isDigit(c))
        		c3=1;
        	if( (c>=0&&c<=47) || (c>=58&&c<=64) ||(c>=91&&c<=96) || (c>=123&&c<=127) )
        		c4=1;
        }
		if(s.length()>=6)
		  c5=1;
		if(c1==1&&c2==1&&c3==1&&c4==1&&c5==1)
		{
			pc=1;
			el1.setText("");
		}
		if(c5==0)
			{
				el1.setText("password must contain atleast 6 characters");
			    el1.setForeground(Color.red);
			}
		else if( c1==0 ||c2==0 || c3==0 ||c4==0 )
			{
				el1.setText("please enter strong password");
			    el1.setForeground(Color.red);
			}
			return pc;
	}
	public int confirmPassword()
	{
		int cp=0;
		
		if( p1.getText().equals(p2.getText()) )
			cp=1;
        if(cp==0)
            {
				el2.setText("password not matching");
			    el2.setForeground(Color.red);
			}	
		else el2.setText("");
		return cp;
	}
//	public static void main(String...a)
	//{
		//new ResetPassword();
	//}
}