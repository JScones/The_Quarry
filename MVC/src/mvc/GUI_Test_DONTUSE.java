package mvc;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

import net.miginfocom.swing.MigLayout;

public class GUI_Test_DONTUSE {

	JFrame frame = new JFrame("Gui Test");

	// First menu components
	private JTextPane menuTextPane = new JTextPane();
	private JTextPane helpTextPane = new JTextPane();
	private JButton start = new JButton("Start");
	private JButton help = new JButton("Help");
	private JButton back = new JButton("Back");
	private Dimension buttonSize = new Dimension(225, 50);
	
	private String helpText = "This is where the help text goes\n";
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblNewLabel = new JLabel("New label");
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JButton btnNewButton = new JButton("New button");
	private final JButton btnNewButton_1 = new JButton("New button");

	/**
	 * Launch the application.
	 	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Test_DONTUSE window = new GUI_Test_DONTUSE();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_Test_DONTUSE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//frame.setResizable(false);
		//frame.setMinimumSize(new Dimension(900, 600));
		frame.setPreferredSize(new Dimension(900, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
		frame.getContentPane().setLayout(new MigLayout("", "[325px][grow]", "[290px,grow]"));
		
		frame.getContentPane().add(tabbedPane, "cell 0 0,grow");
		
		tabbedPane.addTab("New tab", null, panel, null);
		lblNewLabel.setIcon(new ImageIcon("D:\\Josh\\Documents\\Uni\\2017\\SENG201\\Assignment\\The_Quarry\\MVC\\resources\\elephant.png"));
		
		panel.add(lblNewLabel);
		
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(new MigLayout("", "[]", "[]"));
		tabbedPane.setEnabledAt(1, false);
		tabbedPane.setSelectedIndex(2);
		
		frame.getContentPane().add(panel_3, "cell 1 0,grow");
		panel_3.setLayout(new MigLayout("", "[][][][][][][][][]", "[][][][][][][]"));
		
		panel_3.add(btnNewButton, "cell 0 0");
		
		panel_3.add(btnNewButton_1, "cell 8 6");
		
	}

}
