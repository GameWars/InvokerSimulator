package nitto.invoker.main;

import javax.swing.UIManager;

public class InvokerLauncher
{
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			new SimulatorGUI();
		}
		catch (Exception e)
		{
			
		}
	}
}
