package mvc;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentListener;
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
	private Font allFont = new Font(null, Font.BOLD, 20);
	
	private ImageIcon tick = new ImageIcon("resources/tick.png");
	private ImageIcon cross = new ImageIcon("resources/cross.png");
	
	// First menu components
	private JLabel helpTextLabel = new JLabel();
	private JLabel menuTextLabel = new JLabel();
	private JLabel numPlayersLabel = new JLabel("How many players?");
	private JLabel numDaysLabel = new JLabel("How many days would you like to play for?");
	private JLabel playerNum = new JLabel("Player 1, What is your name?");
	private JLabel choosePets = new JLabel("Choose up to 3 pets from the dropdowns below.");
	private JLabel petPicLabel1 = new JLabel();
	private JLabel petPicLabel2 = new JLabel();
	private JLabel petPicLabel3 = new JLabel();
	private JLabel petStatLabel1 = new JLabel();
	private JLabel petStatLabel2 = new JLabel();
	private JLabel petStatLabel3 = new JLabel();
	private JLabel nameAccepted = new JLabel(cross);
	private JLabel petNameAccepted1 = new JLabel(cross);
	private JLabel petNameAccepted2 = new JLabel(cross);
	private JLabel petNameAccepted3 = new JLabel(cross);
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
	private JTextField nameField = new JTextField();
	private JTextField petName1 = new JTextField();
	private JTextField petName2 = new JTextField();
	private JTextField petName3 = new JTextField();
	private JPanel petPanel1 = petPanel(1);
	private JPanel petPanel2 = petPanel(2);
	private JPanel petPanel3 = petPanel(3);
	
	private ButtonGroup numPlayersGroup = new ButtonGroup();
	private ButtonGroup numDaysGroup = new ButtonGroup();
	private Dimension buttonSize = new Dimension(225, 50);
	
	private Boolean isPlayerNameAccepted = false;
	private Boolean isPetName1Accepted = false;
	private Boolean isPetName2Accepted = false;
	private Boolean isPetName3Accepted = false;
	private Boolean isOnePetVisible = false;
	
	
	

	
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
		
		//Main game
		JPanel mainGameCard = new JPanel();
		
		// Add cards to the main panel in order to display and switch between them.
		cards = new JPanel(new CardLayout());
		cards.add(menuCard, "Menu"); // The string here is an ID used to choose which card shows through changeView(ID) below.
		cards.add(helpCard, "Help");
		cards.add(setupCard, "Setup");
		cards.add(playerCreatorCard, "Make Player");
		cards.add(mainGameCard, "Main Game");
		
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
				"[][][][]",
				"[][][]");
		
		JPanel PCCard = new JPanel();
		PCCard.setLayout(Layout);
		playerNum.setFont(allFont);
		playerNum.setHorizontalAlignment(SwingConstants.CENTER);
		PCCard.add(playerNum, "grow");
		nameField.setPreferredSize(buttonSize);
		PCCard.add(nameField);
		PCCard.add(nameAccepted, "wrap");
		choosePets.setFont(allFont);
		choosePets.setHorizontalAlignment(SwingConstants.CENTER);
		PCCard.add(choosePets, "grow, span, wrap, gaptop 10, gapbottom 10");

		setPetComboBoxOptions(petsCombo1);
		petsCombo1.setActionCommand("combo-1");
		setPetComboBoxOptions(petsCombo2);
		petsCombo2.setActionCommand("combo-2");
		setPetComboBoxOptions(petsCombo3);
		petsCombo3.setActionCommand("combo-3");
		
		PCCard.add(petsCombo1, "grow");
		PCCard.add(petsCombo2, "grow");
		PCCard.add(petsCombo3, "grow");
		PCCard.add(petPanel1);
		PCCard.add(petPanel2);
		PCCard.add(petPanel3, "wrap");
		resetPetView();
		clearSelections.setPreferredSize(buttonSize);
		PCCard.add(clearSelections);
		next_player.setPreferredSize(buttonSize);
		next_player.setEnabled(false);
		PCCard.add(next_player, "skip 1, growx");
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
		petPanel.setPreferredSize(new Dimension(185,270));
		if(count == 1)
		{
			petName1.setPreferredSize(buttonSize);
			petPanel.add(petPicLabel1);
			petPanel.add(petStatLabel1);
			petPanel.add(petName1, "gaptop 10, grow, wrap");
			//petNameAccepted1.setText("Name your pet");
			petPanel.add(petNameAccepted1, "skip 2");
		}
		else if(count == 2)
		{
			petPanel.add(petPicLabel2);
			petPanel.add(petStatLabel2);
			petPanel.add(petName2, "gaptop 10, grow, wrap");
			petName2.setPreferredSize(buttonSize);
			petPanel.add(petNameAccepted2, "skip 2");
		}
		else if(count == 3)
		{
			petPanel.add(petPicLabel3);
			petPanel.add(petStatLabel3);
			petPanel.add(petName3, "gaptop 10, grow, wrap");
			petName3.setPreferredSize(buttonSize);
			petPanel.add(petNameAccepted3, "skip 2");
		}
		petPanel.setVisible(false);
		
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
				petPanel1.setVisible(false);
				petName1.setText(null);
			}
			else
			{
				petPicLabel1.setIcon(m_model.defaultPets.get(newPet).icon);
				petStatLabel1.setText(m_model.defaultPets.get(newPet).getStatsString());
				petPanel1.setVisible(true);
			}
		}
		else if(labelNum == 2)
		{
			if(newPet == " ")
			{
				petPanel2.setVisible(false);
				petName2.setText(null);
			}
			else
			{
				petPicLabel2.setIcon(m_model.defaultPets.get(newPet).icon);
				petStatLabel2.setText(m_model.defaultPets.get(newPet).getStatsString());
				petPanel2.setVisible(true);
			}
		}
		else if(labelNum == 3)
		{
			if(newPet == " ")
			{
				petPanel3.setVisible(false);
				petName3.setText(null);
			}
			else
			{
				petPicLabel3.setIcon(m_model.defaultPets.get(newPet).icon);
				petStatLabel3.setText(m_model.defaultPets.get(newPet).getStatsString());
				petPanel3.setVisible(true);
			}
		}

		if(!(petPanel1.isVisible() || petPanel2.isVisible() || petPanel3.isVisible()))
			isOnePetVisible = false;
		else
			isOnePetVisible = true;
		allFieldsAccepted();
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
	
	protected void addComboBoxListener(ItemListener cil1, ItemListener cil2, ItemListener cil3)
	{
		petsCombo1.addItemListener(cil1);
		petsCombo2.addItemListener(cil2);
		petsCombo3.addItemListener(cil3);
	}
	
	protected void addTextFieldListener(DocumentListener ndl, DocumentListener pndl1, DocumentListener pndl2, DocumentListener pndl3)
	{
		nameField.getDocument().addDocumentListener(ndl);
		petName1.getDocument().addDocumentListener(pndl1);
		petName2.getDocument().addDocumentListener(pndl2);
		petName3.getDocument().addDocumentListener(pndl3);
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
		petNames.add(petName1.getText());
		petNames.add(petName2.getText());
		petNames.add(petName3.getText());
		return petNames;
	}
	
	protected void resetPetView()
	{
		petsCombo1.setSelectedItem(" ");
		petsCombo2.setSelectedItem(" ");
		petsCombo3.setSelectedItem(" ");
		
		petStatLabel1.setText(null);
		petPicLabel1.setIcon(null);
		petPanel1.setVisible(false);
		petName1.setText(null);
		
		petStatLabel2.setText(null);
		petPicLabel2.setIcon(null);
		petPanel2.setVisible(false);
		petName2.setText(null);
		
		petStatLabel3.setText(null);
		petPicLabel3.setIcon(null);
		petPanel3.setVisible(false);
		petName3.setText(null);
		
		nameField.setText(null);
		playerNameTaken(true);
		petNameTaken(true, 0);
		petNameTaken(true, 1);
		petNameTaken(true, 2);
		next_player.setEnabled(false);
		allFieldsAccepted();
	}
	
	protected void nextPlayer(int num)
	{
		resetPetView();
		playerNum.setText("Player " + num + ", What is your name?");
	}
	
	protected void changeView(String view)
	{
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, view);
		curView = view;
		
	}
	
	protected void playerNameTaken(Boolean isTaken)
	{
		if(isTaken)
		{
			nameAccepted.setIcon(cross);
			isPlayerNameAccepted = false;
		}
		else
		{
			nameAccepted.setIcon(tick);
			isPlayerNameAccepted = true;
		}
		
		allFieldsAccepted();
	}
	
	protected void petNameTaken(Boolean isTaken, int fieldNum)
	{
		if(isTaken)
		{
			if(fieldNum == 0)
			{
				petNameAccepted1.setIcon(cross);
				isPetName1Accepted = false;
			}		
			else if(fieldNum == 1)
			{
				petNameAccepted2.setIcon(cross);
				isPetName2Accepted = false;
			}
			else if(fieldNum == 2)
			{
				petNameAccepted3.setIcon(cross);
				isPetName3Accepted = false;
			}
		}
		else
		{
			if(fieldNum == 0 && petPanel1.isVisible())
			{
				petNameAccepted1.setIcon(tick);
				isPetName1Accepted = true;
			}		
			else if(fieldNum == 1 && petPanel2.isVisible())
			{
				petNameAccepted2.setIcon(tick);
				isPetName2Accepted = true;
			}
			else if(fieldNum == 2 && petPanel3.isVisible())
			{
				petNameAccepted3.setIcon(tick);
				isPetName3Accepted = true;
			}
		}
		
		allFieldsAccepted();
	}
	
	protected void allFieldsAccepted()
	{
		if(isPlayerNameAccepted && isOnePetVisible)
		{
			if(( (petPanel1.isVisible() && isPetName1Accepted) || !(petPanel1.isVisible()) ) && 
					( (petPanel2.isVisible() && isPetName2Accepted) || !(petPanel2.isVisible()) ) &&
					( (petPanel3.isVisible() && isPetName3Accepted) || !(petPanel3.isVisible()) )
					 )
				next_player.setEnabled(true);
			else
			{
				next_player.setEnabled(false);
			}
		}
		else
		{
			next_player.setEnabled(false);
		}
	}
	
	protected String getPlayerName()
	{
		return nameField.getText();
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
