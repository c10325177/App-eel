
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ManageBook extends JPanel implements ActionListener{
	private ImageIcon homeIcon = new ImageIcon("home.png");
	
	private JLabel title = new JLabel(new ImageIcon("dit_banner.png"));
	private JLabel logoDIT = new JLabel(new ImageIcon("properLogo.png"));
	private JLabel booksLogo = new JLabel(new ImageIcon("library_book.png"));
	private JLabel logoAppEel = new JLabel(new ImageIcon("copyright.png"));
	private JLabel userID = new JLabel("User ID: ");

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
	private JTextField JTFsearch = new JTextField(10);
	
	private JButton addRow = new JButton("         Add Book       ");
	private JButton updateDB = new JButton("        Update Book     ");
	private JButton discardChanges = new JButton("Discard Changes ");
	private JButton deleteBook = new JButton("       Delete Book        ");
	private JButton search = new JButton("Search ");
	private JButton home = new JButton("      Home     ", homeIcon);
		
	private Color background = new Color(152,178,255);

	//JTexfield where it displayed the user ID
	private JTextField ID = new JTextField(5);	
	
	private String[] itemBox = {"Title", "Lib code", "Author"};
	private JComboBox combo = new JComboBox(itemBox);
	
	
	private String[] header = {"Title", "Lib code", "Author", "Genre", "Location", "Available   "};
	private Object data[][] = new Object[][]{
            {"dfhdfh", "fdh", "fdh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh", "fdh", "fdh"},
    };
	private JTable table = new JTable(data, header);
	
	public ManageBook(){
		
		this.setBackground(background);
		GridBagConstraints gbcMain = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.home.setForeground(Color.red);
		this.bookTitle.setFont(new Font("Serif", Font.BOLD, 12));
		libCode.setFont(new Font("Serif", Font.BOLD, 12));
		author.setFont(new Font("Serif", Font.BOLD, 12));
		genre.setFont(new Font("Serif", Font.BOLD, 12));
		location.setFont(new Font("Serif", Font.BOLD, 12));
		available.setFont(new Font("Serif", Font.BOLD, 12));	
		
		//put and set an Icon on the different button
		home.setVerticalTextPosition(AbstractButton.BOTTOM);
		home.setHorizontalTextPosition(AbstractButton.CENTER);
		home.setBorderPainted(false);
		home.setContentAreaFilled(false);		
			
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
	    
	    //JLabel
	    gbcMain.anchor = GridBagConstraints.CENTER;
	    gbcMain.insets = new Insets(0,-800,240,0);
	    gbcMain.gridwidth = 1;
	    this.add(home, gbcMain);
	    
	    gbcMain.insets = new Insets(0,-300,-80,0);
	    gbcMain.gridwidth = 1;
	    this.add(bookTitle, gbcMain);
	    
	    gbcMain.insets = new Insets(0,-315,-140,0);
	    gbcMain.gridwidth = 1;
	    this.add(libCode, gbcMain);
	    
	    gbcMain.insets = new Insets(0,-320,-200,0);
	    gbcMain.gridwidth = 1;
	    this.add(author , gbcMain);
	    
	    gbcMain.insets = new Insets(0,-330,-260,0);
	    gbcMain.gridwidth = 1;
	    this.add(genre , gbcMain);
	    
	    gbcMain.insets = new Insets(0,-305,-320,0);
	    gbcMain.gridwidth = 1;
	    this.add(location , gbcMain);
	    
	    gbcMain.insets = new Insets(0,-305,-380,0);
	    gbcMain.gridwidth = 1;
	    this.add(available , gbcMain);
	    
	    
	    
	    //JtextField
	    gbcMain.insets = new Insets(0,0,-80,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFbookTitle, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-140,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFlibCode, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-200,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFauthor, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-260,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFgenre, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-320,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFlocation, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-380,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFavailable, gbcMain);
	    
	    
	    //JButton
	    gbcMain.insets = new Insets(0,-300,-490,0);
	    gbcMain.gridwidth = 1;
	    this.add(addRow, gbcMain);
	    
	    gbcMain.insets = new Insets(0,20,-490,0);
	    gbcMain.gridwidth = 1;
	    this.add(updateDB, gbcMain);
	    
	    gbcMain.insets = new Insets(0,-300,-550,0);
	    gbcMain.gridwidth = 1;
	    this.add(discardChanges, gbcMain);
	    
	    gbcMain.insets = new Insets(0,20,-550,0);
	    gbcMain.gridwidth = 1;
	    this.add(deleteBook, gbcMain);
	    
	    
	    //JTable
	    JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    
	    gbcMain.insets = new Insets(0,20,250,0);
	    gbcMain.ipady = -300;
	    this.add(pane, gbcMain);
	    
	    //JcomboBox
	    gbcMain.insets = new Insets(0,20,60,300);
	    gbcMain.ipady = 0;
	    this.add(combo, gbcMain);
	    
	    //Jtextfield search
	    gbcMain.insets = new Insets(0,20,60,70);
	    this.add(JTFsearch, gbcMain);
	    
	    //JButton search
	    gbcMain.insets = new Insets(0,20,60,-160);
	    this.add(search, gbcMain);
	    
	    //User ID stuff
	    gbcMain.insets = new Insets(0,0,300,-680);
	    gbcMain.gridwidth = 1;
	    this.add(userID, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,300,-790);
	    gbcMain.gridwidth = 1;
	    this.add(ID, gbcMain);	  	    
	}
	
		public JComboBox getSearchType(){
			return(this.combo);			
		}
	
		public JTextField getBookTitle(){
			return(this.JTFbookTitle);
		}
		
		public JTextField getAuthor(){
			return(this.JTFauthor);
		}
		
		public JTextField getGenre(){
			return(this.JTFgenre);
		}
		
		public JTextField getlocation(){
			return(this.JTFlocation);
		}
		
		public JTextField getAvailable(){
			return(this.JTFavailable);
		}
		
		public JTextField getLibCode(){
			return(this.JTFlibCode);
		}
		
		public JTextField getSearchJTF(){
			return(this.JTFsearch);
		}
	
		public JButton getHome(){
			return(this.home);
		}
		
		public JButton getInsert(){
			return(this.addRow);
		}
		
		public JButton getDelete(){
			return(this.deleteBook);
		}
		
		public JButton getDiscard(){
			return(this.discardChanges);
		}
		
		public JButton getUpdate(){
			return(this.updateDB);
		}
		
		public JButton getSearch(){
			return(this.search);
		}
	
		public int getRowCount() {
	        return data.length;
	    }
	 
	    public int getColumnCount() {
	        return header.length;
	    }
	 
	    public String getColumnName(int columnIndex) {
	        return header[columnIndex];
	    }
	 
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        return data[rowIndex][columnIndex];
	    }
	    
		public JTextField getUserID(){
			return(this.ID);
		}

		@Override
		public void actionPerformed(ActionEvent ev) {
			// TODO Auto-generated method stub
			
			JButton temp = (JButton) ev.getSource();
			String action = temp.getActionCommand();
			
		}
}
