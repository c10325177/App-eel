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
	
	

	public static void InsertCustomer(String Name, String Address, Double Balance)
	{
		Name=TitleCaseConverter.toTitleCase(Name);
		Address=TitleCaseConverter.toTitleCase(Address);
		no_of_rows = 0;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("INSERT INTO Customer(CustomerId, Name, Address, Balance) "
							+ "values (CUSTID.nextVal,'"
							+ Name
							+ "', '"
							+ Address
							+ "' , " + Balance + ")");
			while (rs.next())
			{
				no_of_rows++;
			}
			System.out.println("There are " + no_of_rows
					+ " record in the table");
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
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);

		}
	}

	public static void DeleteCustomer(int CustomerID)
	{
		no_of_rows = 0;
		try
		{
			Statement stmt = con.createStatement();
			int deletedRows = stmt
					.executeUpdate("DELETE FROM Customer WHERE CustomerId = '"
							+ CustomerID + "'");
			System.out.println("Rows Deleted: " + deletedRows);
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			System.out.println("Delete statement excuted");
		}
	}

	public static void UpdateBook(int LibCode, String ISBN, String title,
			String Author, String Genre, String Location, String Available)
	{
		ISBN=TitleCaseConverter.toTitleCase(ISBN);
		title=TitleCaseConverter.toTitleCase(title);
		Author=TitleCaseConverter.toTitleCase(Author);
		Genre=TitleCaseConverter.toTitleCase(Genre);
		Location=TitleCaseConverter.toTitleCase(Location);
		Available=TitleCaseConverter.toTitleCase(Available);
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
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
		}
	}

	public static void InsertBook(String ISBN, String title, String Author,
			String Genre, String Location, String Available)
	{
		ISBN=TitleCaseConverter.toTitleCase(ISBN);
		title=TitleCaseConverter.toTitleCase(title);
		Author=TitleCaseConverter.toTitleCase(Author);
		Genre=TitleCaseConverter.toTitleCase(Genre);
		Location=TitleCaseConverter.toTitleCase(Location);
		Available=TitleCaseConverter.toTitleCase(Available);
		no_of_rows = 0;

		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("INSERT INTO Book(Libcode, ISBN, Title, Author, Genre, Location, Available) "
							+ "values (LIBCODE.nextVal,'"
							+ ISBN
							+ "','"
							+ title
							+ "','"
							+ Author
							+ "','"
							+ Genre
							+ "','"
							+ Location + "','" + Available + "')");
			while (rs.next())
			{
				no_of_rows++;
			}
			System.out.println("There are " + no_of_rows
					+ " record in the table");
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
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
			System.out.println("Rows Deleted: " + deletedRows);
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
			System.out.println("Delete statement excuted");
		}
	}

	public static void InsertUser(String Name, String accessLevel, String password)
	{
		System.out.println("Access Level Value:"
				+ accessLevel);
		
		no_of_rows = 0;
		Name=TitleCaseConverter.toTitleCase(Name);
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
			while (rs.next())
			{
				no_of_rows++;
			}
			System.out.println("There are " + no_of_rows
					+ " record in the table");
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
			
			MyFrame.SwingPopup("New user: "
					+ Name
					+ " has been added to database and allocated user id: "
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
			System.out.println("Rows Updated: " + updateRow);
			MyFrame.SwingPopup("User: " +name +" succesfully updated");
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
				manageUser.getTable().setModel(manageUser.getTableModel());	
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
			manageUser.getTable().setModel(manageUser.getTableModel());
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
			manageUser.getTable().setModel(manageUser.getTableModel());
			
		}
		
		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
		}
	}
}
