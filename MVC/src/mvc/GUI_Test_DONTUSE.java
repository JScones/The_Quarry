package mvc;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

import net.miginfocom.swing.MigLayout;

public class GUI_Test_DONTUSE {

	JFrame frame = new JFrame("Gui Test");
	JPanel cards;

	// First menu components
	private JTextPane menuTextPane = new JTextPane();
	private JTextPane helpTextPane = new JTextPane();
	private JLabel numPlayersLabel = new JLabel();
	private JButton start = new JButton("Start");
	private JButton help = new JButton("Help");
	private JButton back = new JButton("Back");
	private Dimension buttonSize = new Dimension(225, 50);
	
	private String helpText = "This is where the help text goes\n";
	private JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
	private JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
	private JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");

	/**
	 * Launch the application.
	 	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Test_DONTUSE window = new GUI_Test_DONTUSE();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_Test_DONTUSE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Make Menu card
		MigLayout menuLayout = new MigLayout(
				"fill, insets 20", 
				"[][]",
				"[][]");
		
		JPanel menuCard = new JPanel();
		menuCard.setLayout(menuLayout);
		menuTextPane.setEditable(false);
		menuTextPane.setText("poop");
		
		//Centering the text http://stackoverflow.com/questions/3213045/centering-text-in-a-jtextarea-or-jtextpane-horizontal-text-alignment
		StyledDocument doc = menuTextPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		//
		//info1.setPreferredSize(new Dimension(450, 300));
		menuCard.add(menuTextPane, "span,grow,center,wrap, push");
		start.setPreferredSize(buttonSize);
		menuCard.add(start, "grow, hmax 50,center, span, split 2");
		help.setPreferredSize(buttonSize);
		menuCard.add(help, "grow, hmax 50,center");
		
		//Make Help menu card
		MigLayout helpLayout = new MigLayout(
				"fill, insets 20", 
				"[]",
				"[]");
		
		JPanel helpCard = new JPanel();
		helpCard.setLayout(helpLayout);
		helpTextPane.setText(helpText);
		helpTextPane.setEditable(false);
		
		helpCard.add(helpTextPane, "span,grow,center,wrap, push");
		back.setPreferredSize(buttonSize);
		helpCard.add(back, "grow");
		
		//Make the Setup card
		MigLayout setupLayout = new MigLayout(
				"fill, insets 20", 
				"[][]",
				"[][][]");
		
		JPanel setupCard = new JPanel();
		setupCard.setLayout(setupLayout);
		numPlayersLabel.setText("How many players? ");
		numPlayersLabel.setPreferredSize(buttonSize);
		setupCard.add(numPlayersLabel, "cell 0 0");
		
		
		// Add cards to the main panel in order to display and switch between them.
		cards = new JPanel(new CardLayout());
		//cards.add(menuCard, "Menu"); // The string here is an ID used to choose which card shows through changeView(ID) below.
		//cards.add(helpCard, "Help");
		cards.add(setupCard, "Setup");
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		
		setupCard.add(rdbtnNewRadioButton, "flowx,cell 1 0");
		
		setupCard.add(rdbtnNewRadioButton_1, "cell 1 0");
		
		setupCard.add(rdbtnNewRadioButton_2, "cell 1 0");
		
		//frame.add(mainPane, BorderLayout.PAGE_START);
		frame.getContentPane().add(cards, BorderLayout.CENTER);
		//frame.setResizable(false);
		//frame.setMinimumSize(new Dimension(900, 600));
		frame.setPreferredSize(new Dimension(900, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
	}

}
