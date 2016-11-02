package io.github.tranvd2010;

import io.github.tranvd2010.ui.StringGeneratorUI;
import java.awt.EventQueue;
import javax.swing.UIManager;

/**
 *App.java
 *
 * @author Viet Dung Tran (tranvd2010@gmail.com)
 *
 */

/*
 * tich hop goi call-back
 * 
 * tich hop thread sau khi hoc thread 
 * 
 * tim hieu phan them cua main chinh
 */

public class App {
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					StringGeneratorUI frame = new StringGeneratorUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
