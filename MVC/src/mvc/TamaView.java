package mvc;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import net.miginfocom.swing.MigLayout;

import java.awt.event.*;

public class TamaView {
	
	private TamaModel m_model;
	
	JFrame frame = new JFrame("Tamagotchi");
	JPanel cards;
	
	// First menu components
	private JTextPane menuTextPane = new JTextPane();
	private JTextPane helpTextPane = new JTextPane();
	private JButton start = new JButton("Start");
	private JButton help = new JButton("Help");
	private JButton back = new JButton("Back");
	private Dimension buttonSize = new Dimension(225, 50);
	
	
	private String[] animals = new String[] {"Lion", "Gorilla", "Eagle", "Tiger", "Elephant", "Snake"};
	private String helpText = "This is where the help text goes\n";
	private final JPanel panel = new JPanel();
	private final JComboBox comboBox = new JComboBox(new Object[]{});
	private final JComboBox comboBox_1 = new JComboBox(new Object[]{});
	private final JComboBox comboBox_2 = new JComboBox(new Object[]{});

	
	public TamaView(TamaModel model)
	{
		m_model = model;
		
		//Trying miglayout
		MigLayout menuLayout = new MigLayout("fill, insets 20", "[grow][grow][grow][]", "[][][][]");
		
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
		menuCard.add(menuTextPane, "cell 0 0 4 1,push ,alignx center,grow");
		start.setPreferredSize(buttonSize);
		menuCard.add(start, "cell 0 2 4 1,alignx center,hmax 50,grow");
		help.setPreferredSize(buttonSize);
		menuCard.add(help, "cell 0 2 4 1,alignx center,hmax 50,grow");
		
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
		
		
		cards = new JPanel(new CardLayout());
		cards.add(menuCard, "Menu");
		cards.add(helpCard, "Help");
		
		//frame.add(mainPane, BorderLayout.PAGE_START);
		frame.getContentPane().add(cards, BorderLayout.CENTER);
		
		cards.add(panel, "name_401964832595291");
		
		panel.add(comboBox);
		
		panel.add(comboBox_1);
		
		panel.add(comboBox_2);
		//frame.setResizable(false);
		//frame.setMinimumSize(new Dimension(900, 600));
		frame.setPreferredSize(new Dimension(900, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
	}
	
	public void addButtonListener(ActionListener bal)
	{
		start.addActionListener(bal);
		help.addActionListener(bal);
		back.addActionListener(bal);
	}
	
	public void changeView(String view)
	{
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, view);
	}
	
	public void updateText()
	{
		helpTextPane.setText(helpText + Integer.toString(m_model.getClickCount()));
	}

}
