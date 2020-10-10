package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainWindow;

public class DeleteCharListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event) {
		String text=MainWindow.getMainScreenText();
		if(text.length()>0) {
			text= text.substring(0, text.length()-1);
		}
		MainWindow.setMainScreenText(text);
	}

}
