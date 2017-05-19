package mvc;

import java.awt.event.*;
import java.util.Arrays;

public class TamaController {

	private TamaModel m_model;
	private TamaView m_view;
	private String lastPetSelected = " ";
	private CreatePlayersNew playerCreator = new CreatePlayersNew();
	
	public TamaController(TamaModel model, TamaView view)
	{
		m_model = model;
		m_view = view;
		
		view.addButtonListener(new ButtonListener());
		view.addComboBoxListener(new ComboBoxListener());
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
					System.out.println(m_view.getPetSpeciesSelections());
					Player p = playerCreator.makePlayer("Josh", m_view.getPetSpeciesSelections(), m_view.getPetNames());
					
					if(!(m_model.enoughPlayers()))
						m_view.nextPlayer(m_model.curNumPlayers() + 1);
				}
			}	
			else if(command == "combo-1")
				m_view.updatePetPanel(lastPetSelected, 1);
			else if(command == "combo-2")
				m_view.updatePetPanel(lastPetSelected, 2);
			else if(command == "combo-3")
				m_view.updatePetPanel(lastPetSelected, 3);
			else if(command == "Clear")
			{
				m_view.resetPetView();
			}
		}
	}
	
	class ComboBoxListener implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent event) {
		       if (event.getStateChange() == ItemEvent.SELECTED) {
		    	   String item = (String)event.getItem();
		    	   lastPetSelected = item;
		       }
		    }  
	}
}
