import javax.swing.*;

import java.awt.*;

public class LibraryReports extends JPanel
{
	private static final long serialVersionUID = 1L;

	private ImageIcon homeIcon = new ImageIcon("Images/home.png");

	private JLabel title = new JLabel(new ImageIcon("Images/dit_banner.png"));
	private JLabel logoDIT = new JLabel(new ImageIcon("Images/properLogo.png"));
	private JLabel booksLogo = new JLabel(new ImageIcon("Images/library_book.png"));
	private JLabel logoAppEel = new JLabel(new ImageIcon("Images/copyright.png"));
	private ImageIcon iBook = new ImageIcon("Images/book.jpg");
	private ImageIcon iCustomer = new ImageIcon("Images/customer.jpg");
	private ImageIcon iLibrarian = new ImageIcon("Images/librarian.jpg");
	private JLabel userID = new JLabel("User ID: ");
	private JLabel name = new JLabel("Kevin Street Library");

	private JButton print = new JButton("  Print  ");
	private JButton home = new JButton("      Home     ", homeIcon);
	private JButton book = new JButton ("Book", iBook);
	private JButton customer = new JButton ("Customer", iCustomer);
	private JButton librarian = new JButton ("Librarian Activity", iLibrarian);
	

	private Color background = new Color(152, 178, 255);

	// JTexfield where it displayed the user ID
	private JTextField ID = new JTextField(5);


	public LibraryReports()
	{

		this.setBackground(background);
		GridBagConstraints gbcMain = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.home.setForeground(Color.red);
		this.print.setForeground(Color.green);
		name.setFont(new Font("Serif", Font.BOLD, 28));

		// put and set an Icon on the different button
		home.setVerticalTextPosition(AbstractButton.BOTTOM);
		home.setHorizontalTextPosition(AbstractButton.CENTER);
		home.setBorderPainted(false);
		home.setContentAreaFilled(false);
		
		book.setVerticalTextPosition(AbstractButton.BOTTOM);
		book.setHorizontalTextPosition(AbstractButton.CENTER);
		book.setBorderPainted(false);
		book.setContentAreaFilled(false);

		customer.setVerticalTextPosition(AbstractButton.BOTTOM);
		customer.setHorizontalTextPosition(AbstractButton.CENTER);
		customer.setBorderPainted(false);
		customer.setContentAreaFilled(false);
		
		librarian.setVerticalTextPosition(AbstractButton.BOTTOM);
		librarian.setHorizontalTextPosition(AbstractButton.CENTER);
		librarian.setBorderPainted(false);
		librarian.setContentAreaFilled(false);
		

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
		
		gbcMain.insets = new Insets(0, 0, 340, -0);
		gbcMain.gridwidth = 1;
		this.add(name, gbcMain);

		// User ID stuff
		gbcMain.insets = new Insets(0, 0, 300, -680);
		gbcMain.gridwidth = 1;
		this.add(userID, gbcMain);

		gbcMain.insets = new Insets(0, 0, 300, -790);
		gbcMain.gridwidth = 1;
		this.add(ID, gbcMain);


		// JButton
		gbcMain.insets = new Insets(0, 0, -100, 0);
		gbcMain.gridwidth = 1;
		gbcMain.gridx= 0;
		this.add(book, gbcMain);

		gbcMain.insets = new Insets(0, -0, -100, 0);
		gbcMain.gridwidth = 1;
		gbcMain.gridx= 1;
		this.add(customer, gbcMain);
		
		gbcMain.insets = new Insets(0, 0, -100, 0);
		gbcMain.gridwidth = 1;
		gbcMain.gridx= 2;
		this.add(librarian, gbcMain);





	}

	public JButton getHome()
	{
		return (this.home);
	}


	public JTextField getUserID()
	{
		return (this.ID);
	}
	public JButton getBook(){
		return(this.book);
	}
	
	public JButton getCustomer(){
		return(this.customer);
	}
	
	public JButton getLibrarian(){
		return(this.librarian);
	}
}
