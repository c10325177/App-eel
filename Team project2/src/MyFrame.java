
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;



public class MyFrame extends JFrame implements ActionListener {
	
	
	private AdminPage adminPage = new AdminPage();
	private LoginPage loginPage = new LoginPage();
	private ManageBook manageBook = new ManageBook();
	private LibrarianPage  libPage= new LibrarianPage();
	private ManageUser manageUser = new ManageUser();
	private ManageCustomer manageCustomer = new ManageCustomer();
	private LibraryReports libraryReports = new LibraryReports();

	
	//Layout of the main Panel
	private CardLayout c = new CardLayout();
	private String[] listPage = {"LoginPage" , "AdministratorPage", "Manage Books", "Librarian Page", "Manage User", "Manage Customer", "Library Reports"};

	
	public MyFrame(){

	    this.setLayout(c);
	     
        this.add(loginPage, listPage[0]);
        this.add(adminPage, listPage[1]);
        this.add(manageBook, listPage[2]);
        this.add(libPage, listPage[3]);
        this.add(manageUser, listPage[4]);
        this.add(manageCustomer, listPage[5]);
        this.add(libraryReports, listPage[6]);
        loginPage.getLogin().addActionListener(this);
        adminPage.getLogout().addActionListener(this);
        adminPage.getManageBook().addActionListener(this);
        adminPage.getCustomerDetails().addActionListener(this);
        adminPage.getManageAccounts().addActionListener(this);
        adminPage.getLibraryReport().addActionListener(this);
        libPage.getLogout().addActionListener(this);
        libPage.getManageBook().addActionListener(this);
        libPage.getCustomerDetails().addActionListener(this);
        manageBook.getHome().addActionListener(this);
        //listener on the button who manage the different Account(Librarian, admin)
        manageUser.getHome().addActionListener(this);
        manageCustomer.getHome().addActionListener(this);
        libraryReports.getHome().addActionListener(this);
        
       

	}


	@Override
	public void actionPerformed(ActionEvent event) {
		
		// TODO Auto-generated method stub
		Object e = event.getSource();
		if (e == loginPage.getLogin()){
			
			if (loginPage.getUsername().getText().equals("admin") && loginPage.getPassword().getText().equals("admin")){
			c.show(this.getContentPane(), listPage[1]);
			adminPage.getUserID().setText(loginPage.getUsername().getText());
			}
			else {
				c.show(this.getContentPane(), listPage[3]);
				libPage.getUserID().setText(loginPage.getUsername().getText());
			}
		}
		
		//if you click on the button log out
		if (e ==  adminPage.getLogout() || e ==  libPage.getLogout()){
			//display the login Page
			c.show(this.getContentPane(), listPage[0]);
		}
		
		//if you click on the button Manage book from the Admin Page or from the Librarian Page
		if (e ==  adminPage.getManageBook()|| e ==  libPage.getManageBook() ){
			//display the ManageBook page 
			c.show(this.getContentPane(), listPage[2]);
			manageBook.getUserID().setText(loginPage.getUsername().getText());
		}
		
		//if you click on the button Manage Customer from the Admin Page or from the Librarian Page
		if (e ==  adminPage.getCustomerDetails()|| e ==  libPage.getCustomerDetails() ){
			//Display the Manage Customer Page
			c.show(this.getContentPane(), listPage[5]);	
			manageCustomer.getUserID().setText(loginPage.getUsername().getText());
		}
		
		//if you click on the button Manage Account from the Admin Page
		if (e ==  adminPage.getManageAccounts()){
			//Display the Manage Account Page
			c.show(this.getContentPane(), listPage[4]);
			manageUser.getUserID().setText(loginPage.getUsername().getText());
		}
		
		//if you click on the button Library Reports from the Admin Page
		if (e ==  adminPage.getLibraryReport()){
			//Display the Manage Account Page
			c.show(this.getContentPane(), listPage[6]);
			libraryReports.getUserID().setText(loginPage.getUsername().getText());
		}
		
		
		//if you click on the button home from the Manage Book page of the Admin or from the Manage Book page of the Librarian
		if (e ==  manageBook.getHome()){
			if(loginPage.getUsername().getText().equals("admin")){	
			c.show(this.getContentPane(), listPage[1]);
			}
			else{
				c.show(this.getContentPane(), listPage[3]);
			}
		}
		
		//if you click on the button home from the Manage User page of the Admin or from the Manage User page of the Librarian
		if (e ==  manageUser.getHome()){
			if(loginPage.getUsername().getText().equals("admin")){	
			c.show(this.getContentPane(), listPage[1]);
			}
			else{
				c.show(this.getContentPane(), listPage[3]);
			}
		}
		
		if (e ==  manageCustomer.getHome()){
			//Display the Manage Account Page
			c.show(this.getContentPane(), listPage[1]);
		}
		
		if (e ==  libraryReports.getHome()){
			//Display the Manage Account Page
			c.show(this.getContentPane(), listPage[1]);
		}
	}

}
