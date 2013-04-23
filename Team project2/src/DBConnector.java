import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DBConnector
{

	static Connection con;
	static int no_of_rows = 0;
	
	public static void DBConnect() throws SQLException
	{
		/*
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@ferdia:1521:ora11gdb", "team_appeel",
				"bglammmd");
		*/
		
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "baz",
				"bglammmd");

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}

		catch (ClassNotFoundException e)
		{
			System.out.println("Oracle Server not found " + e);
		}
		System.out.println("Oracle Server Connected");
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
							+ "'," + Balance + ")");
			
		}

		catch (SQLException e)
		{
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
					.executeUpdate("DELETE FROM Customer WHERE CustomerId = '"
							+ CustomerID + "'");
			System.out.println("Rows Deleted: " + deletedRows);
			
			if(deletedRows > 0)
			{
				System.out.println("Rows Deleted: " + deletedRows);
				MyFrame.SwingPopup("Customer: \""+Name+ "\" with CustomerID: " +CustomerID +" succesfully deleted");
			}
		}

		catch (SQLException e)
		{
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
							+ "','" + Author + "','" + Genre + "','" + Location + "','" + Available + "')");
		}
		
		catch (SQLException e)
		{
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void DeleteBook(int LibCode)
	{
		no_of_rows = 0;
		try
		{
			Statement stmt = con.createStatement();
			int deletedRows = stmt
					.executeUpdate("DELETE FROM Book WHERE LibCode = '"
							+ LibCode + "'");
			
			if(deletedRows > 0)
			{
				System.out.println("Rows Updated: " + deletedRows);
				MyFrame.SwingPopup("Libcode: " +LibCode +" succesfully deleted");
			}
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			System.out.println("Delete statement excuted");
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
					.executeQuery("INSERT INTO Users(Userid, Name, Accesslevel, password) " 
							+ "values (USERID.nextVal,'"
							+ Name
							+ "', '"
							+ accessLevel
							+ "','" + password + "')");
			
		}
		
		catch (SQLException e)
		{
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void DeleteUser(ManageUser manageUser)
	{
		try
		{
			int USERID = Integer.valueOf(manageUser.getuserID().getText());
			
			Statement stmt = con.createStatement();
			int rowsDeleted = stmt
					.executeUpdate("DELETE FROM Users WHERE UserId = '"
							+ USERID + "'");
			System.out.println("Rows Deleted: " + rowsDeleted);
			
			System.out.println("UID Deleted: "
					+ USERID);
		
			if(rowsDeleted > 0)
			{			
				MyFrame.SwingPopup("User: "
						+ manageUser.getname().getText() +" with User ID: " + manageUser.getuserID().getText()
						+ " has been deleted from the database");
			}
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			System.out.println("Delete statement excuted");
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
					.executeQuery("SELECT * FROM Users where Userid = "+USERID);
			
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
		}
	}
		
	public static void SearchUserByName(ManageUser manageUser)
	{		      				
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			String Name = TitleCaseConverter.toTitleCase(manageUser.getSearchJTF().getText().toString());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE Name LIKE '%"+Name+"%' ORDER BY UserID");
			
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
					.executeQuery("SELECT * FROM Users WHERE AccessLevel LIKE '%"+AccessLevel+"%' ORDER BY UserID");
					
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
		}
	}



	public static void SearchCustomerByName(ManageCustomer manageCustomer)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			String Name = TitleCaseConverter.toTitleCase(manageCustomer.getSearchJTF().getText().toString());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Customer WHERE Name LIKE '%"+Name+"%' ORDER BY Customerid");
			
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
					.executeQuery("SELECT * FROM Customer where Customerid = "+CUSTOMERID);
			
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
		}
		
	}

	public static void SearchCustomerByAddress(ManageCustomer manageCustomer)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			String address = TitleCaseConverter.toTitleCase(manageCustomer.getSearchJTF().getText().toString());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Customer WHERE Address LIKE '%"+address+"%' ORDER BY Customerid");
			
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
			ResultSet rs = stmt.executeQuery("SELECT * FROM Book WHERE Title LIKE '%"+title+"%' ORDER BY Title");
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
					.executeQuery("SELECT * FROM Book where Libcode = "+libCode);
			
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
		}
		
	}



	public static void SearchBookByAuthor(ManageBook manageBook)
	{
		try
		{
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			String author = TitleCaseConverter.toTitleCase(manageBook.getSearchJTF().getText().toString());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Book WHERE Author LIKE '%"+author+"%' ORDER BY Author");
			
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
				
					for (int i = 1; i <= 3; i++) 
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
		}		
	}
}
