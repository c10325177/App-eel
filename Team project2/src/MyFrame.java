import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private AdminPage adminPage = new AdminPage();
	private LoginPage loginPage = new LoginPage();
	private ManageBook manageBook = new ManageBook();
	private LibrarianPage libPage = new LibrarianPage();
	private ManageUser manageUser = new ManageUser();
	private ManageCustomer manageCustomer = new ManageCustomer();
	private LibraryReports libraryReports = new LibraryReports();

	// Layout of the main Panel
	private CardLayout c = new CardLayout();
	private String[] listPage = { "LoginPage", "AdministratorPage",
			"Manage Books", "Librarian Page", "Manage User", "Manage Customer",
			"Library Reports" };

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
		// listener on the button who manage the different Account(Librarian,admin)
		manageUser.getHome().addActionListener(this);
		manageCustomer.getHome().addActionListener(this);
		libraryReports.getHome().addActionListener(this);

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
		else if (e == adminPage.getLibraryReport())
		{
			// Display the Manage Account Page
			c.show(this.getContentPane(), listPage[6]);
			libraryReports.getUserID().setText(
					loginPage.getUsername().getText());
		}

		// if you click on the button home from the Manage Book page of the
		// Admin or from the Manage Book page of the Librarian
		else if (e == manageBook.getHome())
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
			DBConnector.InsertCustomer(Integer.valueOf(manageCustomer
					.getCustomerID().getText()), manageCustomer.getname()
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
			if (manageUser.getPassword().getText()
					.equals(manageUser.getConfirmPassword().getText()))
			{
				DBConnector.InsertUser(
						Integer.valueOf(manageUser.getuserID().getText()),
						manageUser.getname().getText(), manageUser
								.getAccessLevel().getSelectedItem().toString(),
						manageUser.getPassword().getText());

				System.out.println("Access Level Value:"
						+ manageUser.getAccessLevel().getSelectedItem()
								.toString());

				manageUser.EmptyFields();
			}
		}

		else if (e == manageUser.getUpdate())
		{
			if (manageUser.getPassword().getText()
					.equals(manageUser.getConfirmPassword().getText()))
			{
				DBConnector.UpdateUser(
						Integer.valueOf(manageUser.getuserID().getText()),
						manageUser.getname().getText(), manageUser
								.getAccessLevel().getSelectedItem().toString(),
						manageUser.getPassword().getText());

				System.out.println("Access Level Value:"
						+ manageUser.getAccessLevel().getSelectedItem()
								.toString());

				manageUser.EmptyFields();
			}
		}
		
		else if (e == manageUser.getDelete())
		{
			DBConnector.DeleteUser(Integer.valueOf(manageUser.getuserID()
					.getText()));
			System.out.println("UID: "
					+ Integer.valueOf(manageUser.getuserID().getText()));

			manageUser.EmptyFields();
		}
		
		else if (e == manageUser.getDiscard())
		{
			manageUser.EmptyFields();
		}

		else if (e == manageUser.getSearch())
		{

		}
	}
}
