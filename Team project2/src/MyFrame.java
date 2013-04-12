
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;



public class MyFrame extends JFrame implements ActionListener {
	
	
	private AdminPage adminPage = new AdminPage();
	private LoginPage loginPage = new LoginPage();
	private ManageBook manageBook = new ManageBook();
	private Search search = new Search();
	private LibrarianPage  libPage= new LibrarianPage();

	
	//Layout of the main Panel
	private CardLayout c = new CardLayout();
	private String[] listPage = {"LoginPage" , "AdministratorPage", "Manage Books", "Search", "Librarian Page"};

	
	public MyFrame(){

	    this.setLayout(c);
	     
        this.add(loginPage, listPage[0]);
        this.add(adminPage, listPage[1]);
        this.add(manageBook, listPage[2]);
        this.add(search, listPage[3]);
        this.add(libPage, listPage[4]);
        loginPage.getLogin().addActionListener(this);
        adminPage.getLogout().addActionListener(this);
        adminPage.getManageBook().addActionListener(this);
        adminPage.getCustomerDetails().addActionListener(this);
        adminPage.getSearch().addActionListener(this);
        libPage.getLogout().addActionListener(this);
        libPage.getManageBook().addActionListener(this);
        libPage.getCustomerDetails().addActionListener(this);
        libPage.getSearch().addActionListener(this);
        manageBook.getBack().addActionListener(this);
        
       

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
				c.show(this.getContentPane(), listPage[4]);
				libPage.getUserID().setText(loginPage.getUsername().getText());
			}
		}
		if (e ==  adminPage.getLogout() || e ==  libPage.getLogout()){
			c.show(this.getContentPane(), listPage[0]);
		}
		
		if (e ==  adminPage.getManageBook()|| e ==  libPage.getManageBook() ){
			c.show(this.getContentPane(), listPage[2]);
		}
		
		if (e ==  manageBook.getBack()){
			if(loginPage.getUsername().getText().equals("admin")){	
			c.show(this.getContentPane(), listPage[1]);
			}
			else{
				c.show(this.getContentPane(), listPage[4]);
			}
		}
		
		if (e ==  adminPage.getSearch() || e ==  libPage.getSearch()){
			c.show(this.getContentPane(), listPage[3]);
		}
		
	}

}
