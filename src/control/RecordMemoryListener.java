package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.MainWindow;
import utilities.RecordMemory;

public class RecordMemoryListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String textButton= (   (JButton)   e.getSource()).getText();
		if(textButton=="M") {MainWindow.setMainScreenText(MainWindow.getMainScreenText()+"M");
		}else {
			char ch=textButton.charAt(1);
		
			switch(ch) {
			case '+' : 
				RecordMemory.setMemory(  RecordMemory.getMemory()  +  Double.parseDouble(MainWindow.getMainScreenText()));
				break;
			case '-' : 
				RecordMemory.setMemory(  RecordMemory.getMemory()  -  Double.parseDouble(MainWindow.getMainScreenText()));
				break;
			case 'S' :
				RecordMemory.setMemory(Double.parseDouble(MainWindow.getMainScreenText()));
				break;
			case 'C' : 
				RecordMemory.setMemory(0);
				break;
			}
		}
	}

}
