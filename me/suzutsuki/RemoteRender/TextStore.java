package me.suzutsuki.RemoteRender;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

public class TextStore {

	private Minecraft mc;
	private ArrayList<Text> textList = new ArrayList<Text>();
	public TextStore()
	{
		mc = Minecraft.getMinecraft();
	}
	public void doRender()
	{
		ScaledResolution scr = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
		FontRenderer fr = mc.fontRenderer;
		mc.entityRenderer.setupOverlayRendering();
	    for(Text t : textList)
	    {
	    	if(t.tick > 0)
	    	{
	    		fr.drawString(t.text, t.x, t.y, t.color, t.dropShadow);
	    		t.tick--;
	    		if(t.tick < 1)
	    		{
	    			textList.remove(t);
	    		}
	    	}
	    }
	}
	public void add(Text t)
	{
		textList.add(t);
	}
}
