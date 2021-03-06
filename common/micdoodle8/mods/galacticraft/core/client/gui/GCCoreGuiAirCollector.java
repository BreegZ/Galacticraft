package micdoodle8.mods.galacticraft.core.client.gui;

import mekanism.api.EnumColor;
import micdoodle8.mods.galacticraft.core.inventory.GCCoreContainerAirCollector;
import micdoodle8.mods.galacticraft.core.tile.GCCoreTileEntityOxygenCollector;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import universalelectricity.core.electricity.ElectricityDisplay;
import universalelectricity.core.electricity.ElectricityDisplay.ElectricUnit;

/**
 * Copyright 2012-2013, micdoodle8
 * 
 * All rights reserved.
 * 
 */
public class GCCoreGuiAirCollector extends GuiContainer
{
    private final GCCoreTileEntityOxygenCollector collector;

    public GCCoreGuiAirCollector(InventoryPlayer par1InventoryPlayer, GCCoreTileEntityOxygenCollector par2TileEntityAirDistributor)
    {
        super(new GCCoreContainerAirCollector(par1InventoryPlayer, par2TileEntityAirDistributor));
        this.collector = par2TileEntityAirDistributor;
        this.ySize = 180;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString("Oxygen Collector", 8, 10, 4210752);
        this.fontRenderer.drawString("Out:", 87, 31, 4210752);
        String status = "Status: " + this.getStatus();
        this.fontRenderer.drawString(status, this.xSize / 2 - this.fontRenderer.getStringWidth(status) / 2, 50, 4210752);
        status = "Oxygen Output: " + Math.round(this.collector.getCappedScaledOxygenLevel(1000) * 10.0D) / 100.0D + "%";
        this.fontRenderer.drawString(status, this.xSize / 2 - this.fontRenderer.getStringWidth(status) / 2, 60, 4210752);
        status = ElectricityDisplay.getDisplay(GCCoreTileEntityOxygenCollector.WATTS_PER_TICK * 20, ElectricUnit.WATT);
        this.fontRenderer.drawString(status, this.xSize / 2 - this.fontRenderer.getStringWidth(status) / 2, 70, 4210752);
        status = ElectricityDisplay.getDisplay(this.collector.getVoltage(), ElectricUnit.VOLTAGE);
        this.fontRenderer.drawString(status, this.xSize / 2 - this.fontRenderer.getStringWidth(status) / 2, 80, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 90 + 2, 4210752);
    }

    private String getStatus()
    {
        if (this.collector.getPower() > 1 && (this.collector.wattsReceived > 0 || this.collector.ic2Energy > 0 || this.collector.bcEnergy > 0))
        {
            return EnumColor.DARK_GREEN + "Active";
        }

        if (this.collector.getPower() < 1)
        {
            return EnumColor.DARK_RED + "Not Enough Leaf Blocks";
        }

        if (this.collector.wattsReceived == 0 && this.collector.ic2Energy == 0 && this.collector.bcEnergy == 0)
        {
            return EnumColor.DARK_RED + "Not Enough Power";
        }

        return EnumColor.DARK_RED + "Unknown";
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/mods/galacticraftcore/textures/gui/oxygen.png");
        final int var5 = (this.width - this.xSize) / 2;
        final int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6 + 5, 0, 0, this.xSize, 181);

        if (this.collector != null)
        {
            final int scale = (int) (this.collector.getPower() / this.collector.MAX_POWER * 54);
            this.drawTexturedModalRect(var5 + 108, var6 + 26, 176, 0, Math.min(scale, 54), 16);
        }
    }
}
