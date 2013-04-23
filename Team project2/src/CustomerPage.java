import javax.swing.*;

import java.awt.*;

public class CustomerPage extends JPanel
{
	private static final long serialVersionUID = 1L;


	private JLabel title = new JLabel(new ImageIcon("Images/dit_banner.png"));
	private JLabel logoDIT = new JLabel(new ImageIcon("Images/properLogo.png"));
	private JLabel booksLogo = new JLabel(new ImageIcon("Images/library_book.png"));
	private JLabel logoAppEel = new JLabel(new ImageIcon("Images/copyright.png"));
	private JLabel userID = new JLabel("User ID: ");
	private JLabel name = new JLabel("Kevin Street Library");



	private JTextField JTFbookName = new JTextField(10);

	private JButton search = new JButton("Search");
	private JButton print = new JButton("  Print  ");
	private JButton back = new JButton("      Back     ");
	

	private Color background = new Color(152, 178, 255);
	
	private String[] itemBox = { "Customer ID", "Name"};
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox combo = new JComboBox(itemBox);

	// JTexfield where it displayed the user ID
	private JTextField ID = new JTextField(5);

	private String[] header = { "Book name", "Book title", "Date loaned", "Date due", "Return date"};
	private Object data[][] = new Object[][] {
			{ "", "", "", "", ""},};
	private JTable table = new JTable(data, header);

	public CustomerPage()
	{

		this.setBackground(background);
		GridBagConstraints gbcMain = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.back.setForeground(Color.red);
		this.print.setForeground(Color.green);

		name.setFont(new Font("Serif", Font.BOLD, 28));



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
		this.add(back, gbcMain);

		gbcMain.insets = new Insets(0, 0, 340, -0);
		gbcMain.gridwidth = 1;
		this.add(name, gbcMain);

		//JComboBox 
		gbcMain.insets = new Insets(0, 0, -360, 300);
		gbcMain.gridwidth = 1;
		this.add(combo, gbcMain);
		
		// JtextField
		gbcMain.insets = new Insets(0, 0, -360, 0);
		gbcMain.gridwidth = 1;
		this.add(JTFbookName, gbcMain);


		// JButton
		gbcMain.insets = new Insets(0, -0, -360, -300);
		gbcMain.gridwidth = 1;
		this.add(search, gbcMain);



		// User ID stuff
		gbcMain.insets = new Insets(0, 0, 300, -680);
		gbcMain.gridwidth = 1;
		this.add(userID, gbcMain);

		gbcMain.insets = new Insets(0, 0, 300, -790);
		gbcMain.gridwidth = 1;
		this.add(ID, gbcMain);

		// JTable
		JScrollPane pane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		gbcMain.insets = new Insets(0, 40, 0, 0);
		gbcMain.ipady = -140;
		this.add(pane, gbcMain);

	}

	public JButton getBack()
	{
		return (this.back);
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
}
