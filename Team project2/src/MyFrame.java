import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyFrame extends JFrame implements ActionListener, ListSelectionListener
{
	private static final long serialVersionUID = 1L;
	private AdminPage adminPage = new AdminPage();
	private LoginPage loginPage = new LoginPage();
	private ManageBook manageBook = new ManageBook();
	private LibrarianPage libPage = new LibrarianPage();
	private ManageUser manageUser = new ManageUser();
	private ManageCustomer manageCustomer = new ManageCustomer();
	private LibraryReports libraryReports = new LibraryReports();
	private CustomerPage customerPage = new CustomerPage();
	private BookPage bookPage = new BookPage();
	private LibrarianActivity librarianActivity = new LibrarianActivity();
	private LoanPage loanPage = new LoanPage();
	private ReturnPage returnPage = new ReturnPage();

	// Layout of the main Panel
	private CardLayout c = new CardLayout();
	private String[] listPage = { "LoginPage", "AdministratorPage",
			"Manage Books", "Librarian Page", "Manage User", "Manage Customer",
			"Library Reports", "Customer Page", "Book Page", "Librarian Activity Page", "Loan Page", "Return Page"};

	public MyFrame() throws SQLException
	{
		this.setLayout(c);
		this.add(loginPage, listPage[0]);
		this.add(adminPage, listPage[1]);
		this.add(manageBook, listPage[2]);
		this.add(libPage, listPage[3]);
		this.add(manageUser, listPage[4]);
		this.add(manageCustomer, listPage[5]);
		this.add(libraryReports, listPage[6]);
		this.add(customerPage, listPage[7]);
		this.add(bookPage, listPage[8]);
		this.add(librarianActivity, listPage[9]);
		this.add(loanPage, listPage[10]);
		this.add(returnPage, listPage[11]);
		
		loginPage.getLogin().addActionListener(this);
		
		adminPage.getLogout().addActionListener(this);
		adminPage.getManageBook().addActionListener(this);
		adminPage.getCustomerDetails().addActionListener(this);
		adminPage.getManageAccounts().addActionListener(this);
		adminPage.getLibraryReport().addActionListener(this);
		adminPage.getLoan().addActionListener(this);
		adminPage.getReturned().addActionListener(this);
		
		libPage.getLogout().addActionListener(this);
		libPage.getManageBook().addActionListener(this);
		libPage.getCustomerDetails().addActionListener(this);
		
		manageBook.getHome().addActionListener(this);
		// listener on the button who manage the different Account(Librarian,admin)
		manageUser.getHome().addActionListener(this);
		manageCustomer.getHome().addActionListener(this);
		libraryReports.getHome().addActionListener(this);
		customerPage.getBack().addActionListener(this);
		bookPage.getBack().addActionListener(this);
		librarianActivity.getBack().addActionListener(this);
		loanPage.getHome().addActionListener(this);
		returnPage.getHome().addActionListener(this);

		manageBook.getInsert().addActionListener(this);
		manageBook.getDelete().addActionListener(this);
		manageBook.getUpdate().addActionListener(this);
		manageBook.getDiscard().addActionListener(this);
		manageBook.getSearch().addActionListener(this);

		manageCustomer.getInsert().addActionListener(this);
		manageCustomer.getDelete().addActionListener(this);
		manageCustomer.getUpdate().addActionListener(this);
		manageCustomer.getDiscard().addActionListener(this);
		manageCustomer.getSearch().addActionListener(this);

		manageUser.getInsert().addActionListener(this);
		manageUser.getDelete().addActionListener(this);
		manageUser.getUpdate().addActionListener(this);
		manageUser.getDiscard().addActionListener(this);
		manageUser.getSearch().addActionListener(this);
		manageUser.getTable().getSelectionModel().addListSelectionListener(this);
		
		libraryReports.getBook().addActionListener(this);
		libraryReports.getCustomer().addActionListener(this);
		libraryReports.getLibrarian().addActionListener(this);
		

		//Comment out line below to use without DB
		//DBConnector.DBConnect();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent event)
	{
		Object e = event.getSource();
		if (e == loginPage.getLogin())
		{

			if (loginPage.getUsername().getText().equals("admin")
					&& loginPage.getPassword().getText().equals("admin"))
			{
				c.show(this.getContentPane(), listPage[1]);
				adminPage.getUserID()
						.setText(loginPage.getUsername().getText());
			} else
			{
				c.show(this.getContentPane(), listPage[3]);
				libPage.getUserID().setText(loginPage.getUsername().getText());
			}
		}

		// if you click on the button log out
		else if (e == adminPage.getLogout() || e == libPage.getLogout())
		{
			// display the login Page
			c.show(this.getContentPane(), listPage[0]);
		}

		// if you click on the button Manage book from the Admin Page or from
		// the Librarian Page
		else if (e == adminPage.getManageBook() || e == libPage.getManageBook())
		{
			// display the ManageBook page
			c.show(this.getContentPane(), listPage[2]);
			manageBook.getUserID().setText(loginPage.getUsername().getText());
		}

		// if you click on the button Manage Customer from the Admin Page or
		// from the Librarian Page
		else if (e == adminPage.getCustomerDetails()
				|| e == libPage.getCustomerDetails())
		{
			// Display the Manage Customer Page
			c.show(this.getContentPane(), listPage[5]);
			manageCustomer.getUserID().setText(
					loginPage.getUsername().getText());
		}

		// if you click on the button Manage Account from the Admin Page
		else if (e == adminPage.getManageAccounts())
		{
			// Display the Manage Account Page
			c.show(this.getContentPane(), listPage[4]);
			manageUser.getUserID().setText(loginPage.getUsername().getText());
		}

		// if you click on the button Library Reports from the Admin Page
		else if (e == adminPage.getLibraryReport() || e == customerPage.getBack() || e == bookPage.getBack() || e == librarianActivity.getBack())
		{
			// Display the Manage Account Page
			c.show(this.getContentPane(), listPage[6]);
			libraryReports.getUserID().setText(
					loginPage.getUsername().getText());
		}
		
		// if you click on the button Customer from the Library Reports Page
		else if (e == libraryReports.getCustomer())
		{
			// Display the Customer Page
			c.show(this.getContentPane(), listPage[7]);
			customerPage.getUserID().setText(loginPage.getUsername().getText());
		}
		
		// if you click on the button Book from the Library Reports Page
		else if (e == libraryReports.getBook())
		{
			// Display the Book Page
			c.show(this.getContentPane(), listPage[8]);
			bookPage.getUserID().setText(loginPage.getUsername().getText());
		}
		
		// if you click on the button Librarian Activity from the Library Reports Page
		else if (e == libraryReports.getLibrarian())
		{
			// Display the Librarian Activity Page
			c.show(this.getContentPane(), listPage[9]);
			librarianActivity.getUserID().setText(loginPage.getUsername().getText());
		}
		
		// if you click on the button Loan from the Admin Page
		else if (e == adminPage.getLoan())
		{
			// Display the Loan Page
			c.show(this.getContentPane(), listPage[10]);
			loanPage.getUserID().setText(loginPage.getUsername().getText());
		}
		
		// if you click on the button Returned from the Admin Page
		else if (e == adminPage.getReturned())
		{
			// Display the Return Page
			c.show(this.getContentPane(), listPage[11]);
			returnPage.getUserID().setText(loginPage.getUsername().getText());
		}
		

		// if you click on the button home from the Manage Book page of the
		// Admin or from the Manage Book page of the Librarian
		else if (e == manageBook.getHome() || e == loanPage.getHome() || e == returnPage.getHome())
		{
			if (loginPage.getUsername().getText().equals("admin"))
			{
				c.show(this.getContentPane(), listPage[1]);
			} else
			{
				c.show(this.getContentPane(), listPage[3]);
			}
		}

		// if you click on the button home from the Manage User page of the
		// Admin or from the Manage User page of the Librarian
		else if (e == manageCustomer.getHome())
		{
		if (loginPage.getUsername().getText().equals("admin"))
		{
		c.show(this.getContentPane(), listPage[1]);
		} else
		{
		c.show(this.getContentPane(), listPage[3]);
		}
		}

		else if (e == manageUser.getHome())
		{
		// Display the Manage Account Page
		c.show(this.getContentPane(), listPage[1]);
		}

		if (e == libraryReports.getHome())
		{
			// Display the Manage Account Page
			c.show(this.getContentPane(), listPage[1]);
		}

		
		
		
		
		// BOOK DB STUFF
		else if (e == manageBook.getInsert())
		{

			DBConnector.InsertBook(manageBook.getISBN().getText(), 
					manageBook.getAuthor().getText(),
					manageBook.getBookTitle().getText(),
					manageBook.getGenre().getText(),
					manageBook.getlocation().getText(),
					manageBook.getAvailable().getText());
			
			manageBook.EmptyFields();
		}

		else if (e == manageBook.getUpdate())
		{
			DBConnector.UpdateBook(Integer.valueOf(manageBook.getLibCode()
					.getText()), manageBook.getISBN().getText(), manageBook
					.getAuthor().getText(),
					manageBook.getBookTitle().getText(), manageBook.getGenre()
							.getText(), manageBook.getlocation().getText(),
					manageBook.getAvailable().getText());

			manageBook.EmptyFields();
		}

		
		else if (e == manageBook.getDelete())
		{
			DBConnector.DeleteBook(Integer.valueOf(manageBook.getLibCode()
					.getText()));
			manageBook.EmptyFields();
		}

		else if (e == manageBook.getDiscard())
		{
			manageBook.EmptyFields();
		}
		
		if (e == manageBook.getSearch())
		{

		}
			
		// CUSTOMER DB STUFF
		else if (e == manageCustomer.getInsert())
		{
			DBConnector.InsertCustomer(manageCustomer.getname()
					.getText(), manageCustomer.getAddress().getText(), Double
					.parseDouble(manageCustomer.getBalance().getText()
							.toString()));

			manageCustomer.EmptyFields();
		}
		
		else if (e == manageCustomer.getUpdate())
		{					
			DBConnector.UpdateCustomer(Integer.valueOf(manageCustomer
					.getCustomerID().getText()), manageCustomer.getname()
					.getText(), manageCustomer.getAddress().getText(), Double
					.parseDouble(manageCustomer.getBalance().getText()
							.toString()));

			manageCustomer.EmptyFields();
		}

		else if (e == manageCustomer.getDelete())
		{
			DBConnector.DeleteCustomer(Integer.valueOf(manageCustomer
					.getCustomerID().getText()));
			
			manageCustomer.EmptyFields();
		}
		
		else if (e == manageCustomer.getDiscard())
		{
			manageCustomer.EmptyFields();
		}
		
		else if (e == manageCustomer.getSearch())
		{

		}			
		
		// USER DB STUFF
		else if (e == manageUser.getInsert())
		{						
		
				if (manageUser.CheckPassword())
				{
					DBConnector.InsertUser(manageUser.getname()
							.getText(), manageUser.getAccessLevel()
							.getSelectedItem().toString(), manageUser
							.getPassword().getText());
					
					ResetTable(manageUser);	
				}
		}

		else if (e == manageUser.getUpdate())
		{
			if (manageUser.CheckPassword())
			{
				DBConnector.UpdateUser(
							Integer.valueOf(manageUser.getuserID().getText()),
							manageUser.getname().getText(), manageUser
							.getAccessLevel().getSelectedItem().toString(),
							manageUser.getPassword().getText());
			
				ResetTable(manageUser);		
			}
		}
		
		else if (e == manageUser.getDelete())
		{
			DBConnector.DeleteUser(manageUser);		
			ResetTable(manageUser);						
		}
		
		else if (e == manageUser.getDiscard())
		{
			ResetTable(manageUser);
		}		
		
		else if (e == manageUser.getSearch())
		{						
			String temp= manageUser.getSearchType().getSelectedItem().toString();
			
			if(temp.equals("User ID"))
			{			
				if (TestForIntegerValue(manageUser.getSearchJTF().getText()))
				{			
					DBConnector.SearchUserByID(manageUser);
				}
			}
			
			if(temp.equals("Name"))
			{			
				DBConnector.SearchUserByName(manageUser);
			}			
			
			if(temp.equals("Access Level"))
			{			
				DBConnector.SearchUserByAccessLevel(manageUser);
			}
		}
			
	}

	@Override
	public void valueChanged(ListSelectionEvent event)
	{		
		Object e = event.getSource();
		
		if(e == manageUser.getTable().getSelectionModel())
		{
			int row = manageUser.getTable().getSelectionModel().getLeadSelectionIndex();
			manageUser.EmptyFields();
			manageUser.getuserID().setText(manageUser.getTableModel().getValueAt(row, 0).toString());
			manageUser.getname().setText(manageUser.getTableModel().getValueAt(row, 1).toString());
			
			String accessLevel= manageUser.getTableModel().getValueAt(row, 2).toString();	
			
			if(accessLevel.equals("Librarian"))
			{
				manageUser.getAccessLevel().setSelectedItem("Librarian");
			}
			
			else
			{
				manageUser.getAccessLevel().setSelectedItem("Admin");
			}
		}		
	}
	
	public static boolean TestForIntegerValue(String ID)
	{
		boolean integerValue=true;
		
		try 
		{
			Integer.valueOf(ID);					
		}
		
		catch(NumberFormatException e1)
		{
			SwingPopup("You must input a number to search by an id");
			integerValue=false;
		}
		
		return integerValue;
	}
	
	public static void SwingPopup(String Message)
	{
		JOptionPane.showMessageDialog(new JFrame(),Message);
	}
	
	public void ResetTable(JPanel currentPanel)
	{
		((ManageUser) currentPanel).EmptyFields();			
		((ManageUser) currentPanel).getTable().getSelectionModel().removeListSelectionListener(this);		
		((ManageUser) currentPanel).EmptyTable();
		((ManageUser) currentPanel).getTable().getSelectionModel().addListSelectionListener(this);	
	}
}
