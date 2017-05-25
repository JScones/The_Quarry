package mvc;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

/**
 * This class handles the creation of the GUI for the main game, the section where the game is played.
 * 
 * @author Josh & Jack
 *
 */
public class GuiMainGameLoop {
	
	private TamaModel m_model;
	
	private Dimension buttonSize = new Dimension(225, 50);
	
	private Font allFont = new Font(null, Font.BOLD, 20);

	private ImageIcon sad = new ImageIcon("resources/sad.png");
	
	private JLabel dayLabel = new JLabel("Day");
	
	private JLabel mainGamePetStat1 = new JLabel();
	private JLabel mainGamePetStat2 = new JLabel();
	private JLabel mainGamePetStat3 = new JLabel();
	private JLabel[] mainGamePetStats = {mainGamePetStat1, mainGamePetStat2, mainGamePetStat3};
	
	private JLabel petStatus1 = new JLabel();
	private JLabel petStatus2 = new JLabel();
	private JLabel petStatus3 = new JLabel();
	private JLabel[] petStatusLabels = {petStatus1, petStatus2, petStatus3};
	
	private JLabel nameLabel = new JLabel();
	
	private JButton nextPet = new JButton("Next Pet");
	
	private JButton playPet1 = new JButton("Play");
	private JButton playPet2 = new JButton("Play");
	private JButton playPet3 = new JButton("Play");
	private JButton[] playPetButtons = {playPet1, playPet2, playPet3};
	
	private JButton feedPet1 = new JButton("Feed");
	private JButton feedPet2 = new JButton("Feed");
	private JButton feedPet3 = new JButton("Feed");
	private JButton[] feedPetButtons = {feedPet1, feedPet2, feedPet3};
	
	private JButton toiletPet1 = new JButton("Toilet");
	private JButton toiletPet2 = new JButton("Toilet");
	private JButton toiletPet3 = new JButton("Toilet");
	private JButton[] toiletPetButtons = {toiletPet1, toiletPet2, toiletPet3};
	
	private JButton sleepPet1 = new JButton("Sleep");
	private JButton sleepPet2 = new JButton("Sleep");
	private JButton sleepPet3 = new JButton("Sleep");
	private JButton[] sleepPetButtons = {sleepPet1, sleepPet2, sleepPet3};
	
	private JProgressBar hungerBar1 = new JProgressBar();
	private JProgressBar hungerBar2 = new JProgressBar();
	private JProgressBar hungerBar3 = new JProgressBar();
	private JProgressBar[] hungerBars = {hungerBar1, hungerBar2, hungerBar3};
	
	private JProgressBar energyBar1 = new JProgressBar();
	private JProgressBar energyBar2 = new JProgressBar();
	private JProgressBar energyBar3 = new JProgressBar();
	private JProgressBar[] energyBars = {energyBar1, energyBar2, energyBar3};
	
	private JProgressBar toiletBar1 = new JProgressBar();
	private JProgressBar toiletBar2 = new JProgressBar();
	private JProgressBar toiletBar3 = new JProgressBar();
	private JProgressBar[] toiletBars = {toiletBar1, toiletBar2, toiletBar3};
	
	private JProgressBar healthBar1 = new JProgressBar();
	private JProgressBar healthBar2 = new JProgressBar();
	private JProgressBar healthBar3 = new JProgressBar();
	private JProgressBar[] healthBars = {healthBar1, healthBar2, healthBar3};
	
	private JLabel petNameSpecies1 = new JLabel();
	private JLabel petNameSpecies2 = new JLabel();
	private JLabel petNameSpecies3 = new JLabel();
	private JLabel[] petNameSpecies = {petNameSpecies1, petNameSpecies2, petNameSpecies3};
	
	private JLabel mood1 = new JLabel();
	private JLabel mood2 = new JLabel();
	private JLabel mood3 = new JLabel();
	private JLabel[] moods = {mood1, mood2, mood3};
	
	private JLabel favToy1 = new JLabel();
	private JLabel favToy2 = new JLabel();
	private JLabel favToy3 = new JLabel();
	private JLabel[] favToyLabels = {favToy1, favToy2, favToy3};
	
	private JButton storeButton = new JButton("Store");
	private JButton nextDay = new JButton("End my day");
	
	private JPanel petStatBars1 = buildPetStatBars(0);
	private JPanel petStatBars2 = buildPetStatBars(1);
	private JPanel petStatBars3 = buildPetStatBars(2);
	private JPanel[] petStatBars = {petStatBars1, petStatBars2, petStatBars3};
	
	private JPanel petTab1 = buildPetTab(0);
	private JPanel petTab2 = buildPetTab(1);
	private JPanel petTab3 = buildPetTab(2);
	private JTabbedPane mainGameTabbedPane = buildMainGameTab();
	

	public GuiMainGameLoop(TamaModel model)
	{
		m_model = model;
	}
	
	/**
	 * Creates a <code>JPanel</code> and populates it with place holders for:
	 * 		The players name.
	 * 		A <code>TabbedPane</code> displaying the players pets and action buttons.
	 * 		Buttons for accessing the store, going to the next pet and ending a turn.
	 * 		The current day and number of days total.
	 * 
	 * If a players pet has used all its actions for that day or it is dead, the action 
	 * buttons are disabled.
	 * The Next Pet button is disabled when the player is viewing their last pet, and players 
	 * cannot go back to a pet once they have clicked next pet, until their next turn.
	 * 
	 * The <code>TabbedPane</code> displays bars for a pets hunger, energy, toilet and health,
	 * as well as the number of actions left, lives left and whether the pet is sick.
	 * 
	 * @return A <code>JPanel</code> with all the necessary components for playing the game.
	 */
	public JPanel buildMainGameCard()
	{
		MigLayout Layout = new MigLayout(
				"flowy, fill, insets 20", 
				"[][]",
				"[]");
		
		JPanel mainGamePanel = new JPanel();
		mainGamePanel.setLayout(Layout);
		
		nameLabel.setFont(allFont);
		dayLabel.setFont(allFont);
		storeButton.setPreferredSize(buttonSize);
		nextPet.setPreferredSize(buttonSize);
		nextDay.setPreferredSize(buttonSize);
		dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		mainGamePanel.add(nameLabel);
		mainGamePanel.add(mainGameTabbedPane, "push, grow, wrap");
		mainGamePanel.add(dayLabel, "grow, skip 1, split 4");
		mainGamePanel.add(storeButton, "gaptop 100, gapbottom 100");
		mainGamePanel.add(nextPet, "gaptop 100, gapbottom 100");
		mainGamePanel.add(nextDay, "gaptop 100, gapbottom 100");
		
		return mainGamePanel;
	}
	
	private JPanel buildPetTab(int tabNum)
	{
		MigLayout Layout = new MigLayout(
				"fill, insets 20", 
				"[][][]",
				"[][]");
		
		JPanel MGCard = new JPanel();
		MGCard.setLayout(Layout);
		
//		mainGamePetStats[tabNum].setFont(allFont);
//		mainGamePetStats[tabNum].setPreferredSize(new Dimension(300, 300));
//		MGCard.add(mainGamePetStats[tabNum]);
		petStatBars[tabNum].setPreferredSize(new Dimension(400, 300));
		MGCard.add(petStatBars[tabNum]);
		
		petStatusLabels[tabNum].setText("Actions Left: ");
		petStatusLabels[tabNum].setFont(allFont);
		MGCard.add(petStatusLabels[tabNum], "wrap");
		
		playPetButtons[tabNum].setActionCommand("play " + tabNum);
		MGCard.add(playPetButtons[tabNum], "span 2, split 4, growx");
		
		feedPetButtons[tabNum].setActionCommand("feed " + tabNum);
		MGCard.add(feedPetButtons[tabNum], "growx");
		
		toiletPetButtons[tabNum].setActionCommand("toilet " + tabNum);
		MGCard.add(toiletPetButtons[tabNum], "growx");
		
		sleepPetButtons[tabNum].setActionCommand("sleep " + tabNum);
		MGCard.add(sleepPetButtons[tabNum], "growx");
		
		
		return MGCard;
	}
	
	private JTabbedPane buildMainGameTab()
	{
		JTabbedPane mainTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		mainTabbedPane.addTab(null, null, petTab1, "Pet 1");
		mainTabbedPane.addTab(null, null, petTab2, "Pet 2");
		mainTabbedPane.addTab(null, null, petTab3, "Pet 3");
		
		return mainTabbedPane;
	}
	
	/**
	 * Changes the place holder
	 * @param player
	 */
	public void setMainGameTab(Player player)
	{
		int numPets = player.getPets().size();
		mainGameTabbedPane.removeAll();
		mainGameTabbedPane.addTab(null, null, petTab1, "Pet 1");
		mainGameTabbedPane.addTab(null, null, petTab2, "Pet 2");
		mainGameTabbedPane.addTab(null, null, petTab3, "Pet 3");
		nameLabel.setText("Player: " + player.name);
		nextPet.setActionCommand("donePet1");
		nextPet.setText("Next Pet");
		dayLabel.setText("<html><p>Day " + m_model.getCurDay() + " of " + m_model.getNumDays() + "</p><html>");
		enablePetActionButtons();
		
		if(numPets == 1)
		{
			Boolean petAlive1 = player.getPets().get(0).checkAlive();
			enablePetActionButtons(petAlive1, 0);
			
			mainGameTabbedPane.setIconAt(0, player.getPets().get(0).icon);
			mainGameTabbedPane.removeTabAt(1);
			mainGameTabbedPane.removeTabAt(1);
			nextPet.setEnabled(false);
			
			if(petAlive1)
			{
				updatePetBars(0, player.getPets().get(0));
	
				
				petStatus1.setText(getPetStatus(player.getPets().get(0)));
				petStatus2.setText(null);
				petStatus3.setText(null);
			}
			else
			{				
				petStatus1.setText("<html><font size='30' face='Comic Sans MS' color='red'>it Ded</font></html>");
				petStatus1.setIcon(sad);
				petStatus2.setText(null);
				petStatus3.setText(null);
			}
			
		}
		else if(numPets == 2)
		{
			Boolean petAlive1 = player.getPets().get(0).checkAlive();
			enablePetActionButtons(petAlive1, 0);
			Boolean petAlive2 = player.getPets().get(1).checkAlive();
			enablePetActionButtons(petAlive2, 1);
			
			
			mainGameTabbedPane.setIconAt(0, player.getPets().get(0).icon);
			mainGameTabbedPane.setIconAt(1, player.getPets().get(1).icon);
			mainGameTabbedPane.removeTabAt(2);
			
			mainGameTabbedPane.setEnabledAt(1, false);
			nextPet.setEnabled(true);
			
			if(petAlive1)
			{
				petStatus1.setText(player.getPets().get(0).getStatsString());
			}
			else
			{
				petStatus1.setText("<html><font face='Comic Sans MS'>Ded</font></html>");
				petStatus1.setIcon(sad);
			}
			
			if(petAlive2)
			{
				petStatus2.setText(player.getPets().get(1).getStatsString());
			}
			else
			{
				petStatus2.setText("<html><font face='Comic Sans MS'>Ded</font></html>");
				petStatus2.setIcon(sad);
			}
			
			petStatus3.setText(null);
			
			updatePetBars(0, player.getPets().get(0));
			updatePetBars(1, player.getPets().get(1));
			
		}
		else if(numPets == 3)
		{
			Boolean petAlive1 = player.getPets().get(0).checkAlive();
			enablePetActionButtons(petAlive1, 0);
			Boolean petAlive2 = player.getPets().get(1).checkAlive();
			enablePetActionButtons(petAlive2, 1);
			Boolean petAlive3 = player.getPets().get(0).checkAlive();
			enablePetActionButtons(petAlive3, 2);
			
			nextPet.setEnabled(true);
			
			mainGameTabbedPane.setIconAt(0, player.getPets().get(0).icon);
			mainGameTabbedPane.setIconAt(1, player.getPets().get(1).icon);
			mainGameTabbedPane.setIconAt(2, player.getPets().get(2).icon);
			
			mainGameTabbedPane.setEnabledAt(1, false);
			mainGameTabbedPane.setEnabledAt(2, false);
			
			if(petAlive1)
			{
				petStatus1.setText(player.getPets().get(0).getStatsString());
			}
			else
			{
				petStatus1.setText("<html><font face='Comic Sans MS'>Ded</font></html>");
				petStatus1.setIcon(sad);
			}
			
			if(petAlive2)
			{
				petStatus2.setText(player.getPets().get(1).getStatsString());
			}
			else
			{
				petStatus2.setText("<html><font face='Comic Sans MS'>Ded</font></html>");
				petStatus2.setIcon(sad);
			}
			
			if(petAlive3)
			{
				petStatus3.setText(getPetStatus(player.getPets().get(2)));
			}
			else
			{
				petStatus3.setText("<html><font face='Comic Sans MS'>Ded</font></html>");
				petStatus3.setIcon(sad);
			}
			
			updatePetBars(0, player.getPets().get(0));
			updatePetBars(1, player.getPets().get(1));
			updatePetBars(2, player.getPets().get(2));
		}
	}
	
	public void updateDayCount()
	{
		dayLabel.setText("<html><p>Day " + m_model.getCurDay() + " of " + m_model.getNumDays() + "</p><html>");
	}
	
	public void changePetTab(Pet pet, int tab)
	{
		enablePetActionButtons(pet.checkAlive(), tab);
		
		if(tab == 1)
		{
			mainGameTabbedPane.setEnabledAt(tab, true);
			mainGameTabbedPane.setSelectedIndex(tab);
			
			mainGameTabbedPane.setEnabledAt(0, false);
			
			if(mainGameTabbedPane.getTabCount() == 2)
			{
				nextPet.setEnabled(false);
			}
			else
			{
				nextPet.setActionCommand("donePet2");
				nextPet.setText("Next Pet");
			}
		}
		
		if(tab == 2)
		{
			mainGameTabbedPane.setEnabledAt(tab, true);
			mainGameTabbedPane.setSelectedIndex(tab);
			
			mainGameTabbedPane.setEnabledAt(0, false);
			mainGameTabbedPane.setEnabledAt(1, false);
			
			nextPet.setEnabled(false);
		}
	}
	
	public void enablePetActionButtons(boolean enable, int petNum)
	{
		feedPetButtons[petNum].setEnabled(enable);
		playPetButtons[petNum].setEnabled(enable);
		sleepPetButtons[petNum].setEnabled(enable);
		toiletPetButtons[petNum].setEnabled(enable);
	}
	
	public void enablePetActionButtons()
	{
		for(int i = 0; i<3; i++)
		{
			feedPetButtons[i].setEnabled(true);
			playPetButtons[i].setEnabled(true);
			sleepPetButtons[i].setEnabled(true);
			toiletPetButtons[i].setEnabled(true);
		}
	}
	
	private JPanel buildPetStatBars(int tabNum)
	{
		
		JPanel statBarHolder = new JPanel();
		
		MigLayout Layout = new MigLayout(
				"fill, insets 20", 
				"[][]",
				"[][][][]");
		
		statBarHolder.setLayout(Layout);
		
		JProgressBar hungerBar = hungerBars[tabNum];
		hungerBar.setStringPainted(true);
		JProgressBar energyBar = energyBars[tabNum];
		energyBar.setStringPainted(true);
		JProgressBar toiletBar = toiletBars[tabNum];
		toiletBar.setStringPainted(true);
		JProgressBar healthBar = healthBars[tabNum];
		healthBar.setStringPainted(true);
		
		JLabel hunger = new JLabel("Hunger:");
		hunger.setFont(allFont);
		JLabel energy = new JLabel("Energy:");
		energy.setFont(allFont);
		JLabel toilet = new JLabel("Toilet:");
		toilet.setFont(allFont);
		JLabel health = new JLabel("Health: ");
		health.setFont(allFont);
		JLabel mood = new JLabel("Mood: ");
		mood.setFont(allFont);
		JLabel favToy = new JLabel("Favourite toy: ");
		favToy.setFont(allFont);
		
		petNameSpecies[tabNum].setFont(allFont);
		moods[tabNum].setFont(allFont);
		favToyLabels[tabNum].setFont(allFont);
		
		statBarHolder.add(petNameSpecies[tabNum], "span, wrap");
		statBarHolder.add(hunger);
		statBarHolder.add(hungerBar, "wrap, growx");
		statBarHolder.add(energy);
		statBarHolder.add(energyBar, "wrap, growx");
		statBarHolder.add(toilet);
		statBarHolder.add(toiletBar, "wrap, growx");
		statBarHolder.add(health);
		statBarHolder.add(healthBar, "wrap, growx");
		statBarHolder.add(mood);
		statBarHolder.add(moods[tabNum], "wrap, growx");
		statBarHolder.add(favToy);
		statBarHolder.add(favToyLabels[tabNum], "wrap");
		
		return statBarHolder;
	}
	
	public void updatePetBars(int petNum, Pet pet)
	{
		petStatusLabels[petNum].setText(getPetStatus(pet));
		petNameSpecies[petNum].setText(pet.toString());
		int[] barStats = pet.getBarStats();
		
		hungerBars[petNum].setMaximum(barStats[1]);
		hungerBars[petNum].setValue(barStats[0]);
		energyBars[petNum].setMaximum(barStats[3]);
		energyBars[petNum].setValue(barStats[2]);
		toiletBars[petNum].setMaximum(10);
		toiletBars[petNum].setValue(barStats[4]);
		healthBars[petNum].setMaximum(barStats[6]);
		healthBars[petNum].setValue(barStats[5]);
		
		moods[petNum].setText(pet.getMood());
		favToyLabels[petNum].setText(pet.getFavToy());
		
		
	}
	
	public void updatePetStats(int petNum, Player player)
	{
		mainGamePetStats[petNum].setText(player.getPets().get(petNum).getStatsString());
		petStatusLabels[petNum].setText(getPetStatus(player.getPets().get(petNum)));
	}
	
	public void addMainGameLoopListener(ActionListener mglal)
	{
		storeButton.addActionListener(mglal);
		nextDay.addActionListener(mglal);
		
		for(JButton play : playPetButtons)
		{
			play.addActionListener(mglal);
		}
		
		for(JButton feed : feedPetButtons)
		{
			feed.addActionListener(mglal);
		}
		
		for(JButton toilet : toiletPetButtons)
		{
			toilet.addActionListener(mglal);
		}
		
		for(JButton sleep : sleepPetButtons)
		{
			sleep.addActionListener(mglal);
		}
	}
	
	public void addButtonListener(ActionListener bal)
	{
		nextPet.addActionListener(bal);
	}
	
	private String getPetStatus(Pet pet)
	{
		String sick = "";
		if(pet.checkSick())
		{
			sick = "Yes";
		}
		else
		{
			sick = "No";
		}
		
		String out = (
				"<html><p>"
				+ "Actions left: " + pet.getActionsLeft() + "<br /><br />"
				+ "Lives left: " + pet.getLivesLeft() + "<br /><br />"
				+ "Is sick: " + sick
				);
				
		return out;
	}
}
