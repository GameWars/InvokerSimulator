package nitto.invoker.main;

import java.text.DecimalFormat;

/**
 * @author Nitto Bartholy
 *
 */
public class InvokerTime implements Runnable
{
	private long currentTimePassed;
	private long startTime;
	private long currentTime;
	private long helpCurrentTimePassed;
	
	private DecimalFormat df;
	
	private long lastFpsTime;
	@SuppressWarnings("unused")
	private int fps;
	
	private boolean running = false;
	
	private SimulatorGUI jframe;
	
	/**
	 * @param jframe
	 */
	public InvokerTime(SimulatorGUI jframe)
	{
		this.jframe = jframe;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		df = new DecimalFormat("#.##");
		running = false;
		lastFpsTime = 0;
		fps = 0;
		helpCurrentTimePassed = 0;
		startTime = System.currentTimeMillis();
		updateLoop();
	}
	
	/**
	 * 
	 */
	public void updateLoop()
	{
		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
		
		while (true)
		{
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double) OPTIMAL_TIME);
			
			lastFpsTime += updateLength;
			fps++;
			
			if (lastFpsTime >= 1000000000)
			{
				lastFpsTime = 0;
				fps = 0;
			}
			
			update(delta);
			
			try
			{
				Thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000);
			}
			catch (Exception e)
			{
				
			}
		}
	}
	
	/**
	 * @param delta
	 */
	public void update(double delta)
	{
		if (running)
		{
			currentTime = System.currentTimeMillis();
			setCurrentTimePassed(helpCurrentTimePassed + currentTime - startTime);
			String s = Long.toString(currentTimePassed / 100);
			if (s.length() == 1)
			{
				s = "0." + s.substring(s.length() - 1, s.length()) + "s";
			}
			else
			{
				s = s.substring(0, s.length() - 1) + "." + s.substring(s.length() - 1, s.length()) + "s";
			}
			jframe.getTimePassedText().setText(s);
			
			
			double ipt = ((double) jframe.getSuccessfulInvoke() / getCurrentTimePassed() * 1000);
			jframe.getInvokePerTime().setText(df.format(ipt) + "/s");
		}
		else
		{
			startTime = System.currentTimeMillis();
			helpCurrentTimePassed = currentTimePassed;
		}
	}
	
	/**
	 * @param running
	 */
	public void setRunning(boolean running)
	{
		this.running = running;
	}
	
	/**
	 * @return
	 */
	public boolean isRunning()
	{
		return running;
	}
	
	/**
	 * @return
	 */
	public long getCurrentTimePassed()
	{
		return currentTimePassed;
	}
	
	/**
	 * @param currentTimePassed
	 */
	public void setCurrentTimePassed(long currentTimePassed)
	{
		this.currentTimePassed = currentTimePassed;
	}
	
	/**
	 * @param startTime
	 */
	public synchronized void setStartTime(long startTime)
	{
		this.startTime = startTime;
	}
}
