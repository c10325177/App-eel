
import javax.swing.*;

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
	
	private JButton addRow = new JButton(" Add row to table ");
	private JButton updateDB = new JButton("Update Database ");
	private JButton discardChanges = new JButton("Discard Changes ");
	private JButton deleteBook = new JButton("     Delete Book      ");
	
	private Color background = new Color(152,178,255);
	private JButton back = new JButton("      Back      ");
	

	
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
	    gbcMain.insets = new Insets(0,-1370,240,0);
	    gbcMain.gridwidth = 1;
	    this.add(back, gbcMain);
	    
	    gbcMain.insets = new Insets(0,-300,170,0);
	    gbcMain.gridwidth = 1;
	    this.add(bookTitle, gbcMain);
	    
	    gbcMain.insets = new Insets(0,-315,110,0);
	    gbcMain.gridwidth = 1;
	    this.add(libCode, gbcMain);
	    
	    gbcMain.insets = new Insets(0,-320,50,0);
	    gbcMain.gridwidth = 1;
	    this.add(author , gbcMain);
	    
	    gbcMain.insets = new Insets(0,-330,-10,0);
	    gbcMain.gridwidth = 1;
	    this.add(genre , gbcMain);
	    
	    gbcMain.insets = new Insets(0,-305,-70,0);
	    gbcMain.gridwidth = 1;
	    this.add(location , gbcMain);
	    
	    gbcMain.insets = new Insets(0,-305,-130,0);
	    gbcMain.gridwidth = 1;
	    this.add(available , gbcMain);
	    
	    
	    
	    //JtextField
	    gbcMain.insets = new Insets(0,0,170,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFbookTitle, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,110,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFlibCode, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,50,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFauthor, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-10,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFgenre, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-70,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFlocation, gbcMain);
	    
	    gbcMain.insets = new Insets(0,0,-130,0);
	    gbcMain.gridwidth = 1;
	    this.add(JTFavailable, gbcMain);
	    
	    
	    //JButton
	    gbcMain.insets = new Insets(0,-300,-240,0);
	    gbcMain.gridwidth = 1;
	    this.add(addRow, gbcMain);
	    
	    gbcMain.insets = new Insets(0,20,-240,0);
	    gbcMain.gridwidth = 1;
	    this.add(updateDB, gbcMain);
	    
	    gbcMain.insets = new Insets(0,-300,-300,0);
	    gbcMain.gridwidth = 1;
	    this.add(discardChanges, gbcMain);
	    
	    gbcMain.insets = new Insets(0,20,-300,0);
	    gbcMain.gridwidth = 1;
	    this.add(deleteBook, gbcMain);
	    
	    
	    
	    
	}
	
	public JButton getBack(){
		return(this.back);
	}

}
