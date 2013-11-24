package me.suzutsuki.RemoteRender;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

public class Text {
	
	public String text;
	public int x;
	public int y;
	public int tick;
	public int color;
	public boolean dropShadow;
	public Text(String text, int posx, int posy, int tick, int color, boolean dropShadow)
	{
		this.text = text;
		this.x = posx;
		this.y = posy;
		this.tick = tick;
		this.color = color;
		this.dropShadow = dropShadow;
	}

}
