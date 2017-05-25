package mvc;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class GuiEndGame {

	private TamaModel m_model;
	
	private JLabel scoreLabel = new JLabel();
	
	public GuiEndGame(TamaModel model)
	{
		m_model = model;
	}
	
	public JPanel buildEndGame()
	{
		JPanel endGame = new JPanel();
		
		MigLayout layout = new MigLayout(
				"fill, insets 20", 
				"[]",
				"[]");
		
		endGame.setLayout(layout);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		endGame.add(scoreLabel, "push, grow");
		return endGame;
	}
	
	public void updateScores()
	{
		scoreLabel.setText(buildScoreString());
	}
	
	private String buildScoreString()
	{
		String scores = "<html><p><font size='20'><center>";
		scores += "Game Over! Well Done!<br /><br />";
		
		for(Player player : m_model.getPlayers())
		{
			scores += player.name + "'s Score: " + player.getScore() + "<br /><br />";
		}
		
		scores += "</center></font></p></html>";
		return scores;
	}
	
}
