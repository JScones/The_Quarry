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
	private JButton start = new JButton("Start");
	private JButton help = new JButton("Help");
	private JButton back = new JButton("Back");
	private Dimension buttonSize = new Dimension(225, 50);
	private JTabbedPane creatureTabs = new JTabbedPane();
	private JPanel statHolder = new JPanel();
	
	private String helpText = "This is where the help text goes\n";

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
		
		//Trying miglayout
		MigLayout menuLayout = new MigLayout(
				"fill, insets 20", 
				"[][]",
				"[][]");
		
		//Create cards
		JPanel menuCard = new JPanel();
		menuCard.setLayout(menuLayout);
		menuTextPane.setEditable(false);
		menuTextPane.setText("Let's test this out");
		
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
		
		
		statHolder.setPreferredSize(new Dimension(500,500));
		statHolder.add(new JTextField("Hello"));
		ImageIcon lionIcon = new ImageIcon("resources/lion_small.png");
		creatureTabs.addTab("Lion", lionIcon, statHolder);
		
		JPanel tab2 = new JPanel();
		tab2.add(new JTextField("Number 2"));
		
		creatureTabs.addTab("Gorilla", tab2);
		
		cards = new JPanel(new CardLayout());
		//cards.add(menuCard, "Menu");
		//cards.add(helpCard, "Help");
		cards.add(creatureTabs, "Creature");
		
		//frame.add(mainPane, BorderLayout.PAGE_START);
		frame.getContentPane().add(cards, BorderLayout.CENTER);
		//frame.setResizable(false);
		//frame.setMinimumSize(new Dimension(900, 600));
		frame.setPreferredSize(new Dimension(900, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
	}

}
