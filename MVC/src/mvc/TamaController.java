package mvc;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.event.*;
import javax.swing.text.BadLocationException;


public class TamaController {

	private TamaModel m_model;
	private TamaView m_view;
	private String lastPetSelected = " ";
	private CreatePlayers playerCreator = new CreatePlayers();
	private ArrayList<String> playerNames = new ArrayList<>();
	private ArrayList<String> petNames = new ArrayList<>();
	private ArrayList<String> curPetNames = new ArrayList<>();
	private int curPlayerNum = 0;
	private Player curPlayer;
	
	public TamaController(TamaModel model, TamaView view)
	{
		m_model = model;
		m_view = view;
		
		view.startGameGUI.addButtonListener(new StartGameButtonListener());
		view.playerCreationGUI.addButtonListener(new PlayerCreationButtonListener());
		view.playerCreationGUI.addComboBoxListener(new ComboBoxListener(1), new ComboBoxListener(2), new ComboBoxListener(3));
		view.playerCreationGUI.addTextFieldListener(new NameTextFieldListener(), new PetNameTextFieldListener(0), new PetNameTextFieldListener(1), new PetNameTextFieldListener(2));
		view.mainGameLoopGUI.addMainGameLoopListener(new MainLoopButtonListener());
		
		curPetNames.add(" ");
		curPetNames.add(" ");
		curPetNames.add(" ");
	}
	
	
	class StartGameButtonListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();

			if(command == "Start")
			{
				m_view.changeView("Setup");
			}
			else if(command == "Help")
			{
				m_view.changeView("Help");
			}
			else if(command == "Back")
			{
				m_view.changeView("Menu");
			}
			else if(command == "Next")
			{
				m_model.setUp(m_view.startGameGUI.getNumPlayers(), m_view.startGameGUI.getNumDays());
				m_view.changeView("Make Player");
			}	
			
		}
	}
	
	class PlayerCreationButtonListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			
			if(command == "Next")
			{
				Player p = playerCreator.makePlayer(m_view.playerCreationGUI.getPlayerName(), m_view.playerCreationGUI.getPetSpeciesSelections(), m_view.playerCreationGUI.getPetNames());
				playerNames.add(m_view.playerCreationGUI.getPlayerName());
				for(int i = 0; i<m_view.playerCreationGUI.getPetNames().size(); i++)
					if(m_view.playerCreationGUI.getPetNames().get(i).equals(" "))
					{
						//Do nothing
					}
					else
						petNames.add(m_view.playerCreationGUI.getPetNames().get(i));
				m_model.addPlayer(p);
				if(!(m_model.enoughPlayers()))
					m_view.playerCreationGUI.nextPlayer(m_model.curNumPlayers() + 1);
				else
				{
					m_model.incrementDay();
					m_view.mainGameLoopGUI.setMainGameTab(m_model.getPlayers().get(0));
					curPlayerNum = 0;
					m_view.changeView("Main Game");
				}
				curPlayer = m_model.getPlayers().get(0);
			}
			else if(command == "Clear")
			{
				m_view.playerCreationGUI.resetPetView();
			}
			else if(command.equals("donePet1"))
			{
				m_view.mainGameLoopGUI.changePetTab(curPlayer.getPets().get(1), 1);
			}
			else if(command.equals("donePet2"))
			{
				m_view.mainGameLoopGUI.changePetTab(curPlayer.getPets().get(2), 2);
			}
		}
	}
	
	class MainLoopButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			String[] commands = command.split(" ");
			curPlayer = m_model.getPlayers().get(curPlayerNum);
			
			if(commands.length == 2)
			{
				int petNum = Integer.parseInt(commands[1]);
				
				if(commands[0].equals("feed"))
				{
					Food food = m_view.showFeedOptions(curPlayer);
					if(food != null)
					{
						curPlayer.getPets().get(petNum).feed(food);
						curPlayer.getFood().remove(food);
					}
				}
				else if(commands[0].equals("play"))
				{
					Toy toy = m_view.showPlayOptions(curPlayer);
					if(toy != null)
					{
						boolean isToyBroken = curPlayer.getPets().get(petNum).playAndBreak(toy);
						if(isToyBroken)
						{
							m_view.toyBrokeDialog(toy);
							curPlayer.getToys().remove(toy);
						}
					}
				}
				else if(commands[0].equals("toilet"))
				{
					curPlayer.getPets().get(petNum).goToilet();
				}
				else if(commands[0].equals("sleep"))
				{
					curPlayer.getPets().get(petNum).sleep();
				}
				
				if(curPlayer.getPets().get(petNum).getActionsLeft() == 0)
				{
					m_view.mainGameLoopGUI.enablePetActionButtons(false, petNum);
				}
				
				checkPetDied(curPlayer, curPlayer.getPets().get(petNum));
				
				m_view.mainGameLoopGUI.updatePetBars((petNum), curPlayer.getPets().get(petNum));
				
			}
			else if(commands[0].equals("Store"))
			{
				m_view.disableGame();
				@SuppressWarnings("unused")
				ShopView shop = new ShopView(curPlayer, m_view);
			}
			else if(command.equals("End my day"))
			{
				curPlayer.dayOver();
				for(Pet pet : curPlayer.getPets())
				{
					checkPetDied(curPlayer, pet);
				}
				
				if(curPlayerNum + 1 < m_model.curNumPlayers())
				{
					curPlayerNum ++;
					curPlayer = m_model.getPlayers().get(curPlayerNum);
					m_view.mainGameLoopGUI.setMainGameTab(m_model.getPlayers().get(curPlayerNum));
					for(int i = 0; i < curPlayer.getPets().size(); i++)
					{
						if(curPlayer.getPets().get(i).checkMisbehave())
						{
				    		boolean punish = m_view.showPetMisbehavingDialog(curPlayer, curPlayer.getPets().get(i));
				    		if(punish)
				    		{
				    			curPlayer.getPets().get(i).notMisbehave();
				    			curPlayer.getPets().get(i).increaseMood(-2);
				    		}
						}
						if(curPlayer.getPets().get(i).checkSick())
						{
							sickPetPopUp(curPlayer, curPlayer.getPets().get(i));
						}
					}
					randomEvents();
				}
				else
				{	
					curPlayerNum = 0;
					curPlayer = m_model.getPlayers().get(curPlayerNum);
					m_view.dayOver();
					m_model.incrementDay();
					if(m_model.getCurDay() == m_model.getNumDays() + 1)
					{
						m_view.endGameGUI.updateScores();
						m_view.changeView("End Game");
					}
					else
					{
						m_view.mainGameLoopGUI.updateDisplayedDayCount();
						m_view.mainGameLoopGUI.setMainGameTab(curPlayer);
						randomEvents();
					}
				}

				
			}
		}
		
		
	    private void randomEvents()
	    {
	    	Random rand = new Random();
	    	int num = rand.nextInt(9);
	    	
	    	if(num == 8)
	    	{
	    		int playerIndex;
	    		if(m_model.curNumPlayers() == 1)
	    		{
	    			playerIndex = 0;
	    		}
	    		else
	    		{
	    			playerIndex = rand.nextInt(m_model.curNumPlayers() - 1);
	    		}
	    		//sick 
	    		Player sickPlayer = m_model.getPlayers().get(playerIndex);
	    		int sickPetIndex;
	    		if(sickPlayer.getPets().size() == 1)
	    		{
	    			sickPetIndex = 0;
	    		}
	    		else
	    		{
	    			sickPetIndex = rand.nextInt(sickPlayer.getPets().size() - 1);
	    		}
	    		Pet sickPet = sickPlayer.getPets().get(sickPetIndex);
	    		sickPet.becomesSick();
	    		sickPetPopUp(sickPlayer, sickPet);
				
	    		
	    	}
	    	
	    	Random rando = new Random();
	    	int behaveNum = rando.nextInt(9);
	    	
	    	if(behaveNum == 8)
	    	{
	    		int behavePlayerIndex;
	    		int behavePetIndex;
	    		if(m_model.curNumPlayers() == 1)
	    		{
	    			behavePlayerIndex = 0;
	    		}
	    		else
	    		{
	    			behavePlayerIndex = rand.nextInt(m_model.curNumPlayers() - 1);
	    		}
	    		Player behavePlayer = m_model.getPlayers().get(behavePlayerIndex);
	    		if(behavePlayer.getPets().size() == 1)
	    		{
	    			behavePetIndex = 0;
	    		}
	    		else
	    		{
	    			behavePetIndex = rand.nextInt(behavePlayer.getPets().size() - 1);
	    		}
	    		Pet behavePet = behavePlayer.getPets().get(behavePetIndex);
	    		behavePet.misbehave();

	    		misbehavePetPopUp(behavePlayer, behavePet);
	    	}
	    }
	    
	    private void sickPetPopUp(Player sickPlayer, Pet sickPet)
	    {
	    	boolean cure = m_view.showPetSickDialog(sickPlayer, sickPet);
	    	m_view.mainGameLoopGUI.updatePetBars(sickPlayer.getPets().indexOf(sickPet), sickPet); //TODO
			if(cure)
			{
				if(sickPlayer.getMoney() >= 10.0)
				{
					sickPlayer.setMoney(sickPlayer.getMoney() - 10.0);
					sickPet.becomesNotSick();
					sickPet.increaseMood(2);
				}
			}	
	    }
	    
	    private void misbehavePetPopUp(Player behavePlayer, Pet behavePet)
	    {
    		boolean punish = m_view.showPetMisbehavingDialog(behavePlayer, behavePet);
    		m_view.mainGameLoopGUI.updatePetBars(behavePlayer.getPets().indexOf(behavePet), behavePet);
    		if(punish)
    		{
    			behavePet.notMisbehave();
    			behavePet.increaseMood(-2);
    			// feel sad? check deliverables
    		}
	    }
	    
	    private void checkPetDied(Player player, Pet pet)
	    {
	    	if(pet.checkAlive() == false)
			{
				if(pet.checkHasDied() == false)
				{
					Boolean revivePet = m_view.showPetReviveDialog(curPlayer, pet);
					if(revivePet == true)
					{
						pet.revive();
					}
					else
					{
						m_view.mainGameLoopGUI.enablePetActionButtons(false, player.getPets().indexOf(pet));
					}
				}
				else
				{
					m_view.showPetDiedDialog(player, pet);
					m_view.mainGameLoopGUI.updatePetBars(player.getPets().indexOf(pet), pet);
					m_view.mainGameLoopGUI.enablePetActionButtons(false, player.getPets().indexOf(pet));
				}
			}
	    	m_view.mainGameLoopGUI.updatePetBars(player.getPets().indexOf(pet), pet);
	    }
	}

	class ComboBoxListener implements ItemListener
	{
		private int boxNum;
		
		public ComboBoxListener(int aBoxNum)
		{
			boxNum = aBoxNum;
		}
		@Override
		public void itemStateChanged(ItemEvent event) {
		       if (event.getStateChange() == ItemEvent.SELECTED) {
		    	   String item = (String)event.getItem();
		    	   lastPetSelected = item;
		    	   m_view.playerCreationGUI.updatePetPanel(lastPetSelected, boxNum);
		    	   if(lastPetSelected.equals(" "))
		    	   {
		    		   curPetNames.set(boxNum - 1, " ");
		    	   }
		    	   lastPetSelected = " ";
		       }
		       m_view.playerCreationGUI.allFieldsAccepted();
		    }  
	}
	
	class NameTextFieldListener implements DocumentListener
	{
		private int curLen = 0;
		private String curName = "";
		
		@Override
	    public void insertUpdate(DocumentEvent e) {
	        curLen += e.getLength();
	        if(curLen > 0)
	        {
				try {
					curName = e.getDocument().getText(0, curLen);
				} catch (BadLocationException e1) {
					m_view.showErrorDialog();
					e1.printStackTrace();
				}
				
				checkPlayerName();
	        }
	  
	    }

	    @Override
	    public void removeUpdate(DocumentEvent e) {
	        curLen -= e.getLength();
	        if(curLen > 0)
	        {
				try {
					curName = e.getDocument().getText(0, curLen);
				} catch (BadLocationException e1) {
					m_view.showErrorDialog();
					e1.printStackTrace();
				}
				
				checkPlayerName();
	        }
	        else
	        {
	        	m_view.playerCreationGUI.playerNameTaken(true);
	        }
	    }

	    @Override
	    public void changedUpdate(DocumentEvent e) {
	        System.out.println("ChangedUpdate");
	    }
	    
	    private void checkPlayerName()
	    {
	    	boolean allLetters = curName.chars().allMatch(Character::isLetter);
	    	
			if(playerNames.contains(curName))
			{
				m_view.playerCreationGUI.playerNameTaken(true);
			}
			else if(!(allLetters))
			{
				m_view.playerCreationGUI.playerNameTaken(true);
			}
			else
			{
				m_view.playerCreationGUI.playerNameTaken(false);
			}
	    }
	    
	    
	}
	
	class PetNameTextFieldListener implements DocumentListener
	{
		private int curLen = 0;
		private String curName = "";
		private int fieldNum;
		
		public PetNameTextFieldListener(int aFieldNum)
		{
			fieldNum = aFieldNum;
		}
		
		@Override
	    public void insertUpdate(DocumentEvent e) {
	        curLen += e.getLength();
	        if(curLen > 0)
	        {
				try {
					curName = e.getDocument().getText(0, curLen);
					curPetNames.set(fieldNum, curName);
				} catch (BadLocationException e1) {
					m_view.showErrorDialog();
					e1.printStackTrace();
				}
				checkPetNames();
	        }
	  
	    }

	    @Override
	    public void removeUpdate(DocumentEvent e) {
	        curLen -= e.getLength();
	        if(curLen > 0)
	        {
				try {
					curName = e.getDocument().getText(0, curLen);
					curPetNames.set(fieldNum, curName);
				} catch (BadLocationException e1) {
					m_view.showErrorDialog();
					e1.printStackTrace();
				}
				
				checkPetNames();
	        }
	        else
	        {
	        	m_view.playerCreationGUI.petNameTaken(true, fieldNum);
	        }
	    }

	    @Override
	    public void changedUpdate(DocumentEvent e) {
	        System.out.println("ChangedUpdate");
	    }
	    
	    private void checkPetNames()
	    {
	    	boolean allLetters = curName.chars().allMatch(Character::isLetter);
	    	
			if(petNames.contains(curName))
				m_view.playerCreationGUI.petNameTaken(true, fieldNum);
			else if(curPetNames.get((fieldNum + 1)%3).equals(curName))
			{
				m_view.playerCreationGUI.petNameTaken(true, fieldNum);
				m_view.playerCreationGUI.petNameTaken(true, (fieldNum + 1)%3);
			}
			else if(curPetNames.get((fieldNum + 2)%3).equals(curName))
			{
				m_view.playerCreationGUI.petNameTaken(true, fieldNum);
				m_view.playerCreationGUI.petNameTaken(true, (fieldNum + 2)%3);
			}
			else if(!(allLetters))
			{
				m_view.playerCreationGUI.petNameTaken(true, fieldNum);
			}
			else
			{
				m_view.playerCreationGUI.petNameTaken((curPetNames.get(0).equals(" ")), 0);
				m_view.playerCreationGUI.petNameTaken((curPetNames.get(1).equals(" ")), 1);
				m_view.playerCreationGUI.petNameTaken((curPetNames.get(2).equals(" ")), 2);
			}
	    }
	    

	    
	}
}
