
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

	
	//Layout of the main Panel
	private CardLayout c = new CardLayout();
	private String[] listPage = {"LoginPage" , "AdministratorPage", "Manage Books", "Search"};

	
	public MyFrame(){

	    this.setLayout(c);
	     
        this.add(loginPage, listPage[0]);
        this.add(adminPage, listPage[1]);
        this.add(manageBook, listPage[2]);
        this.add(search, listPage[3]);
        loginPage.getLogin().addActionListener(this);
        adminPage.getLogout().addActionListener(this);
        adminPage.getManageBook().addActionListener(this);
        adminPage.getCustomerDetails().addActionListener(this);
        adminPage.getSearch().addActionListener(this);
        manageBook.getBack().addActionListener(this);
        
       

	}


	@Override
	public void actionPerformed(ActionEvent event) {
		
		// TODO Auto-generated method stub
		Object e = event.getSource();
		if (e == loginPage.getLogin()){
			
			if (loginPage.getUsername().getText() == "admin" && loginPage.getPassword().getText() == "admin" ){
			c.show(this.getContentPane(), listPage[1]);
			}
		}
		if (e ==  adminPage.getLogout()){
			c.show(this.getContentPane(), listPage[0]);
		}
		
		if (e ==  adminPage.getManageBook()){
			c.show(this.getContentPane(), listPage[2]);
		}
		
		if (e ==  manageBook.getBack()){
			c.show(this.getContentPane(), listPage[1]);
		}
		
		if (e ==  adminPage.getCustomerDetails()){
			c.show(this.getContentPane(), listPage[0]);
		}
		if (e ==  adminPage.getSearch()){
			c.show(this.getContentPane(), listPage[3]);
		}
		
	}
	
	public void setValue(){
		 loginPage.getUsername().setText(loginPage.getUsername().getText());
	}

}
