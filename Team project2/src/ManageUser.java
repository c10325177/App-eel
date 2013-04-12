import javax.swing.*;

import java.awt.*;

public class ManageUser extends JPanel
{
	private static final long serialVersionUID = 1L;

	private ImageIcon homeIcon = new ImageIcon("Images/home.png");

	private JLabel title = new JLabel(new ImageIcon("Images/dit_banner.png"));
	private JLabel logoDIT = new JLabel(new ImageIcon("Images/properLogo.png"));
	private JLabel booksLogo = new JLabel(new ImageIcon("Images/library_book.png"));
	private JLabel logoAppEel = new JLabel(new ImageIcon("Images/copyright.png"));
	private JLabel userID = new JLabel("User ID: ");

	private JLabel user_ID = new JLabel("USER ID");
	private JLabel name = new JLabel("NAME");
	private JLabel accessLevel = new JLabel("ACCESS LEVEL");
	private JLabel password = new JLabel("PASSWORD");
	private JLabel confirmPassword = new JLabel("CONFIRM PASSWORD");

	private JTextField JTFuserID = new JTextField(10);
	private JTextField JTFname = new JTextField(10);
	private JPasswordField JPFpassword = new JPasswordField(10);
	private JPasswordField JPFconfirmPassword = new JPasswordField(10);
	private JTextField JTFsearch = new JTextField(10);

	private JButton addUser = new JButton("       Add User        ");
	private JButton updateUser = new JButton("       Update User   ");
	private JButton discardChanges = new JButton("Discard Changes ");
	private JButton deleteUser = new JButton("     Delete User      ");
	private JButton search = new JButton("Search ");
	private JButton home = new JButton("      Home     ", homeIcon);

	private Color background = new Color(152, 178, 255);

	// JTexfield where it displayed the user ID
	private JTextField ID = new JTextField(5);

	private String[] itemBox = { "User ID", "Name", "Access Level" };
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox combo = new JComboBox(itemBox);

	private String[] accessLevelItemBox = { "Librarian", "Admin" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox accessLevelCombo = new JComboBox(accessLevelItemBox);	

	private String[] header = { "User ID", "Name", "Access Level" };
	private Object data[][] = new Object[][] { { "dfhdfh", "fdh", "fdh" },
			{ "dfhdfh", "fdh", "fdh" }, { "dfhdfh", "fdh", "fdh" },
			{ "dfhdfh", "fdh", "fdh" }, { "dfhdfh", "fdh", "fdh" },
			{ "dfhdfh", "fdh", "fdh" }, { "dfhdfh", "fdh", "fdh" } };
	private JTable table = new JTable(data, header);

	public ManageUser()
	{

		this.setBackground(background);
		GridBagConstraints gbcMain = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.home.setForeground(Color.red);
		userID.setFont(new Font("Serif", Font.BOLD, 12));
		name.setFont(new Font("Serif", Font.BOLD, 12));
		accessLevel.setFont(new Font("Serif", Font.BOLD, 12));
		password.setFont(new Font("Serif", Font.BOLD, 12));
		accessLevelCombo.setPreferredSize(new Dimension(115, 20));

		// put and set an Icon on the different button
		home.setVerticalTextPosition(AbstractButton.BOTTOM);
		home.setHorizontalTextPosition(AbstractButton.CENTER);
		home.setBorderPainted(false);
		home.setContentAreaFilled(false);

		// BACKGROUND
		gbcMain.insets = new Insets(0, 0, 100, 20);
		gbcMain.anchor = GridBagConstraints.FIRST_LINE_START;
		gbcMain.weightx = 1;
		gbcMain.weighty = 1;
		this.add(logoDIT, gbcMain);

		gbcMain.anchor = GridBagConstraints.PAGE_START;
		gbcMain.ipady = 150;
		this.add(title, gbcMain);

		gbcMain.ipady = 0;
		gbcMain.anchor = GridBagConstraints.FIRST_LINE_END;
		this.add(booksLogo, gbcMain);

		gbcMain.insets = new Insets(0, -300, 0, -270);
		gbcMain.gridx = 1;
		gbcMain.gridy = 0;
		gbcMain.anchor = GridBagConstraints.SOUTH;
		this.add(logoAppEel, gbcMain);

		// JLabel
		gbcMain.anchor = GridBagConstraints.CENTER;
		gbcMain.insets = new Insets(0, -800, 240, 0);
		gbcMain.gridwidth = 1;
		this.add(home, gbcMain);

		gbcMain.insets = new Insets(0, -370, -100, 0);
		gbcMain.gridwidth = 1;
		this.add(user_ID, gbcMain);

		gbcMain.insets = new Insets(0, -380, -160, 0);
		gbcMain.gridwidth = 1;
		this.add(name, gbcMain);

		gbcMain.insets = new Insets(0, -330, -220, 0);
		gbcMain.gridwidth = 1;
		this.add(accessLevel, gbcMain);

		gbcMain.insets = new Insets(0, -345, -280, 0);
		gbcMain.gridwidth = 1;
		this.add(password, gbcMain);

		gbcMain.insets = new Insets(0, -290, -340, 0);
		gbcMain.gridwidth = 1;
		this.add(confirmPassword, gbcMain);

		// JtextField
		gbcMain.insets = new Insets(0, 0, -100, 0);
		gbcMain.gridwidth = 1;
		this.add(JTFuserID, gbcMain);

		gbcMain.insets = new Insets(0, 0, -160, 0);
		gbcMain.gridwidth = 1;
		this.add(JTFname, gbcMain);

		gbcMain.insets = new Insets(0, 0, -220, 0);
		gbcMain.gridwidth = 1;
		this.add(accessLevelCombo, gbcMain);

		gbcMain.insets = new Insets(0, 0, -280, 0);
		gbcMain.gridwidth = 1;
		this.add(JPFpassword, gbcMain);

		gbcMain.insets = new Insets(0, 0, -340, 0);
		gbcMain.gridwidth = 1;
		this.add(JPFconfirmPassword, gbcMain);

		// JButton
		gbcMain.insets = new Insets(0, -300, -440, 0);
		gbcMain.gridwidth = 1;
		this.add(addUser, gbcMain);

		gbcMain.insets = new Insets(0, 20, -440, 0);
		gbcMain.gridwidth = 1;
		this.add(updateUser, gbcMain);

		gbcMain.insets = new Insets(0, -300, -510, 0);
		gbcMain.gridwidth = 1;
		this.add(discardChanges, gbcMain);

		gbcMain.insets = new Insets(0, 20, -510, 0);
		gbcMain.gridwidth = 1;
		this.add(deleteUser, gbcMain);

		// JTable
		JScrollPane pane = new JScrollPane(table,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		gbcMain.insets = new Insets(0, -80, 290, 0);
		gbcMain.ipady = -300;
		this.add(pane, gbcMain);

		// JcomboBox
		gbcMain.insets = new Insets(0, 20, 60, 380);
		gbcMain.ipady = 0;
		this.add(combo, gbcMain);

		// Jtextfield search
		gbcMain.insets = new Insets(0, 20, 60, 70);
		this.add(JTFsearch, gbcMain);

		// JButton search
		gbcMain.insets = new Insets(0, 20, 60, -160);
		this.add(search, gbcMain);

		// User ID stuff
		gbcMain.insets = new Insets(0, 0, 300, -680);
		gbcMain.gridwidth = 1;
		this.add(userID, gbcMain);

		gbcMain.insets = new Insets(0, 0, 300, -790);
		gbcMain.gridwidth = 1;
		this.add(ID, gbcMain);

	}

	@SuppressWarnings("rawtypes")
	public JComboBox getSearchType()
	{
		return (this.combo);
	}

	public JButton getHome()
	{
		return (this.home);
	}

	public JTextField getname()
	{
		return (this.JTFname);
	}

	public JTextField getuserID()
	{
		return (this.JTFuserID);
	}

	public JPasswordField getPassword()
	{
		return (this.JPFpassword);
	}

	public JPasswordField getConfirmPassword()
	{
		return (this.JPFconfirmPassword);
	}

	public JTextField getSearchJTF()
	{
		return (this.JTFsearch);
	}

	public JButton getInsert()
	{
		return (this.addUser);
	}

	public JButton getDelete()
	{
		return (this.deleteUser);
	}

	public JButton getDiscard()
	{
		return (this.discardChanges);
	}

	public JButton getUpdate()
	{
		return (this.updateUser);
	}

	public JButton getSearch()
	{
		return (this.search);
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getAccessLevel()
	{
		return (this.accessLevelCombo);
	}

	public int getRowCount()
	{
		return data.length;
	}

	public int getColumnCount()
	{
		return header.length;
	}

	public String getColumnName(int columnIndex)
	{
		return header[columnIndex];
	}

	public Object getValueAt(int rowIndex, int columnIndex)
	{
		return data[rowIndex][columnIndex];
	}

	public JTextField getUserID()
	{
		return (this.ID);
	}
	
	public void EmptyFields()
	{
		JTFuserID.setText("");
		JTFname.setText("");
		JPFpassword.setText("");
		JPFconfirmPassword.setText("");
		accessLevelCombo.setSelectedItem("User");
	}
}
