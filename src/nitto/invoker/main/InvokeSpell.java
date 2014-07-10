package nitto.invoker.main;

public enum InvokeSpell
{
	ALACRITY(1), CHAOS_METEOR(2), COLD_SNAP(3), DEAFENING_BLAST(4), EMP(5), FORGE_SPIRIT(6), GHOST_WALK(7), ICE_WALL(8), SUN_STRIKE(9), TORNADO(10), UNKNOWN(-1);
	
	private int id;
	
	InvokeSpell(int id)
	{
		this.id = id;		
	}
	
	public int getId()
	{
		return id;
	}
}
