package nitto.invoker.main;

public enum Spell
{
	QUAS(1), WEX(2), EXORT(3), UNKOWN(-1);
	
	private int id;
	
	Spell(int id)
	{
		this.id = id;		
	}
	
	public int getId()
	{
		return id;
	}
}
