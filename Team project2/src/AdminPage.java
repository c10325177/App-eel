

import javax.swing.*;
import java.awt.*;
public class AdminPage extends JPanel{
	
	private ImageIcon custDetails = new ImageIcon("cust_details.png");
	private ImageIcon database = new ImageIcon("database.png");
	private ImageIcon ilogout = new ImageIcon("logout.png");
	private ImageIcon report = new ImageIcon("report.png");
	private ImageIcon books = new ImageIcon("books.png");
	private ImageIcon iloan = new ImageIcon("loanabook.png");
	private ImageIcon ireturn = new ImageIcon("returnabook.png");
	
	
	//the buttons on the administrator page
	private JButton customerDetails = new JButton("Customer Details",custDetails);
	private JButton manageAccounts = new JButton("Manage Accounts", database);
	private JButton libraryReports = new JButton("Library Reports", report);
	private JButton manageBooks = new JButton("Manage Books", books);
	private JButton logout = new JButton("Log Out");
	private JButton loan = new JButton("Loan", iloan);
	private JButton returned = new JButton("Return", ireturn);
	
	//Labels who are displayed on the administrator page
	private JLabel namePage = new JLabel("Administrator Page");
	private JLabel userID = new JLabel("User ID: ");
	private JLabel title = new JLabel(new ImageIcon("dit_banner.png"));
	private JLabel logoDIT = new JLabel(new ImageIcon("properLogo.png"));
	private JLabel booksLogo = new JLabel(new ImageIcon("library_book.png"));
	private JLabel logoAppEel = new JLabel(new ImageIcon("copyright.png"));
	private JLabel name = new JLabel("Kevin Street Library");
	private JLabel key = new JLabel(ilogout);
	

	
	//Color of the background
	private Color background = new Color(152,178,255);
	
	//JTexfiel where it displayed the user ID
	private JTextField ID = new JTextField(5);
	
	private LoginPage loginPage = new LoginPage();
	
	public AdminPage(){
		
		//put and set an Icon on the different button
		customerDetails.setVerticalTextPosition(AbstractButton.BOTTOM);
		customerDetails.setHorizontalTextPosition(AbstractButton.CENTER);
		customerDetails.setBorderPainted(false);
		customerDetails.setContentAreaFilled(false);
		
		manageAccounts.setVerticalTextPosition(AbstractButton.BOTTOM);
		manageAccounts.setHorizontalTextPosition(AbstractButton.CENTER);
		manageAccounts.setBorderPainted(false);
		manageAccounts.setContentAreaFilled(false);
		
	
		manageBooks.setVerticalTextPosition(AbstractButton.BOTTOM);
		manageBooks.setHorizontalTextPosition(AbstractButton.CENTER);
		manageBooks.setBorderPainted(false);
		manageBooks.setContentAreaFilled(false);
		
		libraryReports.setVerticalTextPosition(AbstractButton.BOTTOM);
		libraryReports.setHorizontalTextPosition(AbstractButton.CENTER);
		libraryReports.setBorderPainted(false);
		libraryReports.setContentAreaFilled(false);
		
		loan.setVerticalTextPosition(AbstractButton.BOTTOM);
		loan.setHorizontalTextPosition(AbstractButton.CENTER);
		loan.setBorderPainted(false);
		loan.setContentAreaFilled(false);
		
		returned.setVerticalTextPosition(AbstractButton.BOTTOM);
		returned.setHorizontalTextPosition(AbstractButton.CENTER);
		returned.setBorderPainted(false);
		returned.setContentAreaFilled(false);
		
		//Color of the background
		this.setBackground(background);
		//Instanciation of the GridBagConstraint for the use of the GridBagLayout
		GridBagConstraints gbcMain = new GridBagConstraints();
		//Changing of Layout 
		this.setLayout(new GridBagLayout());
		//Changing of Font for the JLabel "Kevin Street Library"
		name.setFont(new Font("Serif", Font.BOLD, 28));
		//Changing of color of the button Log out
		logout.setForeground(Color.red);
		
			//BACKGROUND
		
			//Specifies the external padding of the component -- the minimum amount of space between the component and the edges of its display area.
			//The value is specified as an Insets object. By default, each component has no external padding.
			// The order is top, left, bottom, right
		    gbcMain.insets = new Insets(0,0,100,20);
		    //display area to determine where (within the area) to place the component. 
		    gbcMain.anchor = GridBagConstraints.FIRST_LINE_START;
		    // Specify space among columns (weightx) and among rows (weighty)
		    gbcMain.weightx = 1;
		    gbcMain.weighty = 1;
		    //Adding of the JLabel logoDIT to the main panel
		    this.add(logoDIT, gbcMain);
		    
		    
		    gbcMain.insets = new Insets(0,0,100,20);
		    gbcMain.anchor = GridBagConstraints.PAGE_START;
		    gbcMain.ipady = 20;
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
		    gbcMain.anchor = GridBagConstraints.CENTER;
		    gbcMain.gridx = 0;
		    gbcMain.gridy = 0;
		    this.add(customerDetails, gbcMain);
		    
		    gbcMain.gridx = 1;
		    this.add(manageAccounts, gbcMain);
		    
		    gbcMain.gridx = 2;
		    gbcMain.gridwidth = GridBagConstraints.REMAINDER;
		    this.add(libraryReports, gbcMain);
		    
		    gbcMain.insets = new Insets(0,-30,-400,0);
		    gbcMain.gridx = 0;
		    gbcMain.gridwidth = 1;
		    this.add(manageBooks, gbcMain);
		    
		    gbcMain.gridx = 1;
		    this.add(loan, gbcMain);
		    gbcMain.gridx = 2;
		    this.add(returned, gbcMain);
		    
		
		    
		    
		    //NORTH
		    gbcMain.gridx = 0;
		    gbcMain.insets = new Insets(0,-220,250,0);
		    gbcMain.gridwidth = 1;
		    this.add(key, gbcMain);
		    
		    gbcMain.insets = new Insets(0,-100,250,0);
		    gbcMain.gridwidth = 1;
		    this.add(logout, gbcMain);
		    
 
		    gbcMain.insets = new Insets(0,0,540,-650);
		    gbcMain.gridwidth = 1;
		    this.add(name, gbcMain);
		
			gbcMain.insets = new Insets(0,0,470,-650);
			gbcMain.gridwidth = 1;
			this.add(namePage, gbcMain);
			   
		    gbcMain.insets = new Insets(0,0,250,-1400);
		    gbcMain.gridwidth = 1;
		    this.add(userID, gbcMain);
		    
		    gbcMain.insets = new Insets(0,0,250,-1550);
		    gbcMain.gridwidth = 1;
		    this.add(ID, gbcMain);
	}

	public JButton getLogout(){
		return(this.logout);
	}
	
	public JButton getManageBook(){
		return(this.manageBooks);
	}
	
	public JButton getCustomerDetails(){
		return (this.customerDetails);
	}

	public JButton getManageAccounts(){
		return(this.manageAccounts);
	}
	
	public JButton getLibraryReport(){
		return(this.libraryReports);
	}
	
	public JTextField getUserID(){
		return(this.ID);
	}
	
	
}
