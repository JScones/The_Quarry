package mvc;

import java.awt.event.*;

public class TamaController {

	private TamaModel m_model;
	private TamaView m_view;
	
	public TamaController(TamaModel model, TamaView view)
	{
		m_model = model;
		m_view = view;
		
		view.addButtonListener(new ButtonListener());
	}
	
	class ButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			if(command == "Start")
			{
				m_model.clicked();
				System.out.println(m_model.getClickCount());
			}
			else if(command == "Help")
			{
				m_view.updateText();
				m_view.changeView("Help");
			}
			else if(command == "Back")
				m_view.changeView("Menu");
		}
	}
}
