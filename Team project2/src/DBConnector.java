import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

public class DBConnector
{

	static Connection con;
	static int no_of_rows = 0;		
	static String T= "T";
	static String F= "F";
	
	public static void DBConnect() throws SQLException
	{
		try
		{	
			
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@ferdia:1521:ora11gdb", "team_appeel",
					"bglammmd");
		}
		/*	
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "baz",
					"bglammmd");		
		}*/

		catch (SQLException e)
		{
			MyFrame.SwingPopup("Contact system administrator: No Database connection\n" +e);
			
			System.out.println("Oracle Server not found " + e);
			System.exit(0);
		}		
	}

	public static void InsertCustomer(ManageCustomer manageCustomer)
	{
		Statement stmt;
		ResultSet rs;
		int id=0;
		
		String Name = TitleCaseConverter.toTitleCase(manageCustomer.getname().getText());
		String Address = TitleCaseConverter.toTitleCase(manageCustomer.getAddress().getText());
		Double Balance = Double.parseDouble(manageCustomer.getBalance().getText());
		
		System.out.println(Name + Address + ""+Balance);
		

			
		no_of_rows = 0;
		try
		{
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("INSERT INTO CUSTOMER "+ "values (CUSTID.nextVal,'" + Name + "', '"
							+ Address
							+ "'," + Balance + ",'"+T+"')");
			
		}

		catch (SQLException e)
		{
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
			System.out.println("SQL exception occured" + e);
		}
		
		try
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT CUSTOMERID FROM CUSTOMER WHERE Name = '"+Name+"'");
			
			while (rs.next()) 
			{
				id=rs.getInt(1);
			    System.out.println("id=" + id);
			}
			
			rs.close();
			
			MyFrame.SwingPopup("New Customer: \""
					+ Name
					+ "\" has been added to database and allocated CustomerID: "
					+ id);
		} 
		
		catch (SQLException e)
		{
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
			System.out.println("SQL exception occured" + e);
		}
	}

	public static void UpdateCustomer(int CustomerID, String Name, String Address, Double Balance)
	{
		Address=TitleCaseConverter.toTitleCase(Address);
		Name=TitleCaseConverter.toTitleCase(Name);
		no_of_rows = 0;
		try
		{
			Statement stmt = con.createStatement();
			int updatedrow = stmt
					.executeUpdate("UPDATE Customer SET CustomerId = "
							+ CustomerID + ",  Name ='" + Name
							+ "', Address = '" + Address + "', Balance = "
							+ Balance + " WHERE CustomerId = '" + CustomerID
							+ "'");
			System.out.println("Rows Updated" + updatedrow);
			
			if(updatedrow > 0)
			{
					System.out.println("Rows Updated: " + updatedrow);
					MyFrame.SwingPopup("Details for Customer: \""+Name+ "\" succesfully updated");
			}
		}

		catch (SQLException e)
		{
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
			System.out.println("SQL exception occured" + e);
		}
	}

	public static void DeleteCustomer(int CustomerID, String Name)
	{
		no_of_rows = 0;
		
		try
		{
			Statement stmt = con.createStatement();
			int deletedRows = stmt
					.executeUpdate("UPDATE Customer SET Active = '"+F+"' WHERE CustomerId = '" + CustomerID+ "'");
			System.out.println("Rows Deleted: " + deletedRows);
			
			if(deletedRows > 0)
			{
				System.out.println("Rows Deleted: " + deletedRows);
				MyFrame.SwingPopup("Customer: \""+Name+ "\" with CustomerID: " +CustomerID +" succesfully deleted");
			}
		}

		catch (SQLException e)
		{
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
			System.out.println("SQL exception occured" + e);
			System.out.println("Delete statement excuted");
		}
	}

	public static void UpdateBook(ManageBook manageBook)
	{	
		int LibCode = Integer.valueOf(manageBook.getLibCode().getText());
		long ISBN=Long.parseLong(manageBook.getISBN().getText());
		String title = TitleCaseConverter.toTitleCase(manageBook.getBookTitle().getText());
		String Author = TitleCaseConverter.toTitleCase(manageBook.getAuthor().getText());
		String Genre = TitleCaseConverter.toTitleCase(manageBook.getGenre().getText());
		String Location = TitleCaseConverter.toTitleCase(manageBook.getlocation().getText());
		String Available = TitleCaseConverter.toTitleCase(manageBook.getAvailable().getText());
		no_of_rows = 0;

		try
		{
			Statement stmt = con.createStatement();
			int updateRow = stmt.executeUpdate("UPDATE Book SET ISBN = '"
					+ ISBN + "', Title='" + title + "', Author='" + Author
					+ "', Genre='" + Genre + "', Location='" + Location
					+ "', Available='" + Available + "' WHERE LibCode ="
					+ LibCode + "");
			System.out.println("Rows Updated: " + updateRow);
			
			if(updateRow > 0)
			{
					System.out.println("Rows Updated: " + updateRow);
					MyFrame.SwingPopup("Book: \""+title+ "\" with Libcode: " +LibCode +" succesfully updated");
			}
		}

		catch (SQLException e)
		{
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
			System.out.println("SQL exception occured" + e);
		}
	}

	public static void InsertBook(ManageBook manageBook)
	{	
		String ISBN=TitleCaseConverter.toTitleCase(manageBook.getISBN().getText());
		String title = TitleCaseConverter.toTitleCase(manageBook.getBookTitle().getText());
		String Author = TitleCaseConverter.toTitleCase(manageBook.getAuthor().getText());
		String Genre = TitleCaseConverter.toTitleCase(manageBook.getGenre().getText());
		String Location = TitleCaseConverter.toTitleCase(manageBook.getlocation().getText());
		String Available = TitleCaseConverter.toTitleCase(manageBook.getAvailable().getText());
		
		no_of_rows = 0;

		ResultSet rs;
		Statement stmt;
		
		try
		{
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("INSERT INTO Book " 
							+ "values (LIBCODE.nextVal,"+ ISBN
							+ ", '"
							+ title
							+ "','" + Author + "','" + Genre + "','" + Location + "','" + Available + "','"+T+"')");
		}
		
		catch (SQLException e)
		{
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
			System.out.println("SQL exception occured" + e);
		}
		
		int newLibCode = 0;	
		
		try
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT LibCode FROM Book WHERE ISBN = "+ISBN+"");
			
			while (rs.next()) 
			{
				newLibCode=rs.getInt(1);
			    System.out.println("id=" + newLibCode);
			}
			
			rs.close();
			
			MyFrame.SwingPopup("New Book \""
					+ title
					+ "\" has been added to database and allocated LibCode: "
					+ newLibCode);
		} 
		
		catch (SQLException e)
		{
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
			e.printStackTrace();
		}
	}

	public static void DeleteBook(int LibCode)
	{
		no_of_rows = 0;
		try
		{
			Statement stmt = con.createStatement();
			int deletedRows = stmt.executeUpdate("UPDATE Book SET active = '"
					+ F + "' WHERE LibCode ="
					+ LibCode + "");
			
			if(deletedRows > 0)
			{
				System.out.println("Rows Deleted: " + deletedRows);
				MyFrame.SwingPopup("Libcode: " +LibCode +" succesfully deleted");
			}		
		}

		catch (SQLException e)
		{
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
			System.out.println("SQL exception occured" + e);	
		}
	}

	public static void InsertUser(String Name, String accessLevel, String password)
	{
		Name=TitleCaseConverter.toTitleCase(Name);
	
		System.out.println("Access Level Value:"
				+ accessLevel);
		
		no_of_rows = 0;
		ResultSet rs;
		Statement stmt;
		
		try
		{
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("INSERT INTO Users(Userid, Name, Accesslevel, password,ACTIVE) " 
							+ "values (USERID.nextVal,'"
							+ Name
							+ "', '"
							+ accessLevel
							+ "','" + password + "','"+T+"')");
			
		}
		
		catch (SQLException e)
		{
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
			System.out.println("SQL exception occured" + e);
		}
		
		int id = 0;	
		
		try
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT Userid FROM Users WHERE Name LIKE '%"+Name+"%'");
			
			while (rs.next()) 
			{
				id=rs.getInt(1);
			    System.out.println("id=" + id);
			}
			
			rs.close();
			
			MyFrame.SwingPopup("New user: \""
					+ Name
					+ "\" has been added to database and allocated user id: "
					+ id);
		} 
		
		catch (SQLException e)
		{
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
			e.printStackTrace();
		}
	}

	public static void DeleteUser(ManageUser manageUser)
	{
		try
		{
			int USERID = Integer.valueOf(manageUser.getuserID().getText());
			
			Statement stmt = con.createStatement();

			
			int rowsDeleted = stmt.executeUpdate("UPDATE Users SET active='"
					+ F + "'WHERE UserID = '" + USERID + "'");
			
			System.out.println("Rows Deleted: " + rowsDeleted);
			
			System.out.println("UID Deleted: "
					+ USERID);
		
			if(rowsDeleted > 0)
			{			
				MyFrame.SwingPopup("User: "
						+ manageUser.getname().getText() +" with User ID: " + manageUser.getuserID().getText()
						+ " has been deleted from the database");
				System.out.println("Delete statement excuted");
			}
		}

		catch (SQLException e)
		{
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
			System.out.println("SQL exception occured" + e);
			
		}
	}

	public static void UpdateUser(int userID, String name, String accessLevel,
			String password)
	{
		
		System.out.println("Access Level Value:"+ accessLevel);
		
		name=TitleCaseConverter.toTitleCase(name);
		no_of_rows = 0;

		try
		{
			Statement stmt = con.createStatement();
			int updateRow = stmt.executeUpdate("UPDATE Users SET Userid="
					+ userID + ", Name='" + name + "', Accesslevel='"
					+ accessLevel + "', password='" + password
					+ "' WHERE UserID = '" + userID + "'");
			
			if(updateRow > 0)
			{
				System.out.println("Rows Updated: " + updateRow);
				MyFrame.SwingPopup("User: " +name +" succesfully updated");
			}
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}
	}
	
	
	public static void SearchUserByID(ManageUser manageUser)
	{				
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			int USERID = Integer.valueOf(manageUser.getSearchJTF().getText());
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM Users where Userid = "+USERID+" AND ACTIVE = '"+T+"'");
			
			if (!rs.next() ) 
			{
			    System.out.println("no data found");
			    MyFrame.SwingPopup("User ID: "+ USERID + " not found in database" );
			}
			
			else
			{		
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 3; i++) 
					{		    	
						newRow.addElement(rs.getObject(i));
						System.out.println(rs.getString("Name")+", Column: "+i);
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while (rs.next());
			
				System.out.println("Searched by USERID " + USERID);
				manageUser.getTableModel().setDataVector(rows, manageUser.getHeader()); 
			}	
		}
		
		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}
	}
		
	public static void SearchUserByName(ManageUser manageUser)
	{		      				
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			String Name = TitleCaseConverter.toTitleCase(manageUser.getSearchJTF().getText().toString());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE Name LIKE '%"+Name+"%' AND ACTIVE = '"+T+"' ORDER BY UserID");
			
			if(!rs.next())
			{
				System.out.println("No rows found");
				MyFrame.SwingPopup("No users matching: \""+Name+ "\" found in the database\n" +
						"you can use an empty search to display all users" );
			}
					
			else
			{
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 3; i++) 
					{		    	
						newRow.addElement(rs.getObject(i));
						System.out.println(rs.getString("Name")+", Column: "+i);
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while(rs.next());
				
			}
			
			System.out.println("Searched by Name " + Name);
			manageUser.getTableModel().setDataVector(rows, manageUser.getHeader()); 
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}
	}
	
	
	public static void SearchUserByAccessLevel(ManageUser manageUser)
	{				
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			String AccessLevel = TitleCaseConverter.toTitleCase(manageUser.getSearchJTF().getText().toString());
			System.out.println("Access Level Text: "+AccessLevel);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM Users WHERE AccessLevel LIKE '%"+AccessLevel+"%' AND ACTIVE = '"+T+"'");
					
			if (!rs.next())
			{
				MyFrame.SwingPopup("Access Level must be searched by \"Librarian\" or \"Admin\"\n" +
						" or you can use an empty search to display all users" );
			}
			
			else
			{
				do
				{			
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 3; i++) 
					{		    	
						newRow.addElement(rs.getObject(i));
						System.out.println(rs.getString("Name")+", Column: "+i);
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while(rs.next());
			}
			
			System.out.println("Searched by Name " + AccessLevel);
			manageUser.getTableModel().setDataVector(rows, manageUser.getHeader()); 		
		}
		
		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}
	}



	public static void SearchCustomerByName(ManageCustomer manageCustomer)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			String Name = TitleCaseConverter.toTitleCase(manageCustomer.getSearchJTF().getText().toString());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Customer WHERE Name LIKE '%"+Name+"%' AND ACTIVE = '"+T+"'");
			
			if(!rs.next())
			{
				System.out.println("No rows found");
				MyFrame.SwingPopup("No users matching: \""+Name+ "\" found in the database\n" +
						"you can use an empty search to display all customers" );
			}
					
			else
			{
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 4; i++) 
					{		    	
						newRow.addElement(rs.getObject(i));
						System.out.println(rs.getString("Name")+", Column: "+i);
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while(rs.next());
				
			}
			
			System.out.println("Searched by Name " + Name);
			manageCustomer.getTableModel().setDataVector(rows, manageCustomer.getHeader()); 
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}		
	}

	public static void SearchCustomerByID(ManageCustomer manageCustomer)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			int CUSTOMERID = Integer.valueOf(manageCustomer.getSearchJTF().getText());
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM Customer where Customerid = "+CUSTOMERID+"AND ACTIVE = '"+T+"'");
			
			if (!rs.next() ) 
			{
			    System.out.println("no data found");
			    MyFrame.SwingPopup("Customer ID: "+ CUSTOMERID + " not found in database" );
			}
			
			else
			{		
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 4; i++) 
					{		    	
						newRow.addElement(rs.getObject(i));
						System.out.println(rs.getString("Name")+", Column: "+i);
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while (rs.next());
			
				System.out.println("Searched by CUSTOMER ID " + CUSTOMERID);
				manageCustomer.getTableModel().setDataVector(rows, manageCustomer.getHeader()); 
			}	
		}
		
		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}		
	}

	public static void SearchCustomerByAddress(ManageCustomer manageCustomer)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			String address = TitleCaseConverter.toTitleCase(manageCustomer.getSearchJTF().getText().toString());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Customer WHERE Address LIKE '%"+address+"%'AND ACTIVE = '"+T+"'");;
			
			if(!rs.next())
			{
				System.out.println("No rows found");
				MyFrame.SwingPopup("No users matching: \""+address+ "\" found in the database\n" +
						"you can use an empty search to display all customers" );
			}
					
			else
			{
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 4; i++) 
					{		    	
						newRow.addElement(rs.getObject(i));
						System.out.println(rs.getString("Name")+", Column: "+i);
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while(rs.next());
				
			}
			
			System.out.println("Searched by address " + address);
			manageCustomer.getTableModel().setDataVector(rows, manageCustomer.getHeader()); 
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}
		
	}



	public static void SearchBookByTitle(ManageBook manageBook)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			String title = TitleCaseConverter.toTitleCase(manageBook.getSearchJTF().getText().toString());
			Statement stmt = con.createStatement();
			System.out.println("searching by title: "+title);
			ResultSet rs = stmt.executeQuery("SELECT * FROM Book WHERE Title LIKE '%"+title+"%' AND ACTIVE = '"+T+"'");
			System.out.println("problem after SQL search by title?");
			
			if(!rs.next())
			{
				System.out.println("No rows found");
				MyFrame.SwingPopup("No books called: \""+title+ "\" found in the database\n" +
						"you can use an empty search to display all books" );
			}
					
			else
			{
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 7; i++) 
					{		    	
						newRow.addElement(rs.getObject(i));
						System.out.println(rs.getString("Title")+", Column: "+i);
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while(rs.next());
				
			}
			
			System.out.println("Searched by author " + title);
			manageBook.getTableModel().setDataVector(rows, manageBook.getHeader()); 
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}	
	}
		

	public static void SearchBookByLibCode(ManageBook manageBook)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			int libCode = Integer.valueOf(manageBook.getSearchJTF().getText());
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM Book where Libcode = "+libCode+" AND ACTIVE = '"+T+"'");
			
			if (!rs.next() ) 
			{
			    System.out.println("no data found");
			    MyFrame.SwingPopup("Libcode: "+ libCode + " not found in database" );
			}
			
			else
			{		
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 7; i++) 
					{		    	
						newRow.addElement(rs.getObject(i));
						System.out.println(rs.getString("Libcode")+", Column: "+i);
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while (rs.next());
			
				System.out.println("Searched by CUSTOMER ID " + libCode);
				manageBook.getTableModel().setDataVector(rows, manageBook.getHeader()); 
			}	
		}
		
		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}		
	}



	public static void SearchBookByAuthor(ManageBook manageBook)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			String author = TitleCaseConverter.toTitleCase(manageBook.getSearchJTF().getText().toString());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Book WHERE Author LIKE '%"+author+"%' AND ACTIVE = '"+T+"'");
			
			if(!rs.next())
			{
				System.out.println("No rows found");
				MyFrame.SwingPopup("No books by author: \""+author+ "\" found in the database\n" +
						"you can use an empty search to display all books" );
			}
					
			else
			{
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 7; i++) 
					{		    	
						newRow.addElement(rs.getObject(i));
						System.out.println(rs.getString("Author")+", Column: "+i);
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while(rs.next());
				
			}
			
			System.out.println("Searched by author " + author);
			manageBook.getTableModel().setDataVector(rows, manageBook.getHeader()); 
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}	
	}
	
	
	public static void SearchBookByAvailable(ManageBook manageBook,boolean searchAvail)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			
			String available = "Yes";
			
			if(!searchAvail)
			{
				available = "No";		
			}
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Book WHERE Available = '"+available+"' AND ACTIVE = '"+T+"' ORDER BY LibCode");
			
			if(!rs.next())
			{
				System.out.println("No rows found");
				MyFrame.SwingPopup("No books by author: \""+available+ "\" found in the database\n" +
						"you can use an empty search to display all books" );
			}
					
			else
			{
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 7; i++) 
					{		    	
						newRow.addElement(rs.getObject(i));
						System.out.println(rs.getString("available")+", Column: "+i);
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while(rs.next());
				
			}
			
			System.out.println("Searched by available " + available);
			manageBook.getTableModel().setDataVector(rows, manageBook.getHeader()); 
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}	
	}
	
	
	public static void SearchBookByOverDue(ManageBook manageBook)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();		
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select Libcode, ISBN,TITLE,AUTHOR,GENRE,LOCATION,AVAILABLE from loan join Book using(libcode) where sysdate > duedate AND ACTIVE = '"+T+"' AND datereturned is null");
			
			if(!rs.next())
			{
				System.out.println("No rows found");
				MyFrame.SwingPopup("No books overdue have been found in the database" );
			}
					
			else
			{
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 7; i++) 
					{		    	
						newRow.addElement(rs.getObject(i));
						System.out.println(rs.getString("available")+", Column: "+i);
					}
				
					
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while(rs.next());
				
			}
			
			System.out.println("Searched for overdue books");
			manageBook.getTableModel().setDataVector(rows, manageBook.getHeader()); 
			MyFrame.SwingPopup("Table displaying Overdue Books" );
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}	
	}



	public static void SearchBookByISBN(ManageBook manageBook)
	{	
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			Long ISBN = Long.parseLong(manageBook.getSearchJTF().getText());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Book where ISBN = "+ISBN);
			
			if(!rs.next())
			{
				System.out.println("No rows found");
				MyFrame.SwingPopup("No books with ISBN: \""+ISBN+ "\" found in the database\n" +
						"you can use an empty search to display all books" );
			}
					
			else
			{
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 7; i++) 
					{		    	
						newRow.addElement(rs.getObject(i));
						System.out.println(rs.getString("ISBN")+", Column: "+i);
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while(rs.next());
				
			}
			
			System.out.println("Searched by ISBN " + ISBN);
			manageBook.getTableModel().setDataVector(rows, manageBook.getHeader()); 
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}		
	}

	public static void DisplayOverDueBookInfo(LoanPage loanPage)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();		
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select loanid, libcode, Title, Name, loandate, floor(sysdate - duedate ) from loan join customer using (customerid) join book using (libcode) where datereturned is null AND duedate < sysdate");
			
			if(!rs.next())
			{
				System.out.println("No rows found");
				MyFrame.SwingPopup("No books overdue have been found in the database" );
			}
					
			else
			{
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 6; i++) 
					{		    	
						newRow.addElement(rs.getObject(i));
						//System.out.println(rs.getString("available")+", Column: "+i);		
					}
				
					System.out.println("Row added to Vector");
					
					rows.add(newRow);
				}
				
				while(rs.next());
				
			}
			
			System.out.println("Searched for overdue books");
			loanPage.getTableModel().setDataVector(rows, loanPage.getHeader()); 
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}	
	}

	@SuppressWarnings("deprecation")
	public static void loanBook(LoanPage loanPage)
	{		
		String LibCode = loanPage.getJTFlibCode().getText();
		String CustomerID = loanPage.getJTFcustomerID().getText();
		String UserID=loanPage.getUserID().getText();
		int libCode = Integer.valueOf(LibCode);
		int customerID = Integer.valueOf(CustomerID);
		int userID = Integer.valueOf(UserID);
		
		System.out.println(""+libCode+customerID+userID);
		
		if(MyFrame.TestForNumericValue(LibCode,"NUMERICINSERTCHECK") && MyFrame.TestForNumericValue(CustomerID,"NUMERICINSERTCHECK") )
		{	
			if(BookAvailable(libCode) && checkCustomerExists(customerID))
			{		
				no_of_rows = 0;

				Statement stmt; 
				
				try
				{
					String booksOutstanding="";
					stmt = con.createStatement();		
					ResultSet rs=stmt.executeQuery("SELECT TITLE FROM LOAN join book using(libcode) where customerid = "+CustomerID+" AND DATERETURNED is NULL");
					
					if(!rs.next())
					{
						System.out.println("User has no outstanding books");			
					}
					
					else
					{	
						@SuppressWarnings("unused")
						int i=0;
						
						do
						{
							booksOutstanding+="\n";				
							booksOutstanding+=(rs.getString(1));
							
							System.out.println("Books Outstanding info: " +booksOutstanding);
							i++;
						}
						
						while(rs.next());
						
						MyFrame.SwingPopup("The customer has the following books outstanding: "+booksOutstanding);
					}
					
					
					System.out.println("Books Outstanding?");
					
					stmt = con.createStatement();		
					stmt.executeQuery("INSERT INTO LOAN "+"values (loanid.nextval,"+userID+","+customerID+",sysdate+5,"+libCode+",sysdate,null)");
					System.out.println("Loan submitted succesfully");				
					
					Date dt = new Date();
					dt.setDate(dt.getDate()+5);
					System.out.print(dt.toLocaleString().substring(0,11));
					MyFrame.SwingPopup("Loan submitted, book due for return on " +dt.toLocaleString().substring(0,11) );
					
					
					String Available="No";
					stmt = con.createStatement();
					
					int updateBookAvailable = stmt.executeUpdate("UPDATE Book SET Available='"+Available+"' WHERE LibCode ="
							+ LibCode + "");
					
					if(updateBookAvailable > 0)
					{
							System.out.println("Libcode: " +LibCode+ " set to unavailable");
					}
					
					else
					{				
						MyFrame.SwingPopup("LibCode: " +LibCode+" was not found in the database");
						System.out.println("Book not found, cant set it to unavailable");
					}
				}
				
				catch (SQLException e)
				{
					MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
					System.out.println("SQL exception occured " + e);
				}		
			}
		}	
	}
	
	public static void returnBook(ReturnPage returnPage)
	{		
		String LibCode = returnPage.getJTFlibCode().getText();
		int libCode = Integer.valueOf(LibCode);
		
		if(MyFrame.TestForNumericValue(LibCode,"NUMERICINSERTCHECK"))
		{
			no_of_rows = 0;
			Statement stmt; 
			try
			{											
				String Available="Yes";
				stmt = con.createStatement();
				
				int updateBookAvailable = stmt.executeUpdate("UPDATE Book SET Available='"+Available+"' WHERE LibCode ="
						+ LibCode + "");
				
				if(updateBookAvailable > 0)
				{
						System.out.println("Libcode: " +LibCode+ " set to available");
				}
				
				else
				{				
					MyFrame.SwingPopup("LibCode: " +LibCode+" was not found in the database");
					System.out.println("Book not found, cant set it available");
				}
				

				int loanID=-1;
				int customerID=-1;
				ResultSet rs = stmt.executeQuery("select loanid,customerid from loan where libcode = "+LibCode+" AND datereturned is null");

				
				if(!rs.next())
				{			
					MyFrame.SwingPopup("The Loan was not found in the database, are you sure the book is on loan?");
					System.out.println("Loan not found, can't return");
				}
				
				else
				{
					loanID=rs.getInt(1);
					customerID=rs.getInt(2);
					System.out.println("Customerid is: " + customerID);	
					//MyFrame.SwingPopup("Customerid is: "+customerID);
					System.out.println("Loanid=" + loanID);	
					//MyFrame.SwingPopup("The loan id is: "+loanID);
				}
				
				
				int daysOverDue=-1;			
				rs = stmt.executeQuery("select floor(sysdate - duedate) from loan where libcode = "+libCode+"");
				
				if(!rs.next())
				{			
					//MyFrame.SwingPopup("Error on getting days overdue");
					System.out.println("Error on getting days overdue");
				}
				
				else
				{
					daysOverDue=rs.getInt(1);
					System.out.println("LoanID: "+loanID +" is "+ daysOverDue+" daysOverDue");	
				    //MyFrame.SwingPopup("LoanID: "+loanID +" is "+ daysOverDue+" daysOverDue");
				}
				
				
				if(daysOverDue > 0)
				{
					double charge = daysOverDue*2.50;
					int balanceUpdated = stmt.executeUpdate("UPDATE CUSTOMER SET balance = (balance - "+charge+") where customerid = "+customerID);
					
					if(balanceUpdated > 0)
					{			
						System.out.println("User has been charged: €"+charge+"0 as book was returned "+daysOverDue+" days overdue");
						MyFrame.SwingPopup("User has been charged: €"+charge+"0 as book was returned "+daysOverDue+" days overdue");
					}
				}			
				
				if(updateBookAvailable>0)
				{
					int updateReturnDate = stmt.executeUpdate("UPDATE LOAN SET datereturned = sysdate where libcode = "+LibCode+" AND datereturned is null");
		
					if(updateReturnDate > 0)
					{			
						System.out.println("New return Date set for book: "+LibCode);
						MyFrame.SwingPopup("Book has been succesfully returned");
					}
				}
			}
				
			catch (SQLException e)
			{
				MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
				System.out.println("SQL exception occured " + e);
			}		
		}
	}
	
	public static boolean BookAvailable(int libCode)
	{	
		boolean BookAvailable = false;
		
		System.out.println("In Book available");
		
		try
		{
			System.out.println("In try in Book available");		
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select available from book where libcode = "+libCode);
			
			if(!rs.next())
			{
				System.out.println("No rows found");
				MyFrame.SwingPopup("Book not found in database");
			}
					
			else
			{ 		
				System.out.println("In else in Book available");
					
				String temp = rs.getString(1);
					
				if(temp.equals("Yes"))
				{
					System.out.println("book found and is available");
					BookAvailable = true;
				}
					
				else
				{
					System.out.println("book found and is not available");
					MyFrame.SwingPopup("That book is already marked as being out on loan?\n Maybe update its status to available: \"yes\" on the Manage Book screen");
				}
					
				System.out.println("LibCode: "+libCode+" has available status: " +BookAvailable);
			}	
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}
		
		return BookAvailable;	
	}
	
	
	public static boolean checkCustomerExists(int customerID)
	{	
		boolean customerFound = false;
		
		System.out.println("in customer");
		
		try
		{	
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select customerid from customer where customerid = "+customerID);
			
			if(!rs.next())
			{
				System.out.println("customer not found, no loan for you");
				MyFrame.SwingPopup("That customerid was not found in the database");
			}
					
			else
			{ 		
				System.out.println("Customerid: "+customerID+" exists you can insert loan");
				customerFound=true;
			}	
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}
		
		return customerFound;	
	}

	public static void DisplayOverDueBookInfoReturnPage(ReturnPage returnPage)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();		
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select loanid, libcode, Title, Name, loandate, floor(sysdate - duedate ) from loan join customer using (customerid) join book using (libcode) where datereturned is null AND duedate < sysdate");
			
			if(!rs.next())
			{
				System.out.println("No rows found");
				MyFrame.SwingPopup("No books overdue have been found in the database" );
			}
					
			else
			{
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 6; i++) 
					{		    	
						newRow.addElement(rs.getObject(i));	
					}
				
					System.out.println("Row added to Vector");
					
					rows.add(newRow);
				}
				
				while(rs.next());		
			}
			
			System.out.println("Searched for overdue books");
			returnPage.getTableModel().setDataVector(rows, returnPage.getHeader()); 
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}		
	}
	
	static String checkLogin(String userID, String password)
	{
		ResultSet rs;
		
		String userAccessLevel="";				
		try
		{
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select accesslevel from users where userid = '"+userID+"' AND password = '"+password+"'");
			
			if(!rs.next())
			{			
				System.out.println("The Username and Password combination you entered is incorrect");
				MyFrame.SwingPopup("The Username and Password combination you entered is incorrect");
			}
			
			else
			{
				userAccessLevel=rs.getString(1);	
				System.out.println("AccessLevel is: "+userAccessLevel);
				MyFrame.SwingPopup("You have been succesfully logged in your AccessLevel is: "+userAccessLevel);
			}
			
		} 
		
		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}	
		
		return userAccessLevel;
	}
	
	
	public static void SearchBookByBookID(BookPage bookPage)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			int BOOKID = Integer.valueOf(bookPage.getJTFbookName().getText());
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select Book.libcode, book.title, Customer.customerid, Users.userid, loan.loandate, loan.datereturned, book.Available from customer, users, loan, book where book.libcode = loan.libcode and customer.customerid = loan.customerid and users.userid = loan.userid and book.libcode =" + BOOKID);
			
			if (!rs.next() ) 
			{
			    System.out.println("no data found");
			    MyFrame.SwingPopup("BOOKID ID: "+ BOOKID + " not found in database" );
			}
			
			else
			{		
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 7; i++) 
					{		    	
						if(i == 5||i==6)
						{
							String temp= rs.getString(i);
							
							if(temp==null)
							{
								temp="";
							}
							
							else
							{						
								temp = temp.substring(0,10);
							}
							
							newRow.addElement(temp);
						}
						
						else
						{
							newRow.addElement(rs.getObject(i));
						}
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while (rs.next());
			
				System.out.println("Searched by BOOKID ID " + BOOKID);
				bookPage.getTableModel().setDataVector(rows, bookPage.getHeader()); 
			}	
		}
		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}		
	}
	
	
	public static void  SearchBookByTitle(BookPage bookPage)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			String title = TitleCaseConverter.toTitleCase(bookPage.getJTFbookName().getText());
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt
					.executeQuery("select Book.libcode, book.title, Customer.customerid, Users.userid, loandate, datereturned, Available from customer, users, loan, book where book.libcode = loan.libcode and customer.customerid = loan.customerid and users.userid = loan.userid and book.title LIKE '%"+title+"%'");

			
			if (!rs.next() ) 
			{
			    System.out.println("no data found");
			    MyFrame.SwingPopup("Title: "+ title + " not found in database" );
			}
			
			else
			{		
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 7; i++) 
					{
						if(i == 5||i==6)
						{
							String temp= rs.getString(i);
							
							if(temp==null)
							{
								temp="";
							}
							
							else
							{							
								temp = temp.substring(0,10);					
							}
							
							newRow.addElement(temp);
						}
						
						else
						{
							newRow.addElement(rs.getObject(i));
						}
						
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while (rs.next());
			
				bookPage.getTableModel().setDataVector(rows, bookPage.getHeader()); 
			}	
		}
		
		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}		
	}
	
	public static void  SearchCustomerByCustomerName(CustomerPage customerPage)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			String Customername = TitleCaseConverter.toTitleCase(customerPage.getJTFbookName().getText());
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select Customer.name, book.title, loan.loandate, loan.duedate, loan.datereturned from Customer, book, loan where book.libcode = loan.libcode and customer.customerid = loan.customerid and customer.name LIKE '%"+Customername+"%'");
			
			if (!rs.next() ) 
			{
			    System.out.println("no data found");
			    MyFrame.SwingPopup("Customer Name: "+ Customername + " not found in database" );
			}
			
			else
			{		
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 5; i++) 
					{		    	
						if(i > 2)
						{
							String temp= rs.getString(i);
							
							if(temp==null)
							{
								temp="";
							}
							
							else
							{							
								temp = temp.substring(0,10);
							}
							
							newRow.addElement(temp);
						}
						
						else
						{
							newRow.addElement(rs.getObject(i));
						}
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while (rs.next());
			
				customerPage.getTableModel().setDataVector(rows, customerPage.getHeader()); 
			}	
		}
		
		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}		
	}
	
	
	public static void SearchlibrarianActivityByUserID(LibrarianActivity librarianActivity)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			int STAFFID = Integer.valueOf(librarianActivity.getJTFbookName().getText());
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select users.userid, users.Name, loan.loandate, loan.loanid, book.libcode, book.title, Customer.Customerid from users, book, loan, customer where users.userid = loan.userid and customer.customerid = loan.customerid and book.libcode = loan.libcode and users.userid=" + STAFFID);
			
			if (!rs.next() ) 
			{
			    System.out.println("no data found");
			    MyFrame.SwingPopup("Staff ID: "+ STAFFID + " not found in database" );
			}
			
			else
			{		
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 7; i++) 
					{		    	
						if(i ==3 )
						{
							String temp= rs.getString(i);
							
							if(temp==null)
							{
								temp="";
							}
							
							else
							{
								temp = temp.substring(0,10);
							}
							
							newRow.addElement(temp);
						}
						
						else
						{
							newRow.addElement(rs.getObject(i));
						}
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while (rs.next());
			
				System.out.println("Searched by CUSTOMER ID " + STAFFID);
				librarianActivity.getTableModel().setDataVector(rows, librarianActivity.getHeader()); 
			}	
		}
		
		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}		
	}
	
	public static void SearchlibrarianActivityByUserName(LibrarianActivity librarianActivity)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			String Username = TitleCaseConverter.toTitleCase(librarianActivity.getJTFbookName().getText());
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select users.userid, users.Name, loan.loandate, loan.loanid, book.libcode, book.title, Customer.Customerid from users, book, loan, customer where users.userid = loan.userid and customer.customerid = loan.customerid and book.libcode = loan.libcode and users.name LIKE '%"+Username+"%'");
			
			if (!rs.next() ) 
			{
			    System.out.println("no data found");
			    MyFrame.SwingPopup("User name: "+ Username + " not found in database" );
			}
			
			else
			{		
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 7; i++) 
					{		    	
						if(i ==3 )
						{
							String temp= rs.getString(i);
							
							if(temp==null)
							{
								temp="";
							}
							
							else
							{
								temp = temp.substring(0,10);
							}
							
							newRow.addElement(temp);
						}
						
						else
						{
							newRow.addElement(rs.getObject(i));
						}
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while (rs.next());
			
				librarianActivity.getTableModel().setDataVector(rows, librarianActivity.getHeader()); 
			}	
		}
		
		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}		
	}
	
	
	public static void SearchCustomerByCustomerID(CustomerPage customerPage)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			int CUSTOMERID = Integer.valueOf(customerPage.getJTFbookName().getText());
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select Customer.name, book.title, loan.loandate, loan.duedate, loan.datereturned from Customer, book, loan where book.libcode = loan.libcode and customer.customerid = loan.customerid and customer.customerid =" + CUSTOMERID);
			
			if (!rs.next() ) 
			{
			    System.out.println("no data found");
			    MyFrame.SwingPopup("CUSTOMER ID: "+ CUSTOMERID + " not found in database" );
			}
			
			else
			{		
				do
				{
					Vector <Object> newRow = new Vector<Object>();
				
					for (int i = 1; i <= 5; i++) 
					{		    	
						if(i > 2 )
						{
							String temp= rs.getString(i);
							System.out.println("temp: "+temp);
							
							if(temp==null)
							{
								temp="";
							}
							
							else
							{						
								temp = temp.substring(0,10);
							}
							newRow.addElement(temp);
						}
						
						else
						{
							newRow.addElement(rs.getObject(i));
						}
					}
				
					System.out.println("Row added to Vector");
					rows.add(newRow);
				}
				
				while (rs.next());
			
				System.out.println("Searched by CUSTOMER ID " + CUSTOMERID);
				customerPage.getTableModel().setDataVector(rows, customerPage.getHeader()); 
			}	
		}
		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			MyFrame.SwingPopup("Contact system administrator: SQL exception occured" + e);
		}		
	}
}
