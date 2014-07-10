package nitto.invoker.log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LogCreator
{
	private LogCreator()
	{
	}
	
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
