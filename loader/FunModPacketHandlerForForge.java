package FunMod.loader;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet60Explosion;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import FunMod.enums.EnumFunMod;

public class FunModPacketHandlerForForge
{
    public static void doExplosion(World var0, Explosion var1)
    {
        if (!var0.isRemote)
        {
            Iterator var2 = var0.playerEntities.iterator();

            while (var2.hasNext())
            {
                Object var3 = var2.next();
                EntityPlayerMP var4 = (EntityPlayerMP)var3;
                Packet60Explosion var5 = new Packet60Explosion(var1.explosionX, var1.explosionY, var1.explosionZ, var1.explosionSize, var1.affectedBlockPositions, (Vec3)var1.func_77277_b().get(var4));
                var4.playerNetServerHandler.sendPacketToPlayer(var5);
            }
        }
    }

    public static void sendClientData(EntityPlayer var0, EnumFunMod var1, Object ... var2)
    {
        EntityPlayerMP var3 = (EntityPlayerMP)var0;

        try
        {
            ByteArrayOutputStream var4 = new ByteArrayOutputStream();
            DataOutputStream var5 = new DataOutputStream(new GZIPOutputStream(var4));
            var5.writeInt(var1.ordinal());
            Object[] var6 = var2;
            int var7 = var2.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                Object var9 = var6[var8];

                if (var9 != null)
                {
                    if (var9 instanceof Map)
                    {
                        Map var10 = (Map)var9;
                        Iterator var11 = var10.keySet().iterator();

                        while (var11.hasNext())
                        {
                            String var12 = (String)var11.next();
                            int var13 = ((Integer)var10.get(var12)).intValue();
                            var5.writeInt(var13);
                            var5.writeUTF(var12);
                        }
                    }
                    else if (var9 instanceof Enum)
                    {
                        var5.writeInt(((Enum)var9).ordinal());
                    }
                    else if (var9 instanceof Boolean)
                    {
                        var5.writeBoolean(((Boolean)var9).booleanValue());
                    }
                    else if (var9 instanceof Integer)
                    {
                        var5.writeInt(((Integer)var9).intValue());
                    }
                    else if (var9 instanceof String)
                    {
                        var5.writeUTF((String)var9);
                    }
                    else if (var9 instanceof Float)
                    {
                        var5.writeFloat(((Float)var9).floatValue());
                    }
                    else if (var9 instanceof Double)
                    {
                        var5.writeDouble(((Double)var9).doubleValue());
                    }
                    else if (var9 instanceof NBTTagCompound)
                    {
                        CompressedStreamTools.write((NBTTagCompound)var9, var5);
                    }
                }
            }

            var5.close();
            var3.playerNetServerHandler.sendPacketToPlayer(new Packet250CustomPayload("mod_AnimalBikes", var4.toByteArray()));
        }
        catch (IOException var14)
        {
            var14.printStackTrace();
        }
    }

    public static void sendServerData(EnumFunMod var0, Object ... var1)
    {
        try
        {
            ByteArrayOutputStream var2 = new ByteArrayOutputStream();
            DataOutputStream var3 = new DataOutputStream(new GZIPOutputStream(var2));
            var3.writeInt(var0.ordinal());
            Object[] var4 = var1;
            int var5 = var1.length;

            for (int var6 = 0; var6 < var5; ++var6)
            {
                Object var7 = var4[var6];

                if (var7 != null)
                {
                    if (var7 instanceof Map)
                    {
                        Map var8 = (Map)var7;
                        Iterator var9 = var8.keySet().iterator();

                        while (var9.hasNext())
                        {
                            String var10 = (String)var9.next();
                            int var11 = ((Integer)var8.get(var10)).intValue();
                            var3.writeInt(var11);
                            var3.writeUTF(var10);
                        }
                    }
                    else if (var7 instanceof Enum)
                    {
                        var3.writeInt(((Enum)var7).ordinal());
                    }
                    else if (var7 instanceof Boolean)
                    {
                        var3.writeBoolean(((Boolean)var7).booleanValue());
                    }
                    else if (var7 instanceof Integer)
                    {
                        var3.writeInt(((Integer)var7).intValue());
                    }
                    else if (var7 instanceof String)
                    {
                        var3.writeUTF((String)var7);
                    }
                    else if (var7 instanceof Float)
                    {
                        var3.writeFloat(((Float)var7).floatValue());
                    }
                    else if (var7 instanceof Double)
                    {
                        var3.writeDouble(((Double)var7).doubleValue());
                    }
                    else if (var7 instanceof NBTTagCompound)
                    {
                        CompressedStreamTools.write((NBTTagCompound)var7, var3);
                    }
                }
            }

            var3.close();
            EntityClientPlayerMP var13 = Minecraft.getMinecraft().thePlayer;
            var13.sendQueue.addToSendQueue(new Packet250CustomPayload("mod_AnimalBikes", var2.toByteArray()));
        }
        catch (IOException var12)
        {
            var12.printStackTrace();
        }
    }
}
