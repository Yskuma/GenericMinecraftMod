package genericminecraftmod.gui;

/**
 * Created by andrewd on 17/06/2015.
 */
import genericminecraftmod.block.BlockGenericSmallContainer;
import genericminecraftmod.container.GenericSmallContainer;
import genericminecraftmod.tile.TileEntityGenericSmallContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiGenericSmallContainer extends GuiContainer {

    public GuiGenericSmallContainer(InventoryPlayer inventoryPlayer,
                                    TileEntityGenericSmallContainer tileEntity) {

        super(new GenericSmallContainer(inventoryPlayer, tileEntity));
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
        fontRendererObj.drawString("Generic Small Container", 8, 6, 4210752);
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2,
                                                   int par3) {
        ResourceLocation tex = new ResourceLocation("genericminecraftmod", "textures/gui/genericinventory.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(tex);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }

}
