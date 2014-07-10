package nitto.invoker.log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Used to save and load LogFiles
 * 
 * @author Nitto Bartholy
 */
public class LogCreator
{
	/**
	 * Private Constructor
	 */
	private LogCreator()
	{
	}
	
	/**
	 * Used to create Log Files at the given path.
	 * 
	 * @param name
	 *            Path and name where the log will be saved/overridden.
	 * @param log
	 *            LogFile to be saved.
	 */
	public static void createLog(String name, LogFile log)
	{
		try
		{
			File file = new File(name);
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(log.getLogText());
			output.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Used to create Log Files at the given path.
	 * 
	 * @param name
	 *            Path and name where the log will be saved/overridden.
	 * @param text
	 *            Text to be saved.
	 */
	public static void createLog(String name, String text)
	{
		try
		{
			File file = new File(name);
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(text);
			output.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Used to load Log Files at the given path.
	 * 
	 * @param name
	 *            Path and name from where the log will be loaded.
	 * @return A LogFile loaded from the given path. Will return an empty
	 *         LogFile if File not found.
	 */
	public static LogFile loadLog(String name)
	{
		File file = new File(name);
		LogFile logFile = new LogFile();
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(file));
			while (true)
			{
				String s = input.readLine();
				if (s == null)
				{
					break;
				}
				logFile.addString(s);
				logFile.addNewLine();
			}
			logFile.addParagraph();
			input.close();
		}
		catch (IOException e)
		{
			System.err.println("Could not load log: " + name);
		}
		return logFile;
	}
}
