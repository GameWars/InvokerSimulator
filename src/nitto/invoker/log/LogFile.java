package nitto.invoker.log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LogFile
{
	private StringBuilder logTextBuilder = null;
	private Calendar calendar = null;
	private SimpleDateFormat dateFormat = null;

	public LogFile()
	{
		init();
	}

	public void init()
	{
		logTextBuilder = new StringBuilder();
		dateFormat = new SimpleDateFormat("[dd-MM-yyyy HH:mm:ss]");
		calendar = new GregorianCalendar(1970, 0, 1);
	}

	public void addString(String s)
	{
		logTextBuilder.append(s);
	}
	
	public void addLine(String s)
	{
		addNewLineCurrentDate();
		logTextBuilder.append(s);
	}
	
	public void addNewLineCurrentDate()
	{
		addNewLine();
		addCalendarStringCurrent();
		logTextBuilder.append(" ");
	}
	
	public void addHeadline(String headline)
	{
		logTextBuilder.append("---" + headline + "---");
		addNewLine();
	}
	
	public void addNewLine()
	{
		logTextBuilder.append("\r\n");
	}
	
	public void addParagraph()
	{
		addNewLine();
	}

	public void clear()
	{
		logTextBuilder.delete(0, logTextBuilder.toString().length());
	}

	public void addCalendarString(Calendar calendar)
	{
		logTextBuilder.append(dateFormat.format(calendar.getTime()));
	}

	public void addCalendarString(int day, int month, int year)
	{
		addCalendarString(day, month - 1, year, 0, 0, 0);
	}

	public void addCalendarString(int day, int month, int year, int hour, int minute, int second)
	{
		calendar.set(year, month - 1, day, hour, minute, second);
		addCalendarString(calendar);
	}

	public void addCalendarStringCurrent()
	{
		calendar.setTimeInMillis(System.currentTimeMillis());
		addCalendarString(calendar);
	}

	public String getLogText()
	{
		return logTextBuilder.toString();
	}

	public void setLogTextBuilder(StringBuilder logTextBuilder)
	{
		this.logTextBuilder = logTextBuilder;
	}

	public StringBuilder getLogTextBuilder()
	{
		return logTextBuilder;
	}

	public void setCalendar(Calendar calendar)
	{
		this.calendar = calendar;
	}

	public Calendar getCalendar()
	{
		return calendar;
	}

	public void setDateFormat(SimpleDateFormat dateFormat)
	{
		this.dateFormat = dateFormat;
	}

	public SimpleDateFormat getDateFormat()
	{
		return dateFormat;
	}
}
