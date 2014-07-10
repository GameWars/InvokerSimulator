package nitto.invoker.main;

/**
 * @author Nitto Bartholy
 * 
 */
public enum Spell
{
	QUAS(1), WEX(2), EXORT(3), UNKOWN(-1);
	
	private int id;
	
	/**
	 * @param id
	 */
	Spell(int id)
	{
		this.id = id;
	}
	
	/**
	 * @return
	 */
	public int getId()
	{
		return id;
	}
}
