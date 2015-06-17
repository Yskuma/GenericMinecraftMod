package genericminecraftmod.handler;

/**
 * Created by andrewd on 17/06/2015.
 */
import genericminecraftmod.container.GenericSmallContainer;
import genericminecraftmod.gui.GuiGenericSmallContainer;
import genericminecraftmod.tile.TileEntityGenericSmallContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
                                      int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity instanceof TileEntityGenericSmallContainer){
            return new GenericSmallContainer(player.inventory, (TileEntityGenericSmallContainer) tileEntity);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
                                      int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity instanceof TileEntityGenericSmallContainer){
            return new GuiGenericSmallContainer(player.inventory, (TileEntityGenericSmallContainer) tileEntity);
        }
        return null;

    }
}
