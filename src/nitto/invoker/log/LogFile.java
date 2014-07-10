package nitto.invoker.log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * A LogFile that can be saved.
 * 
 * @author Nitto Bartholy
 */
public class LogFile
{
	private StringBuilder logTextBuilder = null;
	private Calendar calendar = null;
	private SimpleDateFormat dateFormat = null;
	
	/**
	 * Constructor that calls init().
	 */
	public LogFile()
	{
		init();
	}
	
	/**
	 * Initializes the LogFile.
	 */
	public void init()
	{
		logTextBuilder = new StringBuilder();
		dateFormat = new SimpleDateFormat("[dd-MM-yyyy HH:mm:ss]");
		calendar = new GregorianCalendar(1970, 0, 1);
	}
	
	/**
	 * Adds a String to the logText.
	 * 
	 * @param s
	 *            The String to be added.
	 */
	public void addString(String s)
	{
		logTextBuilder.append(s);
	}
	
	/**
	 * Adds a new Line with the current Date and the given String.
	 * 
	 * @param s
	 *            The String to be added.
	 */
	public void addLine(String s)
	{
		addNewLineCurrentDate();
		logTextBuilder.append(s);
	}
	
	/**
	 * Adds a new Line with the current Date.
	 */
	public void addNewLineCurrentDate()
	{
		addNewLine();
		addCalendarStringCurrent();
		logTextBuilder.append(" ");
	}
	
	/**
	 * Adds a headline of the format ---STRING--- followed by a new Line.
	 * 
	 * @param headline
	 *            The headline to be added.
	 */
	public void addHeadline(String headline)
	{
		logTextBuilder.append("---" + headline + "---");
		addNewLine();
	}
	
	/**
	 * Adds a new Line to the end of the log text.
	 */
	public void addNewLine()
	{
		logTextBuilder.append("\r\n");
	}
	
	/**
	 * Adds two new Lines to the end of the log text.
	 */
	public void addParagraph()
	{
		addNewLine();
		addNewLine();
	}
	
	/**
	 * Clears the current log file.
	 */
	public void clear()
	{
		logTextBuilder.delete(0, logTextBuilder.toString().length());
	}
	
	/**
	 * Adds the given Calendar as a String to the log text.
	 * 
	 * @param calendar
	 *            The given Calendar.
	 */
	public void addCalendarString(Calendar calendar)
	{
		logTextBuilder.append(dateFormat.format(calendar.getTime()));
	}
	
	/**
	 * Adds the given Calendar as a String to the log text.
	 * 
	 * @param day
	 *            The calendar day.
	 * @param month
	 *            The calendar month.
	 * @param year
	 *            The calendar year.
	 */
	public void addCalendarString(int day, int month, int year)
	{
		addCalendarString(day, month - 1, year, 0, 0, 0);
	}
	
	/**
	 * Adds the given Calendar as a String to the log text.
	 * 
	 * @param day
	 *            The calendar day.
	 * @param month
	 *            The calendar month.
	 * @param year
	 *            The calendar year.
	 * @param hour
	 *            The calendar hour.
	 * @param minute
	 *            The calendar minute.
	 * @param second
	 *            The calendar second.
	 */
	public void addCalendarString(int day, int month, int year, int hour, int minute, int second)
	{
		calendar.set(year, month - 1, day, hour, minute, second);
		addCalendarString(calendar);
	}
	
	/**
	 * Adds the current date to the log text.
	 */
	public void addCalendarStringCurrent()
	{
		calendar.setTimeInMillis(System.currentTimeMillis());
		addCalendarString(calendar);
	}
	
	/**
	 * @return
	 */
	public String getLogText()
	{
		return logTextBuilder.toString();
	}
	
	/**
	 * @param logTextBuilder
	 */
	public void setLogTextBuilder(StringBuilder logTextBuilder)
	{
		this.logTextBuilder = logTextBuilder;
	}
	
	/**
	 * @return
	 */
	public StringBuilder getLogTextBuilder()
	{
		return logTextBuilder;
	}
	
	/**
	 * @param calendar
	 */
	public void setCalendar(Calendar calendar)
	{
		this.calendar = calendar;
	}
	
	/**
	 * @return
	 */
	public Calendar getCalendar()
	{
		return calendar;
	}
	
	/**
	 * @param dateFormat
	 */
	public void setDateFormat(SimpleDateFormat dateFormat)
	{
		this.dateFormat = dateFormat;
	}
	
	/**
	 * @return
	 */
	public SimpleDateFormat getDateFormat()
	{
		return dateFormat;
	}
}
