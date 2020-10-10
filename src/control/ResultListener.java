package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calculationParsing.ShantingYard;
import gui.MainWindow;
import utilities.AnsMemory;
import utilities.HistoryMemory;

public class ResultListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String text=MainWindow.getMainScreenText();
		MainWindow.setMainScreenText("");
		ShantingYard parser = new ShantingYard();
		parser.toRPN(text);
		String result=String.valueOf(parser.solveRPN());
		parser.clearStacks();
		MainWindow.setMainScreenText(result);
		HistoryMemory.input(text, result);
		AnsMemory.setAns(Double.parseDouble(result));
		
	}


}
