package mvc;

import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

public class GuiEndGame {

	private TamaModel m_model;
	
	private JLabel scoreLabel = new JLabel();
	
	public GuiEndGame(TamaModel model)
	{
		m_model = model;
	}
	
	private JLabel buildEndGame()
	{
		JLabel endGame = new JLabel();
		
		MigLayout layout = new MigLayout(
				"fill, insets 20", 
				"[]",
				"[]");
		
		endGame.setLayout(layout);
		
		return endGame;
	}
	
	private String buildScoreString()
	{
		String scores = "<html><p>";
		
		for(Player player : m_model.getPlayers())
		{
			scores += player.name + " Score: ";
		}
		
		return scores;
	}
	
}
