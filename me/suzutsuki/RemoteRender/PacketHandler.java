package me.suzutsuki.RemoteRender;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler{

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
		if(packet.channel.equalsIgnoreCase("RemoteRender"))
		{
			handleText(packet);
		}
		else
		{
			handleImage(packet);
		}
	}

	private void handleImage(Packet250CustomPayload pkt)
	{
		//TODO : Implement image rendering
		System.out.println("[RemoteRender]Image rendering is NYI");
	}
	
	private void handleText(Packet250CustomPayload pkt)
	{
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(pkt.data));
		try
		{			
			int x = dis.readInt();
			int y = dis.readInt();
			int tick = dis.readInt();
			int color = dis.readInt();
			boolean dropShadow = dis.readBoolean();
			String text = "";
			int b = 0;
			while((b = dis.read()) != -1)
			{
				text += (char)b;
			}
			RemoteRenderCore.instance.textStore.add(new Text(text, x, y, tick, color, dropShadow));
		}
		catch(IOException e)
		{
			System.out.println("[RemoteRender]IOException occured while reading data stream.");
			System.out.println("[RemoteRender]Maybe string sent from server is misformatted?");
			e.printStackTrace();
		}
		finally
		{
			if(dis != null)
			{
				try {
					dis.close();
				} catch (IOException ignorethis) {
				}
			}
		}
	}
}
