
import javax.swing.*;

import java.awt.*;
public class ManageCustomer extends JPanel{
	private ImageIcon homeIcon = new ImageIcon("home.png");
	
	private JLabel title = new JLabel(new ImageIcon("dit_banner.png"));
	private JLabel logoDIT = new JLabel(new ImageIcon("properLogo.png"));
	private JLabel booksLogo = new JLabel(new ImageIcon("library_book.png"));
	private JLabel logoAppEel = new JLabel(new ImageIcon("copyright.png"));
	private JLabel userID = new JLabel("User ID: ");

	private JLabel customerID = new JLabel("CUSTOMER ID");
	private JLabel name = new JLabel("NAME");
	private JLabel address = new JLabel("ADDRESS");
	private JLabel balance = new JLabel("BALANCE");
	
	private JTextField JTFcustomerID = new JTextField(10);
	private JTextField JTFname = new JTextField(10);
	private JTextField JTFaddress = new JTextField(10);
	private JTextField JTFbalance = new JTextField(10);
	private JTextField JTFsearch = new JTextField(10);
	
	private JButton addCustomer = new JButton(" Add Customer     ");
	private JButton updateCustomer = new JButton("       Update Customer   ");
	private JButton discardChanges = new JButton("Discard Changes ");
	private JButton deleteCustomer = new JButton("     Delete Customer      ");
	private JButton search = new JButton("Search ");
	private JButton home = new JButton("      Home     ", homeIcon);
	
	private Color background = new Color(152,178,255);

	//JTexfield where it displayed the user ID
	private JTextField ID = new JTextField(5);	
	
	private String[] itemBox = {"Customer ID", "Name", "Address", "Balance"};
	private JComboBox combo = new JComboBox(itemBox);
		
	private String[] header = {"Customer ID", "Name", "Address", "Balance"};
	private Object data[][] = new Object[][]{
            {"dfhdfh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh"},
            {"dfhdfh", "fdh", "fdh", "fdh"}
    };
	private JTable table = new JTable(data, header);
	public ManageCustomer(){
		
		this.setBackground(background);
		GridBagConstraints gbcMain = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.home.setForeground(Color.red);
		//this.bookTitle.setFont(new Font("Serif", Font.BOLD, 12));
		customerID.setFont(new Font("Serif", Font.BOLD, 12));
		name.setFont(new Font("Serif", Font.BOLD, 12));
		address.setFont(new Font("Serif", Font.BOLD, 12));
		balance.setFont(new Font("Serif", Font.BOLD, 12));	
		
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
	    
	    gbcMain.insets = new Insets(0,-300,-160,0);
	    gbcMain.gridwidth = 1;
	    this.add(customerID, gbcMain);
	    
	    gbcMain.insets = new Insets(0,-350,-220,0);
	    gbcMain.gridwidth = 1;
	    this.add(name, gbcMain);
	    
	    gbcMain.insets = new Insets(0,-330,-280,0);
	    gbcMain.gridwidth = 1;
	    this.add(address , gbcMain);
	    
	    gbcMain.insets = new Insets(0,-330,-340,0);
	    gbcMain.gridwidth = 1;
	    this.add(balance , gbcMain);
	    
	    
	    //JtextField
	    gbcMain.insets = new Insets(0,0,-150,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFcustomerID, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-220,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFname, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-280,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFaddress, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-340,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFbalance, gbcMain);	    
	    
	    //JButton
	    gbcMain.insets = new Insets(0,-300,-440,0);
	    gbcMain.gridwidth = 1;
	    this.add(addCustomer, gbcMain);
	    
	    gbcMain.insets = new Insets(0,20,-440,0);
	    gbcMain.gridwidth = 1;
	    this.add(updateCustomer, gbcMain);
	    
	    gbcMain.insets = new Insets(0,-300,-510,0);
	    gbcMain.gridwidth = 1;
	    this.add(discardChanges, gbcMain);
	    
	    gbcMain.insets = new Insets(0,20,-510,0);
	    gbcMain.gridwidth = 1;
	    this.add(deleteCustomer, gbcMain);
	    
	    
	    //JTable
	    JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    
	    gbcMain.insets = new Insets(0,-80,290,0);
	    gbcMain.ipady = -300;
	    this.add(pane, gbcMain);
	    
	    //JcomboBox
	    gbcMain.insets = new Insets(0,20,60,380);
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
