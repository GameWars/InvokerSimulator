package nitto.invoker.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class IconPanel extends JPanel
{
	private static final long serialVersionUID = 1084356898362064983L;
	private BufferedImage imageSlot1;
	private BufferedImage imageSlot2;
	private BufferedImage imageSlot3;
	
	private BufferedImage imageSlot4;
	
	private BufferedImage imageSlotD;
	private BufferedImage imageSlotF;
	
	private BufferedImage unknown;
	private BufferedImage alacrity;
	private BufferedImage chaosMeteor;
	private BufferedImage coldSnap;
	private BufferedImage deafeningBlast;
	private BufferedImage emp;
	private BufferedImage forgeSpirit;
	private BufferedImage ghostWalk;
	private BufferedImage iceWall;
	private BufferedImage sunStrike;
	private BufferedImage tornado;
	private BufferedImage quas;
	private BufferedImage wex;
	private BufferedImage exort;
	
	public IconPanel()
	{
		initImageSlots();
		this.setBackground(new Color(SimulatorGUI.BACKGROUND_COLOR, SimulatorGUI.BACKGROUND_COLOR, SimulatorGUI.BACKGROUND_COLOR));
	}
	
	public void initImageSlots()
	{
		try
		{
			unknown = ImageIO.read(new File("res/Unknown.png"));
			alacrity = ImageIO.read(new File("res/Alacrity.png"));
			chaosMeteor = ImageIO.read(new File("res/Chaos_Meteor.png"));
			coldSnap = ImageIO.read(new File("res/Cold_Snap.png"));
			deafeningBlast = ImageIO.read(new File("res/Deafening_Blast.png"));
			emp = ImageIO.read(new File("res/EMP.png"));
			forgeSpirit = ImageIO.read(new File("res/Forge_Spirit.png"));
			ghostWalk = ImageIO.read(new File("res/Ghost_Walk.png"));
			iceWall = ImageIO.read(new File("res/Ice_Wall.png"));
			sunStrike = ImageIO.read(new File("res/Sun_Strike.png"));
			tornado = ImageIO.read(new File("res/Tornado.png"));
			quas = ImageIO.read(new File("res/Quas.png"));
			wex = ImageIO.read(new File("res/Wex.png"));
			exort = ImageIO.read(new File("res/Exort.png"));
			
			imageSlot1 = unknown;
			imageSlot2 = unknown;
			imageSlot3 = unknown;
			imageSlotD = unknown;
			imageSlotF = unknown;
			imageSlot4 = unknown;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void parseQuas()
	{
		this.imageSlot3 = imageSlot2;
		this.imageSlot2 = imageSlot1;
		this.imageSlot1 = quas;
	}
	
	public void parseWex()
	{
		this.imageSlot3 = imageSlot2;
		this.imageSlot2 = imageSlot1;
		this.imageSlot1 = wex;
	}
	
	public void parseExort()
	{
		this.imageSlot3 = imageSlot2;
		this.imageSlot2 = imageSlot1;
		this.imageSlot1 = exort;
	}
	
	public void invokeDraw(InvokeSpell spell)
	{
		imageSlotF = imageSlotD;
		switch (spell)
		{
			case ALACRITY:
				imageSlotD = alacrity;
				break;
			case CHAOS_METEOR:
				imageSlotD = chaosMeteor;
				break;
			case COLD_SNAP:
				imageSlotD = coldSnap;
				break;
			case DEAFENING_BLAST:
				imageSlotD = deafeningBlast;
				break;
			case EMP:
				imageSlotD = emp;
				break;
			case FORGE_SPIRIT:
				imageSlotD = forgeSpirit;
				break;
			case GHOST_WALK:
				imageSlotD = ghostWalk;
				break;
			case ICE_WALL:
				imageSlotD = iceWall;
				break;
			case SUN_STRIKE:
				imageSlotD = sunStrike;
				break;
			case TORNADO:
				imageSlotD = tornado;
				break;
			case UNKNOWN:
				imageSlotD = unknown;
				break;
		}
	}
	
	public void setNextImage(InvokeSpell spell)
	{
		switch (spell)
		{
			case ALACRITY:
				imageSlot4 = alacrity;
				break;
			case CHAOS_METEOR:
				imageSlot4 = chaosMeteor;
				break;
			case COLD_SNAP:
				imageSlot4 = coldSnap;
				break;
			case DEAFENING_BLAST:
				imageSlot4 = deafeningBlast;
				break;
			case EMP:
				imageSlot4 = emp;
				break;
			case FORGE_SPIRIT:
				imageSlot4 = forgeSpirit;
				break;
			case GHOST_WALK:
				imageSlot4 = ghostWalk;
				break;
			case ICE_WALL:
				imageSlot4 = iceWall;
				break;
			case SUN_STRIKE:
				imageSlot4 = sunStrike;
				break;
			case TORNADO:
				imageSlot4 = tornado;
				break;
			case UNKNOWN:
				imageSlot4 = unknown;
				break;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(imageSlot1, 10, 10, null);
		g.drawImage(imageSlot2, 140, 10, null);
		g.drawImage(imageSlot3, 270, 10, null);
		g.drawImage(imageSlotD, 410, 10, null);
		g.drawImage(imageSlotF, 540, 10, null);
		g.drawImage(imageSlot4, 680, 10, null);
	}
	
	@Override
	public void update(Graphics g)
	{
		super.update(g);
	}
}
