package mvc;

import java.awt.EventQueue;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;


public class ShopView {

	private JFrame frame;
	
	private ImageIcon baconImage = new ImageIcon("resources/ball.png");
	
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
	

	/**
	 * Launch the application.
	 */

	
	/**
	 * Create the application.
	 */
	public ShopView() {
		initialize();
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
		
		MigLayout menuLayout = new MigLayout(
				"fill, insets 20", 
				"[][][][][][]",
				"[][][][][][][][][][]");
		main.setLayout(menuLayout);
		
		main.add(foodLabel, "grow, wrap");
		
		main.add(clickLabel1, "grow, wrap");
		
		baconLabel.setText("<html><p>Bacon<br />"
			+ "Price: $" + bacon.getPrice() + "<br />"
			+ "Nutrition: " + bacon.getValue() + "</p></html>");
		bananaLabel.setText("<html><p>Banana<br />"
				+ "Price: $" + banana.getPrice() + "<br />"
						+ "Nutrition: " + banana.getValue() + "</p></html>");
		carrotLabel.setText("<html><p>Carrot<br />"
				+ "Price: $" + carrot.getPrice() + "<br />"
						+ "Nutrition: " + carrot.getValue() + "</p></html>");
		milkLabel.setText("<html><p>Milk<br />"
				+ "Price: " + milk.getPrice() + "<br />"
				+ "Nutrition: " + milk.getValue() + "</p></html>");
		steakLabel.setText("<html><p>Steak<br />"
				+ "Price: $" + steak.getPrice() + "<br />"
				+ "Nutrition: " + steak.getValue() + "</p></html>");
		sushiLabel.setText("<html><p>Sushi<br />"
				+ "Price: $" + sushi.getPrice() + "<br />"
				+ "Nutrition: " + sushi.getValue() + "</p></html>");
		
		ballLabel.setText("<html><p>Ball<br />"
				+ "Price: $" + ball.getPrice() + "<br />"
				+ "Durability: " + ball.getDurability() + "</p></html>");
		bookLabel.setText("<html><p>Book<br />"
				+ "Price: $" + book.getPrice() + "<br />"
				+ "Durability: " + book.getDurability() + "</p></html>");
		clubLabel.setText("<html><p>Club<br />"
				+ "Price: $" + club.getPrice() + "<br />"
				+ "Durability: " + club.getDurability() + "</p></html>");
		pianoLabel.setText("<html><p>Piano<br />"
				+ "Price: $" + piano.getPrice() + "<br />"
				+ "Durability: " + piano.getDurability() + "</p></html>");
		planeLabel.setText("<html><p>Plane<br />"
				+ "Price: $" + plane.getPrice() + "<br />"
				+ "Durability: " + plane.getDurability() + "</p></html>");
		yarnLabel.setText("<html><p>Yarn<br />"
				+ "Price: $" + yarn.getPrice() + "<br />"
				+ "Durability: " + yarn.getDurability() + "</p></html>");
		
		backButton.setText("Back");
		
		main.add(baconButton, "grow");
		main.add(bananaButton, "grow");
		main.add(carrotButton, "grow");		
		main.add(milkButton, "grow");
		main.add(steakButton, "grow");
		main.add(sushiButton, "grow, wrap");
		
		main.add(baconLabel, "grow");
		main.add(bananaLabel, "grow");
		main.add(carrotLabel, "grow");
		main.add(milkLabel, "grow");
		main.add(steakLabel, "grow");
		main.add(sushiLabel, "grow, wrap");
		
		main.add(toyLabel, "grow, wrap");
		main.add(clickLabel2, "grow, wrap");
		
		main.add(ballButton, "grow");
		main.add(bookButton, "grow");
		main.add(clubButton, "grow");
		main.add(pianoButton, "grow");
		main.add(planeButton, "grow");
		main.add(yarnButton, "grow, wrap");
		
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
