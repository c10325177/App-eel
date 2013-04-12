
import javax.swing.*;

import java.awt.*;
public class LibraryReports extends JPanel{
	private ImageIcon homeIcon = new ImageIcon("home.png");
	
	private JLabel title = new JLabel(new ImageIcon("dit_banner.png"));
	private JLabel logoDIT = new JLabel(new ImageIcon("properLogo.png"));
	private JLabel booksLogo = new JLabel(new ImageIcon("library_book.png"));
	private JLabel logoAppEel = new JLabel(new ImageIcon("copyright.png"));
	private JLabel userID = new JLabel("User ID: ");
	private JLabel name = new JLabel("Kevin Street Library");

	private JLabel bookName = new JLabel("BOOK NAME");
	private JLabel staffId = new JLabel("STAFF ID");

	
	private JTextField JTFbookName = new JTextField(10);
	private JTextField JTFstaffId = new JTextField(10);

	
	private JButton search = new JButton("Search");
	private JButton print = new JButton("  Print  ");
	private JButton home = new JButton("      Home     ", homeIcon);
	
	private Color background = new Color(152,178,255);

	//JTexfield where it displayed the user ID
	private JTextField ID = new JTextField(5);	
	
	
	
	private String[] header = {"Book ID", "Book name", "Copies", "Stock"};
	private Object data[][] = new Object[][]{
            {"dfhdfh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh"},
    };
	private JTable table = new JTable(data, header);
	public LibraryReports(){
		
		this.setBackground(background);
		GridBagConstraints gbcMain = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.home.setForeground(Color.red);
		this.print.setForeground(Color.green);
		this.bookName.setFont(new Font("Serif", Font.BOLD, 12));
		staffId.setFont(new Font("Serif", Font.BOLD, 12));
		name.setFont(new Font("Serif", Font.BOLD, 28));
	
		
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
	    
	    gbcMain.insets = new Insets(0,-300,-190,0);
	    gbcMain.gridwidth = 1;
	    this.add(bookName, gbcMain);
	    
	    gbcMain.insets = new Insets(0,-315,-260,0);
	    gbcMain.gridwidth = 1;
	    this.add(staffId, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,340,-0);
	    gbcMain.gridwidth = 1;
	    this.add(name, gbcMain);
	    

	    
	    
	    
	    //JtextField
	    gbcMain.insets = new Insets(0,0,-190,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFbookName, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-260,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFstaffId, gbcMain);
	    
	    
	    
	    //JButton
	    gbcMain.insets = new Insets(0,-0,-360,0);
	    gbcMain.gridwidth = 1;
	    this.add(search, gbcMain);
	    
	    
	    gbcMain.insets = new Insets(0,-0,-430,0);
	    gbcMain.gridwidth = 1;
	    this.add(print, gbcMain);
	    
	    //User ID stuff
	    gbcMain.insets = new Insets(0,0,300,-680);
	    gbcMain.gridwidth = 1;
	    this.add(userID, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,300,-790);
	    gbcMain.gridwidth = 1;
	    this.add(ID, gbcMain);
	    
	    
	    //JTable
	    JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    
	    gbcMain.insets = new Insets(0,20,0,0);
	    gbcMain.ipady = -300;
	    this.add(pane, gbcMain);
	    
	    

	    
	  	    
	}
	
	public JButton getHome(){
		return(this.home);
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
}
