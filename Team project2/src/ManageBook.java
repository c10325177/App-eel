
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
public class ManageBook extends JPanel{
	private JLabel title = new JLabel(new ImageIcon("dit_banner.png"));
	private JLabel logoDIT = new JLabel(new ImageIcon("properLogo.png"));
	private JLabel booksLogo = new JLabel(new ImageIcon("library_book.png"));
	private JLabel logoAppEel = new JLabel(new ImageIcon("copyright.png"));

	private JLabel bookTitle = new JLabel("BOOK TITLE");
	private JLabel libCode = new JLabel("LIB CODE");
	private JLabel author = new JLabel("AUTHOR");
	private JLabel genre = new JLabel("GENRE");
	private JLabel location = new JLabel("LOCATION");
	private JLabel available = new JLabel("AVAILABLE");
	
	private JTextField JTFbookTitle = new JTextField(10);
	private JTextField JTFlibCode = new JTextField(10);
	private JTextField JTFauthor = new JTextField(10);
	private JTextField JTFgenre = new JTextField(10);
	private JTextField JTFlocation = new JTextField(10);
	private JTextField JTFavailable = new JTextField(10);
	
	private JButton addBook = new JButton("       Add Book       ");
	private JButton updateBook = new JButton("     Update Book     ");
	private JButton discardChanges = new JButton("Discard Changes ");
	private JButton deleteBook = new JButton("     Delete Book      ");
	
	private Color background = new Color(152,178,255);
	private JButton back = new JButton("      Home      ");	
	
	//barry new layout	
	private JButton submitSearch = new JButton("      Search      ");
	private JTextField searchText = new JTextField(10);
	String[] items = {"Book Title","Lib Code","Author","Genre","Location","Available"};
	private JComboBox searchType = new JComboBox(items);
		
	//Results stuff
    DefaultTableModel model = new DefaultTableModel(10,6);
    private JTable searchResults = new JTable(model);
    JScrollPane searchResultsPane = new JScrollPane(searchResults);   
	
	public ManageBook(){
		
		this.setBackground(background);
		GridBagConstraints gbcMain = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.back.setForeground(Color.red);
		this.bookTitle.setFont(new Font("Serif", Font.BOLD, 12));
		libCode.setFont(new Font("Serif", Font.BOLD, 12));
		author.setFont(new Font("Serif", Font.BOLD, 12));
		genre.setFont(new Font("Serif", Font.BOLD, 12));
		location.setFont(new Font("Serif", Font.BOLD, 12));
		available.setFont(new Font("Serif", Font.BOLD, 12));
		
		//Results table stuff
		model.setColumnIdentifiers(items);
		Dimension d = searchResults.getPreferredSize();
		searchResultsPane.setPreferredSize(
		    new Dimension(d.width,searchResults.getRowHeight()*10+1));
		
		//BACKGROUND
	    gbcMain.insets = new Insets(0,0,100,20);
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
	    
	    gbcMain.insets = new Insets(0,-300,0,-270);
	    gbcMain.gridx = 1;
	    gbcMain.gridy = 0;
	    gbcMain.anchor = GridBagConstraints.SOUTH;
	    this.add(logoAppEel, gbcMain);
	    
	    //back button
	    gbcMain.anchor = GridBagConstraints.CENTER;
	    gbcMain.insets = new Insets(0,-1370,240,0);
	    gbcMain.gridwidth = 1;
	    this.add(back, gbcMain);
	    
	   //Results stuff	   
	    gbcMain.insets = new Insets(0,-80,200,0);
	    gbcMain.gridwidth = 1;
	    this.add(searchResultsPane, gbcMain);	    
	    
	    //Search stuff
	    gbcMain.insets = new Insets(0,-390,0,0);
	    gbcMain.gridwidth = 1;
	    this.add(searchType, gbcMain);
	    
	    gbcMain.insets = new Insets(0,-90,0,0);
	    gbcMain.gridwidth = 1;
	    this.add(searchText, gbcMain);
	    
	    gbcMain.insets = new Insets(0,210,0,0);
	    gbcMain.gridwidth = 1;
	    this.add(submitSearch, gbcMain);
	    
	    
	    //JLabels south	    
	    gbcMain.insets = new Insets(0,-300,-130,0);
	    gbcMain.gridwidth = 1;
	    this.add(bookTitle, gbcMain);
	    
	    gbcMain.insets = new Insets(0,-315,-190,0);
	    gbcMain.gridwidth = 1;
	    this.add(libCode, gbcMain);
	    
	    gbcMain.insets = new Insets(0,-320,-250,0);
	    gbcMain.gridwidth = 1;
	    this.add(author , gbcMain);
	    
	    gbcMain.insets = new Insets(0,-330,-310,0);
	    gbcMain.gridwidth = 1;
	    this.add(genre , gbcMain);
	    
	    gbcMain.insets = new Insets(0,-305,-370,0);
	    gbcMain.gridwidth = 1;
	    this.add(location , gbcMain);
	    
	    gbcMain.insets = new Insets(0,-305,-430,0);
	    gbcMain.gridwidth = 1;
	    this.add(available , gbcMain);
	     
	    
	    //JtextFields south
	    gbcMain.insets = new Insets(0,0,-130,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFbookTitle, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-190,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFlibCode, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-250,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFauthor, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-310,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFgenre, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-370,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFlocation, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-430,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFavailable, gbcMain);
	    
	    
	    //JButton
	    gbcMain.insets = new Insets(0,-300,-510,0);
	    gbcMain.gridwidth = 1;
	    this.add(addBook, gbcMain);
	    
	    gbcMain.insets = new Insets(0,20,-510,0);
	    gbcMain.gridwidth = 1;
	    this.add(updateBook, gbcMain);
	    
	    gbcMain.insets = new Insets(0,-300,-570,0);
	    gbcMain.gridwidth = 1;
	    this.add(discardChanges, gbcMain);
	    
	    gbcMain.insets = new Insets(0,20,-570,0);
	    gbcMain.gridwidth = 1;
	    this.add(deleteBook, gbcMain);
	    
	    
	    
	    
	}
	
	public JButton getBack(){
		return(this.back);
	}

}
