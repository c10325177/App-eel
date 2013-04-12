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
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@ferdia:1521:ora11gdb", "team_appeel",
				"bglammmd");

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}

		catch (ClassNotFoundException e)
		{
			System.out.println("Class not found " + e);
		}
		System.out.println("Class found ");
	}
	
	

	public static void InsertCustomer(String Name, String Address, Double Balance)
	{
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

	public static void UpdateCustomer(int CustomerID, String Name,
			String Address, Double Balance)
	{
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
		no_of_rows = 0;
		LibCode = 25;

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

	public static void InsertUser(String name, String accessLevel,
			String password)
	{
		no_of_rows = 0;

		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("INSERT INTO Users(Userid, Name, Accesslevel, password) " 
							+ "values (USERID.nextVal,'"
							+ name
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
	}

	public static void DeleteUser(int UserID)
	{
		no_of_rows = 0;
		try
		{
			Statement stmt = con.createStatement();
			int deletedRows = stmt
					.executeUpdate("DELETE FROM Users WHERE UserId = '"
							+ UserID + "'");
			System.out.println("Rows Deleted: " + deletedRows);
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
		no_of_rows = 0;

		try
		{
			Statement stmt = con.createStatement();
			int updateRow = stmt.executeUpdate("UPDATE Users SET Userid="
					+ userID + ", Name='" + name + "', Accesslevel='"
					+ accessLevel + "', password='" + password
					+ "' WHERE UserID = '" + userID + "'");
			System.out.println("Rows Updated: " + updateRow);
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
		}
	}
	
	
	public static void SearchUserByID(int USERID)
	{
		no_of_rows = 0;

		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM Users where Userid = "+USERID);
			while (rs.next())
			{
				no_of_rows++;
			}
			System.out.println("Searched by userid " + USERID);
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
		}
	}
		
	public static void SearchUserByName(String Name)
	{
		no_of_rows = 0;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM Users WHERE Name LIKE '%"+Name+"%'");
			while (rs.next())
			{
				String userName = rs.getString("Name");
				System.out.println(userName);
			}
			System.out.println("Searched by Name " + Name);
			
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
		}
	}
	
	
		
	
	public static void SearchUserByAccessLevel(String AccessLevel)
	{
		no_of_rows = 0;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM Users WHERE AccessLevel LIKE '%"+AccessLevel+"%'");
			while (rs.next())
			{
				String userName = rs.getString("Name");
				System.out.println(userName);
			}
			System.out.println("Searched by AccessLevel " + AccessLevel);
			
		}

		catch (SQLException e)
		{
			System.out.println("SQL exception occured" + e);
		}
	}
}
