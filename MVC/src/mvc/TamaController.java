package mvc;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.event.*;
import javax.swing.text.BadLocationException;


public class TamaController {

	private TamaModel m_model;
	private TamaView m_view;
	private String lastPetSelected = " ";
	private CreatePlayersNew playerCreator = new CreatePlayersNew();
	private ArrayList<String> playerNames = new ArrayList<>();
	private ArrayList<String> petNames = new ArrayList<>();
	private ArrayList<String> curPetNames = new ArrayList<>();
	private int curPlayerNum = 0;
	private Player curPlayer;
	
	public TamaController(TamaModel model, TamaView view)
	{
		m_model = model;
		m_view = view;
		
		view.addButtonListener(new ButtonListener());
		view.addComboBoxListener(new ComboBoxListener(1), new ComboBoxListener(2), new ComboBoxListener(3));
		view.addTextFieldListener(new NameTextFieldListener(), new PetNameTextFieldListener(0), new PetNameTextFieldListener(1), new PetNameTextFieldListener(2));
		view.addMainGameLoopListener(new MainLoopButtonListener());
		
		curPetNames.add(" ");
		curPetNames.add(" ");
		curPetNames.add(" ");
	}
	
	
	class ButtonListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			String curView = m_view.getCurrentView();
			//System.out.println(command);
			if(command == "Start")
			{
				m_view.changeView("Setup");
			}
			else if(command == "Help")
			{
				//m_view.updateText();
				m_view.changeView("Help");
			}
			else if(command == "Back")
			{
				m_view.changeView("Menu");
			}
			else if(command == "Next")
			{
				if(curView== "Setup")
				{
					m_model.setUp(m_view.getNumPlayers(), m_view.getNumDays());
					m_view.changeView("Make Player");
				}
				else if(curView == "Make Player")
				{
					//System.out.println(m_view.getPetSpeciesSelections());
					Player p = playerCreator.makePlayer(m_view.getPlayerName(), m_view.getPetSpeciesSelections(), m_view.getPetNames());
					playerNames.add(m_view.getPlayerName());
					for(int i = 0; i<m_view.getPetNames().size(); i++)
						if(m_view.getPetNames().get(i).equals(" "))
						{
							
						}
						else
							petNames.add(m_view.getPetNames().get(i));
					m_model.addPlayer(p);
					if(!(m_model.enoughPlayers()))
						m_view.nextPlayer(m_model.curNumPlayers() + 1);
					else
					{
						m_model.incrementDay();
						m_view.setMainGameTab(m_model.getPlayers().get(0));
						curPlayerNum = 0;
						m_view.changeView("Main Game");
					}
				}
			}	
			else if(command == "Clear")
			{
				m_view.resetPetView();
			}
			else if(command.equals("donePet1"))
			{
				m_view.changePetTab(1);
			}
			else if(command.equals("donePet2"))
			{
				m_view.changePetTab(2);
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
			//System.out.println(command);
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
						m_view.updatePetBars((petNum), curPlayer.getPets().get(petNum));
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
						
						m_view.updatePetBars((petNum), curPlayer.getPets().get(petNum));
					}
				}
				else if(commands[0].equals("toilet"))
				{
					curPlayer.getPets().get(petNum).goToilet();
					m_view.updatePetBars((petNum), curPlayer.getPets().get(petNum));
				}
				else if(commands[0].equals("sleep"))
				{
					curPlayer.getPets().get(petNum).sleep();
					m_view.updatePetBars((petNum), curPlayer.getPets().get(petNum));
				}
				
				if(curPlayer.getPets().get(petNum).getActionsLeft() == 0)
				{
					m_view.enablePetActionButtons(false, Integer.parseInt(commands[1]));
				}
				
			}
			else if(commands[0].equals("Store"))
			{
				//System.out.println(curPlayer);
				m_view.disableGame();
				ShopView shop = new ShopView(curPlayer, m_view);
			}
			else if(command.equals("End my day"))
			{
				curPlayer.dayOver();
				
				if(curPlayerNum + 1 < m_model.curNumPlayers())
				{
					m_view.setMainGameTab(m_model.getPlayers().get(curPlayerNum + 1));
					curPlayerNum ++;
					curPlayer = m_model.getPlayers().get(curPlayerNum);
				}
				else
				{
					curPlayerNum = 0;
					curPlayer = m_model.getPlayers().get(curPlayerNum);
					m_view.dayOver();
					m_model.incrementDay();
					m_view.updateDayCount();
					m_view.setMainGameTab(curPlayer);
					
				}
			}
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
		    	   m_view.updatePetPanel(lastPetSelected, boxNum);
		    	   if(lastPetSelected.equals(" "))
		    	   {
		    		   curPetNames.set(boxNum - 1, " ");
		    	   }
		    	   lastPetSelected = " ";
		       }
		       m_view.allFieldsAccepted();
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
	        	m_view.playerNameTaken(true);
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
				m_view.playerNameTaken(true);
			}
			else if(!(allLetters))
			{
				m_view.playerNameTaken(true);
			}
			else
			{
				m_view.playerNameTaken(false);
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
	        	m_view.petNameTaken(true, fieldNum);
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
				m_view.petNameTaken(true, fieldNum);
			else if(curPetNames.get((fieldNum + 1)%3).equals(curName))
			{
				m_view.petNameTaken(true, fieldNum);
				m_view.petNameTaken(true, (fieldNum + 1)%3);
			}
			else if(curPetNames.get((fieldNum + 2)%3).equals(curName))
			{
				m_view.petNameTaken(true, fieldNum);
				m_view.petNameTaken(true, (fieldNum + 2)%3);
			}
			else if(!(allLetters))
			{
				m_view.petNameTaken(true, fieldNum);
			}
			else
			{
				m_view.petNameTaken((curPetNames.get(0).equals(" ")), 0);
				m_view.petNameTaken((curPetNames.get(1).equals(" ")), 1);
				m_view.petNameTaken((curPetNames.get(2).equals(" ")), 2);
			}
	    }
	    
	}
}
