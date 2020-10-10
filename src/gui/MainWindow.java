package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.JDentaku;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import control.AnsListener;
import control.CleanScreenListener;
import control.DeleteCharListener;
import control.KeyTextListener;
import control.RecordMemoryListener;
import control.ResultListener;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JList;
import java.awt.CardLayout;


public class MainWindow {

	private JFrame frame;
	private static JTextField mainScreenInterface;
	private static DefaultListModel<String> historyModelList;

	/**
	 * Launch the application.
	 */
	public static void execute() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setTitle("JDentaku Version " + JDentaku.getVersion());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane mainSplitPane = new JSplitPane();
		frame.getContentPane().add(mainSplitPane, BorderLayout.CENTER);
		
		JPanel mainLeftSidePanel = new JPanel();
		mainSplitPane.setLeftComponent(mainLeftSidePanel);
		mainLeftSidePanel.setLayout(new BorderLayout(0, 0));
		
		//
		CardLayout cards=new CardLayout(0,0);
		//
		
		JPanel panel = new JPanel();
		mainLeftSidePanel.add(panel, BorderLayout.NORTH);
		
		JPanel cardPanel = new JPanel();
		mainLeftSidePanel.add(cardPanel, BorderLayout.CENTER);
		cardPanel.setLayout(cards);
		
		JButton historyButton = new JButton("History");
		historyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cards.first(cardPanel);
				
			}
			
		});
		panel.add(historyButton);
		
		JButton memoryButton = new JButton("Memory");
		memoryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cards.last(cardPanel);
				
			}
			
		});
		panel.add(memoryButton);
		
		
		
		;
		
		
		JPanel historyPanel = new JPanel();
		cardPanel.add(historyPanel, "name_256874655408300");
		historyPanel.setLayout(new BorderLayout(0, 0));
		
		JList<String> historyList = new JList<String>();
		historyPanel.add(historyList);
		
		JPanel memoryPanel = new JPanel();
		cardPanel.add(memoryPanel, "name_256879496179900");
		memoryPanel.setLayout(new BorderLayout(0, 0));
		
		JList<String> memoryList = new JList<String>();
		memoryPanel.add(memoryList, BorderLayout.CENTER);
		
		historyModelList=new DefaultListModel<String>();
		historyList.setModel(historyModelList);
		
		
		JPanel mainRightSidePanel = new JPanel();
		mainSplitPane.setRightComponent(mainRightSidePanel);
		mainRightSidePanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		mainRightSidePanel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		//-------------------------------------------------------------------------
		
		KeyTextListener ktlistener= new KeyTextListener();
		CleanScreenListener cslistener= new CleanScreenListener();
		DeleteCharListener dclistener=new DeleteCharListener();
		ResultListener resultlistener= new ResultListener();
		AnsListener ansl=new AnsListener();
		RecordMemoryListener rmlistener= new RecordMemoryListener();
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel lowerInputPanel = new JPanel();
		lowerInputPanel.setLayout(new GridLayout(4, 5));
		
		JButton sevenButton = new JButton("7");
		sevenButton.addActionListener(ktlistener);
		lowerInputPanel.add(sevenButton);
		
		
		JButton eightButton = new JButton("8");
		eightButton.addActionListener(ktlistener);
		lowerInputPanel.add(eightButton);
		
		
		JButton nineButton = new JButton("9");
		nineButton.addActionListener(ktlistener);
		lowerInputPanel.add(nineButton);
		
		
		JButton delButton = new JButton("DEL");
		delButton.addActionListener(dclistener);
		lowerInputPanel.add(delButton);
		
		
		JButton acButton = new JButton("AC");
		acButton.addActionListener(cslistener);
		lowerInputPanel.add(acButton);
		
		
		JButton fourButton = new JButton("4");
		fourButton.addActionListener(ktlistener);
		lowerInputPanel.add(fourButton);
	
		
		JButton fiveButton = new JButton("5");
		fiveButton.addActionListener(ktlistener);
		lowerInputPanel.add(fiveButton);
		
		JButton sixButton = new JButton("6");
		sixButton.addActionListener(ktlistener);
		lowerInputPanel.add(sixButton);
		
		JButton multiplyButton = new JButton("X");
		multiplyButton.addActionListener(ktlistener);
		lowerInputPanel.add(multiplyButton);
		
		JButton divisionButton = new JButton("\u00F7");
		divisionButton.addActionListener(ktlistener);
		lowerInputPanel.add(divisionButton);
		
		JButton oneButton = new JButton("1");
		oneButton.addActionListener(ktlistener);
		lowerInputPanel.add(oneButton);
		
		JButton twoButton = new JButton("2");
		twoButton.addActionListener(ktlistener);
		lowerInputPanel.add(twoButton);
		
		JButton threeButton = new JButton("3");
		threeButton.addActionListener(ktlistener);
		lowerInputPanel.add(threeButton);
		
		JButton sumButton = new JButton("+");
		sumButton.addActionListener(ktlistener);
		lowerInputPanel.add(sumButton);
		
		JButton restButton = new JButton("-");
		restButton.addActionListener(ktlistener);
		lowerInputPanel.add(restButton);
		
		JButton zeroButton = new JButton("0");
		zeroButton.addActionListener(ktlistener);
		lowerInputPanel.add(zeroButton);
		
		JButton dotButton = new JButton(".");
		dotButton.addActionListener(ktlistener);
		lowerInputPanel.add(dotButton);
		
		JButton ScientificNotationButton = new JButton("X10^n");
		ScientificNotationButton.addActionListener(ktlistener);
		lowerInputPanel.add(ScientificNotationButton);
		
		JButton ansButton = new JButton("Ans");
		ansButton.addActionListener(ansl);
		lowerInputPanel.add(ansButton);
		
		JButton equalButton = new JButton("=");
		equalButton.addActionListener(resultlistener);
		lowerInputPanel.add(equalButton);
		
		JPanel upperInputPanel = new JPanel();
		upperInputPanel.setLayout(new GridLayout(3,6));
		
		JButton gradesButton = new JButton("\u00B0");
		upperInputPanel.add(gradesButton);
		
		JButton rootButton = new JButton("\u221Ax");
		rootButton.addActionListener(ktlistener);
		upperInputPanel.add(rootButton);
		
		JButton twoPowerButton = new JButton("x^2");
		twoPowerButton.addActionListener(ktlistener);
		upperInputPanel.add(twoPowerButton);
		
		JButton nPowerButton = new JButton("x^n");
		nPowerButton.addActionListener(ktlistener);
		upperInputPanel.add(nPowerButton);
		
		JButton logButton = new JButton("Log");
		logButton.addActionListener(ktlistener);
		upperInputPanel.add(logButton);
		
		JButton lnButton = new JButton("Ln");
		lnButton.addActionListener(ktlistener);
		upperInputPanel.add(lnButton);
		
		JButton mcButton = new JButton("MC");
		mcButton.addActionListener(rmlistener);
		upperInputPanel.add(mcButton);
		
		JButton eButton = new JButton("e");
		eButton.addActionListener(ktlistener);
		upperInputPanel.add(eButton);
		
		JButton piButton = new JButton("\uD835\uDF0B");
		piButton.addActionListener(ktlistener);
		upperInputPanel.add(piButton);
		
		JButton senButton = new JButton("Sen");
		senButton.addActionListener(ktlistener);
		upperInputPanel.add(senButton);
		
		JButton cosButton = new JButton("Cos");
		cosButton.addActionListener(ktlistener);
		upperInputPanel.add(cosButton);
		
		JButton tanButton = new JButton("Tan");
		tanButton.addActionListener(ktlistener);
		upperInputPanel.add(tanButton);
		
		JButton leftParentButton = new JButton("(");
		leftParentButton.addActionListener(ktlistener);
		upperInputPanel.add(leftParentButton);
		
		JButton rightParentButton = new JButton(")");
		rightParentButton.addActionListener(ktlistener);
		upperInputPanel.add(rightParentButton);
		
		JButton msButton = new JButton("MS");
		msButton.addActionListener(rmlistener);
		upperInputPanel.add(msButton);
		
		JButton mminusButton = new JButton("M-");
		mminusButton.addActionListener(rmlistener);
		upperInputPanel.add(mminusButton);
		
		JButton mplusButton = new JButton("M+");
		mplusButton.addActionListener(rmlistener);
		upperInputPanel.add(mplusButton);
		
		JButton mButton = new JButton("M");
		mButton.addActionListener(rmlistener);
		upperInputPanel.add(mButton);
		
		//----------------------------//
		inputPanel.add(upperInputPanel);
		inputPanel.add(lowerInputPanel);
		//----------------------------//
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		mainRightSidePanel.add(splitPane, BorderLayout.CENTER);
		
		mainScreenInterface = new JTextField();
		mainScreenInterface.setColumns(10);
		splitPane.setLeftComponent(mainScreenInterface);
		splitPane.setRightComponent(inputPanel);
	}
	public static void setMainScreenText(String text) {
		mainScreenInterface.setText(text);
		
	}
	public static String getMainScreenText() {
		return mainScreenInterface.getText();
	}
	public static void updateHistory(LinkedList<String> queue) {
		historyModelList.clear();
		for(String e:queue) {
			historyModelList.addElement(e);
		}
	}
}
