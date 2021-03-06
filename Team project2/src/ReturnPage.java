import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.Vector;

public class ReturnPage extends JPanel
{
	private static final long serialVersionUID = 1L;

	private ImageIcon homeIcon = new ImageIcon("Images/home.png");

	private JLabel title = new JLabel(new ImageIcon("Images/dit_banner.png"));
	private JLabel logoDIT = new JLabel(new ImageIcon("Images/properLogo.png"));
	private JLabel booksLogo = new JLabel(new ImageIcon("Images/library_book.png"));
	private JLabel logoAppEel = new JLabel(new ImageIcon("Images/copyright.png"));
	private JLabel userID = new JLabel("User ID: ");
	private JLabel name = new JLabel("Kevin Street Library");
	private JButton home = new JButton("      Home     ", homeIcon);

	private JLabel libCode = new JLabel("Lib Code");	
	private JTextField JTFlibCode = new JTextField(20);

	public JTextField getJTFlibCode()
	{
		return JTFlibCode;
	}

	JButton submitReturn = new JButton("Submit Return");	
	JButton displayOverDueBooks = new JButton("Display Overdue Books");

	private JLabel returnBook = new JLabel("Enter/Scan Lib Code below to return a book:");

	private Color background = new Color(152, 178, 255);

	// JTexfield where it displayed the user ID
	private JTextField ID = new JTextField(5);
	
	private Vector <String> header = new Vector<String>();       
	private DefaultTableModel tableModel = new DefaultTableModel() ;
	private JTable table = new JTable(tableModel);	


	public ReturnPage()
	{
		header.add("Loan ID");
		header.add("Lib code");
		header.add("Book Title");
		header.add("Customer Name");	
		header.add("Loan Date");
		header.add("Days over Due");
		tableModel.setColumnIdentifiers(header);
		
		JScrollPane pane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		table.setEnabled(false);


		this.setBackground(background);
		GridBagConstraints gbcMain = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.home.setForeground(Color.red);
		name.setFont(new Font("Serif", Font.BOLD, 28));
		returnBook.setForeground(Color.RED);
		returnBook.setFont(new Font("Serif", Font.BOLD, 28));

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
		gbcMain.insets = new Insets(0, -800, 190, 0);
		gbcMain.gridwidth = 1;
		this.add(home, gbcMain);
		
		gbcMain.insets = new Insets(0, 0, 290, -0);
		gbcMain.gridwidth = 1;
		this.add(name, gbcMain);
	

		// User ID stuff
		gbcMain.insets = new Insets(0, 0, 250, -680);
		gbcMain.gridwidth = 1;
		this.add(userID, gbcMain);

		gbcMain.insets = new Insets(0, 0, 250, -790);
		gbcMain.gridwidth = 1;
		this.add(ID, gbcMain);
		
		//JLabel
		
		gbcMain.anchor = GridBagConstraints.CENTER;
		gbcMain.insets = new Insets(0, 15, -200, 0);
		gbcMain.gridwidth = 1;
		this.add(returnBook, gbcMain);
		
		//JBUTTONS	
		gbcMain.anchor = GridBagConstraints.CENTER;
		gbcMain.insets = new Insets(0, -355, -280, 0);;
		gbcMain.gridwidth = 1;
		this.add(libCode, gbcMain);
		
		//JTFS
		gbcMain.insets = new Insets(0, 0, -280, 0);
		gbcMain.gridwidth = 1;
		this.add(JTFlibCode, gbcMain);
			
		//submit return
		gbcMain.insets = new Insets(0, 0, -280, -400);
		gbcMain.gridwidth = 1;
		this.add(submitReturn, gbcMain);
		
		//gbcMain.ipady = 0;
		gbcMain.insets = new Insets(0, 0, -50, 0);
		gbcMain.gridwidth = 1;
		this.add(displayOverDueBooks, gbcMain);

		//add table	
		gbcMain.insets = new Insets(0, 20, 120, 0);
		gbcMain.ipady = -300;
		this.add(pane, gbcMain);

	}

	public JButton getHome()
	{
		return (this.home);
	}

	public JTextField getUserID()
	{
		return (this.ID);
	}
	
	public JButton getSubmitReturn()
	{
		return submitReturn;
	}

	public DefaultTableModel getTableModel()
	{
		return (this.tableModel);
	}

	public Vector<String> getHeader()
	{
		return(this.header);
	}
	
	public JButton getDisplayOverDueBooks()
	{
		return displayOverDueBooks;
	}
	
	public void emptyTable()
	{
		tableModel.setRowCount(0);
	}
	
	public JTable getTable()
	{
		return (this.table);
	}
	
	public void emptyFields()
	{
		JTFlibCode.setText("");
	}
}
