package utilities;

import java.util.LinkedList;

import gui.MainWindow;

public class HistoryMemory {
	private static LinkedList<String> history=new LinkedList<String>();
	public static void input(String operation, String result) {
		if(history.size()>=10) {history.remove();}
			String text= operation + " = " + result;
			history.add(text);
		
		
		MainWindow.updateHistory(history);
		
	}

}
