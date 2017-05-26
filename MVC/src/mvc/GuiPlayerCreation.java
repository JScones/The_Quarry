package mvc;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentListener;

import net.miginfocom.swing.MigLayout;

/**
 * This class handles the creation of the GUI for the section of the game
 * where players enter their names and choose their pets.
 * 
 * 
 *
 */
public class GuiPlayerCreation {
	
	private TamaModel m_model;

	private Font allFont = new Font(null, Font.BOLD, 20);
	private Dimension buttonSize = new Dimension(225, 50);
	
	private ImageIcon tick = new ImageIcon(GuiPlayerCreation.class.getResource("/resources/tick.png"));
	private ImageIcon cross = new ImageIcon(GuiPlayerCreation.class.getResource("/resources/cross.png"));
	
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
	
	private JButton next_player = new JButton("Next");
	private JButton clearSelections = new JButton("Clear");
	
	private JTextField nameField = new JTextField();
	private JTextField petName1 = new JTextField();
	private JTextField petName2 = new JTextField();
	private JTextField petName3 = new JTextField();
	
	private JPanel petPanel1 = createPetPanel(1);
	private JPanel petPanel2 = createPetPanel(2);
	private JPanel petPanel3 = createPetPanel(3);
	
	private JComboBox<String> petsCombo1 = new JComboBox<String>();
	private JComboBox<String> petsCombo2 = new JComboBox<String>();
	private JComboBox<String> petsCombo3 = new JComboBox<String>();
	
	private Boolean isPlayerNameAccepted = false;
	private Boolean isPetName1Accepted = false;
	private Boolean isPetName2Accepted = false;
	private Boolean isPetName3Accepted = false;
	private Boolean isOnePetVisible = false;
	
	public GuiPlayerCreation(TamaModel model)
	{
		//allows access to the number of players expected, and the default stats of all the pets
		m_model = model;
	}
	
	/**
	 * Creates a <code>JPanel</code> and populates it with a field for name entry, 3 dropdown boxes
	 * for selecting up to 3 pets, and a next button.
	 * 
	 * If a pet is selected in one of the boxes a pet Panel is shown, displaying the stats of
	 * that species and a field for entering the name of the pet.
	 * 
	 * The next button remains disabled until the player has entered a valid name (a tick appears)
	 * and has at least one pet with a valid name.
	 * 
	 * The clear button clears all text fields and resets all dropdown boxes to nothing.
	 * 
	 * @return A <code>JPanel</code> with all the necessary components for player creation.
	 */
	public JPanel buildPlayerCreatorPanel()
	{
		MigLayout Layout = new MigLayout(
				"fill, insets 20, wrap 3", 
				"[][][][]",
				"[][][][]");
		
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
		PCCard.add(petPanel1, "align center, hmin 310");
		PCCard.add(petPanel2, "align center, hmin 310");
		PCCard.add(petPanel3, "align center, hmin 310, wrap");
		resetPetView();
		clearSelections.setPreferredSize(buttonSize);
		PCCard.add(clearSelections);
		next_player.setPreferredSize(buttonSize);
		next_player.setEnabled(false);
		PCCard.add(next_player, "skip 1, growx");
		return PCCard;
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
	
	private JPanel createPetPanel(int count)
	{
		MigLayout Layout = new MigLayout(
				"fill, insets 20, wrap 1", 
				"[][]",
				"[][]");
		
		JPanel petPanel = new JPanel();
		petPanel.setLayout(Layout);
		//petPanel.setLayout(new BoxLayout(petPanel, BoxLayout.Y_AXIS));
		petPanel.setPreferredSize(new Dimension(300, 270));
		
		petStatLabel1.setFont(allFont);
		petStatLabel2.setFont(allFont);
		petStatLabel3.setFont(allFont);
		
		if(count == 1)
		{
			petName1.setPreferredSize(buttonSize);
			petPanel.add(petPicLabel1, "align center");
			petPanel.add(petStatLabel1, "align center");
			petPanel.add(petName1, "gaptop 10, grow, split 2");
			//petNameAccepted1.setText("Name your pet");
			petPanel.add(petNameAccepted1);
		}
		else if(count == 2)
		{
			petPanel.add(petPicLabel2, "align center");
			petPanel.add(petStatLabel2, "align center");
			petPanel.add(petName2, "gaptop 10, grow, split 2");
			petName2.setPreferredSize(buttonSize);
			petPanel.add(petNameAccepted2);
		}
		else if(count == 3)
		{
			petPanel.add(petPicLabel3, "align center");
			petPanel.add(petStatLabel3, "align center");
			petPanel.add(petName3, "gaptop 10, grow, split 2");
			petName3.setPreferredSize(buttonSize);
			petPanel.add(petNameAccepted3);
		}
		petPanel.setVisible(false);
		
		return petPanel;
	}
	
	/**
	 * Displays a panel showing the stats of the species of pet given by <code>newPet</code>
	 * underneath the correct <code>ComboBox</code>.
	 * 
	 * If nothing is selected <code>newPet</code> is " " (a space) and the panel is hidden.
	 * 
	 * @param newPet a String identifying the species of the pet selected in the <code>ComboBox</code>
	 * @param labelNum an Int identifying which <code>ComboBox</code> the pet is selected in.
	 */
	public void updatePetPanel(String newPet, int labelNum)
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
				petStatLabel1.setText("<html>" + m_model.defaultPets.get(newPet).getStatsString() + "</html>");
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
				petStatLabel2.setText("<html>" + m_model.defaultPets.get(newPet).getStatsString() + "</html>");
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
				petStatLabel3.setText("<html>" + m_model.defaultPets.get(newPet).getStatsString() + "</html>");
				petPanel3.setVisible(true);
			}
		}

		if(!(petPanel1.isVisible() || petPanel2.isVisible() || petPanel3.isVisible()))
			isOnePetVisible = false;
		else
			isOnePetVisible = true;
		allFieldsAccepted();
	}
	
	/**
	 * Resets the entire view, ready for another player to enter their name and choose
	 * their pets.
	 * 
	 * @param num the number of the current player entering their details.
	 */
	public void nextPlayer(int num)
	{
		resetPetView();
		playerNum.setText("Player " + num + ", What is your name?");
	}
	
	/**
	 * Resets the player creation screen by clearing all text fields and reseting all comboBoxes.
	 */
	public void resetPetView()
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
	
	public ArrayList<String> getPetSpeciesSelections()
	{
		ArrayList<String> petSpecies = new ArrayList<String>();
		petSpecies.add((String)petsCombo1.getSelectedItem());
		petSpecies.add((String)petsCombo2.getSelectedItem());
		petSpecies.add((String)petsCombo3.getSelectedItem());
		
		return petSpecies;
	}
	
	public ArrayList<String> getPetNames()
	{
		ArrayList<String> petNames = new ArrayList<String>();
		petNames.add(petName1.getText());
		petNames.add(petName2.getText());
		petNames.add(petName3.getText());
		return petNames;
	}

	public void playerNameTaken(Boolean isTaken)
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
	
	public void petNameTaken(Boolean isTaken, int fieldNum)
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
	
	public void allFieldsAccepted()
	{
		if (isPlayerNameAccepted && isOnePetVisible)
		{
			if (((petPanel1.isVisible() && isPetName1Accepted) || !(petPanel1.isVisible()))
					&& ((petPanel2.isVisible() && isPetName2Accepted) || !(petPanel2.isVisible()))
					&& ((petPanel3.isVisible() && isPetName3Accepted) || !(petPanel3.isVisible()))
					 )
			{
				next_player.setEnabled(true);
			}
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
	
	public String getPlayerName()
	{
		return nameField.getText();
	}
	
	public void addButtonListener(ActionListener bal)
	{
		next_player.addActionListener(bal);
		petsCombo1.addActionListener(bal);
		petsCombo2.addActionListener(bal);
		petsCombo3.addActionListener(bal);
		clearSelections.addActionListener(bal);
	}
	
	public void addComboBoxListener(ItemListener cil1, ItemListener cil2, ItemListener cil3)
	{
		petsCombo1.addItemListener(cil1);
		petsCombo2.addItemListener(cil2);
		petsCombo3.addItemListener(cil3);
	}
	
	public void addTextFieldListener(DocumentListener ndl, DocumentListener pndl1, DocumentListener pndl2, DocumentListener pndl3)
	{
		nameField.getDocument().addDocumentListener(ndl);
		petName1.getDocument().addDocumentListener(pndl1);
		petName2.getDocument().addDocumentListener(pndl2);
		petName3.getDocument().addDocumentListener(pndl3);
	}
}
