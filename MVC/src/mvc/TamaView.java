package mvc;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;

public class TamaView {
	
	private TamaModel m_model;
	
	public JFrame frame = new JFrame("Tamagotchi");
	private JPanel cards;
	protected GuiStartGame viewSetup;
	protected GuiPlayerCreation playerCreationGUI;
	protected GuiMainGameLoop mainGameLoopGUI;
	
	private String curView = "Menu";
	
	
	

	public TamaView(TamaModel model)
	{
		m_model = model;
		viewSetup = new GuiStartGame(m_model);
		playerCreationGUI = new GuiPlayerCreation(m_model);
		mainGameLoopGUI = new GuiMainGameLoop(m_model);
		initialise();
		changeView(curView);
		
	}
	
	private void initialise()
	{
		//Make Menu card
		JPanel menuCard = viewSetup.buildMainMenuPanel();
		
		//Make Help menu card
		JPanel helpCard = viewSetup.buildHelpPanel();
		
		//Make the number of players and days card
		JPanel setupCard = viewSetup.buildSetupPanel();
		
		//Make the player creator card
		JPanel playerCreatorCard = playerCreationGUI.buildPlayerCreatorPanel();
		
		//Main game
		JPanel mainGameCard = mainGameLoopGUI.buildMainGameCard();
		
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
		frame.setPreferredSize(new Dimension(1100, 700));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
	}
	
	public void dayOver()
	{
		JOptionPane.showMessageDialog(frame, "Day " + m_model.getCurDay() + " over!");
	}
	
	protected void addButtonListener(ActionListener bal)
	{
		viewSetup.addButtonListener(bal);
		mainGameLoopGUI.addButtonListener(bal);
	}
	
	protected void changeView(String view)
	{
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, view);
		curView = view;	
	}

	protected String getCurrentView()
	{
		return curView;
	}
	
	public void disableGame()
	{
		frame.setEnabled(false);
	}
	
	public void enableGame()
	{
		frame.setEnabled(true);
	}
	
	public Food showFeedOptions(Player player)
	{
		ArrayList<Food> foods = player.getFood();
		
		Food[] foodArray = foods.toArray(new Food[0]);
		
		if(foodArray.length != 0)
		{
			Food s = (Food)JOptionPane.showInputDialog(
					frame, 
					"What do you want to feed your pet?",
					"Feed",
					JOptionPane.PLAIN_MESSAGE,
					null,
					foodArray,
					foodArray[0]);
			return s;
		}
		
		else
		{
			JOptionPane.showMessageDialog(frame, "You don't have any food :(\n" + "Go buy some in the Store.");
			return null;
		}
	}
	
	public Toy showPlayOptions(Player player)
	{
		ArrayList<Toy> toys = player.getToys();
		
		Toy[] toyArray = toys.toArray(new Toy[0]);
		
		if(toyArray.length != 0)
		{
			Toy s = (Toy)JOptionPane.showInputDialog(
					frame, 
					"What toy do you want to your pet to play with?",
					"Play",
					JOptionPane.PLAIN_MESSAGE,
					null,
					toyArray,
					toyArray[0]);
			return s;
		}
		
		else
		{
			JOptionPane.showMessageDialog(frame, "You don't have any toys :( \n" + "Go buy some in the Store.");
			return null;
		}
	}
	
	public void showErrorDialog()
	{
		JOptionPane.showMessageDialog(frame, "An error was caught somewhere");
	}
	
	public void toyBrokeDialog(Toy brokenToy)
	{
		JOptionPane.showMessageDialog(frame, "Oh no, your pet broke the " + brokenToy.getName());
	}
	
	public Boolean showPetReviveDialog(Player player, Pet pet)
	{
		int revive = (Integer)JOptionPane.showOptionDialog(frame, "<html><font size='5'>Oh no " + player.name + ", your pet " + pet.getName() + " died! <br>" + "Do you want to revive it</font></html>", "Uh oh", 0, 1, null, null, null);
		if(revive == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void showPetDiedDialog(Player player, Pet pet)
	{
		JOptionPane.showMessageDialog(frame, "Oh no " + player.name + "\n" + "Your pet " + pet.getName() + " died again!");
	}
	
	public Boolean showPetSickDialog(Player sickPlayer, Pet sickPet)
	{
		int giveMedicine = (Integer)JOptionPane.showOptionDialog(frame, "Oh no, player " + sickPlayer.name + "'s pet " + sickPet.getName() + " got sick! \n" + "Do you want to give it medicine for $10?", "Uh oh", 0, 1, null, null, null);
		if(giveMedicine == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Boolean showPetMisbehavingDialog(Player behavePlayer, Pet behavePet)
	{
		int punish = (Integer)JOptionPane.showOptionDialog(frame, "Oh no, player " + behavePlayer.name + "'s pet " + behavePet.getName() + " is misbehaving! \n" + "Do you want to correct this behaviour?", "Uh oh", 0, 1, null, null, null);
		if(punish == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
