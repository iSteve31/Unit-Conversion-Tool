package com.mycompany.toolpack;

import com.mycompany.toolpack.forms.MainWindow;

public class ConversionTool {

	public static void main(String[] args) {
		
		try {
			MainWindow frameToolPack = new MainWindow();
			frameToolPack.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
