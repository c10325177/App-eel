import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginPage extends JPanel {
	
	private JLabel title = new JLabel(new ImageIcon("dit_banner.png"));
	private JLabel logoDIT = new JLabel(new ImageIcon("properLogo.png"));
	private JLabel booksLogo = new JLabel(new ImageIcon("library_book.png"));
	private JLabel logoAppEel = new JLabel(new ImageIcon("copyright.png"));
	private JLabel name = new JLabel("Kevin Street Library");
	private JLabel username = new JLabel("Username:");
	private JLabel password = new JLabel("Password:");
	private Color background = new Color(152,178,255);
	private JTextField user = new JTextField(10);
	private JPasswordField pass = new JPasswordField(10);

	private JButton login = new JButton("        Login        ");
	
	public LoginPage(){
	
		this.setBackground(background);
		GridBagConstraints gbcMain = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		name.setFont(new Font("Serif", Font.BOLD, 28));
		login.setForeground(Color.green);
		
		
		
		//bBACKGROUND
	    gbcMain.insets = new Insets(0,0,100,20);
	    gbcMain.anchor = GridBagConstraints.FIRST_LINE_START;
	    gbcMain.weightx = 1;
	    gbcMain.weighty = 1;
	    this.add(logoDIT, gbcMain);
	    
	    gbcMain.anchor = GridBagConstraints.PAGE_START;
	    gbcMain.ipady = 150;
	    this.add(title, gbcMain);
	    
	    gbcMain.ipady = 0;
	    gbcMain.anchor = GridBagConstraints.FIRST_LINE_END;
	    this.add(booksLogo, gbcMain);
	    
	    
	    gbcMain.insets = new Insets(0,-300,0,-270);
	    gbcMain.gridx = 1;
	    gbcMain.gridy = 0;
	    gbcMain.anchor = GridBagConstraints.SOUTH;
	    this.add(logoAppEel, gbcMain);
	    
	    
	    //CENTER
	    gbcMain.insets = new Insets(-200,-530,0,0);
	    gbcMain.anchor = GridBagConstraints.CENTER;
	    gbcMain.gridx = 1;
	    gbcMain.gridy = 0;
	    gbcMain.gridheight = 1;
	    gbcMain.gridwidth = 2;
 	    this.add(name, gbcMain);
 	    
 	    gbcMain.insets = new Insets(-100,-215,-100,0);
 	    gbcMain.gridx = 1;
 	    gbcMain.gridheight = 1;
 	    gbcMain.gridwidth = 1;
 	    gbcMain.ipady = 0;
 	    this.add(username, gbcMain);
	   
 	    gbcMain.insets = new Insets(-100,-440,-100,0);
 	    gbcMain.gridx = 1;
 	    gbcMain.gridwidth = GridBagConstraints.REMAINDER;
	    this.add(user, gbcMain);
	    
	    gbcMain.insets = new Insets(-0,-60,-75,-928);
	    gbcMain.gridx = 0;
	    gbcMain.gridy = 0;
	    gbcMain.gridwidth = 1;
	    gbcMain.gridheight = 1;
	    this.add(password, gbcMain);
	    
	    gbcMain.insets = new Insets(-0,-40,-75,400);
	    gbcMain.gridx = 1;
	    gbcMain.gridwidth = GridBagConstraints.REMAINDER;
	    this.add(pass, gbcMain);
	    
	    gbcMain.insets = new Insets(-0,-40,-165,-100);
	    gbcMain.gridx = 1;
	    gbcMain.gridwidth = 1;
	    gbcMain.gridheight = 1;
	    this.add(login, gbcMain);
	
	}
	public JButton getLogin(){
		return(this.login);
	}
	
	public JTextField getUsername(){
		return(this.user);
	}
	
	public JPasswordField getPassword(){
		return(this.pass);
	}

}
