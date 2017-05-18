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
	private JLabel helpTextLabel = new JLabel();
	private JLabel menuTextLabel = new JLabel();
	private JLabel numPlayersLabel = new JLabel("How many players?");
	private JLabel numDaysLabel = new JLabel("How many days would you like to play for?");
	private JLabel playerNum = new JLabel("Player 1");
	private JButton start = new JButton("Start");
	private JButton help = new JButton("Help");
	private JButton back = new JButton("Back");
	private JButton next = new JButton("Next");
	private JRadioButton players1 = new JRadioButton("1 player  ");
	private JRadioButton players2 = new JRadioButton("2 players  ");
	private JRadioButton players3 = new JRadioButton("3 players  ");
	private JRadioButton days1 = new JRadioButton("1 day  ");
	private JRadioButton days2 = new JRadioButton("2 days  ");
	private JRadioButton days3 = new JRadioButton("3 days  ");
	private JRadioButton days4 = new JRadioButton("4 days  ");
	private JRadioButton days5 = new JRadioButton("5 days  ");
	private JComboBox petsList = new JComboBox();
	
	private ButtonGroup numPlayersGroup = new ButtonGroup();
	private ButtonGroup numDaysGroup = new ButtonGroup();
	private Dimension buttonSize = new Dimension(225, 50);
	
	

	
	public TamaView(TamaModel model)
	{
		m_model = model;
		initialise();
		
	}
	
	private void initialise()
	{
		//Make Menu card
		JPanel menuCard = buildMainMenuPanel();
		
		//Make Help menu card
		JPanel helpCard = buildHelpPanel();
		
		//Make the number of players and days card
		JPanel setupCard = buildSetupPanel();
		
		//Make the player creator card
		JPanel playerCreatorCard = buildPlayerCreatorPanel();
		
		// Add cards to the main panel in order to display and switch between them.
		cards = new JPanel(new CardLayout());
		cards.add(menuCard, "Menu"); // The string here is an ID used to choose which card shows through changeView(ID) below.
		cards.add(helpCard, "Help");
		cards.add(setupCard, "Setup");
		cards.add(playerCreatorCard, "Make Player");
		
		//frame.add(mainPane, BorderLayout.PAGE_START);
		frame.getContentPane().add(cards, BorderLayout.CENTER);
		//frame.setResizable(false);
		//frame.setMinimumSize(new Dimension(900, 600));
		frame.setPreferredSize(new Dimension(900, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
	}
	
	private JPanel buildMainMenuPanel()
	{
		MigLayout menuLayout = new MigLayout(
				"fill, insets 20", 
				"[][]",
				"[][]");
		
		JPanel menuCard = new JPanel();
		menuCard.setLayout(menuLayout);
		//centerText(menuTextPane);
		menuTextLabel.setText(m_model.getMainMenuText());
		menuTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//
		//info1.setPreferredSize(new Dimension(450, 300));
		menuCard.add(menuTextLabel, "span,grow,center,wrap, push");
		start.setPreferredSize(buttonSize);
		menuCard.add(start, "grow, hmax 50,center, span, split 2");
		help.setPreferredSize(buttonSize);
		menuCard.add(help, "grow, hmax 50,center");
		
		return menuCard;
	}
	
	private JPanel buildHelpPanel()
	{
		MigLayout helpLayout = new MigLayout(
				"fill, insets 20", 
				"[]",
				"[]");
		
		JPanel helpCard = new JPanel();
		helpCard.setLayout(helpLayout);
		helpTextLabel.setText(m_model.getHelpText());
		helpTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		helpCard.add(helpTextLabel, "span,grow,center,wrap, push");
		back.setPreferredSize(buttonSize);
		helpCard.add(back, "grow");
		
		return helpCard;
	}
	
	private JPanel buildSetupPanel()
	{
		//Make the Setup card
		MigLayout setupLayout = new MigLayout(
				"fill, insets 20, wrap 2", 
				"[][]",
				"[][][]");
		
		JPanel setupCard = new JPanel();
		setupCard.setLayout(setupLayout);
		numPlayersLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//numPlayersLabel.setText("How many players?");
		setupCard.add(numPlayersLabel, "grow");
		
		numPlayersGroup.add(players1);
		numPlayersGroup.add(players2);
		numPlayersGroup.add(players3);
		players1.setActionCommand("1");
		players2.setActionCommand("2");
		players3.setActionCommand("3");
		
		players1.setSelected(true);
		setupCard.add(players1, "split 3");
		setupCard.add(players2);
		setupCard.add(players3);
		
		numDaysGroup.add(days1);
		numDaysGroup.add(days2);
		numDaysGroup.add(days3);
		numDaysGroup.add(days4);
		numDaysGroup.add(days5);
		days1.setActionCommand("1");
		days2.setActionCommand("2");
		days3.setActionCommand("3");
		days4.setActionCommand("4");
		days5.setActionCommand("5");

		days1.setSelected(true);
		numDaysLabel.setHorizontalAlignment(SwingConstants.CENTER);
		setupCard.add(numDaysLabel, "grow");
		setupCard.add(days1, "split 5");
		setupCard.add(days2);
		setupCard.add(days3);
		setupCard.add(days4);
		setupCard.add(days5);
		
		next.setPreferredSize(buttonSize);
		setupCard.add(next, "skip, grow, hmax 30");
		
		return setupCard;
	}
	
	private JPanel buildPlayerCreatorPanel()
	{
		MigLayout Layout = new MigLayout(
				"fill, insets 20, wrap 2", 
				"[][]",
				"[][][]");
		
		JPanel PCCard = new JPanel();
		PCCard.setLayout(Layout);
		System.out.println(playerNum.getFont());
		playerNum.setFont(new Font(null, Font.BOLD, 20));
		PCCard.add(playerNum, "wrap");
		String[] species = m_model.getSpecies();
		for(int i = 0; i < species.length; i++)
		{
			petsList.addItem(species[i]);
		}
		PCCard.add(petsList);
		
		return PCCard;
	}
	
	public void addButtonListener(ActionListener bal)
	{
		start.addActionListener(bal);
		help.addActionListener(bal);
		back.addActionListener(bal);
		next.addActionListener(bal);
	}
	
	public int getNumPlayers()
	{
		return Integer.parseInt(numPlayersGroup.getSelection().getActionCommand());
	}
	
	public int getNumDays()
	{
		return Integer.parseInt(numDaysGroup.getSelection().getActionCommand());
	}
	
	public void changeView(String view)
	{
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, view);
	}
	
	public void updateText()
	{
		helpTextLabel.setText(Integer.toString(m_model.getClickCount()));
	}

}
