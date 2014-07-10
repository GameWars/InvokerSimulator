package nitto.invoker.main;

import java.awt.event.KeyEvent;
import java.util.Random;

public class InvokerLogic
{
	private IconPanel panel;
	
	private Spell spell1;
	private Spell spell2;
	private Spell spell3;
	
	private InvokeSpell dSpell;
	@SuppressWarnings("unused")
	private InvokeSpell fSpell;
	
	private InvokeSpell currentSpell;
	
	private Random random;
	
	private boolean started;
	
	private int successful;
	
	private int failed;
	
	public InvokerLogic(IconPanel panel)
	{
		this.panel = panel;
		init();
	}
	
	public void init()
	{
		random = new Random(System.currentTimeMillis());
		spell1 = Spell.UNKOWN;
		spell2 = Spell.UNKOWN;
		spell3 = Spell.UNKOWN;
		
		dSpell = InvokeSpell.UNKNOWN;
		fSpell = InvokeSpell.UNKNOWN;
		
		started = false;
		
		successful = 0;
		
		failed = 0;
		
		currentSpell = InvokeSpell.UNKNOWN;
		
	}
	
	public void handleKey(KeyEvent e)
	{
		if (started)
		{
			if (e.getKeyCode() == KeyEvent.VK_Q)
			{
				panel.parseQuas();
				spell3 = spell2;
				spell2 = spell1;
				spell1 = Spell.QUAS;
				panel.repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_W)
			{
				panel.parseWex();
				spell3 = spell2;
				spell2 = spell1;
				spell1 = Spell.WEX;
				panel.repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_E)
			{
				panel.parseExort();
				spell3 = spell2;
				spell2 = spell1;
				spell1 = Spell.EXORT;
				panel.repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_R)
			{
				invoke();
			}
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				currentSpell = getNextSpell();
				panel.setNextImage(currentSpell);
				panel.repaint();
			}
		}
		else
		{
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				panel.setNextImage(InvokeSpell.UNKNOWN);
				currentSpell = InvokeSpell.UNKNOWN;
				panel.repaint();
			}
		}
	}
	
	public void invoke()
	{
		int quas = getNumberQuas();
		int wex = getNumberWex();
		int exort = getNumberExort();
		if (isValidInvoke(quas, wex, exort))
		{
			fSpell = dSpell;
			dSpell = currentSpell;
			if (quas == 3)
			{
				panel.invokeDraw(InvokeSpell.COLD_SNAP);
				currentSpell = InvokeSpell.COLD_SNAP;
			}
			if (quas == 2 && wex == 1)
			{
				panel.invokeDraw(InvokeSpell.GHOST_WALK);
				currentSpell = InvokeSpell.GHOST_WALK;
			}
			if (quas == 2 && exort == 1)
			{
				panel.invokeDraw(InvokeSpell.ICE_WALL);
				currentSpell = InvokeSpell.ICE_WALL;
			}
			if (wex == 2 && quas == 1)
			{
				panel.invokeDraw(InvokeSpell.TORNADO);
				currentSpell = InvokeSpell.TORNADO;
			}
			if (quas == 1 && wex == 1 & exort == 1)
			{
				panel.invokeDraw(InvokeSpell.DEAFENING_BLAST);
				currentSpell = InvokeSpell.DEAFENING_BLAST;
			}
			if (exort == 2 && quas == 1)
			{
				panel.invokeDraw(InvokeSpell.FORGE_SPIRIT);
				currentSpell = InvokeSpell.FORGE_SPIRIT;
			}
			if (wex == 3)
			{
				panel.invokeDraw(InvokeSpell.EMP);
				currentSpell = InvokeSpell.EMP;
			}
			if (wex == 2 && exort == 1)
			{
				panel.invokeDraw(InvokeSpell.ALACRITY);
				currentSpell = InvokeSpell.ALACRITY;
			}
			if (exort == 2 && wex == 1)
			{
				panel.invokeDraw(InvokeSpell.CHAOS_METEOR);
				currentSpell = InvokeSpell.CHAOS_METEOR;
			}
			if (exort == 3)
			{
				panel.invokeDraw(InvokeSpell.SUN_STRIKE);
				currentSpell = InvokeSpell.SUN_STRIKE;
			}
			panel.setNextImage(getNextSpell());
			panel.repaint();
			successful++;
		}
		else
		{
			failed++;
		}
	}
	
	private boolean isValidInvoke(int quas, int wex, int exort)
	{
		if (currentSpell.equals(InvokeSpell.COLD_SNAP) && quas == 3)
		{
			return true;
		}
		if (currentSpell.equals(InvokeSpell.GHOST_WALK) && quas == 2 && wex == 1)
		{
			return true;
		}
		if (currentSpell.equals(InvokeSpell.ICE_WALL) && quas == 2 && exort == 1)
		{
			return true;
		}
		if (currentSpell.equals(InvokeSpell.TORNADO) && wex == 2 & quas == 1)
		{
			return true;
		}
		if (currentSpell.equals(InvokeSpell.DEAFENING_BLAST) && quas == 1 & wex == 1 & exort == 1)
		{
			return true;
		}
		if (currentSpell.equals(InvokeSpell.FORGE_SPIRIT) && exort == 2 & quas == 1)
		{
			return true;
		}
		if (currentSpell.equals(InvokeSpell.EMP) && wex == 3)
		{
			return true;
		}
		if (currentSpell.equals(InvokeSpell.ALACRITY) && wex == 2 & exort == 1)
		{
			return true;
		}
		if (currentSpell.equals(InvokeSpell.CHAOS_METEOR) && exort == 2 & wex == 1)
		{
			return true;
		}
		if (currentSpell.equals(InvokeSpell.SUN_STRIKE) && exort == 3)
		{
			return true;
		}
		return false;
	}
	
	public int getNumberQuas()
	{
		int quas = 0;
		if (spell1.equals(Spell.QUAS))
		{
			quas += 1;
		}
		if (spell2.equals(Spell.QUAS))
		{
			quas += 1;
		}
		if (spell3.equals(Spell.QUAS))
		{
			quas += 1;
		}
		return quas;
	}
	
	public int getNumberWex()
	{
		int wex = 0;
		if (spell1.equals(Spell.WEX))
		{
			wex += 1;
		}
		if (spell2.equals(Spell.WEX))
		{
			wex += 1;
		}
		if (spell3.equals(Spell.WEX))
		{
			wex += 1;
		}
		return wex;
	}
	
	public int getNumberExort()
	{
		int exort = 0;
		if (spell1.equals(Spell.EXORT))
		{
			exort += 1;
		}
		if (spell2.equals(Spell.EXORT))
		{
			exort += 1;
		}
		if (spell3.equals(Spell.EXORT))
		{
			exort += 1;
		}
		return exort;
	}
	
	public InvokeSpell getNextSpell()
	{
		InvokeSpell c = currentSpell;
		while (currentSpell.getId() == c.getId())
		{
			int r = random.nextInt(10) + 1;
			for (InvokeSpell is : InvokeSpell.values())
			{
				if (is.getId() == r)
				{
					currentSpell = is;
				}
			}
		}
		return currentSpell;
	}
	
	public void setStarted(boolean started)
	{
		this.started = started;
	}
	
	public boolean isStarted()
	{
		return started;
	}
	
	public int getSuccessful()
	{
		return successful;
	}
	
	public int getFailed()
	{
		return failed;
	}
	
	public int getTotal()
	{
		return getSuccessful() + getFailed();
	}
	
	public double getPercentage()
	{
		double perc = ((double) successful / getTotal()) * 100;
		if (perc == 0)
		{
			return 0d;
		}
		return ((double) successful / getTotal()) * 100;
	}
}
