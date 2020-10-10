package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainWindow;

public class CleanScreenListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		MainWindow.setMainScreenText("");
		
	}
	
}
