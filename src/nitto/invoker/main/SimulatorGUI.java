package nitto.invoker.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nitto.invoker.log.LogCreator;
import nitto.invoker.log.LogFile;

/**
 * @author Nitto Bartholy
 *
 */
public class SimulatorGUI extends JFrame implements ActionListener, KeyListener
{
	private static final long serialVersionUID = 285617875983888060L;
	
	private static final int DISPLAY_WIDTH = 824;
	private static final int DISPLAY_HEIGHT = 240;
	
	public static final int BACKGROUND_COLOR = 72;
	
	private InvokerLogic logic;
	
	private IconPanel iconPanel;
	
	private JPanel bottomPanel;
	
	private JPanel bot1Panel;
	private JPanel bot2Panel;
	private JPanel bot3Panel;
	
	private JTextField timePassedText;
	
	private InvokerTime invokerTime;
	private JLabel invokerTimeLbl;
	
	private JTextField successfulInvoke;
	private JLabel successfulInvokeLbl;
	
	private JTextField failedInvoke;
	private JLabel failedInvokeLbl;
	
	private JTextField percentageInvoke;
	private JLabel percentageInvokeLbl;
	
	private JTextField totalInvoke;
	private JLabel totalInvokeLbl;
	
	private JTextField invokePerTime;
	private JLabel invokePerTimeLbl;
	
	private DecimalFormat df;
	
	/**
	 * 
	 */
	public SimulatorGUI()
	{
		super("Invoker Simulator");
		
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(DISPLAY_WIDTH, 60));
		bottomPanel.setVisible(true);
		bottomPanel.setOpaque(true);
		bottomPanel.setBackground(new Color(BACKGROUND_COLOR, BACKGROUND_COLOR, BACKGROUND_COLOR));
		bottomPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		bot1Panel = new JPanel();
		bot1Panel.setVisible(true);
		bot1Panel.setOpaque(true);
		bot1Panel.setBackground(new Color(BACKGROUND_COLOR - 30, BACKGROUND_COLOR - 30, BACKGROUND_COLOR - 30));
		bot1Panel.setLayout(new GridLayout(2, 2, 5, 5));
		
		bot2Panel = new JPanel();
		bot2Panel.setVisible(true);
		bot2Panel.setOpaque(true);
		bot2Panel.setBackground(new Color(BACKGROUND_COLOR - 30, BACKGROUND_COLOR - 30, BACKGROUND_COLOR - 30));
		bot2Panel.setLayout(new GridLayout(2, 2, 5, 5));
		
		bot3Panel = new JPanel();
		bot3Panel.setVisible(true);
		bot3Panel.setOpaque(true);
		bot3Panel.setBackground(new Color(BACKGROUND_COLOR - 30, BACKGROUND_COLOR - 30, BACKGROUND_COLOR - 30));
		bot3Panel.setLayout(new GridLayout(2, 2, 5, 5));
		
		iconPanel = new IconPanel();
		iconPanel.setPreferredSize(new Dimension(DISPLAY_WIDTH, 148));
		iconPanel.setVisible(true);
		iconPanel.setOpaque(true);
		
		timePassedText = new JTextField("0.0s");
		timePassedText.setPreferredSize(new Dimension(100, 50));
		timePassedText.setEditable(false);
		timePassedText.setHorizontalAlignment(JTextField.CENTER);
		timePassedText.setFocusable(false);
		
		successfulInvoke = new JTextField("0");
		successfulInvoke.setPreferredSize(new Dimension(100, 50));
		successfulInvoke.setEditable(false);
		successfulInvoke.setHorizontalAlignment(JTextField.CENTER);
		successfulInvoke.setFocusable(false);
		
		failedInvoke = new JTextField("0");
		failedInvoke.setPreferredSize(new Dimension(100, 50));
		failedInvoke.setEditable(false);
		failedInvoke.setHorizontalAlignment(JTextField.CENTER);
		failedInvoke.setFocusable(false);
		
		percentageInvoke = new JTextField("0%");
		percentageInvoke.setPreferredSize(new Dimension(100, 50));
		percentageInvoke.setEditable(false);
		percentageInvoke.setHorizontalAlignment(JTextField.CENTER);
		percentageInvoke.setFocusable(false);
		
		totalInvoke = new JTextField("0");
		totalInvoke.setPreferredSize(new Dimension(100, 50));
		totalInvoke.setEditable(false);
		totalInvoke.setHorizontalAlignment(JTextField.CENTER);
		totalInvoke.setFocusable(false);
		
		invokePerTime = new JTextField("0/s");
		invokePerTime.setPreferredSize(new Dimension(100, 50));
		invokePerTime.setEditable(false);
		invokePerTime.setHorizontalAlignment(JTextField.CENTER);
		invokePerTime.setFocusable(false);
		
		invokerTimeLbl = new JLabel("Time passed: ");
		invokerTimeLbl.setHorizontalAlignment(JTextField.CENTER);
		successfulInvokeLbl = new JLabel("Successful Invokes: ");
		successfulInvokeLbl.setHorizontalAlignment(JTextField.CENTER);
		failedInvokeLbl = new JLabel("Failed Invokes: ");
		failedInvokeLbl.setHorizontalAlignment(JTextField.CENTER);
		percentageInvokeLbl = new JLabel("Success Percentage: ");
		percentageInvokeLbl.setHorizontalAlignment(JTextField.CENTER);
		totalInvokeLbl = new JLabel("Total Invokes: ");
		totalInvokeLbl.setHorizontalAlignment(JTextField.CENTER);
		invokePerTimeLbl = new JLabel("Invokes per second: ");
		invokePerTimeLbl.setHorizontalAlignment(JTextField.CENTER);
		
		bottomPanel.add(invokerTimeLbl);
		bottomPanel.add(timePassedText);
		bottomPanel.add(successfulInvokeLbl);
		bottomPanel.add(successfulInvoke);
		
		bottomPanel.add(bot1Panel);
		bottomPanel.add(bot2Panel);
		bottomPanel.add(bot3Panel);
		
		bot1Panel.add(invokerTimeLbl);
		bot1Panel.add(timePassedText);
		bot1Panel.add(invokePerTimeLbl);
		bot1Panel.add(invokePerTime);
		
		bot2Panel.add(successfulInvokeLbl);
		bot2Panel.add(successfulInvoke);
		bot2Panel.add(failedInvokeLbl);
		bot2Panel.add(failedInvoke);
		
		bot3Panel.add(totalInvokeLbl);
		bot3Panel.add(totalInvoke);
		bot3Panel.add(percentageInvokeLbl);
		bot3Panel.add(percentageInvoke);
		
		df = new DecimalFormat("#.##");
		
		logic = new InvokerLogic(iconPanel);
		
		invokerTime = new InvokerTime(this);
		
		new Thread(invokerTime).start();
		
		this.add(iconPanel, BorderLayout.NORTH);
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		this.requestFocus();
		
		bot1Panel.addKeyListener(this);
		bot2Panel.addKeyListener(this);
		bot3Panel.addKeyListener(this);
		
		bottomPanel.addKeyListener(this);
		iconPanel.addKeyListener(this);
		timePassedText.addKeyListener(this);
		this.addKeyListener(this);
		
		setResizable(false);
		setPreferredSize(new Dimension(DISPLAY_WIDTH, DISPLAY_HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e)
	{
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			logic.setStarted(!logic.isStarted());
			invokerTime.setRunning(!invokerTime.isRunning());
		}
		if (e.getKeyCode() == KeyEvent.VK_P)
		{
			saveToLog();
		}
		logic.handleKey(e);
		successfulInvoke.setText(Integer.toString(logic.getSuccessful()));
		failedInvoke.setText(Integer.toString(logic.getFailed()));
		totalInvoke.setText(Integer.toString(logic.getTotal()));
		if (!Double.isNaN(logic.getPercentage()))
		{
			percentageInvoke.setText(df.format(logic.getPercentage()) + "%");
		}
		else
		{
			percentageInvoke.setText("0%");
		}
	}
	
	/**
	 * @return
	 */
	public JTextField getTimePassedText()
	{
		return timePassedText;
	}
	
	/**
	 * @return
	 */
	public JTextField getInvokePerTime()
	{
		return invokePerTime;
	}
	
	/**
	 * @return
	 */
	public int getSuccessfulInvoke()
	{
		if (successfulInvoke.getText().equals(""))
		{
			return 0;
		}
		return Integer.parseInt(successfulInvoke.getText());
	}
	
	/**
	 * 
	 */
	public void saveToLog()
	{
		LogFile logFile = new LogFile();
		logFile.addHeadline("STATS");
		logFile.addLine("Time passed: " + timePassedText.getText());
		logFile.addLine("Invokes per second: " + invokePerTime.getText());
		logFile.addParagraph();
		logFile.addLine("Successful Invokes: " + successfulInvoke.getText());
		logFile.addLine("Failed Invokes: " + failedInvoke.getText());
		logFile.addParagraph();
		logFile.addLine("Total Invokes: " + totalInvoke.getText());
		logFile.addLine("Success Percentage: " + percentageInvoke.getText());
		LogFile loadLogFile = LogCreator.loadLog("Invoker.log");
		logFile.addParagraph();
		logFile.addNewLine();
		logFile.addString(loadLogFile.getLogText());
		LogCreator.createLog("Invoker.log", logFile);
	}
}
