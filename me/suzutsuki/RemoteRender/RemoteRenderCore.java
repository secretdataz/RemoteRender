package me.suzutsuki.RemoteRender;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(name = "RemoteRender",
modid = "RemoteRender",
version = "0.0.1")
@NetworkMod(clientSideRequired = true,
serverSideRequired = false,
channels={"RemoteRender","RemoteRenderImage"},
packetHandler = PacketHandler.class)
public class RemoteRenderCore {

	@Instance(value = "RemoteRender")
	public static RemoteRenderCore instance;
	
	@SidedProxy(clientSide = "me.suzutsuki.RemoteRender.ClientProxy", serverSide="me.suzutsuki.RemoteRender.CommonProxy")
	public static CommonProxy prox;
	
	public TextStore textStore;
	
	@EventHandler
	public void load(FMLInitializationEvent e)
	{
		textStore = new TextStore();
		prox.registerTickHandler();
	}
}
