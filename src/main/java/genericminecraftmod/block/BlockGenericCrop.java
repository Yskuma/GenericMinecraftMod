package genericminecraftmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import genericminecraftmod.GenericMinecraftMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

/**
 * Created by andrewd on 28/01/2015.
 */
public class BlockGenericCrop extends BlockGenericCropCore {

    public BlockGenericCrop()
    {
        // Basic block setup
        setBlockName("genericCrop");
        setBlockTextureName(GenericMinecraftMod.MODID + ":" + this.getUnlocalizedName() + "_0");
        maxGrowth = 10;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(int parMetadata, int parFortune, Random parRand)
    {
        return ((parMetadata+1)/2);
    }

    @Override
    public Item getItemDropped(int parMetadata, Random parRand, int parFortune)
    {
        return (GenericMinecraftMod.itemGenericSeeds);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister parIIconRegister)
    {
        iIcon = new IIcon[maxGrowth+1];

        for(int i = 0; i < maxGrowth; i++)
        {
            iIcon[i] = parIIconRegister.registerIcon(GenericMinecraftMod.MODID + ":" + this.getUnlocalizedName() + "_" + (i/2));
        }
    }
}
