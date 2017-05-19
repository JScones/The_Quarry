package mvc;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import net.miginfocom.swing.MigLayout;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TamaView {
	
	private TamaModel m_model;
	
	JFrame frame = new JFrame("Tamagotchi");
	JPanel cards;
	
	private String curView = "Menu";
	
	// First menu components
	private JLabel helpTextLabel = new JLabel();
	private JLabel menuTextLabel = new JLabel();
	private JLabel numPlayersLabel = new JLabel("How many players?");
	private JLabel numDaysLabel = new JLabel("How many days would you like to play for?");
	private JLabel playerNum = new JLabel("Player 1, please choose your pets:");
	private JLabel petPicLabel1 = new JLabel();
	private JLabel petPicLabel2 = new JLabel();
	private JLabel petPicLabel3 = new JLabel();
	private JLabel petStatLabel1 = new JLabel();
	private JLabel petStatLabel2 = new JLabel();
	private JLabel petStatLabel3 = new JLabel();
	private JButton start = new JButton("Start");
	private JButton help = new JButton("Help");
	private JButton back = new JButton("Back");
	private JButton next = new JButton("Next");
	private JButton next_player = new JButton("Next");
	private JButton clearSelections = new JButton("Clear");
	private JRadioButton players1 = new JRadioButton("1 player  ");
	private JRadioButton players2 = new JRadioButton("2 players  ");
	private JRadioButton players3 = new JRadioButton("3 players  ");
	private JRadioButton days1 = new JRadioButton("1 day  ");
	private JRadioButton days2 = new JRadioButton("2 days  ");
	private JRadioButton days3 = new JRadioButton("3 days  ");
	private JRadioButton days4 = new JRadioButton("4 days  ");
	private JRadioButton days5 = new JRadioButton("5 days  ");
	private JComboBox<String> petsCombo1 = new JComboBox<String>();
	private JComboBox<String> petsCombo2 = new JComboBox<String>();
	private JComboBox<String> petsCombo3 = new JComboBox<String>();
	private JTextField petName1 = new JTextField();
	private JTextField petName2 = new JTextField();
	private JTextField petName3 = new JTextField();
	
	private ButtonGroup numPlayersGroup = new ButtonGroup();
	private ButtonGroup numDaysGroup = new ButtonGroup();
	private Dimension buttonSize = new Dimension(225, 50);
	
	

	
	public TamaView(TamaModel model)
	{
		m_model = model;
		initialise();
		changeView(curView);
		
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
		setupCard.add(next, "skip, grow, hmax 50");
		
		return setupCard;
	}
	
	private JPanel buildPlayerCreatorPanel()
	{
		MigLayout Layout = new MigLayout(
				"fill, insets 20, wrap 3", 
				"[][][]",
				"[][][]");
		
		JPanel PCCard = new JPanel();
		PCCard.setLayout(Layout);
		playerNum.setFont(new Font(null, Font.BOLD, 20));
		playerNum.setHorizontalAlignment(SwingConstants.CENTER);
		PCCard.add(playerNum, "grow, span 2");
		clearSelections.setPreferredSize(buttonSize);
		PCCard.add(clearSelections, "wrap");

		setPetComboBoxOptions(petsCombo1);
		petsCombo1.setActionCommand("combo-1");
		setPetComboBoxOptions(petsCombo2);
		petsCombo2.setActionCommand("combo-2");
		setPetComboBoxOptions(petsCombo3);
		petsCombo3.setActionCommand("combo-3");
		
		PCCard.add(petsCombo1);
		PCCard.add(petsCombo2);
		PCCard.add(petsCombo3);
		PCCard.add(petPanel(1));
		PCCard.add(petPanel(2));
		PCCard.add(petPanel(3), "wrap");
		resetPetView();
		next_player.setPreferredSize(buttonSize);
		PCCard.add(next_player, "skip 1");
		return PCCard;
	}
	
	private JPanel petPanel(int count)
	{
		MigLayout Layout = new MigLayout(
				"fill, flowy, insets 20", 
				"[][]",
				"[][]");
		
		JPanel petPanel = new JPanel();
		petPanel.setLayout(Layout);
		//petPanel.setLayout(new BoxLayout(petPanel, BoxLayout.Y_AXIS));
		petPanel.setPreferredSize(new Dimension(185,200));
		if(count == 1)
		{
			petPanel.add(petPicLabel1);
			petPanel.add(petStatLabel1);
			petPanel.add(petName1, "gaptop 10");
			petName1.setPreferredSize(buttonSize);
			petName1.setVisible(false);
		}
		else if(count == 2)
		{
			petPanel.add(petPicLabel2);
			petPanel.add(petStatLabel2);
			petPanel.add(petName2, "gaptop 10");
			petName2.setPreferredSize(buttonSize);
			petName2.setVisible(false);
		}
		else if(count == 3)
		{
			petPanel.add(petPicLabel3);
			petPanel.add(petStatLabel3);
			petPanel.add(petName3, "gaptop 10");
			petName3.setPreferredSize(buttonSize);
			petName3.setVisible(false);
		}
		return petPanel;
	}
	
	private void setPetComboBoxOptions(JComboBox<String> curBox)
	{
		String[] species = m_model.getSpecies();
		curBox.addItem(" ");
		for(int i = 0; i < species.length; i++)
		{
			curBox.addItem(species[i]);
		}
		curBox.setPreferredSize(buttonSize);
	}
	
	
	protected void updatePetPanel(String newPet, int labelNum)
	{
		if(labelNum == 1)
		{
			if(newPet == " ")
			{
				petPicLabel1.setIcon(null);
				petStatLabel1.setText(null);
				petName1.setVisible(false);
			}
			else
			{
				petPicLabel1.setIcon(m_model.defaultPets.get(newPet).icon);
				petStatLabel1.setText(m_model.defaultPets.get(newPet).getStatsString());
				petName1.setVisible(true);
			}
		}
		else if(labelNum == 2)
		{
			if(newPet == " ")
			{
				petPicLabel2.setIcon(null);
				petStatLabel2.setText(null);
				petName2.setVisible(false);
			}
			else
			{
				petPicLabel2.setIcon(m_model.defaultPets.get(newPet).icon);
				petStatLabel2.setText(m_model.defaultPets.get(newPet).getStatsString());
				petName2.setVisible(true);
			}
		}
		else if(labelNum == 3)
		{
			if(newPet == " ")
			{
				petPicLabel3.setIcon(null);
				petStatLabel3.setText(null);
				petName3.setVisible(false);
			}
			else
			{
				petPicLabel3.setIcon(m_model.defaultPets.get(newPet).icon);
				petStatLabel3.setText(m_model.defaultPets.get(newPet).getStatsString());
				petName3.setVisible(true);
			}
		}
	}
	
	protected void addButtonListener(ActionListener bal)
	{
		start.addActionListener(bal);
		help.addActionListener(bal);
		back.addActionListener(bal);
		next.addActionListener(bal);
		next_player.addActionListener(bal);
		petsCombo1.addActionListener(bal);
		petsCombo2.addActionListener(bal);
		petsCombo3.addActionListener(bal);
		clearSelections.addActionListener(bal);
	}
	
	protected void addComboBoxListener(ItemListener cal)
	{
		petsCombo1.addItemListener(cal);
		petsCombo2.addItemListener(cal);
		petsCombo3.addItemListener(cal);
	}
	
	protected int getNumPlayers()
	{
		return Integer.parseInt(numPlayersGroup.getSelection().getActionCommand());
	}
	
	protected int getNumDays()
	{
		return Integer.parseInt(numDaysGroup.getSelection().getActionCommand());
	}
	
	protected ArrayList<String> getPetSpeciesSelections()
	{
		ArrayList<String> petSpecies = new ArrayList<String>();
		petSpecies.add((String)petsCombo1.getSelectedItem());
		petSpecies.add((String)petsCombo2.getSelectedItem());
		petSpecies.add((String)petsCombo3.getSelectedItem());
		
		return petSpecies;
	}
	
	protected ArrayList<String> getPetNames()
	{
		ArrayList<String> petNames = new ArrayList<String>();
		petNames.add("Bob");
		petNames.add("Foo");
		petNames.add("Bar");
		return petNames;
	}
	
	protected void resetPetView()
	{
		petsCombo1.setSelectedItem(" ");
		petsCombo2.setSelectedItem(" ");
		petsCombo3.setSelectedItem(" ");
		petStatLabel1.setText(null);
		petPicLabel1.setIcon(null);
		petName1.setVisible(false);
		petStatLabel2.setText(null);
		petPicLabel2.setIcon(null);
		petName2.setVisible(false);
		petStatLabel3.setText(null);
		petPicLabel3.setIcon(null);
		petName3.setVisible(false);
	}
	
	protected void nextPlayer(int num)
	{
		resetPetView();
		playerNum.setText("Player " + num + ", please choose your pets:");
	}
	
	protected void changeView(String view)
	{
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, view);
		curView = view;
		
	}
	
	protected void updateText()
	{
		helpTextLabel.setText(Integer.toString(m_model.getClickCount()));
	}
	
	protected String getCurrentView()
	{
		return curView;
	}

}
