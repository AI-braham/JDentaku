package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.MainWindow;

public class KeyTextListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		String sourceText = (  (JButton) event.getSource()  ).getText();
		
		runtime:{
			
		switch(sourceText) {
			case "Sen":
			case "Cos":
			case "Tan":
			case "Log":
			case "Ln":
				String text = MainWindow.getMainScreenText() + sourceText;
				MainWindow.setMainScreenText(text+"(");
				break runtime;
		
		}	
		if(sourceText=="x^n") {
			String text = MainWindow.getMainScreenText();
			MainWindow.setMainScreenText(text+ "^");
			break runtime;
		}
		if(sourceText=="x^2") {
			String text = MainWindow.getMainScreenText();
			MainWindow.setMainScreenText(text+ "^2");
			break runtime;
		}
		if(sourceText=="\u221Ax") {
			String text = MainWindow.getMainScreenText();
			MainWindow.setMainScreenText(text+ "sqrt(");
			break runtime;
		}
		if(sourceText=="X10^n") {
			String text = MainWindow.getMainScreenText();
			MainWindow.setMainScreenText(text+ "X10^");
			break runtime;
		}
		String text = MainWindow.getMainScreenText() + sourceText;
		MainWindow.setMainScreenText(text);
		break runtime;
		}
	}
}

