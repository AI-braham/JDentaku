package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainWindow;

public class AnsListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String text=MainWindow.getMainScreenText();
		MainWindow.setMainScreenText(text+"Ans");
		
	}

}
