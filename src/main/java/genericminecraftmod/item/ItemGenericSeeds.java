package genericminecraftmod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import genericminecraftmod.GenericMinecraftMod;
import genericminecraftmod.block.BlockGenericCrop;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by andrewd on 28/01/2015.
 */
public class ItemGenericSeeds extends Item implements IPlantable {

    public ItemGenericSeeds() {
        this.setUnlocalizedName("genericSeeds");
        this.setCreativeTab(GenericMinecraftMod.TAB);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(GenericMinecraftMod.MODID + ":" + getUnlocalizedName());
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess iBlockAccess, int i, int i1, int i2) {
        return EnumPlantType.Crop;
    }

    @Override
    public Block getPlant(IBlockAccess iBlockAccess, int i, int i1, int i2) {
        return GenericMinecraftMod.blockGenericCrop;
    }

    @Override
    public int getPlantMetadata(IBlockAccess iBlockAccess, int i, int i1, int i2) {
        return 0;
    }

    @Override
    public boolean onItemUse(ItemStack parItemStack, EntityPlayer parPlayer,
                             World parWorld, int parX, int parY, int parZ, int par7, float par8,
                             float par9, float par10)
    {
        // not sure what this parameter does, copied it from potato
        if (par7 != 1)
        {
            return false;
        }
        // check if player has capability to edit
        else if (parPlayer.canPlayerEdit(parX, parY+1, parZ, par7, parItemStack))
        {
            // check that the soil block can sustain the plant
            // and that block above is air so there is room for plant to grow
            if (parWorld.getBlock(parX, parY, parZ).canSustainPlant(parWorld,
                    parX, parY, parZ, ForgeDirection.UP, this) && parWorld
                    .isAirBlock(parX, parY+1, parZ))
            {
                // place the plant block
                parWorld.setBlock(parX, parY+1, parZ, GenericMinecraftMod.blockGenericCrop);
                // decrement the stack of seed items
                --parItemStack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
