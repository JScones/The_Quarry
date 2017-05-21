package mvc;

import java.awt.EventQueue;

public class ShopRunner {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopView window = new ShopView();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
