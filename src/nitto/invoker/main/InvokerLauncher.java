package nitto.invoker.main;

import javax.swing.UIManager;

/**
 * @author Nitto Bartholy
 * 
 */
public class InvokerLauncher
{
	/**
	 * @param args
	 */
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
