package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;


public class ShopView {

	private JFrame frame;
	
	private ImageIcon baconImage = new ImageIcon("resources/ball.png");
	
	private Player player;
	

		
	private JPanel main = new JPanel();
	private JLabel foodLabel = new JLabel("Food");
	private JLabel clickLabel1 = new JLabel("Click picture to buy.");
	private JLabel clickLabel2 = new JLabel("Click picture to buy.");
	
	private JButton baconButton = new JButton();
	private JButton bananaButton = new JButton();
	private JButton carrotButton = new JButton();
	private JButton milkButton = new JButton();
	private JButton sushiButton = new JButton();
	private JButton steakButton = new JButton();
	
	private JLabel baconLabel = new JLabel();
	private JLabel bananaLabel = new JLabel();
	private JLabel carrotLabel = new JLabel();
	private JLabel milkLabel = new JLabel();
	private JLabel steakLabel = new JLabel();
	private JLabel sushiLabel = new JLabel();
	
	private JLabel toyLabel = new JLabel("Toys");
	
	private JButton ballButton = new JButton();
	private JButton bookButton = new JButton();
	private JButton clubButton = new JButton();
	private JButton pianoButton = new JButton();
	private JButton planeButton = new JButton();
	private JButton yarnButton = new JButton();
	
	private JLabel ballLabel = new JLabel();
	private JLabel bookLabel = new JLabel();
	private JLabel clubLabel = new JLabel();
	private JLabel pianoLabel = new JLabel();
	private JLabel planeLabel = new JLabel();
	private JLabel yarnLabel = new JLabel();
	
	private JButton backButton = new JButton();
	
	private JLabel toyBoxLabel = new JLabel("Toy Box:");
	private JLabel moneyLabel = new JLabel();
	private JLabel toyBoxListLabel = new JLabel();
	private JLabel foodBoxLabel = new JLabel("Food Box:");
	private JLabel foodBoxListLabel = new JLabel();
	
	String toyList = new String();
	String foodList = new String();

	/**
	 * Launch the application.
	 */

	
	/**
	 * Create the application.
	 */
	public ShopView(Player aPlayer) {
		player = aPlayer;
		initialize();
		ActionListener bl = new ButtonListener();
		addButtonListener(bl);
		updateShop();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Food bacon = new FoodBacon();
		Food banana = new FoodBanana();
		Food carrot = new FoodCarrot();
		Food milk = new FoodMilk();
		Food steak = new FoodSteak();
		Food sushi = new FoodSushi();
		
		Toy ball = new ToyBall();
		Toy book = new ToyBook();
		Toy club = new ToyClub();
		Toy piano = new ToyPiano();
		Toy plane = new ToyPlane();
		Toy yarn = new ToyYarn();
		
//		player.addToy(ball);
//		player.addToy(book);
//		player.addToy(yarn);
//		player.addToy(piano);
//		player.addToy(book);
//		player.addFood(milk);
//		player.addFood(carrot);
//		player.addFood(carrot);
//		

		
		MigLayout menuLayout = new MigLayout(
				"fill, insets 20", 
				"[][][][][][][]",
				"[][][][][][][][][][]");
		main.setLayout(menuLayout);
		
		main.add(foodLabel, "grow");
		
		moneyLabel.setText("Money: $" + player.getMoney());
		main.add(moneyLabel, "skip 5, grow, wrap");
		
		main.add(clickLabel1, "grow");
		
		main.add(foodBoxLabel, "grow, skip 5, wrap");
		
		baconLabel.setText(List(bacon));
		bananaLabel.setText(List(banana));
		carrotLabel.setText(List(carrot));
		milkLabel.setText(List(milk));
		steakLabel.setText(List(steak));
		sushiLabel.setText(List(sushi));
		
		ballLabel.setText(List(ball));
		bookLabel.setText(List(book));
		clubLabel.setText(List(club));
		pianoLabel.setText(List(piano));
		planeLabel.setText(List(plane));
		yarnLabel.setText(List(yarn));
		
		backButton.setText("Back");
		
		baconButton.setActionCommand("bacon");
		bananaButton.setActionCommand("banana");
		carrotButton.setActionCommand("carrot");
		milkButton.setActionCommand("milk");
		steakButton.setActionCommand("steak");
		sushiButton.setActionCommand("sushi");
		
		
		main.add(baconButton, "grow");
		main.add(bananaButton, "grow");
		main.add(carrotButton, "grow");		
		main.add(milkButton, "grow");
		main.add(steakButton, "grow");
		main.add(sushiButton, "grow");

		main.add(foodBoxListLabel, "grow, wrap");

		
		main.add(baconLabel, "grow");
		main.add(bananaLabel, "grow");
		main.add(carrotLabel, "grow");
		main.add(milkLabel, "grow");
		main.add(steakLabel, "grow");
		main.add(sushiLabel, "grow, wrap");
		
		main.add(toyLabel, "grow, wrap");
		main.add(clickLabel2, "grow");
		main.add(toyBoxLabel, "grow, skip 5, wrap");
		
		ballButton.setActionCommand("ball");
		bookButton.setActionCommand("book");
		clubButton.setActionCommand("club");
		pianoButton.setActionCommand("piano");
		planeButton.setActionCommand("plane");
		yarnButton.setActionCommand("yarn");
		
		main.add(ballButton, "grow");
		main.add(bookButton, "grow");
		main.add(clubButton, "grow");
		main.add(pianoButton, "grow");
		main.add(planeButton, "grow");
		main.add(yarnButton, "grow");


		main.add(toyBoxListLabel, "grow, wrap");
		
		main.add(ballLabel, "grow");
		main.add(bookLabel, "grow");
		main.add(clubLabel, "grow");
		main.add(pianoLabel, "grow");
		main.add(planeLabel, "grow");
		main.add(yarnLabel, "grow, wrap");
		
		main.add(backButton, "grow");
		
		
		baconButton.setIcon(baconImage);
		bananaButton.setIcon(baconImage);
		carrotButton.setIcon(baconImage);
		milkButton.setIcon(baconImage);
		steakButton.setIcon(baconImage);
		sushiButton.setIcon(baconImage);
		
		ballButton.setIcon(baconImage);
		bookButton.setIcon(baconImage);
		clubButton.setIcon(baconImage);
		pianoButton.setIcon(baconImage);
		planeButton.setIcon(baconImage);
		yarnButton.setIcon(baconImage);
		

		
		
		frame.add(main);
		
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
		updateShop();
	}
	
	private  void closeShop()
	{
		
	}
	
	private String List(Food food)
	{
		return "<html><p>" + food.getName() + "<br />"
				+ "Price: $" + food.getPrice() + "<br />"
				+ "Nutrition: " + food.getValue() + "</p></html>";
	}
	
	private String List(Toy toy)
	{
		return "<html><p>" + toy.getName() + "<br />"
				+ "Price: $" + toy.getPrice() + "<br />"
				+ "Durability: " + toy.getDurability() + "</p></html>";
	}
	
	private void addButtonListener(ActionListener bl)
	{
		baconButton.addActionListener(bl);
		bananaButton.addActionListener(bl);
		carrotButton.addActionListener(bl);
		milkButton.addActionListener(bl);
		steakButton.addActionListener(bl);
		sushiButton.addActionListener(bl);
		
		ballButton.addActionListener(bl);
		bookButton.addActionListener(bl);
		clubButton.addActionListener(bl);
		pianoButton.addActionListener(bl);
		planeButton.addActionListener(bl);
		yarnButton.addActionListener(bl);
	}
	
	private void showNotEnoughMoneyDialog()
	{
		JOptionPane.showMessageDialog(frame, "You don't have enough money to buy this item.");
	}
	
	private void updateShop()
	{
		Map<String, Integer> foodMap = new HashMap<String, Integer>();
		String foodList = "";
		for(int j=0; j < player.getFood().size(); j++)
		{
			if(!foodMap.containsKey(player.getFood().get(j).toString()))
				foodMap.put(player.getFood().get(j).getName(), 1);
			else
				foodMap.put(player.getFood().get(j).getName(), foodMap.get(player.getFood().get(j).getName()) + 1);
		}
		
		String[] foodKeys = foodMap.keySet().toArray(new String[]{});
		
		for(int i = 0; i < foodMap.size(); i++)
		{

			foodList += foodKeys[i] + " x" + foodMap.get(foodKeys[i]);
			foodList += "<br />";
			
		}
		
		foodList = "<html><p>" + foodList + "</p></html>";

		
		foodBoxListLabel.setText(foodList);
		
		Map<String, Integer> toysMap = new HashMap<String, Integer>();
		String toyList = "";
		for(int j=0; j < player.getToys().size(); j++)
		{
			if(!toysMap.containsKey(player.getToys().get(j).toString()))
				toysMap.put(player.getToys().get(j).getName(), 1);
			else

				toysMap.put(player.getToys().get(j).getName(), toysMap.get(player.getToys().get(j).getName()) + 1);
		}
		
		
		String[] toyKeys = toysMap.keySet().toArray(new String[]{});
		
		for(int i = 0; i < toysMap.size(); i++)
		{
			toyList += toyKeys[i] + " x" + toysMap.get(toyKeys[i]);
			toyList += "<br />";
		}
		
		toyList = "<html><p>" + toyList + "</p></html>";
		toyBoxListLabel.setText(toyList);
		
		moneyLabel.setText("Money: $" + String.format("%.2f", player.getMoney()));
	}
	
	class ButtonListener implements ActionListener
	{
		

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			
			if(command.equals("bacon"))
			{
				if(player.canBuy(new FoodBacon()))
				{
					player.Buy(new FoodBacon());
				}
				else
				{
					showNotEnoughMoneyDialog();
				}
			}
				
			else if(command.equals("banana"))
			{
				if(player.canBuy(new FoodBanana()))
				{
					player.Buy(new FoodBanana());
				}
				else
				{
					showNotEnoughMoneyDialog();
				}
			}
			else if(command.equals("carrot"))
			{
				if(player.canBuy(new FoodCarrot()))
				{
					player.Buy(new FoodCarrot());
				}
				else
				{
					showNotEnoughMoneyDialog();
				}
			}
			else if(command.equals("milk"))
			{
				if(player.canBuy(new FoodMilk()))
				{
					player.Buy(new FoodMilk());
				}
				else
				{
					showNotEnoughMoneyDialog();
				}
			}
			else if(command.equals("steak"))
			{
				if(player.canBuy(new FoodSteak()))
				{
					player.Buy(new FoodSteak());
				}
				else
				{
					showNotEnoughMoneyDialog();
				}
			}
			else if(command.equals("sushi"))
			{
				if(player.canBuy(new FoodSushi()))
				{
					player.Buy(new FoodSushi());
				}
				else
				{
					showNotEnoughMoneyDialog();
				}
			}
			else if(command.equals("ball"))
			{
				if(player.canBuy(new ToyBall()))
				{
					player.Buy(new ToyBall());
				}
				else
				{
					showNotEnoughMoneyDialog();
				}
			}
			else if(command.equals("book"))
			{
				if(player.canBuy(new ToyBook()))
				{
					player.Buy(new ToyBook());
				}
				else
				{
					showNotEnoughMoneyDialog();
				}
			}
			else if(command.equals("club"))
			{
				if(player.canBuy(new ToyClub()))
				{
					player.Buy(new ToyClub());
				}
				else
				{
					showNotEnoughMoneyDialog();
				}
			}
			else if(command.equals("piano"))
			{
				if(player.canBuy(new ToyPiano()))
				{
					player.Buy(new ToyPiano());
				}
				else
				{
					showNotEnoughMoneyDialog();
				}
			}
			else if(command.equals("plane"))
			{
				if(player.canBuy(new ToyPlane()))
				{
					player.Buy(new ToyPlane());
				}
				else
				{
					showNotEnoughMoneyDialog();
				}
			}
			else if(command.equals("yarn"))
			{
				if(player.canBuy(new ToyYarn()))
				{
					player.Buy(new ToyYarn());
				}
				else
				{
					showNotEnoughMoneyDialog();
				}
			}
			
			updateShop();
			
		}
	
	}

}


